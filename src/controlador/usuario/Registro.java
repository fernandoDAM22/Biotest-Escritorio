package controlador.usuario;

import controlador.baseDeDatos.Cifrado;
import controlador.baseDeDatos.ConexionBD;
import controlador.herramientas.ComprobarDatos;
import modelo.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Este clase contiene los metodos necesarios para poder registrar a
 * un usuario en la base de datos
 *
 * @author Fernando
 */
public class Registro implements Codigos {
    public static int comprobarRegistro(String nombre, String email, String password1, String password2, String telefono) {
        if (nombre.equals("") || email.equals("") || password1.equals("") || password2.equals("") || telefono.equals("")) {
            return ERROR_CAMPOS_VACIOS;
        }
        if (!ComprobarDatos.comprobarNombre(nombre)) {
            return ERROR_NOMBRE;
        }
        if (!ComprobarDatos.comprobarCorreo(email)) {
            return ERROR_EMAIL;
        }
        if (!ComprobarDatos.comprobarPassword(password1, password2)) {
            return ERROR_PASSWORDS;
        }
        if (!ComprobarDatos.comprobarFormatoPassword(password1)) {
            return ERROR_FORMATO_PASSWORD;
        }
        if(!ComprobarDatos.comprobarTelefono(telefono)){
            return ERROR_TELEFONO;
        }

        if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres registrarte?") == 0) {
            registrarUsuario(new Usuario(nombre, email, Cifrado.SHA256(password1), telefono, USUARIO_NORMAL));
        }
        return CORRECTO;
    }

    private static void registrarUsuario(Usuario usuario) {
        int resultado = 0;
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        String sql = "INSERT INTO `usuarios`(`nombre`, `contrasena`, `email`, `telefono`) VALUES (?,?,?,?)";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,usuario.getNombre());
            sentencia.setString(2,usuario.getPassword());
            sentencia.setString(3,usuario.getEmail());
            sentencia.setString(4,usuario.getTelefono());
            resultado = sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }


    }
}
