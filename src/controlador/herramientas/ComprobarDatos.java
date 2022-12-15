package controlador.herramientas;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Esta clase contiene las expresiones regulares para poder comprobar datos
 * @author Fernando
 */
public class ComprobarDatos implements Patrones{
    /**
     * Este metodo permite comprobar que el nombre del usuario cumple con
     * los requisitos adecuados
     * @param cadena es la cadena que queremos comprobar
     * @return true si la cadena cumple con las condiciones, false si no
     * @author Fernando
     */
    public static boolean comprobarNombre(String cadena) {
        return cadena.matches(PATRON_NOMBRE);
    }

    /**
     * Este metodo nos permite comprobar que el formato del correo electronico
     * es valido
     * @param email es el email que queremos comprobar
     * @return true si el correo es valido, false si no lo es
     * @author Fernando
     */
    public static boolean comprobarCorreo(String email) {
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            return false;
        }
        return true;
    }

    /**
     * Este metodo comprueba que un el formato del numero de telefono
     * es valido
     * @param telefono es el telefono que queremos comprobar
     * @return true si es valido, false si no
     * @author Fernando
     */
    public static boolean comprobarTelefono(String telefono){
        return telefono.matches(PATRON_TELEFONO);
    }

    /**
     * Este metodo comprueba que las dos contraseñas son iguales
     * @param password1 es la primera contraseña
     * @param password2 es la segunda contraseña
     * @return true si las contraseñas coinciden, false si no
     * @author Fernando
     */
    public static boolean comprobarPassword(String password1, String password2){
        return password1.equals(password2);
    }

    /**
     * Este metodo permite comprobar que la contraseña contiene al menos
     * 8 caracteres de los cuales uno es un numero
     * @param password es la contraseña que queremos comprobar
     * @return true si es valida, false si no
     * @author Fernando
     */
    public static boolean comprobarFormatoPassword(String password){
        return password.matches(PATRON_FORMATO_PASSWORD);
    }



}
