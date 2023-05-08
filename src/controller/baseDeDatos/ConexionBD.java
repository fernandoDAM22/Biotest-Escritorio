package controller.baseDeDatos;

import controller.tools.JSONReader;
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
public class ConexionBD {
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
        this.usuario = JSONReader.getConfigValue(JSONReader.DATABASE,JSONReader.ADMIN);
        this.password = JSONReader.getConfigValue(JSONReader.DATABASE,JSONReader.ADMIN_PASSWORD);
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
        String dbhost = JSONReader.getConfigValue(JSONReader.DATABASE,JSONReader.DBHOST);
        String dbname = JSONReader.getConfigValue(JSONReader.DATABASE,JSONReader.DBNAME);
        try {
            //Cargamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");//actual mysql-connector-j-8.0.31.jar

            try {
                conexion = DriverManager.getConnection("jdbc:mysql://" + dbhost + ":3306/" + dbname,
                        this.usuario, this.password);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
        }

        return conexion;

    }

    /**
     * Nos permite cerrar la conexion en la base de datos
     */
    public void cerrarConexion() {
        try {
            if(conexion != null) conexion.close();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, ex);
        }
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
            closeResultSet(resultSet);
            cerrarSentencia(sentencia);
            cerrarConexion(conexionBD);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
        }
    }

    /**
     * Este metodo permite cerrar un objeto ResultSet
     * @param resultSet es el resultSet que queremos cerrar
     * @throws SQLException en caso de que ocurran problemas con la conexion a la base de datos
     * @author Fernando
     */
    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
    }

    /**
     * Este metodo permite cerrar una sentencia preparada
     * @param sentencia es la sentencia preparada que queremos cerrar
     * @throws SQLException en caso de que ocurran problemas con la conexion a la base de datos
     * @author Fernando
     */
    public static void cerrarSentencia(PreparedStatement sentencia) throws SQLException {
        if (sentencia != null) {
            sentencia.close();
        }
    }

    /**
     * Este metodo permite cerrar una conexion a la base de datos
     * @param conexionBD es la conexion que queremos cerrar
     * @author Fernando
     */
    public static void cerrarConexion(ConexionBD conexionBD){
        if(conexionBD != null){
            conexionBD.cerrarConexion();
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
            cerrarSentencia(sentencia);
            cerrarConexion(conexionBD);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_SQL_EXCEPTION, e);
        }
    }

}
