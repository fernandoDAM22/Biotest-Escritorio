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
 * Esta clase nos permite gestionar las categorias de las preguntas
 *
 * @author Fernando
 */
public class GestionCategorias {
    /**
     * Este metodo nos permite obtener un ArrayList con los nombres de las categorias
     *
     * @return un ArrayList con los nombres de las categorias que contienen al menos una pregunta
     */
    public static ArrayList<String> obtenerCategorias() {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        ArrayList<String> nombresCategorias = new ArrayList<>();
        String sql = "select nombre from categoria";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                nombresCategorias.add(resultSet.getString("nombre"));
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
        return nombresCategorias;
    }

    /**
     * este metodo permite colocar las preguntas de una categoria
     * en la tabla
     *
     * @param tabla     es la tabla en la que vamos a colocar las preguntas
     * @param categoria es la categoria de las preguntas
     * @author Fernando
     */
    public static void colocarPreguntas(JTable tabla, String categoria) {
        //obtenemos todas las preguntas de una categoria en concreto
        ArrayList<String[]> preguntas = GestionPreguntas.obtenerPreguntas(categoria);
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

    /**
     * Este metodo permite insertar una categoria en la base de datos
     *
     * @param nombre     es el nombre de la categoria
     * @param descipcion es la descripcion de la categoria
     * @return un valor mayor que 0 en caso de que se inserte la categoria
     * @author Fernando
     */
    public static int insertarCategoria(String nombre, String descipcion) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        String sql = "insert into categoria (nombre,descripcion) values (?,?);";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, descipcion);
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
     * Este metodo permite comprobar si ya existe una categoria con un determinado
     * nombre en la base de datos
     *
     * @param nombre es el nombre de la categoria que queremos comprobar
     * @return true si existe, false si no
     * @author fernando
     */
    public static boolean existeCategoria(String nombre) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String sql = "select * from categoria where nombre like ?";
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
     * Este metodo permite borrar una categoria de la base de datos
     * @param nombre es el nombre de la categoria que queremos borrar
     * @return true si se borra, false si no
     * @author Fernando
     */
    public static boolean borrarCategoria(String nombre) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        int resultado = 0;
        String sql = "delete from categoria where nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,nombre);
            resultado = sentencia.executeUpdate();
            /*
             * Hay que tener en cuenta que saltara una excepcion si el usuario
             * elije borrar una categoria que tiene preguntas puesto que esto no esta permitido por la integridad referencial,
             * si salta la excepcion retornamos false
             */
        } catch (SQLException e) {
            return false;
        }finally {
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
        return resultado > 0;
    }

    /**
     * Este metodo permite modificar los datos de una categoria
     * @param nombreAntiguo es el nombre que tiene actualmente la categoria
     * @param nombreNuevo es el nombre nuevo que le vamos a poner a la categoria
     * @param descripcion es la descripcion nueva que le vamos a poner a la categoria
     * @return true si se ha modificado, false si no
     */
    public static boolean modificarCategoria(String nombreAntiguo, String nombreNuevo, String descripcion){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        int resultado = 0;
        String sql = "update categoria set nombre = ?, descripcion = ? where nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,nombreNuevo);
            sentencia.setString(2,descripcion);
            sentencia.setString(3,nombreAntiguo);
            resultado = sentencia.executeUpdate();
        } catch (SQLException e) {
            return false;
        }finally {
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
        return resultado > 0;
    }

    /**
     * Este metodo permite obtener el id de una categoria
     * a partir de su nombre
     * @param nombre es el nombre de la categoria que estamos buscando
     * @return el id de la categoria, -1 si no se encuentra
     */
    public static int obtenerIdCategoria(String nombre){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet;
        String sql = "select id from categoria where nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,nombre);
            resultSet = sentencia.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("id");
            }

        } catch (SQLException e) {
            return -1;
        }finally {
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
}
