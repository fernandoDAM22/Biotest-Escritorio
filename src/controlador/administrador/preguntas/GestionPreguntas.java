package controlador.administrador.preguntas;

import controlador.baseDeDatos.ConexionBD;

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
     * @param categoria es la categoria de la cual queremos obtener las preguntas
     * @return un ArrayList de String con los datos de las preguntas
     */
    public static ArrayList<String[]> obtenerPreguntas(String categoria) {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        String enunciado,respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2,respuestaIncorrecta3;
        ArrayList<String[]> preguntas = new ArrayList<>();
        String sql = "SELECT enunciado,respuesta_correcta,respuesta_incorrecta1,respuesta_incorrecta2,respuesta_incorrecta3 " +
                "from preguntas p JOIN categoria c on p.id_categoria = c.id WHERE c.nombre like ?";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,categoria);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()){
                //guardamos los datos de la pregunta actual en el ResulSet
                enunciado = resultSet.getString("enunciado");
                respuestaCorrecta = resultSet.getString("respuesta_correcta");
                respuestaIncorrecta1 = resultSet.getString("respuesta_incorrecta1");
                respuestaIncorrecta2 = resultSet.getString("respuesta_incorrecta2");
                respuestaIncorrecta3 = resultSet.getString("respuesta_incorrecta3");
                //agregamos la pregunta al ArrayList
                preguntas.add(new String[]{enunciado,respuestaCorrecta,respuestaIncorrecta1,respuestaIncorrecta2,respuestaIncorrecta3});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
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
     * @param label es la label donde vamos a colocar el texto
     * @param texto es el texto que vamos a colocar
     * @author Fernando
     */
    public static void colocarEnunciadoPregunta(JLabel label, String texto){
        if(texto.length() < 30){
            label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        }else if(texto.length() < 50 ){
            label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        }else if (texto.length() < 80){
            label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        }
        label.setText(texto);
    }

    /**
     * Este metodo se usa para colocar las respuestas de las preguntas,
     * establece el tamaño de letra en funcion de la longitud del texto
     * @param campo es el campo donde vamos a colocar el texto
     * @param texto es el texto que vamos a colocar
     * @author fernando
     */
    public static void colocarRespuesta(JTextField campo, String texto){
        if(texto.length() <= 10){
            campo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        }else if(texto.length() < 20){
            campo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        }else{
            campo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        }
        campo.setText(texto);
    }
}
