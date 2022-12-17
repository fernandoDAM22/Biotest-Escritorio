package controlador.administrador.categorias;

import com.kitfox.svg.A;
import controlador.administrador.preguntas.GestionPreguntas;
import controlador.baseDeDatos.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta clase nos permite gestionar las categorias de las preguntas
 * @author Fernando
 */
public class GestionCategorias {
    /**
     * Este metodo nos permite obtener un ArrayList con los nombres de las categorias
     * que contienen al menos una pregunta
     *
     * @return un ArrayList con los nombres de las categorias que contienen al menos una pregunta
     */
    public static ArrayList<String> obtenerCategorias() {
        PreparedStatement sentencia = null;
        ConexionBD conexionBD = null;
        Connection conexion = null;
        ResultSet resultSet = null;
        ArrayList<String> nombresCategorias = new ArrayList<>();
        String sql = "SELECT c.nombre from preguntas p join categoria c on p.id_categoria = c.id " +
                "GROUP by c.nombre HAVING COUNT(p.id) > 0";
        conexionBD = new ConexionBD();
        try {
            conexion = conexionBD.abrirConexion();
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            while (resultSet.next()){
                nombresCategorias.add(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            assert sentencia != null;
            try {
                sentencia.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexionBD.cerrarConexion();
        }
        return nombresCategorias;
    }

    /**
     * este metodo permite colocar las preguntas de una categoria
     * en la tabla
     *
     * @param tabla es la tabla en la que vamos a colocar las preguntas
     * @param categoria es la categoria de las preguntas
     * @return el modelo que se le asigna a la tabla, para poder acceder
     *          a las preguntas desde la ventana donde se encuentra la tabla
     * @author Fernando
     */
    public static DefaultTableModel colocarPreguntas(JTable tabla,String categoria){
        //obtenemos todas las preguntas de una categoria en concreto
        ArrayList<String[]> preguntas = GestionPreguntas.obtenerPreguntas(categoria);
        //creamos el modelo
        DefaultTableModel modelo = new DefaultTableModel(new String[]{
                "Pregunta", "Respuesta Correcta", "Respuesta Incorrecta 1", "Respuesta Incorrecta 2", "Respuessta Incorrecta 3"
        }, 0);
        //y se lo añadimos a la tabla
        tabla.setModel(modelo);
        //agragamos las preguntas al modelo
        for (String[] s : preguntas) {
            modelo.addRow(s);
        }
        return modelo;
    }
}
