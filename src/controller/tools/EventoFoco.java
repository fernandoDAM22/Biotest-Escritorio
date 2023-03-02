package controller.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Esta clase contiene el metodo focusGained para usarlo en
 * los JTextField
 * @author Fernando
 */
public class EventoFoco extends FocusAdapter {
    /**
     * Este metodo permite seleccionar el texto de un JTextFiel,
     * tambien permite copiar el texto seleccionado al portapapeles
     * @param evt el evento provocado
     * @author Fernando;
     */
    @Override
    public void focusGained(FocusEvent evt) {
        JTextField campo = (JTextField) evt.getSource();
        campo.selectAll();
        //se copia el texto al portapapeles
        copiarTexto(campo.getText());
    }

    /**
     * Este metodo permite seleccionar el texto seleccionado de un
     * JTextField al portapapeles
     * @param text es el texto que se va a seleccionar
     * @author Fernando
     */
    private void copiarTexto(String text) {
        StringSelection seleccion = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(seleccion, null);
    }
}
