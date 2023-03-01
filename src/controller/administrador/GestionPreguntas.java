package controller.administrador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import controller.baseDeDatos.Constantes;
import controller.baseDeDatos.HttpRequest;
import controller.tools.LoggerUtil;
import controller.tools.Mensajes;
import model.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Esta clase nos permite gestionar las preguntas
 *
 * @author fernando
 */
public class GestionPreguntas {
    private static final Logger logger = LoggerUtil.getLogger(GestionPreguntas.class);
    /**
     * Este metodo permite obtener las preguntas de una categoria concreta
     *
     * @param categoria es la categoria de la cual queremos obtener las preguntas
     * @return un ArrayList de String con los datos de las preguntas
     */
    public static ArrayList<String[]> obtenerPreguntas(String categoria) {
        String url = Constantes.URL_PREGUNTAS_CATEGORIA;
        String valores = null;
        valores = "categoria=" + URLEncoder.encode(categoria, StandardCharsets.UTF_8);
        String jsonResultado = HttpRequest.GET_REQUEST(url, valores);

        Gson gson = new Gson();
        List<String[]> listaPreguntas = gson.fromJson(jsonResultado, new TypeToken<List<String[]>>(){}.getType());

        ArrayList<String[]> preguntas = new ArrayList<>();
        for (String[] pregunta : listaPreguntas) {
           preguntas.add(new String[]{pregunta[0],pregunta[1],pregunta[2],pregunta[3],pregunta[4]});
        }
        return preguntas;

    }

    /**
     * Este metodo nos permite obtener las preguntas de un cuestionario
     * @param cuestionario es el cuestionario del que queremos obtener las preguntas
     * @return arrayList de String con los datos de la pregunta
     */
    public static ArrayList<String[]> obtenerPreguntasCuestionario(String cuestionario) {
        String url = Constantes.URL_PREGUNTAS_CUESTIONARIO;
        String valores = null;
        valores = "cuestionario=" + URLEncoder.encode(cuestionario, StandardCharsets.UTF_8);
        String jsonResultado = HttpRequest.GET_REQUEST(url, valores);

        Gson gson = new Gson();
        List<String[]> listaPreguntas = gson.fromJson(jsonResultado, new TypeToken<List<String[]>>(){}.getType());

        ArrayList<String[]> preguntas = new ArrayList<>();
        for (String[] pregunta : listaPreguntas) {
            preguntas.add(new String[]{pregunta[0],pregunta[1],pregunta[2],pregunta[3],pregunta[4]});
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
        String url = Constantes.URL_OBTENER_RESPUESTAS;
        String valores = null;
        valores = "enunciado=" + URLEncoder.encode(enunciadoPregunta, StandardCharsets.UTF_8);
        String jsonResultado = HttpRequest.GET_REQUEST(url, valores);

        Gson gson = new Gson();
        return gson.fromJson(jsonResultado, String[].class);
    }

    /**
     * Este metodo permite insertar una pregunta en la base de datos
     *
     * @param p es la pregunta que vamos a insertar
     * @return true si se inserta, false si no
     * @author Fernando
     */

    public static boolean insertarPregunta(Pregunta p) {
        Gson gson = new Gson();
        String values = gson.toJson(p);
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_INSERTAR_PREGUNTA, values);
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(respuesta);
        return element.getAsBoolean();
    }

    /**
     * Este metodo permite borrar una pregunta de la base de datos
     *
     * @param enunciado es el enunciado de la pregunta que vamos a borrar
     * @return true si se borra, false si no
     * @author Fernando
     */
    public static boolean borrarPregunta(String enunciado) {
        String query = null;
        query = "enunciado=" + URLEncoder.encode(enunciado, StandardCharsets.UTF_8);
        try {
            String response = HttpRequest.POST_REQUEST(Constantes.URL_BORRAR_PREGUNTA, query);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response);
            return element.getAsBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
        HashMap<String, String> params = new HashMap<>();
        params.put("enunciado", p.getEnunciado());
        params.put("respuestaCorrecta", p.getRespuestaCorrecta());
        params.put("respuestaIncorrecta1", p.getRespuestaIncorrecta1());
        params.put("respuestaIncorrecta2", p.getRespuestaIncorrecta2());
        params.put("respuestaIncorrecta3", p.getRespuestaIncorrecta3());
        params.put("enunciadoantiguo", enunciado);

        String query = String.join("&", params.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.toList()));
        try {
            String response = HttpRequest.POST_REQUEST(Constantes.URL_MODIFICAR_PREGUNTA,query);
            System.out.println(response);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response);
            return element.getAsBoolean();
        } catch (Exception e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_EXCEPTION, e);
            return false;
        }
    }

    /**
     * Este metodo permite obtener el id de una pregunta a partir de su enunciado
     * @param enunciado es el enunciado de la pregunta de la cual queremos obtener su id
     * @return el id de la pregunta
     * @author Fernando
     */
    public static int obtenerId(String enunciado) {
        String param = null;
        param = "enunciado=" + URLEncoder.encode(enunciado, StandardCharsets.UTF_8);
        try {
            String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_ID,param);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response);
            String result = element.toString().replaceAll("\"","");
            return Integer.parseInt(result);
        } catch (Exception e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_EXCEPTION, e);
            return -1;
        }
    }

    /**
     * Este metodo permite obtener todos los ids de las preguntas de la base de datos
     * @return un ArrayList con los ids de todas las preguntas de la base de datos
     * @author Fernando
     */
    public static ArrayList<Integer> obtenerIds(){
        try {
            String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_IDS,"");
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response);
            if (element.isJsonArray()) {
                ArrayList<Integer> list = new ArrayList<>();
                JsonArray jsonArray = element.getAsJsonArray();
                for (JsonElement jsonElement : jsonArray) {
                    list.add(jsonElement.getAsInt());
                }
                return list;
            } else {
                return null;
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_EXCEPTION, e);
            return null;
        }
    }

    /**
     * Este metodo permite obtener los datos de una pregunta a partir de su id
     * @param id es el id de la pregunta
     * @return un objeto pregunta
     * @author Fernando
     */
    public static Pregunta obtenerDatos(int id){
        String url = Constantes.URL_OBTENER_DATOS;
        String param = null;
        param = "id=" + URLEncoder.encode(String.valueOf(id), StandardCharsets.UTF_8);
        String jsonResultado = HttpRequest.GET_REQUEST(url, param);

        Gson gson = new Gson();
        String[] data = gson.fromJson(jsonResultado, String[].class);
        if(data != null){
            return new Pregunta(data[0],data[1],data[2],data[3],data[4]);
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
        String values = null;
        values = "enunciado=" + URLEncoder.encode(enunciado, StandardCharsets.UTF_8);
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_EXISTE_PREGUNTA, values);
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(respuesta);
        return element.getAsBoolean();
    }

    /**
     * Este metodo indica si una pregunta se ha acertado
     * @param idPartida es el id de la pregunta
     * @param idPregunta es el id de la partida
     * @return true si se acierta, false si no ( return !=0)
     */
    public static boolean preguntaAcertada(int idPartida, int idPregunta) {
        HashMap<String, String> params = new HashMap<>();
        params.put("idPartida", String.valueOf(idPartida));
        params.put("idPregunta", String.valueOf(idPregunta));
        String query = String.join("&", params.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.toList()));
        try {
            String response = HttpRequest.GET_REQUEST(Constantes.URL_PREGUNTA_ACERTADA,query);
            JsonParser parser = new JsonParser();
            int numero = parser.parse(response).getAsInt();
            return numero != 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_EXCEPTION, e);
            return false;
        }
    }
}
