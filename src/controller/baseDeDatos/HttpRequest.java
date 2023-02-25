package controller.baseDeDatos;



import controller.tools.LoggerUtil;
import controller.tools.Mensajes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase HttpRequest: permite enviar (INSERT,DELETE,UPDATE) y recibir (SELECT) datos del WebService
 * 
 * 
 * @author encarna
 *
 */

public final class HttpRequest {
    private static final Logger logger = LoggerUtil.getLogger(HttpRequest.class);

	/**
	 * Enviar peticiones de ACTUALIZACIÓN
	 * @param url
	 * @param values
	 * @return
	 */
    public static String POST_REQUEST(String url, String values) {
        try {
            StringBuilder result = new StringBuilder();
            URL url2 = new URL(url);
            URLConnection conn = url2.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(values);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            wr.close();
            rd.close();
            return result.toString();
        } catch (IOException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_ENTRADA_SALIDA, e);
            return e.toString();
        }
    }

    /**
     * Solicitar la ejecución de consultas select
     * 
     * @param url
     * @param values
     * @return
     */
    public static String GET_REQUEST(String url, String values) {
        try {
            StringBuilder result = new StringBuilder();
            String URL = url + "?" + values;
            URL obj = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
           // con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            return result.toString();
        }catch (IOException e) {
            logger.log(Level.SEVERE, Mensajes.ERROR_ENTRADA_SALIDA, e);
            return e.toString();
        }
    }
}