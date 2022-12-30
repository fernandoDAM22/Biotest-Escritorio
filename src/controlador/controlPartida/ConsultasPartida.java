package controlador.controlPartida;

import controlador.baseDeDatos.ConexionBD;
import modelo.Partida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta clase contiene los metodos que implican consultas a la
 * base de datos relacionadas con las partidas
 * @author Fernando
 */
public class ConsultasPartida {
    /**
     * Este metodo permite obtener todos los id de las partidas
     * @return un ArrayList con los ids de las partidas, null si ocurre algun error
     * @author Fernando
     */
    public static ArrayList<Integer> obtenerId(){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet;
        String sql = "select id from partidas";
        ArrayList<Integer> ids = new ArrayList<>();
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()){
                ids.add(resultSet.getInt("id"));
            }

        } catch (SQLException e) {
            return null;
        }finally {
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
        return ids;
    }

    /**
     * Este metodo permite insertar una partida en la base de datos
     * @param partida es el objeto de la clase partida que contiene los datos
     * @author Fernando
     */
    public static void insertarPartida(Partida partida){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ArrayList<Integer> ids = new ArrayList<>();
        conexionBD = new ConexionBD();
        String sql = "INSERT INTO partidas(id,fecha,puntuacion,id_usuario,tipo_partida) VALUES (?,?,?,?,?)";
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1,partida.getId());
            sentencia.setString(2,partida.getFecha());
            sentencia.setInt(3,0);
            sentencia.setInt(4,partida.getIdUsuario());
            sentencia.setString(5, partida.getTipo());
            sentencia.executeUpdate();
        } catch (SQLException ignored) {
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

    /**
     * Este metodo permite insertar una pregunta en la tabla preguntas_partida
     * @param idPartida es el id de la partida en la que se ha respondido esa pregunta
     * @param idPregunta es el id de la pregunta que se ha respondido
     * @param acertada indica si la pregunta a sido acertada o no
     * @author Fernando
     */
    public static void insertarPregunta(int idPartida, int idPregunta, boolean acertada){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        conexionBD = new ConexionBD();
        String sql = "INSERT INTO preguntas_partida (id_pregunta, id_partida, acertada) VALUES (?,?,?)";
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1,idPregunta);
            sentencia.setInt(2,idPartida);
            sentencia.setBoolean(3,acertada);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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

    /**
     * Este metodo permite establecer una puntuacion a una partida
     * @param idPartida es el id de la partida a la que le vamos a asignar la puntuacion
     * @param puntuacion es la puntuacion que le vamos a asignar a la partida
     * @author Fernando
     */
    public static void establecerPuntuacion(int idPartida, int puntuacion){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        conexionBD = new ConexionBD();
        String sql = "Update partidas set puntuacion = ? where id = ?";
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1,puntuacion);
            sentencia.setInt(2,idPartida);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
