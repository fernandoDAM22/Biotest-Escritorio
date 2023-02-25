package controller.baseDeDatos;

import controller.tools.LoggerUtil;
import controller.tools.Mensajes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase nos permite conectarnos a una base de datos
 *
 * @author Fernando
 */
public class ConexionBD implements Configuracion {
    private static final Logger logger = LoggerUtil.getLogger(ConexionBD.class);
    /**
     * Objeto connection a la base de datos
     */
    Connection conexion;
    /**
     * Usuario de la base de datos
     */
    String usuario;
    /**
     * Contrasena del usuario en la base de datos
     */
    String password;

    /**
     * Constructor sin parametros
     */
    public ConexionBD() {
        this.usuario = ADMIN;
        this.password = PASSWORD_ADMIN;
    }

    /**
     * Constructor con parametros
     *
     * @param usuario  es el usuario que se conecta
     * @param password es la contraseña del usuario
     */
    public ConexionBD(String usuario, String password) {
        // super();
        this.usuario = usuario;
        this.password = password;
    }


    /**
     * Este metodo nos permite abrir una conexion
     * en la base de datos
     *
     * @return la conexion a la base de datos
     */
    public Connection abrirConexion() {
        try {
            //Cargamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");//actual mysql-connector-j-8.0.31.jar

            try {
                conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + DBHOST + ":3306/" + DBNAME,
                        this.usuario, this.password);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conexion;

    }

    /**
     * Nos permite cerrar la conexion en la base de datos
     *
     * @return
     */
    public boolean cerrarConexion() {
        try {
            if(conexion != null) conexion.close();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, ex);
            return false;
        }
        return true;
    }

    /**
     * Este metodo permite cerrar las conexiones en la base de datos
     *
     * @param resultSet  un objeto ResultSet
     * @param sentencia  un objeto PreparedStatement
     * @param conexionBD un objeto ConexionBD
     * @author Fernando
     */
    public static void cerrar(ResultSet resultSet, PreparedStatement sentencia, ConexionBD conexionBD) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexionBD != null) {
                conexionBD.cerrarConexion();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
        }
    }
    /**
     * Este metodo permite cerrar las conexiones en la base de datos
     *
     * @param sentencia  un objeto PreparedStatement
     * @param conexionBD un objeto ConexionBD
     * @author Fernando
     */

    public static void cerrar(PreparedStatement sentencia, ConexionBD conexionBD) {
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexionBD != null) {
                conexionBD.cerrarConexion();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
        }
    }

}
