package controller.baseDeDatos;

import java.io.BufferedReader;
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
    private  final String RUTA_COPIA = "./backups/";

    /**
     * Este método permite crear una copia de seguridad de la base de datos,
     * la copia se guarda en la ruta donde indique la variable {@code RUTA_COPIA} (./backups/),
     * con el nombre compuesto por la fecha actual + "copia.sql"
     * @return true si se crea la copia, false si no
     * @author Fernando
     */
    public  boolean crearCopia(){
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
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Este metodo genera el nombre del copia de seguridad, basicamente crea un
     * StringBuilder, en el que añade la ruta de la copia de seguridad, la fecha actual
     * y el nombre de la copia, esto para generar el nombre completo del fichero
     * @return el nombre del fichero
     * @author Fernando
     */
    private String nombreCopia(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RUTA_COPIA);
        stringBuilder.append(LocalDate.now());
        stringBuilder.append("copia.sql");
        return stringBuilder.toString();
    }
}
