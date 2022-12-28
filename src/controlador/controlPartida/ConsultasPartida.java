package controlador.controlPartida;

import com.kitfox.svg.A;
import controlador.baseDeDatos.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta clase contiene los metodos que implican consultas a la
 * base de datos relacionadas con las partidas
 * @author Fernando
 */
public class ConsultasPartida {
    /**
     * Este metodo permite obtener todos los id de las partidas
     * @return un ArrayList con los ids de las partidas, null si ocurre algun error
     * @author Fernando
     */
    public static ArrayList<Integer> obtenerId(){
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet;
        String sql = "select id from partidas";
        ArrayList<Integer> ids = new ArrayList<>();
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()){
                ids.add(resultSet.getInt("id"));
            }

        } catch (SQLException e) {
            return null;
        }finally {
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
        return ids;
    }
}
