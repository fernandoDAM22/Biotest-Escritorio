package controller.tools;
import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    private static FileHandler fileHandler;

    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());

        if (fileHandler == null) {
            try {
                fileHandler = new FileHandler("logs/log-file");
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
