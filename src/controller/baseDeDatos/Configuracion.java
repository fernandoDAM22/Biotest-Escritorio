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
     * Es el nombre del usuario administrador
     */
    String ADMIN = "root";
    /**
     * Contraseña del usuario
     */
    String PASSWORD_ADMIN = "";
    /**
     * Ruta a la instacion de nuestro XAMPP
     */
    String XAMPP_PATH = "C:/xamppp/mysql/";
    /**
     * Email desde el cual se mandan los emails con el resumen de la partida
     */
    String  EMAIL = "BioTestProyecto@gmail.com";
    /**
     * Password generada para el email desde el cual se mandan los emails con el resumen de la partida
     */
    String EMAIL_PASSWORD = "exrsdgkstaivnerh";
    /**
     * Host para enviar los emails con el resumen de la partida
     */
    String SMTP_HOST  = "smtp.gmail.com";
    /**
     * Puerto para enviar los emails con el resumen de la partida
     */
    int SMTP_PORT = 587;
}
