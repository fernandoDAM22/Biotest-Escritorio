package controller.tools;

import javax.swing.*;

/**
 * Esta clase permite que un comboBox tenga comportamiento de pila,
 * es decir, los elementos se inserten por el principio, se usa en la clase
 * MisPartidas, ya que desde la base de datos las partidas vienen ordenadas por fecha,
 * de modo la mas reciente debe ser la primera, y de este modo en el comboBox se colocan ordenadas
 * tambien por fecha segun se van insertando
 * @author Fernando
 */
public class PilaComboBoxModel<T> extends DefaultComboBoxModel<T> {
    @Override
    public void addElement(T obj) {
        insertElementAt(obj, 0);
    }

    @Override
    public void insertElementAt(T obj, int index) {
        super.insertElementAt(obj, 0);
    }
}
