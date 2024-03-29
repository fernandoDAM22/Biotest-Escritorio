package controller.controlPartida;

import controller.baseDeDatos.ConexionBD;
import controller.tools.LoggerUtil;
import controller.tools.Mensajes;
import model.Partida;
import model.Pregunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase contiene los metodos que implican consultas a la
 * base de datos relacionadas con las partidas
 *
 * @author Fernando
 */
public class ConsultasPartida {
    private static final Logger logger = LoggerUtil.getLogger(ConsultasPartida.class);
    /**
     * Este metodo permite obtener todos los id de las partidas
     *
     * @return un ArrayList con los ids de las partidas, null si ocurre algun error
     * @author Fernando
     */
    public static ArrayList<Integer> obtenerId() {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
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
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
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
        ConexionBD conexionBD;
        Connection conexion;
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
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
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
        ConexionBD conexionBD;
        Connection conexion;
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
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
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
        ConexionBD conexionBD;
        Connection conexion;
        conexionBD = new ConexionBD();
        String sql = "Update partidas set puntuacion = ? where id = ?";
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, puntuacion);
            sentencia.setInt(2, idPartida);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
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
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3,categoria;
        ArrayList<String[]> preguntas = new ArrayList<>();
        String sql = """
                SELECT p.enunciado,p.respuesta_correcta,p.respuesta_incorrecta1,p.respuesta_incorrecta2,p.respuesta_incorrecta3,c.nombre as categoria
                from (((preguntas p join preguntas_partida pr on p.id = pr.id_pregunta)\s
                      join partidas pa on pr.id_partida = pa.id)
                      JOIN categoria c on c.id = p.id_categoria)
                      WHERE pa.id = ?;
                """;
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
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
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
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;

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
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return -1;
    }
    public static ArrayList<Pregunta> obtenerPreguntas(int idPartida){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3;
        int id_categoria;
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        String sql = """
                SELECT p.enunciado,p.respuesta_correcta,p.respuesta_incorrecta1,p.respuesta_incorrecta2,p.respuesta_incorrecta3,p.id_categoria as categoria
                from (((preguntas p join preguntas_partida pr on p.id = pr.id_pregunta)\s
                      join partidas pa on pr.id_partida = pa.id)
                      JOIN categoria c on c.id = p.id_categoria)
                      WHERE pa.id = ?;
                """;
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
                id_categoria = resultSet.getInt("categoria");
                //agregamos la pregunta al ArrayList
                preguntas.add(new Pregunta(enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3,id_categoria));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return preguntas;
    }
    public static Partida obtenerPartida(int idPartida){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        Partida partida = null;
        int id, idUsuario, puntuacion;
        String  tipo;
        LocalDate fecha;
        ArrayList<Pregunta> preguntas = obtenerPreguntas(idPartida);
        String sql = "SELECT * FROM partidas WHERE id = ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, idPartida);
            resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                fecha = LocalDate.parse(resultSet.getString("fecha"));
                puntuacion = resultSet.getInt("puntuacion");
                idUsuario = resultSet.getInt("id_usuario");
                tipo = resultSet.getString("tipo_partida");
                partida = new Partida(id,fecha,puntuacion,tipo,idUsuario,preguntas);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return partida;
    }
    public static ArrayList<Partida> obtenerPartidasUsuario(String usuario){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        ArrayList<Partida> partidas = new ArrayList<>();
        int  puntuacion, idPartida;
        String  tipo;
        LocalDate fecha;
        String sql = "SELECT p.id,p.fecha,p.puntuacion,p.tipo_partida from partidas p inner JOIN usuarios u on p.id_usuario = u.id WHERE BINARY u.nombre = ?;";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,usuario);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                idPartida = resultSet.getInt("id");
                fecha = LocalDate.parse(resultSet.getString("fecha"));
                puntuacion = resultSet.getInt("puntuacion");
                tipo = resultSet.getString("tipo_partida");
                ArrayList<Pregunta> preguntas = obtenerPreguntas(idPartida);
                partidas.add(new Partida(idPartida,fecha,puntuacion,tipo,preguntas));
            }
            return partidas;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
            return null;
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }

    }
}
