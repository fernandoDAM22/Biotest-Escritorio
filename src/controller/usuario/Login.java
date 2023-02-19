package controller.usuario;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import controller.baseDeDatos.Cifrado;
import controller.baseDeDatos.ConexionBD;
import controller.baseDeDatos.Constantes;
import controller.baseDeDatos.HttpRequest;
import controller.tools.ComprobarDatos;
import model.Pregunta;
import model.Usuario;
import com.google.gson.JsonParser;

import java.awt.*;
import java.lang.reflect.Type;

public class Login implements Codigos {
    /**
     * Este metodo permite comprobar si los datos introducidos
     * en el formulario de login son correctos
     * @param nombre es el nombre de la persona
     * @param password es la contraseña de la persona
     * @return el codigo de error correspondiente
     * @author Fernando
     */
    public static int login(String nombre, String password) {
        if (ComprobarDatos.existeUsuario(nombre) == ERROR) {
            return ERROR_NO_EXISTE_USUARIO;
        }
        if (Cifrado.SHA256(password).equals(obtenerDatos(nombre,Codigos.OBTENER_PASSWORD))) {
            return CORRECTO;
        }
        return ERROR_PASSWORD_INCORRECTA;
    }

    /**
     * Este metodo nos permite obtener algun dato de una persona
     * a partir de su nombre
     * @param nombre es el nombre de la persona que estamos buscando
     * @param tipoDato es el dato que queremos obtener del usuario
     * @return el dato indicado si existe la persona, una cadena vacia si no existe
     * @author Fernando
     */
    public static String obtenerDatos(String nombre,String tipoDato) {
        String url = Constantes.URL_LOGIN;
        String valores = "nombre=" + nombre;
        String jsonResultado = HttpRequest.GET_REQUEST(url, valores);

        Gson gson = new Gson();
        JsonElement jsonElement = gson.fromJson(jsonResultado, JsonElement.class);
        JsonArray jsonArray = jsonElement.getAsJsonArray();

        int id = jsonArray.get(0).getAsInt();
        String name = jsonArray.get(1).getAsString();
        String contrasena = jsonArray.get(2).getAsString();
        String email = jsonArray.get(3).getAsString();
        String telefono = jsonArray.get(4).getAsString();
        String tipo = jsonArray.get(5).getAsString();

        Usuario usuario = new Usuario(id, name, contrasena, email, telefono, tipo);
        if (tipoDato.equals(Codigos.OBTENER_PASSWORD)) {
            return usuario.getPassword();
        } else if (tipoDato.equals(Codigos.OBTENER_TIPO)) {
            return usuario.getTipo();
        }

        return null;
    }

}
