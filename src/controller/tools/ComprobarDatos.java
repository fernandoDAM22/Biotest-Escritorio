package controller.tools;

import controller.baseDeDatos.ConexionBD;
import controller.usuario.Codigos;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase contiene las expresiones regulares para poder comprobar datos
 * @author Fernando
 */
public class ComprobarDatos implements Patrones{
    private static final Logger logger = LoggerUtil.getLogger(ComprobarDatos.class);
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
        return email.matches(PATRON_EMAIL);
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
    /**
     * Este metodo permite comprobar si existe un usuario con un deteminado
     * nombre en la base de datos
     * @param nombre es el nombre del usuario que queremos comprobar
     * @return Codigos.ERROR si existe alguien con ese nombre, 0 si no
     * @author Fernando
     */
    public static int existeUsuario(String nombre) {
        ResultSet resultSet;
        int resultado = Codigos.ERROR;
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        /*
          Tenemos que usar la clausula BINARY para poder obtener el usuario que se llame exactamente
          igual al que estamos buscando, ya que con el igual o con el like no distingue entre mayusculas
          y minusculas
         */
        String sql = "SELECT * FROM usuarios WHERE BINARY nombre = ?";

        try {
            conexionBD = new ConexionBD();
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,nombre);
            resultSet = sentencia.executeQuery();
            if(resultSet.next()){
                resultado = 1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                sentencia.close();
                conexionBD.cerrarConexion();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
            }catch (NullPointerException npe){
                logger.log(Level.SEVERE, Mensajes.ERROR_NULL_POINTER_EXCEPCION, npe);
            }
        }
        return resultado;
    }



}
