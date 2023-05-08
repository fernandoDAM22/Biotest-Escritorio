package controller.baseDeDatos;

import controller.tools.JSONReader;
import controller.tools.LoggerUtil;
import controller.tools.Mensajes;
import controller.usuario.Codigos;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Este clase permite crear copias de seguridad de la base de datos mysql
 * @author Fernando
 */
public class CopiaDeSeguridad implements Codigos {
    private static final Logger logger = LoggerUtil.getLogger(CopiaDeSeguridad.class);
    /**
     * Es la ruta donde se guardan las copias de seguridad
     */
    private  static final String RUTA_COPIA = "./backups/";

    /**
     * Este método permite crear una copia de seguridad de la base de datos,
     * la copia se guarda en la ruta donde indique la variable {@code RUTA_COPIA} (./backups/),
     * con el nombre compuesto por la fecha actual + "copia.sql"
     * @return true si se crea la copia, false si no
     * @author Fernando
     */
    public static boolean crearCopia(){
        comprobarCarpeta();
        try {


            ProcessBuilder builder = new ProcessBuilder(comandoCrear());
            builder.redirectOutput(ProcessBuilder.Redirect.to(new java.io.File(nombreCopia())));

            Process process = builder.start();
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_EXCEPTION, e);
            return false;
        }
        return true;
    }

    /**
     * Este metodo crear el comando para crear la copia de seguridad
     * @return el comando
     */
    public static List<String> comandoCrear(){
        List<String> command = new ArrayList<>();
        command.add(JSONReader.getConfigValue(JSONReader.DATABASE,JSONReader.XAMPP_PATH) + "bin/mysqldump");
        command.add("-u");
        command.add("root");
        command.add("preguntas");
        return command;
    }

    /**
     * Este metodo genera el nombre del copia de seguridad, basicamente crea un
     * StringBuilder, en el que añade la ruta de la copia de seguridad, la fecha actual
     * y el nombre de la copia, esto para generar el nombre completo del fichero
     * @return el nombre del fichero
     * @author Fernando
     */
    private static String nombreCopia(){
        return RUTA_COPIA +
                LocalDate.now() +
                "copia.sql";
    }

    /**
     * Este metodo permite comprobar si la carpeta de backups existe o no,
     * si existe no hace nada, y si no existe la crea
     */
    private static void comprobarCarpeta(){
        File carpeta = new File(RUTA_COPIA);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }

    /**
     * Este metodo permite restaurar la copia de seguridad
     * <hr>
     * <h1><b>Importante</b></h1>
     * <p>
     *     comprobar en la interfaz configuracion que la variable XAMPP_PATH contiene la ruta
     *     de nuestro XAMPP
     * </p>
     * <hr>
     * @return CANCELADO si se cancela la operacion, CORRECTO si se restaura la copia  y ERROR si no puede restaurar la copia
     * @author Fernando
     */
    public static int restaurarCopia() {
        String nombreArchivo = elegirCopia();
        if(nombreArchivo == null){
            return CANCELADO;
        }
        if(JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres realizar una copia de seguridad?", "¿Estas seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) != 0){
            return CANCELADO;
        }
        try {
            /*
            Importante comprobar en la interfaz configuracion que la variable XAMPP_PATH contiene la ruta
            de nuestro XAMPP
             */
            ProcessBuilder builder = new ProcessBuilder(comandoRestaurar());
            builder.redirectInput(ProcessBuilder.Redirect.from(new java.io.File(RUTA_COPIA + nombreArchivo)));

            Process process = builder.start();
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_EXCEPTION, e);
            return ERROR;
        }
        return CORRECTO;
    }
    public static List<String> comandoRestaurar(){
        List<String> command = new ArrayList<>();
        command.add(JSONReader.getConfigValue(JSONReader.DATABASE,JSONReader.XAMPP_PATH) + "bin/mysql");
        command.add("-u");
        command.add("root");
        command.add("preguntas");
        return command;
    }

    /**
     * Este metodo abre un JFileChooser para elegir en archivo que se va a importar
     * @return el nombre del archivo si se elige, null si se cierre el JFileChooser sin elegir archivo
     * @author Fernando
     */
    private static String elegirCopia() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(RUTA_COPIA));
        fileChooser.setFileFilter(new FileNameExtensionFilter("SQL files (*.sql)", "sql"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getName();
        }
        return null;
    }


}
