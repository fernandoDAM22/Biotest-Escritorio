package controlador.administrador;

import controlador.baseDeDatos.ConexionBD;
import modelo.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        ConexionBD conexionBD = null;
        Connection conexion = null;
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
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
        return preguntas;

    }

    public static ArrayList<String[]> obtenerPreguntasCuestionario(String cuestionario) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3;
        ArrayList<String[]> preguntas = new ArrayList<>();
        String sql = "SELECT p.* from ((preguntas p inner JOIN preguntas_cuestionarios pp ON p.id = pp.id_pregunta)\n" +
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
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
        return preguntas;

    }

    /**
     * Este metodo coloca el enunciado de una pregunta en la label
     * del panel de informacion, en funcion de la longitud del texto
     * establece el tamaño de letra de la label
     *
     * @param label es la label donde vamos a colocar el texto
     * @param texto es el texto que vamos a colocar
     * @author Fernando
     */
    public static void colocarEnunciadoPregunta(JLabel label, String texto) {
        if (texto.length() < 30) {
            label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        } else if (texto.length() < 50) {
            label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        } else if (texto.length() < 80) {
            label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        }
        label.setText(texto);
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
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3;
        ArrayList<String[]> preguntas = new ArrayList<>();
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
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
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
        ConexionBD conexionBD = null;
        Connection conexion = null;
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
     * Este metodo permite borrar una pregunta de la base de datos
     *
     * @param enunciado es el enunciado de la pregunta que vamos a borrar
     * @return true si se borra, false si no
     * @author Fernando
     */
    public static boolean borrarPregunta(String enunciado) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        String sql = "delete from preguntas where enunciado like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, enunciado);
            int estado = sentencia.executeUpdate();
            return estado > 0;
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
     * Este metodo permite modificar una pregunta de la base de datos
     *
     * @param p         es el objeto que contiene los datos nuevos de la pregunta
     * @param enunciado es el enunciado de la pregunta que queremos modificar
     * @return true si se modifica la pregunta, false si no
     */
    public static boolean modificarPregunta(Pregunta p, String enunciado) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
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
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
    }

    public static int obtenerId(String enunciado) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet;
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
    public static ArrayList<Integer> obtenerIds(){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet;
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
    public static Pregunta obtenerDatos(int id){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String enunciado,respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3;
        ArrayList<String[]> preguntas = new ArrayList<>();
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
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
        return null;
    }


}
