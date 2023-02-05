/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.juego;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import controller.baseDeDatos.CopiaDeSeguridad;
import controller.controlPartida.ConsultasPartida;
import controller.usuario.Codigos;
import controller.usuario.ConfiguracionUsuario;
import view.acceso.VentanaLogin;
import view.administrador.VentanaAdministrarCategorias;
import view.administrador.VentanaAdministrarCuestionarios;
import view.administrador.VentanaAdministrarPreguntas;
import view.usuario.VentanaAjustesUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase permite al usuario ver el resultado de una partida, se lanza
 * automaticamente al finalizar la partida
 * @author fernando
 *
 */
public class VentanaResultado extends javax.swing.JFrame {
    /**
     * Es el id de la partida que se acaba de jugar
     */
    private int idPartida;
    /**
     * Es el modelo de la tabla que contiene las preguntas
     */
    private DefaultTableModel modelo;

    /**
     * Creates new form VentanaResultado
     */
    public VentanaResultado(int idPartida) {
        this.idPartida = idPartida;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Creates new form VentanaResultado
     */
    public VentanaResultado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelLateral = new javax.swing.JPanel();
        labelPuntuacion = new javax.swing.JLabel();
        sliderPuntuacion = new javax.swing.JSlider();
        panelBotones = new javax.swing.JPanel();
        btnMenuPrincipal = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPreguntas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtRespuestaCorrecta = new javax.swing.JTextField();
        txtEnunciado = new javax.swing.JTextField();
        txtRespuestaIncorrecta1 = new javax.swing.JTextField();
        txtRespuestaIncorrecta2 = new javax.swing.JTextField();
        txtRespuestaIncorrecta3 = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        barraMenu = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        opcionModoJuego = new javax.swing.JMenuItem();
        opcionCerrarSesion = new javax.swing.JMenuItem();
        opcionAjustesUsuario = new javax.swing.JMenuItem();
        menuAdministrador = new javax.swing.JMenu();
        opcionPreguntas = new javax.swing.JMenuItem();
        opcionCuestionarios = new javax.swing.JMenuItem();
        opcionCategorias = new javax.swing.JMenuItem();
        opcionCopiasDeSeguridad = new javax.swing.JMenu();
        opcionImportar = new javax.swing.JMenuItem();
        opcionExportar = new javax.swing.JMenuItem();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        panelLateral.setPreferredSize(new java.awt.Dimension(300, 468));
        panelLateral.setLayout(new java.awt.GridLayout(3, 1));

        labelPuntuacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPuntuacion.setForeground(new java.awt.Color(255, 255, 255));
        labelPuntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPuntuacion.setText("Puntuciacion: ");
        panelLateral.add(labelPuntuacion);

        sliderPuntuacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sliderPuntuacion.setMajorTickSpacing(10);
        sliderPuntuacion.setMaximum(10);
        sliderPuntuacion.setMinorTickSpacing(1);
        sliderPuntuacion.setPaintLabels(true);
        sliderPuntuacion.setPaintTicks(true);
        sliderPuntuacion.setValue(5);
        panelLateral.add(sliderPuntuacion);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        btnMenuPrincipal.setBackground(new Color(29, 209, 161));
        btnMenuPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenuPrincipal.setForeground(new java.awt.Color(0, 0, 0));
        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuPrincipal.setPreferredSize(new java.awt.Dimension(150, 40));
        btnMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        panelBotones.add(btnMenuPrincipal);

        btnSalir.setBackground(new Color(238, 82, 83));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(150, 40));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnSalirActionPerformer(evt);
            }
        });
        panelBotones.add(btnSalir);

        panelLateral.add(panelBotones);

        panelPrincipal.add(panelLateral, java.awt.BorderLayout.LINE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        tablaPreguntas.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Enunciado", "Respuesta Correcta", "Respuesta Incorrecta 1", "Respuesta Incorrecta 2", "Respuesta Incorrecta 3", "categoria"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPreguntas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                super.mouseClicked(evt);
                tablaPreguntasMouseClicked(evt);
            }
        });
        tablaPreguntas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                super.keyReleased(evt);
                tablaPreguntasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPreguntas);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la pregunta"));
        jPanel6.setPreferredSize(new java.awt.Dimension(900, 300));

        jLabel2.setText("Enunciado");

        jLabel3.setText("Respuesta correcta");

        jLabel4.setText("Respuesta incorrecta 1");

        jLabel5.setText("Respuesta incorrecta 2");

        jLabel6.setText("Respuesta incorrecta 3");

        jLabel7.setText("Categoria");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRespuestaCorrecta, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRespuestaIncorrecta1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRespuestaIncorrecta2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRespuestaIncorrecta3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEnunciado, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtEnunciado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtRespuestaCorrecta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtRespuestaIncorrecta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtRespuestaIncorrecta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtRespuestaIncorrecta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
        );

        jPanel4.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        panelPrincipal.add(jPanel4, java.awt.BorderLayout.CENTER);

        menuUsuario.setText("Usuario");

        opcionModoJuego.setText("Seleccionar Modo de juego");
        opcionModoJuego.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));

        menuUsuario.add(opcionModoJuego);
        opcionCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                opcionCerrarSesionActionPerformed(evt);
            }
        });
        menuUsuario.add(opcionCerrarSesion);

        opcionModoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionModoJuegoActionPerformed(evt);
            }
        });
        opcionCerrarSesion.setText("Cerrar Sesion");
        opcionCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        opcionAjustesUsuario.setText("Ajustes de usuario");
        opcionAjustesUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
        opcionAjustesUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                opcionAjustesUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(opcionAjustesUsuario);
        barraMenu.add(menuUsuario);

        menuAdministrador.setText("Administrador");

        opcionPreguntas.setText("Preguntas");
        opcionPreguntas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
        opcionPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionPreguntasActionPerformed(evt);
            }
        });
        menuAdministrador.add(opcionPreguntas);

        opcionCuestionarios.setText("Cuestionarios");
        opcionCuestionarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
        opcionCuestionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionCuestionariosActionPerformed(evt);
            }
        });
        menuAdministrador.add(opcionCuestionarios);

        opcionCategorias.setText("Categorias");
        opcionCategorias.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));

        opcionCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionCategoriasActionPerformed(evt);
            }
        });
        menuAdministrador.add(opcionCategorias);
        opcionCopiasDeSeguridad.setText("Copias de seguridad");
        opcionImportar.setText("Importar");
        opcionImportar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
        opcionImportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                opcionImportarActionPerformed(evt);
            }
        });
        opcionExportar.setText("Exportar");
        opcionExportar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
        opcionExportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                opcionExportarActionPeformed(evt);
            }
        });
        opcionCopiasDeSeguridad.add(opcionImportar);
        opcionCopiasDeSeguridad.add(opcionExportar);
        menuAdministrador.add(opcionCopiasDeSeguridad);


        barraMenu.add(menuAdministrador);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
        ponerPreguntas();
        ponerPuntuacion();
        ConfiguracionUsuario.desactivarMenu(barraMenu,menuAdministrador);

        pack();
    }// </editor-fold>

    private void opcionAjustesUsuarioActionPerformed(ActionEvent evt) {
        VentanaAjustesUsuario frame = new VentanaAjustesUsuario();
        frame.setVisible(true);
        dispose();
    }

    private void btnMenuPrincipalActionPerformed(ActionEvent evt) {
        VentanaSeleccionarModoJuego frame = new VentanaSeleccionarModoJuego();
        frame.setVisible(true);
        dispose();
    }

    private void btnSalirActionPerformer(ActionEvent evt) {
        System.exit(0);
    }

    private void opcionCerrarSesionActionPerformed(ActionEvent evt) {
        VentanaLogin frame = new VentanaLogin();
        frame.setVisible(true);
        dispose();
    }

    private void tablaPreguntasKeyReleased(KeyEvent evt) {
        colocarDatosPregunta();
    }

    private void tablaPreguntasMouseClicked(MouseEvent evt) {
        colocarDatosPregunta();
    }

    /**
     * Este metodo nos permite colocar los datos de una pregunta en las casillas correspondientes
     * @author Fernando
     */
    private void colocarDatosPregunta() {
        //obtenemos la posicion de la fila que se ha pulsado
        int posicion = tablaPreguntas.getSelectedRow();
        //obtenemos los datos de la pregunta
        String enunciado = (String) modelo.getValueAt(posicion, 0);
        String respuestaCorrecta = (String) modelo.getValueAt(posicion, 1);
        String respuestaIncorrecta1 = (String) modelo.getValueAt(posicion, 2);
        String respuestaIncorrecta2 = (String) modelo.getValueAt(posicion, 3);
        String respuestaIncorrecta3 = (String) modelo.getValueAt(posicion, 4);
        String categoria = (String) modelo.getValueAt(posicion,5);
        //colocamos el enunciado de la pregunta
        txtEnunciado.setText(enunciado);
        //colocamos las respuestas de la pregunta
        txtRespuestaCorrecta.setText(respuestaCorrecta);
        txtRespuestaIncorrecta1.setText(respuestaIncorrecta1);
        txtRespuestaIncorrecta2.setText(respuestaIncorrecta2);
        txtRespuestaIncorrecta3.setText(respuestaIncorrecta3);
        txtCategoria.setText(categoria);
    }

    private void ponerPuntuacion() {
        int puntuacion = ConsultasPartida.obtenerPuntuacion(idPartida);
        if(puntuacion == -1){
            return;
        }
        labelPuntuacion.setText("Puntuacion: " + puntuacion);
        sliderPuntuacion.setValue(Math.min(puntuacion, 10));
        sliderPuntuacion.setEnabled(false);
    }

    /**
     * Este metodo nos permote poner las preguntas en la tabla
     * @author Fernando
     */
    private void ponerPreguntas() {
        ArrayList<String[]> preguntas = ConsultasPartida.obtenerPreguntasPartida(idPartida);
        //obtenemos el modelo
        modelo = (DefaultTableModel) tablaPreguntas.getModel();
        //y se lo añadimos a la tabla
        tablaPreguntas.setModel(modelo);
        //agragamos las preguntas al modelo
        for (String[] s : preguntas) {
            modelo.addRow(s);
        }
    }

    private void opcionExportarActionPeformed(ActionEvent evt) {
        if(JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres realizar una copia de seguridad?", "¿Estas seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) != 0){
            return;
        }
        if(CopiaDeSeguridad.crearCopia()){
            JOptionPane.showMessageDialog(this,"Copia realizada correctamente","Correcto",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"Error al realizar la copia de seguridad","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void opcionImportarActionPerformed(ActionEvent evt) {
        int estado = CopiaDeSeguridad.restaurarCopia();
        if(estado == Codigos.CORRECTO){
            JOptionPane.showMessageDialog(this,"Copia importada correctamente","Correcto",JOptionPane.INFORMATION_MESSAGE);
        }else if(estado == Codigos.ERROR){
            JOptionPane.showMessageDialog(this,"Error al importar la copia, consulte el manual","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void opcionModoJuegoActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaSeleccionarModoJuego ventana = new VentanaSeleccionarModoJuego();
        ventana.setVisible(true);
        dispose();
    }

    private void opcionPreguntasActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaAdministrarPreguntas ventana = new VentanaAdministrarPreguntas();
        ventana.setVisible(true);
        dispose();
    }

    private void opcionCuestionariosActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaAdministrarCuestionarios ventana =  new VentanaAdministrarCuestionarios();
        ventana.setVisible(true);
        dispose();
    }

    private void opcionCategoriasActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaAdministrarCategorias ventana =  new VentanaAdministrarCategorias();
        ventana.setVisible(true);
        dispose();
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
                new VentanaResultado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel labelPuntuacion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider sliderPuntuacion;
    private javax.swing.JTable tablaPreguntas;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem opcionCategorias;
    private javax.swing.JMenuItem opcionCuestionarios;
    private javax.swing.JMenu opcionCopiasDeSeguridad;
    private javax.swing.JMenuItem opcionExportar;
    private javax.swing.JMenuItem opcionImportar;

    private javax.swing.JMenuItem opcionModoJuego;
    private javax.swing.JMenuItem opcionCerrarSesion;
    private javax.swing.JMenuItem opcionAjustesUsuario;
    private javax.swing.JMenuItem opcionPreguntas;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtEnunciado;
    private javax.swing.JTextField txtRespuestaCorrecta;
    private javax.swing.JTextField txtRespuestaIncorrecta1;
    private javax.swing.JTextField txtRespuestaIncorrecta2;
    private javax.swing.JTextField txtRespuestaIncorrecta3;
    // End of variables declaration
}
