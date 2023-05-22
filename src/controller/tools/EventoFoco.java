package controller.tools;

import javax.swing.*;
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
    }
}
