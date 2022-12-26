package controlador.administrador;

import controlador.baseDeDatos.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

    /**
     * Este metodo permite obtener el id de un cuestionario
     *
     * @param nombre es el nombre del cuestionario del que queremos saber su id
     * @return el id del cuestionario en caso de que exista, -1 si no existe
     * @author Fernando
     */
    public static int obtenerId(String nombre) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        int id;
        String sql = "select id from cuestionarios where nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombre);
            resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                return id;
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
        return -1;
    }

    /**
     * Este metodo permite insertar una pregunta en un cuestionario
     *
     * @param idCuestionario es el id del cuestionario
     * @param idPregunta     es el id de la pregunta
     * @return true si se inserta, false si no
     * @author Fernando
     */
    public static boolean insertarPregunta(int idCuestionario, int idPregunta) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        int id;
        String sql = "insert into preguntas_cuestionarios (id_cuestionario, id_pregunta) values (?,?)";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, idCuestionario);
            sentencia.setInt(2, idPregunta);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            /*
             En caso de querer insertar la misma pregunta dos veces en el mismo cuestionario saltara
             esta excepcion, puesto que la base de datos no lo permite, en cuyo caso retornamos false
             */
            return false;
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
     * Este metodo permite colocar las preguntas de un cuestionario en la tabla de preguntas
     *
     * @param tabla        es la tabla donde queremos colocar las preguntas
     * @param cuestionario es el cuestionario que contiene las preguntas que le vamos a colocar a la tabla
     * @author Fernando
     */
    public static void colocarPreguntas(JTable tabla, String cuestionario) {
        //obtenemos todas las preguntas de una categoria en concreto
        ArrayList<String[]> preguntas = GestionPreguntas.obtenerPreguntasCuestionario(cuestionario);
        //creamos el modelo
        DefaultTableModel modelo = new DefaultTableModel(new String[]{
                "Pregunta", "Respuesta Correcta", "Respuesta Incorrecta 1", "Respuesta Incorrecta 2", "Respuessta Incorrecta 3"
        }, 0);
        //y se lo añadimos a la tabla
        tabla.setModel(modelo);
        //agragamos las preguntas al modelo
        for (String[] s : preguntas) {
            modelo.addRow(s);
        }
    }
}
