/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.administrador;

import java.awt.Color;
import vista.juego.VentanaSeleccionarModoJuego;

/**
 *
 * @author fernando
 */
public class VentanaAdministrarPreguntas extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAdministrarPreguntas
     */
    public VentanaAdministrarPreguntas() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVaciar = new javax.swing.JButton();
        listaPreguntas = new javax.swing.JComboBox<>();
        listaCategorias = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputRespuestaCorrecta = new javax.swing.JTextField();
        inputRespuestaIncorrecta1 = new javax.swing.JTextField();
        inputRespuestaIncorrecta2 = new javax.swing.JTextField();
        inputRespuestaIncorrecta3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        opcionModoJuego = new javax.swing.JMenuItem();
        menuAdministrador = new javax.swing.JMenu();
        opcionPreguntas = new javax.swing.JMenuItem();
        opcionCuestionarios = new javax.swing.JMenuItem();
        opcionCategorias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        panelPrincipal.setLayout(new java.awt.GridLayout(4, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Preguntas");
        jPanel1.add(jLabel1);

        panelPrincipal.add(jPanel1);

        btnVaciar.setBackground(new Color(238, 82, 83));
        btnVaciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVaciar.setForeground(new Color(0, 0, 0));
        btnVaciar.setText("Vaciar");
        btnVaciar.setBorder(null);
        btnVaciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVaciar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });
        jPanel2.add(btnVaciar);

        listaPreguntas.setEditable(true);
        listaPreguntas.setForeground(new Color(255, 255, 255));
        listaPreguntas.setMaximumRowCount(50);
        listaPreguntas.setPreferredSize(new java.awt.Dimension(600, 40));
        jPanel2.add(listaPreguntas);

        listaCategorias.setForeground(new Color(255, 255, 255));
        listaCategorias.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel2.add(listaCategorias);

        panelPrincipal.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(2, 4));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Respuesta Correcta");
        jPanel3.add(jLabel2);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Respuesta Incorrecta 1");
        jPanel3.add(jLabel4);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Respuesta Incorrecta 2 ");
        jPanel3.add(jLabel3);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Respuesta Incorrecta 3");
        jPanel3.add(jLabel5);

        inputRespuestaCorrecta.setColumns(20);
        inputRespuestaCorrecta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaCorrecta.setForeground(new Color(255, 255, 255));
        jPanel3.add(inputRespuestaCorrecta);

        inputRespuestaIncorrecta1.setColumns(20);
        inputRespuestaIncorrecta1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaIncorrecta1.setForeground(new Color(255, 255, 255));
        jPanel3.add(inputRespuestaIncorrecta1);

        inputRespuestaIncorrecta2.setColumns(20);
        inputRespuestaIncorrecta2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaIncorrecta2.setForeground(new Color(255, 255, 255));
        jPanel3.add(inputRespuestaIncorrecta2);

        inputRespuestaIncorrecta3.setColumns(20);
        inputRespuestaIncorrecta3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaIncorrecta3.setForeground(new Color(255, 255, 255));
        jPanel3.add(inputRespuestaIncorrecta3);

        panelPrincipal.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        btnInsertar.setBackground(new Color(29, 209, 161));
        btnInsertar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsertar.setForeground(new Color(0, 0, 0));
        btnInsertar.setText("Insertar");
        btnInsertar.setBorder(null);
        btnInsertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertar.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel4.add(btnInsertar);

        btnBorrar.setBackground(new Color(238, 82, 83));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setForeground(new Color(0, 0, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.setBorder(null);
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel4.add(btnBorrar);

        btnModificar.setBackground(new Color(238, 82, 83));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificar.setForeground(new Color(0, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel4.add(btnModificar);

        btnBuscar.setBackground(new Color(29, 209, 161));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel4.add(btnBuscar);

        panelPrincipal.add(jPanel4);

        menuUsuario.setText("Usuario");

        opcionModoJuego.setText("Seleccionar Modo de juego");
        opcionModoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionModoJuegoActionPerformed(evt);
            }
        });
        menuUsuario.add(opcionModoJuego);

        barraMenu.add(menuUsuario);

        menuAdministrador.setText("Administrador");

        opcionPreguntas.setText("Preguntas");
        opcionPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionPreguntasActionPerformed(evt);
            }
        });
        menuAdministrador.add(opcionPreguntas);

        opcionCuestionarios.setText("Cuestionarios");
        opcionCuestionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionCuestionariosActionPerformed(evt);
            }
        });
        menuAdministrador.add(opcionCuestionarios);

        opcionCategorias.setText("Categorias");
        opcionCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionCategoriasActionPerformed(evt);
            }
        });
        menuAdministrador.add(opcionCategorias);

        barraMenu.add(menuAdministrador);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed
         
    }//GEN-LAST:event_btnVaciarActionPerformed

    private void opcionPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionPreguntasActionPerformed
        VentanaAdministrarPreguntas ventana = new VentanaAdministrarPreguntas();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionPreguntasActionPerformed

    private void opcionModoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionModoJuegoActionPerformed
        VentanaSeleccionarModoJuego ventana = new VentanaSeleccionarModoJuego();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionModoJuegoActionPerformed

    private void opcionCuestionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionCuestionariosActionPerformed
        VentanaAdministrarCuestionarios ventana =  new VentanaAdministrarCuestionarios();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionCuestionariosActionPerformed

    private void opcionCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionCategoriasActionPerformed
       VentanaAdministrarCategorias ventana =  new VentanaAdministrarCategorias();
       ventana.setVisible(true); 
       dispose();
    }//GEN-LAST:event_opcionCategoriasActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAdministrarPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrarPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrarPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrarPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdministrarPreguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JTextField inputRespuestaCorrecta;
    private javax.swing.JTextField inputRespuestaIncorrecta1;
    private javax.swing.JTextField inputRespuestaIncorrecta2;
    private javax.swing.JTextField inputRespuestaIncorrecta3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> listaCategorias;
    private javax.swing.JComboBox<String> listaPreguntas;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem opcionCategorias;
    private javax.swing.JMenuItem opcionCuestionarios;
    private javax.swing.JMenuItem opcionModoJuego;
    private javax.swing.JMenuItem opcionPreguntas;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
