package controller.tools;

/**
 * Esta interfaz contiene los patrones para comprobar los datos de
 * registro del usuario
 */
public interface Patrones {
    /**
     * Este patron comprueba que el nombre solo contiene letras y espacios
     */
    String PATRON_NOMBRE = "^[a-zA-Z ]*$";
    /**
     * Este patron comprueba que el telefono es una cadena con 9 numeros
     */
    String PATRON_TELEFONO = "^[0-9]{9}$";
    /**
     * Este patron comprueba que la contraseña contiene un minimo de 8 caracteres
     * de los cuales al menos uno es un numero
     */
    String PATRON_FORMATO_PASSWORD = "^(?=.*[0-9]).{8,}$";
    /**
     * Este patron permite comprobar que el correo introducido por
     * el usuario es correcto
     */
    String PATRON_EMAIL = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

}
