package controller.administrador;

import controller.baseDeDatos.ConexionBD;
import model.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Esta clase nos permite gestionar las preguntas
 *
 * @author fernando
 */
public class GestionPreguntas {
    /**
     * Este metodo permite obtener las preguntas de una categoria concreta
     *
     * @param categoria es la categoria de la cual queremos obtener las preguntas
     * @return un ArrayList de String con los datos de las preguntas
     */
    public static ArrayList<String[]> obtenerPreguntas(String categoria) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3;
        ArrayList<String[]> preguntas = new ArrayList<>();
        String sql = "SELECT enunciado,respuesta_correcta,respuesta_incorrecta1,respuesta_incorrecta2,respuesta_incorrecta3 " +
                "from preguntas p JOIN categoria c on p.id_categoria = c.id WHERE c.nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, categoria);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                //guardamos los datos de la pregunta actual en el ResulSet
                enunciado = resultSet.getString("enunciado");
                respuestaCorrecta = resultSet.getString("respuesta_correcta");
                respuestaIncorrecta1 = resultSet.getString("respuesta_incorrecta1");
                respuestaIncorrecta2 = resultSet.getString("respuesta_incorrecta2");
                respuestaIncorrecta3 = resultSet.getString("respuesta_incorrecta3");
                //agregamos la pregunta al ArrayList
                preguntas.add(new String[]{enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return preguntas;

    }

    /**
     * Este metodo nos permite obtener las preguntas de un cuestionario
     * @param cuestionario es el cuestionario del que queremos obtener las preguntas
     * @return arrayList de String con los datos de la pregunta
     */
    public static ArrayList<String[]> obtenerPreguntasCuestionario(String cuestionario) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3;
        ArrayList<String[]> preguntas = new ArrayList<>();
        String sql = "SELECT p.* from ((preguntas p inner JOIN preguntas_cuestionarios pp ON p.id = pp.id_pregunta) " +
                                        "INNER JOIN cuestionarios c on c.id = pp.id_cuestionario)\n" +
                                        "WHERE c.nombre like ?;";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, cuestionario);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                //guardamos los datos de la pregunta actual en el ResulSet
                enunciado = resultSet.getString("enunciado");
                respuestaCorrecta = resultSet.getString("respuesta_correcta");
                respuestaIncorrecta1 = resultSet.getString("respuesta_incorrecta1");
                respuestaIncorrecta2 = resultSet.getString("respuesta_incorrecta2");
                respuestaIncorrecta3 = resultSet.getString("respuesta_incorrecta3");
                //agregamos la pregunta al ArrayList
                preguntas.add(new String[]{enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return preguntas;

    }

    /**
     * Este metodo se usa para colocar las respuestas de las preguntas,
     * establece el tamaño de letra en funcion de la longitud del texto
     *
     * @param campo es el campo donde vamos a colocar el texto
     * @param texto es el texto que vamos a colocar
     * @author fernando
     */
    public static void colocarRespuesta(JTextField campo, String texto) {
        if (texto.length() <= 10) {
            campo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        } else if (texto.length() < 20) {
            campo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        } else {
            campo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        }
        campo.setText(texto);
    }

    /**
     * Este metodo permite obtener las respuestas de una pregunta
     *
     * @param enunciadoPregunta es el enunciado de la pregunta de la cual
     *                          queremos obtener las respuestas
     * @return un array con las cuatro respuestas de la pregunta;
     * @author Fernando
     */
    public static String[] obtenerRespuestas(String enunciadoPregunta) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3;
        String sql = "SELECT respuesta_correcta,respuesta_incorrecta1,respuesta_incorrecta2,respuesta_incorrecta3 " +
                "from preguntas where enunciado like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, enunciadoPregunta);
            resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                respuestaCorrecta = resultSet.getString("respuesta_correcta");
                respuestaIncorrecta1 = resultSet.getString("respuesta_incorrecta1");
                respuestaIncorrecta2 = resultSet.getString("respuesta_incorrecta2");
                respuestaIncorrecta3 = resultSet.getString("respuesta_incorrecta3");
                return new String[]{respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3};
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return null;
    }

    /**
     * Este metodo permite insertar una pregunta en la base de datos
     *
     * @param p es la pregunta que vamos a insertar
     * @return true si se inserta, false si no
     * @author Fernando
     */

