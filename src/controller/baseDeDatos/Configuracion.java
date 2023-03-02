package controller.baseDeDatos;

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
     * Es el nombre del usuario sin privilegios
     */
    String USER = "user";
    /**
     * Es el nombre del usuario administrador
     */
    String ADMIN = "root";
    /**
     * Contraseña del usuario
     */
    String PASSWORD_ADMIN = "";
    /**
     * Contraseña del usuario normal
     */
    String PASSWORD_USER = "user123456";
    /**
     * Ruta a la instacion de nuestro XAMPP
     */
    String XAMPP_PATH = "C:/xamppp/mysql/";
}
