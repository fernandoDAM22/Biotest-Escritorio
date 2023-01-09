/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import controlador.administrador.GestionPreguntas;
import controlador.controlPartida.ConsultasPartida;
import vista.administrador.VentanaAdministrarCategorias;
import vista.administrador.VentanaAdministrarCuestionarios;
import vista.administrador.VentanaAdministrarPreguntas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fernando
 */
public class VentanaResultado extends javax.swing.JFrame {
    private int idPartida;
    private DefaultTableModel modelo;

    /**
     * Creates new form VentanaResultado
     */
    public VentanaResultado(int idPartida) {
        this.idPartida = idPartida;
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

        dialogoInformacionPregunta = new javax.swing.JDialog();
        panelInformacionPregunta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        labelTextoPregunta = new javax.swing.JLabel();
        labelCategoriaPregunta = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelRespuestaCorrecta = new javax.swing.JLabel();
        labelRespuestaIncorrecta1Informacion = new javax.swing.JLabel();
        labelRespuestaIncorrecta2Informacion = new javax.swing.JLabel();
        labelRespuestaIncorrecta3Informacion = new javax.swing.JLabel();
        textoRespuestaCorrecta = new javax.swing.JTextField();
        textoRespuestaIncorrecta1 = new javax.swing.JTextField();
        textoRespuestaIncorrecta2 = new javax.swing.JTextField();
        textoRespuestaIncorrecta3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnSalirDiaologoInformacion1 = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panelLateral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        panelBotones = new javax.swing.JPanel();
        btnMenuPrincipal = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPreguntas = new javax.swing.JTable();
        barraMenu = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        opcionModoJuego = new javax.swing.JMenuItem();
        menuAdministrador = new javax.swing.JMenu();
        opcionPreguntas = new javax.swing.JMenuItem();
        opcionCuestionarios = new javax.swing.JMenuItem();
        opcionCategorias = new javax.swing.JMenuItem();

        panelInformacionPregunta.setLayout(new java.awt.GridLayout(3, 1));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 40));

        labelTextoPregunta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTextoPregunta.setForeground(new java.awt.Color(255, 255, 255));
        labelTextoPregunta.setText("Aqui va el texto de la pregunta");
        labelTextoPregunta.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel1.add(labelTextoPregunta);

        labelCategoriaPregunta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCategoriaPregunta.setForeground(new java.awt.Color(255, 255, 255));
        labelCategoriaPregunta.setText("");
        labelCategoriaPregunta.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel1.add(labelCategoriaPregunta);

        panelInformacionPregunta.add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(2, 4));

        labelRespuestaCorrecta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelRespuestaCorrecta.setForeground(new java.awt.Color(255, 255, 255));
        labelRespuestaCorrecta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRespuestaCorrecta.setText("Respuesta Correcta");
        jPanel2.add(labelRespuestaCorrecta);

        labelRespuestaIncorrecta1Informacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelRespuestaIncorrecta1Informacion.setForeground(new java.awt.Color(255, 255, 255));
        labelRespuestaIncorrecta1Informacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRespuestaIncorrecta1Informacion.setText("Respuesta Incorrecta 1");
        jPanel2.add(labelRespuestaIncorrecta1Informacion);

        labelRespuestaIncorrecta2Informacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelRespuestaIncorrecta2Informacion.setForeground(new java.awt.Color(255, 255, 255));
        labelRespuestaIncorrecta2Informacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRespuestaIncorrecta2Informacion.setText("Respuesta Incorrecta 2");
        jPanel2.add(labelRespuestaIncorrecta2Informacion);

        labelRespuestaIncorrecta3Informacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelRespuestaIncorrecta3Informacion.setForeground(new java.awt.Color(255, 255, 255));
        labelRespuestaIncorrecta3Informacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRespuestaIncorrecta3Informacion.setText("Respuesta Incorrecta 3");
        jPanel2.add(labelRespuestaIncorrecta3Informacion);

        textoRespuestaCorrecta.setEditable(false);
        textoRespuestaCorrecta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoRespuestaCorrecta.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(textoRespuestaCorrecta);

        textoRespuestaIncorrecta1.setEditable(false);
        textoRespuestaIncorrecta1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoRespuestaIncorrecta1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(textoRespuestaIncorrecta1);

        textoRespuestaIncorrecta2.setEditable(false);
        textoRespuestaIncorrecta2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoRespuestaIncorrecta2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(textoRespuestaIncorrecta2);

        textoRespuestaIncorrecta3.setEditable(false);
        textoRespuestaIncorrecta3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoRespuestaIncorrecta3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(textoRespuestaIncorrecta3);

        panelInformacionPregunta.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 40));

        btnSalirDiaologoInformacion1.setBackground(new Color(238, 82, 83));
        btnSalirDiaologoInformacion1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalirDiaologoInformacion1.setForeground(new java.awt.Color(0, 0, 0));
        btnSalirDiaologoInformacion1.setText("Salir");
        btnSalirDiaologoInformacion1.setPreferredSize(new java.awt.Dimension(200, 50));
        btnSalirDiaologoInformacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirDiaologoInformacionActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalirDiaologoInformacion1);

        panelInformacionPregunta.add(jPanel3);

        javax.swing.GroupLayout dialogoInformacionPreguntaLayout = new javax.swing.GroupLayout(dialogoInformacionPregunta.getContentPane());
        dialogoInformacionPregunta.getContentPane().setLayout(dialogoInformacionPreguntaLayout);
        dialogoInformacionPreguntaLayout.setHorizontalGroup(
                dialogoInformacionPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelInformacionPregunta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        );
        dialogoInformacionPreguntaLayout.setVerticalGroup(
                dialogoInformacionPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelInformacionPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        panelLateral.setPreferredSize(new java.awt.Dimension(300, 468));
        panelLateral.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Puntuciacion: ");
        panelLateral.add(jLabel1);

        jSlider1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(10);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(5);
        panelLateral.add(jSlider1);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        btnMenuPrincipal.setBackground(new Color(29, 209, 161));
        btnMenuPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenuPrincipal.setForeground(new java.awt.Color(0, 0, 0));
        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuPrincipal.setPreferredSize(new java.awt.Dimension(150, 40));
        panelBotones.add(btnMenuPrincipal);

        btnSalir.setBackground(new Color(238, 82, 83));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(150, 40));
        panelBotones.add(btnSalir);

        panelLateral.add(panelBotones);

        panelPrincipal.add(panelLateral, java.awt.BorderLayout.LINE_END);

        tablaPreguntas.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Pregunta", "Respuesta Correcta", "Respuesta Incorrecta 1", "Respuesta Incorrecta 2", "Respuesta Incorrecta 3"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPreguntas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tablaPreguntasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPreguntas);

        panelPrincipal.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        ponerPreguntas();
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirDiaologoInformacionActionPerformed(ActionEvent evt) {
        dialogoInformacionPregunta.dispose();
    }

    private void tablaPreguntasMouseClicked(MouseEvent evt) {
        //obtenemos la posicion de la fila que se ha pulsado
        int posicion = tablaPreguntas.getSelectedRow();
        //obtenemos los datos de la pregunta
        String enunciado = (String) modelo.getValueAt(posicion, 0);
        String respuestaCorrecta = (String) modelo.getValueAt(posicion, 1);
        String respuestaIncorrecta1 = (String) modelo.getValueAt(posicion, 2);
        String respuestaIncorrecta2 = (String) modelo.getValueAt(posicion, 3);
        String respuestaIncorrecta3 = (String) modelo.getValueAt(posicion, 4);
        //colocamos el enunciado de la pregunta
        GestionPreguntas.colocarEnunciadoPregunta(labelTextoPregunta, enunciado);
        //colocamos las respuestas de la pregunta
        GestionPreguntas.colocarRespuesta(textoRespuestaCorrecta, respuestaCorrecta);
        GestionPreguntas.colocarRespuesta(textoRespuestaIncorrecta1, respuestaIncorrecta1);
        GestionPreguntas.colocarRespuesta(textoRespuestaIncorrecta2, respuestaIncorrecta2);
        GestionPreguntas.colocarRespuesta(textoRespuestaIncorrecta3, respuestaIncorrecta3);

        dialogoInformacionPregunta.setSize(1000, 500);
        dialogoInformacionPregunta.show();
    }

    private void ponerPreguntas() {
        ArrayList<String[]> preguntas = ConsultasPartida.obtenerPreguntasPartida(idPartida);
        //creamos el modelo
        modelo = new DefaultTableModel(new String[]{
                "Pregunta", "Respuesta Correcta", "Respuesta Incorrecta 1", "Respuesta Incorrecta 2", "Respuessta Incorrecta 3"
        }, 0);
        //y se lo añadimos a la tabla
        tablaPreguntas.setModel(modelo);
        //agragamos las preguntas al modelo
        for (String[] s : preguntas) {
            modelo.addRow(s);
        }
    }

    private void opcionModoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionModoJuegoActionPerformed
        VentanaSeleccionarModoJuego ventana = new VentanaSeleccionarModoJuego();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionModoJuegoActionPerformed

    private void opcionPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionPreguntasActionPerformed
        VentanaAdministrarPreguntas ventana = new VentanaAdministrarPreguntas();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionPreguntasActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirDiaologoInformacion1;
    private javax.swing.JDialog dialogoInformacionPregunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable tablaPreguntas;
    private javax.swing.JLabel labelCategoriaPregunta;
    private javax.swing.JLabel labelRespuestaCorrecta;
    private javax.swing.JLabel labelRespuestaIncorrecta1Informacion;
    private javax.swing.JLabel labelRespuestaIncorrecta2Informacion;
    private javax.swing.JLabel labelRespuestaIncorrecta3Informacion;
    private javax.swing.JLabel labelTextoPregunta;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem opcionCategorias;
    private javax.swing.JMenuItem opcionCuestionarios;
    private javax.swing.JMenuItem opcionModoJuego;
    private javax.swing.JMenuItem opcionPreguntas;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelInformacionPregunta;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField textoRespuestaCorrecta;
    private javax.swing.JTextField textoRespuestaIncorrecta1;
    private javax.swing.JTextField textoRespuestaIncorrecta2;
    private javax.swing.JTextField textoRespuestaIncorrecta3;
    // End of variables declaration
}