    public static boolean insertarPregunta(Pregunta p) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        String sql = "insert into preguntas " +
                "(enunciado,respuesta_correcta,respuesta_incorrecta1,respuesta_incorrecta2,respuesta_incorrecta3,id_categoria) " +
                " values (?,?,?,?,?,?)";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, p.getEnunciado());
            sentencia.setString(2, p.getRespuestaCorrecta());
            sentencia.setString(3, p.getRespuestaIncorrecta1());
            sentencia.setString(4, p.getRespuestaIncorrecta2());
            sentencia.setString(5, p.getRespuestaIncorrecta3());
            sentencia.setInt(6, p.getIdCategoria());
            int estado = sentencia.executeUpdate();
            return estado > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
    }

    /**
     * Este metodo permite borrar una pregunta de la base de datos
     *
     * @param enunciado es el enunciado de la pregunta que vamos a borrar
     * @return true si se borra, false si no
     * @author Fernando
     */
    public static boolean borrarPregunta(String enunciado) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        String sql = "delete from preguntas where enunciado like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, enunciado);
            int estado = sentencia.executeUpdate();
            return estado > 0;
        } catch (SQLException e) {
           return false;
        } finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
    }

    /**
     * Este metodo permite modificar una pregunta de la base de datos
     *
     * @param p         es el objeto que contiene los datos nuevos de la pregunta
     * @param enunciado es el enunciado de la pregunta que queremos modificar
     * @return true si se modifica la pregunta, false si no
     * @author Fernando
     */
    public static boolean modificarPregunta(Pregunta p, String enunciado) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        String sql = "UPDATE `preguntas` set enunciado = ?, respuesta_correcta = ?, respuesta_incorrecta1 = ?, respuesta_incorrecta2 = ?, respuesta_incorrecta3 = ?  WHERE enunciado like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, p.getEnunciado());
            sentencia.setString(2, p.getRespuestaCorrecta());
            sentencia.setString(3, p.getRespuestaIncorrecta1());
            sentencia.setString(4, p.getRespuestaIncorrecta2());
            sentencia.setString(5, p.getRespuestaIncorrecta3());
            sentencia.setString(6, enunciado);
            int estado = sentencia.executeUpdate();
            return estado > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(sentencia,conexionBD);
        }
    }

    /**
     * Este metodo permite obtener el id de una pregunta a partir de su enunciado
     * @param enunciado es el enunciado de la pregunta de la cual queremos obtener su id
     * @return el id de la pregunta
     * @author Fernando
     */
    public static int obtenerId(String enunciado) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        int id;
        String sql = "select id from preguntas where enunciado like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, enunciado);
            resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return -1;
    }

    /**
     * Este metodo permite obtener todos los ids de las preguntas de la base de datos
     * @return un ArrayList con los ids de todas las preguntas de la base de datos
     * @author Fernando
     */
    public static ArrayList<Integer> obtenerIds(){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        ArrayList<Integer> ids = new ArrayList<>();
        String sql = "select id from preguntas";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            while(resultSet.next()) {
                ids.add(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return ids;
    }

    /**
     * Este metodo permite obtener los datos de una pregunta a partir de su id
     * @param id es el id de la pregunta
     * @return un objeto pregunta
     * @author Fernando
     */
    public static Pregunta obtenerDatos(int id){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String enunciado,respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3;
        String sql = "SELECT enunciado,respuesta_correcta,respuesta_incorrecta1,respuesta_incorrecta2,respuesta_incorrecta3 " +
                "from preguntas where id = ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, id);
            resultSet = sentencia.executeQuery();
            if (resultSet.next()) {
                enunciado = resultSet.getString("enunciado");
                respuestaCorrecta = resultSet.getString("respuesta_correcta");
                respuestaIncorrecta1 = resultSet.getString("respuesta_incorrecta1");
                respuestaIncorrecta2 = resultSet.getString("respuesta_incorrecta2");
                respuestaIncorrecta3 = resultSet.getString("respuesta_incorrecta3");
                return new Pregunta(enunciado,respuestaCorrecta,respuestaIncorrecta1,respuestaIncorrecta2,respuestaIncorrecta3);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return null;
    }

    /**
     * Este metodo nos permite comprobar si ya existe una pregunta en la base de datos
     * basandose en el enunciado
     * @param enunciado es el enunciado de la pregunta que estamos buscando
     * @return true si existe, false si no
     * @author Fernando
     */
    public static boolean existePregunta(String enunciado){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String sql = "select * from preguntas where enunciado like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,enunciado);
            resultSet = sentencia.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
    }

    /**
     * Este metodo permite saber si una pregunta ha sido acertada o no
     * @param idPartida es el id de la partida
     * @param enunciado es el enunciado de la pregunta la cual queremos comprobar
     * @return true si ha sido acertada, false si no
     */
    public static boolean preguntaAcertada(int idPartida, String enunciado) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD;
        Connection conexion;
        ResultSet resultSet = null;
        String sql = "select acertada from resultado_preguntas where enunciado = ? and id_partida = ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,enunciado);
            sentencia.setInt(2,idPartida);
            resultSet = sentencia.executeQuery();
            if(resultSet.next()){
                int num = resultSet.getInt("acertada");
                return num > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConexionBD.cerrar(resultSet,sentencia,conexionBD);
        }
        return false;
    }    /**
     * Este metodo permite comprobar que las 4 respuestas de una partida sean distintas
     * @param respuesta1 es la primera respuesta de la pregunta
     * @param respuesta2 es la segunda respuesta de la pregunta
     * @param respuesta3 es la tercera respuesta de la pregunta
     * @param respuesta4 es la cuarta respuesta de la pregunta
     * @return true en caso de que las respuestas sean distintas, false si alguna se repite
     * @author Fernando
     */

    @SuppressWarnings("all") //para suprimir el warning que indica que se puede simplificar el if
    public static boolean respuestasDistintas(String respuesta1, String respuesta2, String respuesta3, String respuesta4) {
        if (respuesta1.equals(respuesta2) || respuesta1.equals(respuesta3) || respuesta1.equals(respuesta4) ||
                respuesta2.equals(respuesta3) || respuesta2.equals(respuesta4) || respuesta3.equals(respuesta4)) {
            return false;
        } else {
            return true;
        }
    }

}
