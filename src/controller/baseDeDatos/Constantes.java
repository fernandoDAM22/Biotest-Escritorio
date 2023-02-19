package controller.baseDeDatos;

/**
 * Clase Constantes
 * 
 * @author encarna
 *
 */
public interface Constantes {

	String SERVER = "http://localhost/webServiceProyecto/";


	String URL_REGISTRO = SERVER + "acceso/registro.php";
	String URL_LOGIN = SERVER + "acceso/login.php";
	String 	URL_PREGUNTAS_CATEGORIA = SERVER + "admin/preguntas/listarPreguntasDeCategoria.php";
	String URL_PREGUNTAS_CUESTIONARIO = SERVER + "admin/preguntas/obtenerPreguntasCuestionario.php";
	String URL_OBTENER_RESPUESTAS = SERVER + "admin/preguntas/obtenerRespuestas.php";
	String URL_INSERTAR_PREGUNTA = SERVER + "admin/preguntas/insertarPregunta.php";
	String URL_BORRAR_PREGUNTA  = SERVER + "admin/preguntas/borrarPregunta.php";
	String URL_MODIFICAR_PREGUNTA = SERVER + "admin/preguntas/modificarPregunta.php";



}
