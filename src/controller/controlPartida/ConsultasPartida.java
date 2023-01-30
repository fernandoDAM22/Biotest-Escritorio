package controller.controlPartida;

import controller.baseDeDatos.ConexionBD;
import model.Partida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta clase contiene los metodos que implican consultas a la
 * base de datos relacionadas con las partidas
 *
 * @author Fernando
 */
public class ConsultasPartida {
    /**
     * Este metodo permite obtener todos los id de las partidas
     *
     * @return un ArrayList con los ids de las partidas, null si ocurre algun error
     * @author Fernando
     */
    public static ArrayList<Integer> obtenerId() {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String sql = "select id from partidas";
        ArrayList<Integer> ids = new ArrayList<>();
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                ids.add(resultSet.getInt("id"));
            }

        } catch (SQLException e) {
            return null;
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return ids;
    }

    /**
     * Este metodo permite insertar una partida en la base de datos
     *
     * @param partida es el objeto de la clase partida que contiene los datos
     * @author Fernando
     */
    public static void insertarPartida(Partida partida) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ArrayList<Integer> ids = new ArrayList<>();
        conexionBD = new ConexionBD();
        String sql = "INSERT INTO partidas(id,fecha,puntuacion,id_usuario,tipo_partida) VALUES (?,?,?,?,?)";
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, partida.getId());
            sentencia.setString(2, partida.getFecha());
            sentencia.setInt(3, 0);
            sentencia.setInt(4, partida.getIdUsuario());
            sentencia.setString(5, partida.getTipo());
            sentencia.executeUpdate();
        } catch (SQLException ignored) {
        } finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }

    }

    /**
     * Este metodo permite insertar una pregunta en la tabla preguntas_partida
     *
     * @param idPartida  es el id de la partida en la que se ha respondido esa pregunta
     * @param idPregunta es el id de la pregunta que se ha respondido
     * @param acertada   indica si la pregunta a sido acertada o no
     * @author Fernando
     */
    public static void insertarPregunta(int idPartida, int idPregunta, boolean acertada) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        conexionBD = new ConexionBD();
        String sql = "INSERT INTO preguntas_partida (id_pregunta, id_partida, acertada) VALUES (?,?,?)";
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, idPregunta);
            sentencia.setInt(2, idPartida);
            sentencia.setBoolean(3, acertada);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
    }

    /**
     * Este metodo permite establecer una puntuacion a una partida
     *
     * @param idPartida  es el id de la partida a la que le vamos a asignar la puntuacion
     * @param puntuacion es la puntuacion que le vamos a asignar a la partida
     * @author Fernando
     */
    public static void establecerPuntuacion(int idPartida, int puntuacion) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        conexionBD = new ConexionBD();
        String sql = "Update partidas set puntuacion = ? where id = ?";
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, puntuacion);
            sentencia.setInt(2, idPartida);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
    }

    /**
     * Este metodo nos permite obtener las preguntas que se han
     * respondido en una partida a traves del id de la partida
     *
     * @param idPartida es el id de la partida de la cual queremos obtener sus preguntas
     * @return un ArrayList de String con los datos de las preguntas
     * @author Fernando
     */
    public static ArrayList<String[]> obtenerPreguntasPartida(int idPartida) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3,categoria;
        ArrayList<String[]> preguntas = new ArrayList<>();
        String sql = "SELECT p.enunciado,p.respuesta_correcta,p.respuesta_incorrecta1,p.respuesta_incorrecta2,p.respuesta_incorrecta3,c.nombre as categoria\n" +
                "from (((preguntas p join preguntas_partida pr on p.id = pr.id_pregunta) \n" +
                "      join partidas pa on pr.id_partida = pa.id)\n" +
                "      JOIN categoria c on c.id = p.id_categoria)\n" +
                "      WHERE pa.id = ?;\n";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, idPartida);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                //guardamos los datos de la pregunta actual en el ResulSet
                enunciado = resultSet.getString("enunciado");
                respuestaCorrecta = resultSet.getString("respuesta_correcta");
                respuestaIncorrecta1 = resultSet.getString("respuesta_incorrecta1");
                respuestaIncorrecta2 = resultSet.getString("respuesta_incorrecta2");
                respuestaIncorrecta3 = resultSet.getString("respuesta_incorrecta3");
                categoria = resultSet.getString("categoria");
                //agregamos la pregunta al ArrayList
                preguntas.add(new String[]{enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3,categoria});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return preguntas;
    }

    /**
     * Este metodo nos permite obtener la puntuacion de una partida
     * @param idPartida es el id de la partida de la cual queremos obtener su puntuacion
     * @return la puntuacion de la partida, -1 si ocurre algun error
     * @author Fernando
     */
    public static int obtenerPuntuacion(int idPartida) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;

        ArrayList<String[]> preguntas = new ArrayList<>();
        String sql = "SELECT puntuacion from partidas where id = ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, idPartida);
            resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("puntuacion");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return -1;
    }
}
