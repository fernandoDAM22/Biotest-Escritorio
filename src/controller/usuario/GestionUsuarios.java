package controller.usuario;

import controller.baseDeDatos.Cifrado;
import controller.baseDeDatos.ConexionBD;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase contiene los metodos necesarios para la gestion de los usuarios
 * @author Fernando
 */
public class GestionUsuarios {
    /**
     * Este metodo permite obtener el id de un usuario a partir de su nombre
     * @param nombreUsuario es el usuario del que queremos saber el id
     * @return el id del usuario si existe, -1 si no existe
     */
    public static int obtenerIdUsuario(String nombreUsuario) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String sql = "select id from usuarios where nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,nombreUsuario);
            resultSet = sentencia.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
           return  -1;
        }finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return -1;
    }

    public static Usuario obtenerDatosUsuario(String nombreUsuario) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String sql = "select * from usuarios where nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,nombreUsuario);
            resultSet = sentencia.executeQuery();
            if(resultSet.next()){
                return new Usuario(resultSet.getString("nombre"),
                        resultSet.getString("contrasena"),
                        resultSet.getString("email"),
                        resultSet.getString("telefono"),
                        resultSet.getString("tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return null;
    }

    /**
     * Este metodo permite cambiar la contraseña de un usuario
     * @param user es el usuario al que le queremos cambiar la contraseña
     * @param password es la nueva contraseña que le vamos a asignar (sin cifrar)
     * @return true si se cambia, false si no
     */
    public static boolean cambiarPassword(String user,String password) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        /*La contraseña viene sin cifrar, por lo que aqui antes de modificarla
        * la ciframos primero*/
        String hash = Cifrado.SHA256(password);
        String sql = "update usuarios set contrasena = ? where BINARY nombre = ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,hash);
            sentencia.setString(2,user);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
        return false;
    }

    /**
     * Este metodo permita cambier el email de un usuario
     * @param user es el usuario al que le vamos a cambiar el nombre
     * @param email es el email que le vamos a poner al usuario
     * @return true si se cambia, false si no
     * @author Fernando
     */
    public static boolean cambiarEmail(String user, String email) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String sql = "update usuarios set email = ? where BINARY nombre = ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,email);
            sentencia.setString(2,user);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
        return false;
    }
    /**
     * Este metodo permita cambiar el telefono de un usuario
     * @param user es el usuario al que le vamos a cambiar el nombre
     * @param telefono es el telefono que le vamos a poner al usuario
     * @return true si se cambia, false si no
     * @author Fernando
     */
    public static boolean cambiarTelefono(String user, String telefono) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String sql = "update usuarios set telefono = ? where BINARY nombre = ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,telefono);
            sentencia.setString(2,user);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
        return false;
    }
    /**
     * Este metodo permita cambiar el nombre de usuario
     * @param user es el usuario al que le vamos a cambiar el nombre
     * @param nuevoNombre es el que le vamos a poner al usuario
     * @return true si se cambia, false si no
     * @author Fernando
     */
    public static boolean cambiarNombre(String user, String nuevoNombre) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String sql = "update usuarios set nombre = ? where BINARY nombre = ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,nuevoNombre);
            sentencia.setString(2,user);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
        return false;
    }
}
