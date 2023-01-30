package controller.usuario;

import controller.baseDeDatos.ConexionBD;

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
}
