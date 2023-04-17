package controller.tools;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Esta clase permite interactuar con el navegador del usuario
 * @author Fernando
 */
public class Browser {
    /**
     * Esta constante contiene la url de la licencia de nuestra aplicacion
     */
    public static final String URL_LICENCIA = "https://creativecommons.org/licenses/by-nc-sa/4.0/deed.es";

    /**
     * Este metodo permite abrir una url en el navegador predeterminado
     * del usuario
     * @param url es la url que queremos abrir
     * @return true si se abre la url, falsa si no se puede abrir por diversas circunstancias
     * @author Fernando
     */
    public static boolean openURL(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URI(url));
                    return true;
                } catch (IOException | URISyntaxException ex) {
                    /*
                     * En caso de que no se pueda abrir el navegador devido a un error,
                     * retornamos false, para poder indicarselo al usuario y copiar la url
                     * de la licencia en su portapapeles
                     */
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Este metodo permite copiar una url al portapapeles del usuario
     * @param url es la url que queremos copiar en el portapapeles
     * @author Fernando
     */
    public static void copyURL(String url){
        StringSelection seleccion = new StringSelection(url);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(seleccion, null);

    }
}
