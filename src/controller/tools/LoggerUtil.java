package controller.tools;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;

/**
 * Esta clase nos permite registrar todas las excepciones en un fichero de log
 * @author Fernando
 */
public class LoggerUtil {
    private static FileHandler fileHandler;

    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());

        if (fileHandler == null) {
            try {
                File carpeta = new File("logs");
                if(!carpeta.isFile()){
                    carpeta.mkdirs();
                }
                fileHandler = new FileHandler("logs/log-file.txt",true);
                fileHandler.setFormatter(new SimpleFormatter());
            } catch (IOException e) {
                logger.log(Level.SEVERE, "No se pudo crear el archivo de registro", e);
            }
            logger.setUseParentHandlers(false);
            for (Handler handler : logger.getHandlers()) {
                if (handler instanceof ConsoleHandler) {
                    logger.removeHandler(handler);
                }
            }
        }

        logger.addHandler(fileHandler);
        return logger;
    }
}
