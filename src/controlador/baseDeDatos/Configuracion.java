package controlador.baseDeDatos;

/**
 * Esta interfaz contiene la configuracion para
 * poder conectarnos a la base de datos
 * @author Fernando
 */
public interface Configuracion {
    /**
     * Nombre del host
     */
    String DBHOST = "localhost";
    /**
     * nombre de la base de datos
     */
    String DBNAME = "preguntas";
    /**
     * Contraseña del usuario
     */
    String PASSWORD_ADMIN = "admin123456";
    /**
     * Contraseña del usuario normal
     */
    String PASSWORD_USER = "user123456";
}
