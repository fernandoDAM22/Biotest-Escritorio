/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.administrador.dialogos;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author fernando
 */
public class DialogoDatosCategoriaCuestionario extends javax.swing.JDialog {
    private static String nombre = "";
    private static String descripcion = "";

    /**
     * Creates new form dialogoDescripcion
     */
    public DialogoDatosCategoriaCuestionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //en caso de que se cierre la ventana reseteamos los valores de nombre
        //y descripcion
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                nombre = "";
                descripcion = "";
            }
        });
    }
     public static void mostrarDialogo() {
        nombre = "";
        descripcion = "";
        DialogoDatosCategoriaCuestionario dialogo = new DialogoDatosCategoriaCuestionario(new JFrame(), true);
        dialogo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialogo.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelFila1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelFila2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        panelFila3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        inputDescripcion = new javax.swing.JTextField();
        panelFila4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 400));

        panelPrincipal.setLayout(new java.awt.GridLayout(4, 0, 1, 0));

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        panelFila1.setLayout(flowLayout1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Introduce los datos");
        panelFila1.add(jLabel1);

        panelPrincipal.add(panelFila1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        panelFila2.add(jLabel2);

        inputNombre.setPreferredSize(new java.awt.Dimension(500, 40));
        panelFila2.add(inputNombre);

        panelPrincipal.add(panelFila2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripcion");
        panelFila3.add(jLabel3);

        inputDescripcion.setPreferredSize(new java.awt.Dimension(500, 40));
        panelFila3.add(inputDescripcion);

        panelPrincipal.add(panelFila3);

        jButton1.setBackground(new java.awt.Color(50, 225, 126));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Aceptar");
        jButton1.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelFila4.add(jButton1);

        panelPrincipal.add(panelFila4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nombre = inputNombre.getText();
        descripcion = inputDescripcion.getText();
        if ( nombre.length() == 0|| descripcion.length() == 0) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres realizar la accion?", "¿Estas seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
            dispose();
        } else {
            descripcion = "";
            nombre = "";
        }//GEN-LAST:event_jButton1ActionPerformed
    }


    /**
     * Este metodo devuelve el nombre escrito en el cuadro de texto para el nombre
     * @return el nombre si se ha rellenado, null si ocurre algun error
     * @author Fernando
     */
    public static String getNombre(){
        if(nombre.length() == 0){
            return null;
        }
        return nombre;
    }
    /**
     * Este metodo devuelve la descripcion escrita en el cuadro de texto para la descripcion
     * @return la descripcion si se ha rellenado, null si ocurre algun error
     * @author Fernando
     */
    public static String getDescripcion(){
        if(descripcion.length() == 0){
            return null;
        }
        return descripcion;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogoDatosCategoriaCuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoDatosCategoriaCuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoDatosCategoriaCuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoDatosCategoriaCuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoDatosCategoriaCuestionario dialog = new DialogoDatosCategoriaCuestionario(new JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputDescripcion;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelFila1;
    private javax.swing.JPanel panelFila2;
    private javax.swing.JPanel panelFila3;
    private javax.swing.JPanel panelFila4;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}