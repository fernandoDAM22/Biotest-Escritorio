package controller.administrador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import controller.baseDeDatos.ConexionBD;
import controller.baseDeDatos.Constantes;
import controller.baseDeDatos.HttpRequest;
import model.Cuestionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static controller.baseDeDatos.HttpRequest.POST_REQUEST;

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
        String values;
        try {
            values = "nombre=" + URLEncoder.encode(nombre, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_EXISTE_CUESTIONARIO, values);
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(respuesta);
        return element.getAsBoolean();
    }

    /**
     * Este metodo permite obtener los cuestionarios de una determinada categoria
     *
     * @param categoria es la categoria de la que queremos obtener los cuestionaros
     * @return un ArrayList con los nombres de los cuestionarios
     * @author Fernando
     */
    public static ArrayList<String> obtenerCuestionarios(String categoria) {
        String param;
        try {
            param = "categoria="+URLEncoder.encode(categoria, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_CUESTIONARIOS,param);
        Gson gson = new Gson();
        JsonArray jsonArray = new Gson().fromJson(response, JsonArray.class);
        ArrayList<String> data = new ArrayList<>();

        for (JsonElement element : jsonArray) {
            data.add(element.getAsString());
        }

        return data;
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
        String values = null;
        try {
            values = "nombre=" + URLEncoder.encode(nombre, "UTF-8")
                    + "&desc=" + URLEncoder.encode(descripcion, "UTF-8")
                    + "&idcategoria=" + idCategoria;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String response = POST_REQUEST(Constantes.URL_INSERTAR_CUESTIONARIO, values);
        System.out.println(response);
        Gson gson = new Gson();
        return gson.fromJson(response, Integer.class);

    }

    /**
     * Este metodo permite obtener el id de un cuestionario
     *
     * @param nombre es el nombre del cuestionario del que queremos saber su id
     * @return el id del cuestionario en caso de que exista, -1 si no existe
     * @author Fernando
     */
    public static int obtenerId(String nombre) {
        String param = null;
        try {
            param = "nombre=" + URLEncoder.encode(nombre, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        try {
            String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_ID_CUESTIONARIO,param);
            JsonArray jsonArray = new Gson().fromJson(response, JsonArray.class); // convertimos la respuesta en un objeto JsonArray
            return jsonArray.get(0).getAsInt();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
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
        HashMap<String, String> params = new HashMap<>();
        params.put("cuestionario", String.valueOf(idCuestionario));
        params.put("pregunta", String.valueOf(idPregunta));
        String query = String.join("&", params.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.toList()));
        try {
            String response = HttpRequest.POST_REQUEST(Constantes.URL_INSERTAR_PREGUNTA_CUESTIONARIO,query);
            System.out.println(response);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response);
            return element.getAsBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Este metodo permite colocar las preguntas de un cuestionario en la tabla de preguntas
     *
     * @param tabla        es la tabla donde queremos colocar las preguntas
     * @param cuestionario es el cuestionario que contiene las preguntas que le vamos a colocar a la tabla
     * @return el modelo que se asigna a la tabla
     * @author Fernando
     */
    public static DefaultTableModel colocarPreguntas(JTable tabla, String cuestionario) {
        //obtenemos todas las preguntas de una categoria en concreto
        ArrayList<String[]> preguntas = GestionPreguntas.obtenerPreguntasCuestionario(cuestionario);
        //creamos el modelo
        DefaultTableModel modelo = new DefaultTableModel(new String[]{
                "Pregunta", "Respuesta Correcta", "Respuesta Incorrecta 1", "Respuesta Incorrecta 2", "Respuessta Incorrecta 3"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //y se lo añadimos a la tabla
        tabla.setModel(modelo);
        //agregamos las preguntas al modelo
        for (String[] s : preguntas) {
            modelo.addRow(s);
        }
        return modelo;
    }

    /**
     * Este metodo permite borrar una pregunta de un cuestionario
     *
     * @param idCuestionario es el id del cuestionario al que le queremos borrar la pregunta
     * @param idPregunta     es el id de la pregunta que queremos borrar
     * @return true si se borra, false si no
     */
    public static boolean borrarPregunta(int idCuestionario, int idPregunta) {
        HashMap<String, String> params = new HashMap<>();
        params.put("cuestionario", String.valueOf(idCuestionario));
        params.put("pregunta", String.valueOf(idPregunta));
        String query = String.join("&", params.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.toList()));
        try {
            String response = HttpRequest.POST_REQUEST(Constantes.URL_BORRAR_PREGUNTA_CUESTIONARIO,query);
            System.out.println(response);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response);
            return element.getAsBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Este metodo permite obtener la descripcion de un cuestionario a partir de su nombre
     *
     * @param nombre es el nombre del cuestionario del que queremos obtener la descripcion
     * @return la descripcion si el cuestionario existe, null si no existe
     * @author Fernando
     */
    public static String obtenerDescripcion(String nombre) {
        String param = null;
        try {
            param = "nombre=" + URLEncoder.encode(nombre, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        try {
            String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_DESCRIPCION_CUESTIONARIO,param);
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(response, JsonArray.class);
            return jsonArray.get(0).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Este metodo permite modificar los datos de un cuestionario
     *
     * @param c es el objeto que contiene los datos del cuestionario
     * @return true si se modifica, false si no
     * @author Fernando
     */
    public static boolean modificar(Cuestionario c) {
        String values = null;
        try {
            values = "nombre=" + URLEncoder.encode(c.getNombre(), "UTF-8")
                    + "&desc=" + URLEncoder.encode(c.getDescripcion(), "UTF-8")
                    + "&id=" + c.getId();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String response = POST_REQUEST(Constantes.URL_MODIFICAR_CUESTIONARIO, values);
        Gson gson = new Gson();
        return gson.fromJson(response, Boolean.class);

    }

    /**
     * Este metodo permite borrar un cuestionario a partir de su id
     *
     * @param id es el id del cuestionario que queremos borrar
     * @return true si se borra, false si no
     * @author Fernando
     */
    public static boolean borrar(int id) {
        String values = "id=" + id;
        try {
            String response = HttpRequest.POST_REQUEST(Constantes.URL_BORRAR_CUESTIONARIO, values);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response);
            return element.getAsBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Este metodo nos permite obtener los cuestionarios que cuenten con 10 o
     * mas preguntas
     * @return un ArrayList con los nombres de los cuestionarios
     * @author Fernando
     */
    public static ArrayList<String> obtenerCuestionariosCompletos() {
        String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_CUESTIONARIOS_COMPLETOS,"");
        Gson gson = new Gson();
        JsonArray jsonArray = new Gson().fromJson(response, JsonArray.class);
        ArrayList<String> data = new ArrayList<>();

        for (JsonElement element : jsonArray) {
            data.add(element.getAsString());
        }
        return data;
    }

    /**
     * Este metodo permite obtener los ids de las preguntas de un cuestionario a partir
     * de su nombre
     * @param cuestionario es el nombre del cuestionario
     * @return un ArrayList con los ids de las preguntas
     * @author Fernando
     */
    public static ArrayList<Integer> obtenerIdPreguntas(String cuestionario) {
        String param = null;
        try {
            param = "nombre=" +  URLEncoder.encode(cuestionario, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        try {
            String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_ID_PREGUNTAS_CUESTIONARIOS,param);
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
            e.printStackTrace();
            return null;
        }

    }
}

