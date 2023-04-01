package controller.tools;

import javax.swing.*;

/**
 * Esta clase permite que un comboBox tenga comportamiento de pila
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
