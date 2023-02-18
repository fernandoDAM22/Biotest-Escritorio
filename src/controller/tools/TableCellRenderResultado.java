package controller.tools;

import controller.administrador.GestionPreguntas;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Esta clase permite colocar las filas de la tabla de preguntas
 * de la ventana resultado de color verde si se acerto la pregunta
 * y de color rojo si se fallo
 * @author Fernando
 */
public class TableCellRenderResultado  extends DefaultTableCellRenderer {
    private int idPartida;

    public TableCellRenderResultado(int idPartida) {
        this.idPartida = idPartida;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int idPregunta = GestionPreguntas.obtenerId((String) table.getValueAt(row,0));
        //si la pregunta se acerto se coloca la fila de la tabla de color verde, de lo contrario se coloca de color rojo
        if (GestionPreguntas.preguntaAcertada(idPartida,idPregunta)) {
            c.setBackground(Colores.COLOR_PREGUNTAS_ACERTADAS);
        } else {
            c.setBackground(Colores.COLOR_PREGUNTAS_FALLADAS);
        }
        if (isSelected) {
            c.setForeground(Color.white);
        } else {
            c.setForeground(table.getForeground());
        }
        return c;
    }
}
