package controller.administrador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import controller.baseDeDatos.Constantes;
import controller.baseDeDatos.HttpRequest;
import controller.tools.LoggerUtil;
import controller.tools.Mensajes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static controller.baseDeDatos.HttpRequest.POST_REQUEST;

/**
 * Esta clase nos permite gestionar las categorias de las preguntas
 *
 * @author Fernando
 */
public class GestionCategorias {
    private static final Logger logger = LoggerUtil.getLogger(GestionCategorias.class);
    /**
     * Este metodo nos permite obtener un ArrayList con los nombres de las categorias
     *
     * @return un ArrayList con los nombres de las categorias que contienen al menos una pregunta
     */
    public static ArrayList<String> obtenerCategorias() {
        String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_CATEGORIAS, "");
        Gson gson = new Gson();

        // Parsear la respuesta del servidor en una lista de listas de strings
        List<List<String>> categorias = gson.fromJson(response, new TypeToken<List<List<String>>>() {}.getType());

        // Crear un ArrayList para guardar los nombres de las categorías
        ArrayList<String> nombresCategorias = new ArrayList<>();

        // Recorrer la lista de categorías, obtener el nombre de cada categoría y añadirlo al ArrayList correspondiente
        for (List<String> categoria : categorias) {
            nombresCategorias.add(categoria.get(0));
        }

        return nombresCategorias;


    }

    /**
     * este metodo permite colocar las preguntas de una categoria
     * en la tabla
     *
     * @param tabla     es la tabla en la que vamos a colocar las preguntas
     * @param categoria es la categoria de las preguntas
     * @return el modelo de la tabla
     * @author Fernando
     */
    public static DefaultTableModel colocarPreguntas(JTable tabla, String categoria) {
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
        return modelo;
    }

    /**
     * Este metodo permite insertar una categoria en la base de datos
     *
     * @param nombre     es el nombre de la categoria
     * @param descripcion es la descripcion de la categoria
     * @return un valor mayor que 0 en caso de que se inserte la categoria
     * @author Fernando
     */
    public static int insertarCategoria(String nombre, String descripcion) {
        String values = null;
        try {
            values = "nombre=" + URLEncoder.encode(nombre, "UTF-8") + "&desc=" + URLEncoder.encode(descripcion, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_ENCODING, e);
        }

        String response = POST_REQUEST(Constantes.URL_INSERTAR_CATEGORIA, values);
        Gson gson = new Gson();
        return gson.fromJson(response, Integer.class);

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
        String values;
        values = null;
        try {
            values = "nombre=" + URLEncoder.encode(nombre, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_ENCODING, e);
        }
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_EXISTE_CATEGORIA, values);
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(respuesta);
        return element.getAsBoolean();
    }

    /**
     * Este metodo permite borrar una categoria de la base de datos
     * @param nombre es el nombre de la categoria que queremos borrar
     * @return true si se borra, false si no
     * @author Fernando
     */
    public static boolean borrarCategoria(String nombre) {
        String param = null;
        try {
            param = "nombre=" + URLEncoder.encode(nombre, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_ENCODING, e);
        }
        try {
            String response = HttpRequest.POST_REQUEST(Constantes.URL_BORRAR_CATEGORIA, param);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response);
            return element.getAsBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Este metodo permite modificar los datos de una categoria
     * @param nombreAntiguo es el nombre que tiene actualmente la categoria
     * @param nombreNuevo es el nombre nuevo que le vamos a poner a la categoria
     * @param descripcion es la descripcion nueva que le vamos a poner a la categoria
     * @return true si se ha modificado, false si no
     */
    public static boolean modificarCategoria(String nombreAntiguo, String nombreNuevo, String descripcion){
        try {
            // Crear un mapa con los parámetros a enviar
            Map<String, String> params = new HashMap<>();
            params.put("nombre", nombreNuevo);
            params.put("desc", descripcion);
            params.put("nombreant", nombreAntiguo);

            // Convertir el mapa en una cadena de consulta (query string)
            String query = params.entrySet().stream()
                    .map(e -> e.getKey() + "=" + e.getValue())
                    .collect(Collectors.joining("&"));

            // Hacer la petición POST
            String response = HttpRequest.POST_REQUEST(Constantes.URL_MODIFICAR_CATEGORIA, query);
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
     * Este metodo permite obtener el id de una categoria
     * a partir de su nombre
     * @param nombre es el nombre de la categoria que estamos buscando
     * @return el id de la categoria, -1 si no se encuentra
     */
    public static int obtenerIdCategoria(String nombre){
        String param = null;
        try {
            param = "nombre=" + URLEncoder.encode(nombre, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        try {
            String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_ID_CATEGORIA,param);
            JsonArray jsonArray = new Gson().fromJson(response, JsonArray.class); // convertimos la respuesta en un objeto JsonArray
             return jsonArray.get(0).getAsInt();
        } catch (Exception e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_EXCEPTION, e);
            return -1;
        }
    }

    /**
     * Este metodo permite obtener la descripcion de una categoria a partir de su nombre
     * @param nombre es el nombre de la categoria
     * @return la descripcion si la categoria existe, null si no
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
            String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_DESCRIPCION,param);
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(response, JsonArray.class);
            return jsonArray.get(0).getAsString();
        } catch (Exception e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_EXCEPTION, e);
            return null;
        }
    }

    /**
     * Este metodo nos permite obtener la categoria de una pregunta a traves su enunciado
     * @param pregunta es el enunciado de la pregunta de la cual queremos obtener su categoria
     * @return el nombre de la categoria de la pregunta, null si ocurre algun error
     * @author Fernando
     */
    public static String obtenerCategoriaPregunta(String pregunta){
        String param = null;
        try {
            param = "pregunta=" + URLEncoder.encode(pregunta, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        try {
            String response = HttpRequest.GET_REQUEST(Constantes.URL_OBTENER_CATEGORIA_PREGUNTA,param);
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(response, JsonArray.class);
            return jsonArray.get(0).getAsString();
        } catch (Exception e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_EXCEPTION, e);
            return "";
        }
    }

}
