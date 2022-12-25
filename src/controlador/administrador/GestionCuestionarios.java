package controlador.administrador;

import com.kitfox.svg.A;
import controlador.baseDeDatos.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta clase contiene los metodos necesarios para gestionar los cuestionarios
 *
 * @author Fernando
 */
public class GestionCuestionarios {
    /**
     * Este metodo permite comprobar si existe un cuestionario
     * con un determinado nombre en la base de datos
     *
     * @param nombre es el nombre del cuestionario que queremos comprobar
     * @return true si existe, false si no
     * @author Fernando
     */
    public static boolean existeCuestionario(String nombre) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String sql = "select *  from cuestionarios where nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombre);
            resultSet = sentencia.executeQuery();
            return resultSet.next();
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
    }

    /**
     * Este metodo permite obtener los cuestionarios de una determinada categoria
     *
     * @param categoria es la categoria de la que queremos obtener los cuestionaros
     * @return un ArrayList con los nombres de los cuestionarios
     * @author Fernando
     */
    public static ArrayList<String> obtenerCuestionarios(String categoria) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        ArrayList<String> cuestionarios = new ArrayList<>();
        String sql = "select cu.nombre from cuestionarios cu join categoria cat on cu.id_categoria = cat.id where cat.nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, categoria);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                cuestionarios.add(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (sentencia != null) sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return cuestionarios;
    }

    /**
     * Este metodo permite insertar un cuestionario
     *
     * @param idCategoria es el id de la categoria del cuestionario
     * @param nombre      es el nombre del cuestionario
     * @param descripcion es la descripcion del cuestionario
     * @return mayor que 0 si se inserta
     * @author Fernando
     */
    public static int insertarCuestionario(int idCategoria, String nombre, String descripcion) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String sql = "INSERT INTO cuestionarios(nombre, descripcion, id_categoria) VALUES (?,?,?);";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, descripcion);
            sentencia.setInt(3, idCategoria);
            return sentencia.executeUpdate();
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
    }
}
