package controller.baseDeDatos;

import com.google.gson.internal.bind.JsonTreeReader;

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
	String URL_OBTENER_ID = SERVER + "admin/preguntas/obtenerId.php";
	String URL_OBTENER_IDS = SERVER + "admin/preguntas/obtenerIds.php";
	String URL_OBTENER_DATOS = SERVER + "admin/preguntas/obtenerDatos.php";
	String URL_EXISTE_PREGUNTA = SERVER + "admin/preguntas/existePregunta.php";
	String URL_PREGUNTA_ACERTADA = SERVER + "admin/preguntas/preguntaAcertada.php";

	String URL_OBTENER_CATEGORIAS = SERVER + "admin/categorias/listarCategorias.php";
	String URL_INSERTAR_CATEGORIA = SERVER + "admin/categorias/insertarCategoria.php";
	String URL_EXISTE_CATEGORIA  = SERVER +"admin/categorias/existeCategoria.php";
	String URL_BORRAR_CATEGORIA = SERVER + "admin/categorias/borrarCategoria.php";
	String URL_MODIFICAR_CATEGORIA = SERVER + "admin/categorias/modificarCategoria.php";
	String URL_OBTENER_ID_CATEGORIA = SERVER + "admin/categorias/obtenerIdCategoria.php";
	String URL_OBTENER_DESCRIPCION = SERVER + "admin/categorias/obtenerDescripcion.php";
	String URL_OBTENER_CATEGORIA_PREGUNTA = SERVER + "admin/categorias/obtenerCategoriaPregunta.php";

}
