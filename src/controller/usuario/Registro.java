package controller.usuario;

import controller.baseDeDatos.Cifrado;
import controller.baseDeDatos.ConexionBD;
import controller.tools.ComprobarDatos;
import model.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Esta clase contiene los metodos necesarios para poder registrar a
 * un usuario en la base de datos
 *
 * @author Fernando
 */
public class Registro implements Codigos {
    /**
     * Este metodo permite comprobar que los datos de registro estan correctos
     *
     * @param nombre    es el nombre de la persona
     * @param email     es el email de la persona
     * @param password1 es la contraseña de la persona
     * @param password2 es la repeticion de la contraseña de la persona
     * @param telefono  es el telefono de la persona
     * @return el codigo correspondiente en funcion de lo ocurrido
     * @author Fernando
     */
    public static int comprobarRegistro(String nombre, String email, String password1, String password2, String telefono) {
        //Se comprueba que no haya campos vacios
        if (nombre.equals("") || email.equals("") || password1.equals("") || password2.equals("") || telefono.equals("")) {
            return ERROR_CAMPOS_VACIOS;
        }
        //Se comprueba que el nombre solo tenga espacios y letras
        if (!ComprobarDatos.comprobarNombre(nombre)) {
            return ERROR_NOMBRE;
        }
        //se comprueba que el correo tenga un formato valido
        if (!ComprobarDatos.comprobarCorreo(email)) {
            return ERROR_EMAIL;
        }
        //se comprueba que las dos contraseñas coinciden
        if (!ComprobarDatos.comprobarPassword(password1, password2)) {
            return ERROR_PASSWORDS;
        }
        //se comprueba que el formato de la contraseña es correcto
        if (!ComprobarDatos.comprobarFormatoPassword(password1)) {
            return ERROR_FORMATO_PASSWORD;
        }
        //se comprueba que el telefono
        if (!ComprobarDatos.comprobarTelefono(telefono)) {
            return ERROR_TELEFONO;
        }
        if(ComprobarDatos.existeUsuario(nombre) > 0){
            return ERROR_EXISTE_USUARIO;
        }
        //Solo insertamos el usuario en caso de que se pulse la
        //opcion de aceptar
        if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres registrarte?") == 0) {
            registrarUsuario(new Usuario(nombre, Cifrado.SHA256(password1), email,telefono, USUARIO_NORMAL));
            return CORRECTO;
        }
        return CANCELADO;
    }



    /**
     * Este metodo inserta el usuario en la base de datos
     *
     * @param usuario es el usuario con los datos que vamos a insertar
     * @author Fernando
     */
    public static boolean registrarUsuario(Usuario usuario) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        String sql = "INSERT INTO `usuarios`(`nombre`, `contrasena`, `email`, `telefono`, `tipo`) VALUES (?,?,?,?,?)";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getPassword());
            sentencia.setString(3, usuario.getEmail());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setString(5, usuario.getTipo());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
    }

}
