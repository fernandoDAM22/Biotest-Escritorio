package controller.baseDeDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Este clase permite crear copias de seguridad de la base de datos mysql
 * @author Fernando
 */
public class CopiaDeSeguridad {
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
            List<String> command = new ArrayList<>();
            command.add("mysqldump");
            command.add("-u");
            command.add("admin");
            command.add("-p");
            command.add("preguntas");

            ProcessBuilder builder = new ProcessBuilder(command);
            builder.redirectOutput(ProcessBuilder.Redirect.to(new java.io.File(nombreCopia())));

            Process process = builder.start();
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ignored) {

        }
        return comprobar(nombreCopia());
    }

    /**
     * Este metodo genera el nombre del copia de seguridad, basicamente crea un
     * StringBuilder, en el que añade la ruta de la copia de seguridad, la fecha actual
     * y el nombre de la copia, esto para generar el nombre completo del fichero
     * @return el nombre del fichero
     * @author Fernando
     */
    private static String nombreCopia(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RUTA_COPIA);
        stringBuilder.append(LocalDate.now());
        stringBuilder.append("copia.sql");
        return stringBuilder.toString();
    }

    /**
     * Este metodo permite comprobar si se ha creado la copia de seguridad o no,
     * lo que hace es comprobar si el fichero que se acaba de crear existe o no
     * @param nombreCopia es el nombre del archivo que queremos comprobar
     * @return true si existe el archivo, false si no
     */
    private static boolean comprobar(String nombreCopia){
        File file = new File(nombreCopia);
        return file.exists() && !file.isDirectory();
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
}
