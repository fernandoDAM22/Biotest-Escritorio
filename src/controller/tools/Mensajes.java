package controller.tools;

/**
 * En esta interfaz tenemos los mensajes que mostramos al usuario
 * @author Fernando
 */
public interface Mensajes {
    //--------------------------------------DESCRIPCION DE LOS MODOS DE JUEGO--------------------------------
    String DESCRIPCION_MODO_LIBRE = "En este modo de juego podras responder todas las preguntas que quieras";
    String DESCRIPCION_MODO_SIN_FALLOS = "En este modo de juego podras responder preguntas hasta que falles una";
    String DESCRIPCION_MODO_CLASICO = "En este modo de juego jugaras una partida de 10 preguntas";
    String DESCRIPCION_CUESTIONARIOS = "En este modo de juego jugaras una partida resolviendo un cuestionario";
    //-------------------------------------MENSAJES DE LOS DIAOLOGOS------------------------------------------
    String ERROR = "Error";
    String CONFIRMACION_BACKUP = "¿Estas seguro de que quieres realizar una copia de seguridad?";
    String BACKUP_CORRECTO = "Copia realizada correctamente";

    String ERROR_USERNAME = "Error, el nombre no es valido";
    String ERROR_EMAIL = "Error, el email no es valido";
    String ERROR_FORMATO_PASSWORD = "Error, la contraseña debe tener minino 8 caracteres y un numero";
    String ERROR_PASSWORDS = "Error, las contraseñas no coinciden";
    String ERROR_TELEFONO = "Error, el telefono no es correcto";
    String ERROR_EXISTE_USUARIO = "Error, ya existe un usuario con ese nombre";
    String OPERACION_CANCELADA = "Operacion cancelada";
    String NO_EXISTE_USUARIO = "No existe el usuario";
    String PASSWORD_INCORRECTA = "Contraseña Incorrecta";
    String RELLENE_TODOS_LOS_CAMPOS = "Rellene todos los campos";
    String PREGUNTA_BORRADA = "Pregunta borrada correctamente";
    String ERROR_BORRAR_PREGUNTA = "No se ha podido borrar la pregunta, consulte el manual";
    String MENSAJE_CONFIRMACION = "¿Estas seguro de que quieres realizar la accion?";
    String USUARIO_BORRADO = "Usuario borrado correctamente";
    String ERROR_BORRAR_USUARIO = "No se ha podido borrar el usuario, consulte el manual";
    String ERROR_BACKUP = "Error al realizar la copia de seguridad";
    String IMPORTACION_CORRECTA = "Copia importada correctamente";
    String ERROR_IMPORTACION = "Error al importar la copia, consulte el manual";
    String ERROR_EXISTE_PREGUNTA = "Ya existe una pregunta con ese enunciado";
    String PREGUNTA_INSERTADA = "Pregunta Insertada Correctamente";
    String ERROR_INSERTAR_PREGUNTA = "No se ha podido insertar la pregunta";
    String PREGUNTA_MODIFICADA = "Pregunta Modificada Correctamente";
    String ERROR_MODIFICAR_PREGUNTA = "No se ha podido Modificar la pregunta";
    String ERROR_EXISTE_CATEGORIA = "Ya existe una categoria con ese nombre";
    String CATEGORIA_MODIFICADA = "Categoria Modificada Correctamente";
    String ERROR_MODIFICAR_CATEGORIA = "No se ha podido modificar la categoria";
    String CATEGORIA_BORRADA = "Categoria borrada correctamente";
    String ERROR_BORRAR_CATEGORIA = "No se ha podido borrar la categoria, consulte el manual";
    String CATEGORIA_INSERTADA = "Categoria insertada correctamente";

    String ERROR_EXISTE_CUESTIONARIO = "Ya existe un cuestionario con ese nombre";
    String CUESTIONARIO_INSERTADO = "Cuestionario insertado correctamente";
    String ERROR_INSERTAR_CUESTIONARIOS = "No se ha podido insertar el cuestionario";
    String CUESTIONARIO_BORRADO = "Cuestionario borrado correctamente";
    String ERROR_BORRAR_CUESTIONARIO = "No se ha podido borrar el cuestionario";
    String CUESIONARIO_MODIFICADO = "Cuestionario modificado correctamente";
    String ERROR_MODIFICAR_CUESIONARIO = "No se ha podido modificar el cuestionario";
    String EMAIL_CAMBIADO = "Email Cambiado correctamente";
    String ERROR_CAMBIAR_EMAIL = "No se ha podido cambiar el email";
    String ERROR_CAMBIAR_PASSWORD = "Error al cambiar la contraseña";
    String PASSWORD_CAMBIADA = "Contraseña cambiada correctamente";
    String USUARIO_CAMBIADO = "Usuario cambiado correctamente";
    String ERROR_CAMBIAR_USERNAME = "No se ha podido cambiar el nombre de usuario";
    String TELEFONO_CAMBIADO = "Telefono cambiado correctamente";
    String SELECCIONE_MODO_JUEGO = "Seleccione un modo de juego";
    String USUARIO_REGISTRADO = "Usuario registrado correctamente" ;
    String ERROR_MISMO_USUARIO = "Error, no puedes borrar tu mismo usuario";
    //----------------------------------BOTONES---------------------------------------------//
    String MENSAJE_BORRAR = "Eliminar";
    //-----------------------------------LOGGER--------------------------------------------//
    //mensajes para registrar las excepciones en el archivo log

    String ERROR_SELECCION_USUARIO = "No tienes seleccionado ningun usuario";
    String USUARIO_MODIFICADO = "Usuario modificado correctamente";
    String ERROR_MODIFICAR_USUARIO = "No se ha podido modificar el usuario";
    String ERROR_INSERTAR_USUARIO = "No se ha podido insertar el usuario";
    String CORRECTO = "Correcto";
    String TITULO_CONFIRMACION = "¿Estas seguro?";
    Object ERROR_CUESTIONARIO_SELECCIONADO = "Error, no tienes seleccionado ningun cuestionario";
    String ERROR_ENCODING = "Se produjo una excepción al insertar una pregunta";
    String ERROR_EXCEPTION = "Se produjo una excepcion";
    String ERROR_SQL_EXCEPTION = "Se produjo una excepcion de sql";
    String ERROR_ENTRADA_SALIDA = "Se produjo un error en la entrada/salida";
    String ERROR_NULL_POINTER_EXCEPCION = "Se produjo un error de puntero nulo";
}
