package controller.tools;

import javax.swing.table.DefaultTableModel;

/**
 * Este clase crea un modelo el cual no es editable, se usa para asignarselo a las tablas
 * cuando se obtenienen los datos, se carga el modelo y despues se le asigna a la tabla
 * @author Fernando
 *
 */
public class DefaultTableModelNoEditable extends DefaultTableModel {
    public DefaultTableModelNoEditable(String[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
