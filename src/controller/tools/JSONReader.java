package controller.tools;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase nos permite obtener datos de un fichero .json
 *
 * @author Fernando
 */
public class JSONReader {
    private static final String CONFIG_FILE = "./configuracion.json";
    //-------------------DATABASE E EMAIL ------------------------------------
    public static final String EMAIL = "email";
    public static final String DATABASE = "database";
    //-------------------PROPIEDADES DE DATABASE------------------------------//
    public static final String DBHOST = "host";
    public static final String DBNAME = "name";
    public static final String ADMIN ="admin";
    public static final String ADMIN_PASSWORD = "adminPassword";
    public static final String XAMPP_PATH = "xamppPath";
    //-------------------PROPIEDADES DE EMAIL------------------------------//
    public static final String EMAIL_SENDER = "sender";
    public static final String EMAIL_PASSWORD = "password";
    public static final String SMTP_HOST = "smtpHost";
    public static final String SMTP_PORT = "smtpPort";

    private static final Logger logger = LoggerUtil.getLogger(JSONReader.class);



    public static String getConfigValue(String objectName, String propertyName)  {
        Gson gson = new Gson();
        JsonObject jsonObject = null;
        try {
            jsonObject = gson.fromJson(new FileReader(CONFIG_FILE), JsonObject.class);
        } catch (FileNotFoundException e) {
           logger.log(Level.SEVERE,Mensajes.ERROR_ENTRADA_SALIDA,e);
        }
        assert jsonObject != null;
        JsonObject object = jsonObject.getAsJsonObject(objectName);
        return object.get(propertyName).getAsString();
    }
}
