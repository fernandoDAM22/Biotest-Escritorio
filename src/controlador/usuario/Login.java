package controlador.usuario;

import controlador.baseDeDatos.Cifrado;
import controlador.baseDeDatos.ConexionBD;
import controlador.herramientas.ComprobarDatos;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements Codigos {
    public static int login(String nombre, String password) {
        if (ComprobarDatos.existeUsuario(nombre) == ERROR) {
            return ERROR_NO_EXISTE_USUARIO;
        }
        if (Cifrado.SHA256(password).equals(obtenerPassword(nombre))) {
            return CORRECTO;
        }
        return ERROR_PASSWORD_INCORRECTA;
    }

    public static String obtenerPassword(String nombre) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String sql = "select * from usuarios where nombre like ?";
        String password = "";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombre);
            resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                password = resultSet.getString("contrasena");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
        return password;
    }
}
