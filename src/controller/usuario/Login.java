package controller.usuario;

import controller.baseDeDatos.Cifrado;
import controller.baseDeDatos.ConexionBD;
import controller.tools.ComprobarDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase contiene los metodos necesarios para permitir al usuario
 * iniciar sesion en el sistema
 * @author Fernando
 */
public class Login implements Codigos {
    /**
     * Este metodo permite comprobar si los datos introducidos
     * en el formulario de login son correctos
     * @param nombre es el nombre de la persona
     * @param password es la contraseña de la persona
     * @return el codigo de error correspondiente
     * @author Fernando
     */
    public static int login(String nombre, String password) {
        if (ComprobarDatos.existeUsuario(nombre) == ERROR) {
            return ERROR_NO_EXISTE_USUARIO;
        }
        if (Cifrado.SHA256(password).equals(obtenerDatos(nombre,Codigos.OBTENER_PASSWORD))) {
            return CORRECTO;
        }
        return ERROR_PASSWORD_INCORRECTA;
    }

    /**
     * Este metodo nos permite obtener algun dato de una persona
     * a partir de su nombre
     * @param nombre es el nombre de la persona que estamos buscando
     * @return el dato indicado si existe la persona, una cadena vacia si no existe
     * @author Fernando
     */
    public static String obtenerDatos(String nombre,String tipoDato) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
           /*
          Tenemos que usar la clausula BINARY para poder obtener el usuario que se llame exactamente
          igual al que estamos buscando, ya que con el igual o con el like no distingue entre mayusculas
          y minusculas
         */
        String sql = "SELECT * FROM usuarios WHERE BINARY nombre = ?";
        String password = "";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombre);
            resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                password = resultSet.getString(tipoDato);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return password;
    }

}
