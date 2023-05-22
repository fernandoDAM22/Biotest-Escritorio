package controller.tools;

import controller.administrador.GestionCategorias;
import controller.baseDeDatos.ConexionBD;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase nos permite crear informes sobre algunas tablas de la base
 * de datos
 * @author Fernando
 */
public class Informes {
    /**
     * Este metodo nos permite crear un informe con el numero de preguntas
     * de cada categoria
     * @throws JRException en caso de que ocurra algun error al generar el informe
     * @author Fernando
     */
    public static void informePreguntasPorCategoria() throws JRException, FileNotFoundException {
        //comprobamos que la carpeta resultados existe
        comprobarCarpeta();
        //Indicamos las carpetas donde se encuentra el origen y destino del informe
        String reportSource = "templatesInformes/cuentaPreguntasCategoria.jrxml";
        String reportDest = "resultadosInformes/cuentaPreguntasCategoria.html";
        //Compilamos el informe .jrxml  para generar el .jasper
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
        //Creamos la conexion a la bd para poder rellenar el .jasper con los datos de la bd
        ConexionBD cbd = new ConexionBD();
        Connection conn = cbd.abrirConexion();
        //Cargamos los datos en el jasper pasandole los parámetros y la conexion a la BD
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
        //Exportamos el informe
        JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        viewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewer.setVisible(true);
    }
    /**
     * Este metodo nos permite crear un informe con las categorias
     * de la base de datos
     * @throws JRException en caso de que ocurra algun error al generar el informe
     * @author Fernando
     */
    public static void informeCategorias() throws JRException, FileNotFoundException {
        //comprobamos que la carpeta resultados existe
        comprobarCarpeta();
        //Indicamos las carpetas donde se encuentra el origen y destino del informe
        String reportSource = "templatesInformes/categorias.jrxml";
        String reportDest = "resultadosInformes/categorias.html";
        //Compilamos el informe .jrxml  para generar el .jasper
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
        //Creamos la conexion a la bd para poder rellenar el .jasper con los datos de la bd
        ConexionBD cbd = new ConexionBD();
        Connection conn = cbd.abrirConexion();
        //Cargamos los datos en el jasper pasandole los parámetros y la conexion a la BD
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
        //Exportamos el informe
        JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        viewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewer.setVisible(true);
    }
    /**
     * Este metodo nos permite crear un informe con las preguntas
     * de la categoria indicada
     * @param categoria es la categoria de la cual queremos realizar el informe
     * @throws JRException en caso de que ocurra algun error al generar el informe
     * @author Fernando
     */

    public static void informePreguntasPorCategoria(String categoria) throws JRException, FileNotFoundException {
        //comprobamos que la carpeta resultados existe
        comprobarCarpeta();
        String reportSource = "templatesInformes/informacionPreguntas.jrxml";
        String reportDest = "resultadosInformes/preguntas.html";
        //Crear un mapa para guardar parametros que podemos pasar al informe
        Map<String, Object> params = new HashMap<>();
        params.put("id_categoria", GestionCategorias.obtenerIdCategoria(categoria));
        //Compilamos el informe .jrxml  para generar el .jasper
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
        //Creamos la conexion a la bd para poder rellenar el .jasper con los datos de la bd
        ConexionBD cbd = new ConexionBD();
        Connection conn = cbd.abrirConexion();
        //Cargamos los datos en el jasper pasandole los parámetros y la conexion a la BD
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
        //Exportamos el informe
        JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);

        //Y lo visualizamos
        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        viewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewer.setVisible(true);
    }
    /**
     * Este metodo nos permite crear un informe con las preguntas de la base de datos
     * @throws JRException en caso de que ocurra algun error al generar el informe
     * @author Fernando
     */

    public static void informePreguntas() throws JRException, FileNotFoundException {
        //comprobamos que la carpeta resultados existe
        comprobarCarpeta();
        //Indicamos las carpetas donde se encuentra el origen y destino del informe
        String reportSource = "templatesInformes/datosPreguntas.jrxml";
        String reportDest = "resultadosInformes/datosPreguntas.html";
        //Compilamos el informe .jrxml  para generar el .jasper
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

        //Creamos la conexion a la bd para poder rellenar el .jasper con los datos de la bd
        ConexionBD cbd = new ConexionBD();
        Connection conn = cbd.abrirConexion();

        //Cargamos los datos en el jasper pasandole los parámetros y la conexion a la BD
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);

        //Exportamos el informe
        JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
        //lo visualizamos
        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        viewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewer.setVisible(true);
    }

    /**
     * Este metodo permite comprobar que la carpeta resultados existe,
     * en caso de no existir la crea
     * @author Fernando
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void comprobarCarpeta(){
        File file = new File("resultadosInformes");
        if(!file.exists()){
            file.mkdirs();
        }
    }
}
