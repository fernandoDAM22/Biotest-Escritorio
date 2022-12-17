/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.administrador;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import controlador.administrador.categorias.GestionCategorias;
import controlador.administrador.preguntas.GestionPreguntas;
import vista.juego.VentanaSeleccionarModoJuego;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author fernando
 */
public class VentanaAdministrarCategorias extends javax.swing.JFrame {
    DefaultTableModel modelo;

    /**
     * Creates new form VentanaAdministrarCategorias
     */
    public VentanaAdministrarCategorias() {
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

        dialogoPreguntas = new javax.swing.JDialog();
        panelPrincipal1 = new javax.swing.JPanel();
        panelDialogoFila1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelDialogoFila2 = new javax.swing.JPanel();
        btnVaciarDialogo = new javax.swing.JButton();
        listaPreguntasDialogo = new javax.swing.JComboBox<>();
        listaCategoriasDialogo = new javax.swing.JComboBox<>();
        panelDialogoFila3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputRespuestaCorrecta = new javax.swing.JTextField();
        inputRespuestaIncorrecta1 = new javax.swing.JTextField();
        inputRespuestaIncorrecta2 = new javax.swing.JTextField();
        inputRespuestaIncorrecta3 = new javax.swing.JTextField();
        panelDialogoFila4 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
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
        panelPrinicipal = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnModificarNombre = new javax.swing.JButton();
        panelContenido = new javax.swing.JPanel();
        listaCategorias = new javax.swing.JComboBox<>();
        listaCategorias.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                jTable1ItemListener(e);
            }
        });
        tablaPreguntas = new javax.swing.JScrollPane();
        tablaInformacionPreguntas = new javax.swing.JTable();
        barraMenu = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        opcionModoJuego = new javax.swing.JMenuItem();
        menuAdministrador = new javax.swing.JMenu();
        opcionPreguntas = new javax.swing.JMenuItem();
        opcionCuestionarios = new javax.swing.JMenuItem();
        opcionCategorias = new javax.swing.JMenuItem();

        panelPrincipal1.setLayout(new java.awt.GridLayout(4, 1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Preguntas");
        panelDialogoFila1.add(jLabel2);

        panelPrincipal1.add(panelDialogoFila1);

        panelDialogoFila2.setPreferredSize(new java.awt.Dimension(1000, 50));

        btnVaciarDialogo.setBackground(new Color(238, 82, 83));
        btnVaciarDialogo.setForeground(new Color(0, 0, 0));
        btnVaciarDialogo.setText("Vaciar");
        btnVaciarDialogo.setBorder(null);
        btnVaciarDialogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVaciarDialogo.setPreferredSize(new java.awt.Dimension(100, 40));
        btnVaciarDialogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarDialogoActionPerformed(evt);
            }
        });
        panelDialogoFila2.add(btnVaciarDialogo);

        listaPreguntasDialogo.setEditable(true);
        listaPreguntasDialogo.setForeground(new Color(255, 255, 255));
        listaPreguntasDialogo.setMaximumRowCount(50);
        listaPreguntasDialogo.setPreferredSize(new java.awt.Dimension(600, 40));
        panelDialogoFila2.add(listaPreguntasDialogo);

        listaCategoriasDialogo.setForeground(new Color(255, 255, 255));
        listaCategoriasDialogo.setPreferredSize(new java.awt.Dimension(200, 40));
        panelDialogoFila2.add(listaCategoriasDialogo);

        panelPrincipal1.add(panelDialogoFila2);

        panelDialogoFila3.setLayout(new java.awt.GridLayout(2, 4));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Respuesta Correcta");
        panelDialogoFila3.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Respuesta Incorrecta 1");
        panelDialogoFila3.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Respuesta Incorrecta 2 ");
        panelDialogoFila3.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Respuesta Incorrecta 3");
        panelDialogoFila3.add(jLabel6);

        inputRespuestaCorrecta.setColumns(20);
        inputRespuestaCorrecta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaCorrecta.setForeground(new Color(255, 255, 255));
        panelDialogoFila3.add(inputRespuestaCorrecta);

        inputRespuestaIncorrecta1.setColumns(20);
        inputRespuestaIncorrecta1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaIncorrecta1.setForeground(new Color(255, 255, 255));
        panelDialogoFila3.add(inputRespuestaIncorrecta1);

        inputRespuestaIncorrecta2.setColumns(20);
        inputRespuestaIncorrecta2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaIncorrecta2.setForeground(new Color(255, 255, 255));
        panelDialogoFila3.add(inputRespuestaIncorrecta2);

        inputRespuestaIncorrecta3.setColumns(20);
        inputRespuestaIncorrecta3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaIncorrecta3.setForeground(new Color(255, 255, 255));
        panelDialogoFila3.add(inputRespuestaIncorrecta3);

        panelPrincipal1.add(panelDialogoFila3);

        panelDialogoFila4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        btnInsertar.setBackground(new Color(29, 209, 161));
        btnInsertar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsertar.setForeground(new Color(0, 0, 0));
        btnInsertar.setText("Insertar");
        btnInsertar.setBorder(null);
        btnInsertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertar.setPreferredSize(new java.awt.Dimension(200, 60));
        panelDialogoFila4.add(btnInsertar);

        btnBuscar.setBackground(new Color(29, 209, 161));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setPreferredSize(new java.awt.Dimension(200, 60));
        panelDialogoFila4.add(btnBuscar);

        btnSalir.setBackground(new Color(238, 82, 83));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setForeground(new Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(200, 60));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelDialogoFila4.add(btnSalir);

        panelPrincipal1.add(panelDialogoFila4);

        javax.swing.GroupLayout dialogoPreguntasLayout = new javax.swing.GroupLayout(dialogoPreguntas.getContentPane());
        dialogoPreguntas.getContentPane().setLayout(dialogoPreguntasLayout);
        dialogoPreguntasLayout.setHorizontalGroup(
                dialogoPreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrincipal1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );
        dialogoPreguntasLayout.setVerticalGroup(
                dialogoPreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dialogoPreguntasLayout.createSequentialGroup()
                                .addComponent(panelPrincipal1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelInformacionPregunta.setLayout(new java.awt.GridLayout(3, 1));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 40));

        labelTextoPregunta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTextoPregunta.setForeground(new Color(255, 255, 255));
        labelTextoPregunta.setText("Aqui va el texto de la pregunta");
        labelTextoPregunta.setPreferredSize(new java.awt.Dimension(600, 30));
        jPanel1.add(labelTextoPregunta);

        labelCategoriaPregunta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelCategoriaPregunta.setForeground(new Color(255, 255, 255));
        labelCategoriaPregunta.setText("Categoria");
        labelCategoriaPregunta.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel1.add(labelCategoriaPregunta);

        panelInformacionPregunta.add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(2, 4));

        labelRespuestaCorrecta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelRespuestaCorrecta.setForeground(new Color(255, 255, 255));
        labelRespuestaCorrecta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRespuestaCorrecta.setText("Respuesta Correcta");
        jPanel2.add(labelRespuestaCorrecta);

        labelRespuestaIncorrecta1Informacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelRespuestaIncorrecta1Informacion.setForeground(new Color(255, 255, 255));
        labelRespuestaIncorrecta1Informacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRespuestaIncorrecta1Informacion.setText("Respuesta Incorrecta 1");
        jPanel2.add(labelRespuestaIncorrecta1Informacion);

        labelRespuestaIncorrecta2Informacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelRespuestaIncorrecta2Informacion.setForeground(new Color(255, 255, 255));
        labelRespuestaIncorrecta2Informacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRespuestaIncorrecta2Informacion.setText("Respuesta Incorrecta 2");
        jPanel2.add(labelRespuestaIncorrecta2Informacion);

        labelRespuestaIncorrecta3Informacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelRespuestaIncorrecta3Informacion.setForeground(new Color(255, 255, 255));
        labelRespuestaIncorrecta3Informacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRespuestaIncorrecta3Informacion.setText("Respuesta Incorrecta 3");
        jPanel2.add(labelRespuestaIncorrecta3Informacion);

        textoRespuestaCorrecta.setEditable(false);
        textoRespuestaCorrecta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoRespuestaCorrecta.setHorizontalAlignment(JTextField.CENTER);
        textoRespuestaCorrecta.setForeground(new Color(255, 255, 255));
        textoRespuestaCorrecta.setBackground(new Color(50, 255, 126,100));
        jPanel2.add(textoRespuestaCorrecta);

        textoRespuestaIncorrecta1.setEditable(false);
        textoRespuestaIncorrecta1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoRespuestaIncorrecta1.setForeground(new Color(255, 255, 255));
        textoRespuestaIncorrecta1.setHorizontalAlignment(JTextField.CENTER);
        textoRespuestaIncorrecta1.setBackground(new Color(255, 56, 56,100));
        jPanel2.add(textoRespuestaIncorrecta1);

        textoRespuestaIncorrecta2.setEditable(false);
        textoRespuestaIncorrecta2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoRespuestaIncorrecta2.setForeground(new Color(255, 255, 255));
        textoRespuestaIncorrecta2.setHorizontalAlignment(JTextField.CENTER);
        textoRespuestaIncorrecta2.setBackground(new Color(255, 56, 56,100));
        jPanel2.add(textoRespuestaIncorrecta2);

        textoRespuestaIncorrecta3.setEditable(false);
        textoRespuestaIncorrecta3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textoRespuestaIncorrecta3.setForeground(new Color(255, 255, 255));
        textoRespuestaIncorrecta3.setHorizontalAlignment(JTextField.CENTER);
        textoRespuestaIncorrecta3.setBackground(new Color(255, 56, 56,100));
        jPanel2.add(textoRespuestaIncorrecta3);

        panelInformacionPregunta.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 40));

        btnSalirDiaologoInformacion1.setBackground(new Color(238, 82, 83));
        btnSalirDiaologoInformacion1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalirDiaologoInformacion1.setForeground(new Color(0, 0, 0));
        btnSalirDiaologoInformacion1.setText("Salir");
        btnSalirDiaologoInformacion1.setPreferredSize(new java.awt.Dimension(200, 50));
        btnSalirDiaologoInformacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirDiaologoInformacion1ActionPerformed(evt);
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

        panelPrinicipal.setLayout(new java.awt.BorderLayout());

        panelBotones.setAutoscrolls(true);
        panelBotones.setPreferredSize(new java.awt.Dimension(200, 405));
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        jLabel1.setPreferredSize(new java.awt.Dimension(200, 220));
        panelBotones.add(jLabel1);

        btnCrear.setBackground(new Color(29, 209, 161));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrear.setForeground(new Color(0, 0, 0));
        btnCrear.setText("Crear");
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.setPreferredSize(new java.awt.Dimension(150, 50));
        panelBotones.add(btnCrear);

        btnBorrar.setBackground(new Color(238, 82, 83));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setForeground(new Color(0, 0, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.setPreferredSize(new java.awt.Dimension(150, 50));
        panelBotones.add(btnBorrar);

        btnModificarNombre.setBackground(new Color(238, 82, 83));
        btnModificarNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificarNombre.setForeground(new Color(0, 0, 0));
        btnModificarNombre.setText("Modificar Nombre");
        btnModificarNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarNombre.setPreferredSize(new java.awt.Dimension(150, 50));
        panelBotones.add(btnModificarNombre);

        panelPrinicipal.add(panelBotones, java.awt.BorderLayout.LINE_END);

        panelContenido.setLayout(new java.awt.BorderLayout(0, 25));

        listaCategorias.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        listaCategorias.setForeground(new Color(0, 0, 0));
        listaCategorias.setPreferredSize(new java.awt.Dimension(200, 50));
        panelContenido.add(listaCategorias, java.awt.BorderLayout.PAGE_START);

        tablaInformacionPreguntas.setForeground(new Color(255, 255, 255));
        tablaInformacionPreguntas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Pregunta", "Respuesta Correcta", "Respuesta Incorrecta 1", "Respuesta Incorrecta 2", "Respuessta Incorrecta 3"
                }
        ) {
            Class[] types = new Class[]{
                    String.class, String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tablaInformacionPreguntas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        tablaPreguntas.setViewportView(tablaInformacionPreguntas);

        panelContenido.add(tablaPreguntas, java.awt.BorderLayout.CENTER);

        panelPrinicipal.add(panelContenido, java.awt.BorderLayout.CENTER);

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
                        .addComponent(panelPrinicipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrinicipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
        listaCategorias.setEditable(true);
        for (String e : GestionCategorias.obtenerCategorias()) {
            listaCategorias.addItem(e);
        }
        GestionCategorias.colocarPreguntas(tablaInformacionPreguntas, listaCategorias.getSelectedItem().toString());
        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        VentanaAdministrarCuestionarios ventana = new VentanaAdministrarCuestionarios();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionCuestionariosActionPerformed

    private void opcionCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionCategoriasActionPerformed
        VentanaAdministrarCategorias ventana = new VentanaAdministrarCategorias();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionCategoriasActionPerformed

    private void btnVaciarDialogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarDialogoActionPerformed

    }//GEN-LAST:event_btnVaciarDialogoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dialogoPreguntas.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //obtenemos la posicion de la fila que se ha pulsado
        int posicion = tablaInformacionPreguntas.getSelectedRow();
        //obtenemos los datos de la pregunta
        String enunciado = (String) modelo.getValueAt(posicion,0);
        String respuestaCorrecta = (String) modelo.getValueAt(posicion,1);
        String respuestaIncorrecta1 = (String) modelo.getValueAt(posicion,2);
        String respuestaIncorrecta2 = (String) modelo.getValueAt(posicion,3);
        String respuestaIncorrecta3 = (String) modelo.getValueAt(posicion,4);
        //colocamos el enunciado de la pregunta
        GestionPreguntas.colocarEnunciadoPregunta(labelTextoPregunta, enunciado);
        //colocamos la categoria en su label correspondiente
        labelCategoriaPregunta.setText(listaCategorias.getSelectedItem().toString());
        //colocamos las respuestas de la pregunta
        GestionPreguntas.colocarRespuesta(textoRespuestaCorrecta,respuestaCorrecta);
        GestionPreguntas.colocarRespuesta(textoRespuestaIncorrecta1,respuestaIncorrecta1);
        GestionPreguntas.colocarRespuesta(textoRespuestaIncorrecta2,respuestaIncorrecta2);
        GestionPreguntas.colocarRespuesta(textoRespuestaIncorrecta3,respuestaIncorrecta3);

        dialogoInformacionPregunta.setSize(1000, 500);
        dialogoInformacionPregunta.show();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1ItemListener(java.awt.event.ItemEvent evt) {
        modelo = GestionCategorias.colocarPreguntas(tablaInformacionPreguntas, listaCategorias.getSelectedItem().toString());
    }

    private void btnSalirDiaologoInformacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirDiaologoInformacion1ActionPerformed
        dialogoInformacionPregunta.dispose();
    }//GEN-LAST:event_btnSalirDiaologoInformacion1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAdministrarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrarCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdministrarCategorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificarNombre;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirDiaologoInformacion1;
    private javax.swing.JButton btnVaciarDialogo;
    private javax.swing.JDialog dialogoInformacionPregunta;
    private javax.swing.JDialog dialogoPreguntas;
    private javax.swing.JTextField inputRespuestaCorrecta;
    private javax.swing.JTextField inputRespuestaIncorrecta1;
    private javax.swing.JTextField inputRespuestaIncorrecta2;
    private javax.swing.JTextField inputRespuestaIncorrecta3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable tablaInformacionPreguntas;
    private javax.swing.JLabel labelCategoriaPregunta;
    private javax.swing.JLabel labelRespuestaCorrecta;
    private javax.swing.JLabel labelRespuestaIncorrecta1Informacion;
    private javax.swing.JLabel labelRespuestaIncorrecta2Informacion;
    private javax.swing.JLabel labelRespuestaIncorrecta3Informacion;
    private javax.swing.JLabel labelTextoPregunta;
    private javax.swing.JComboBox<String> listaCategorias;
    private javax.swing.JComboBox<String> listaCategoriasDialogo;
    private javax.swing.JComboBox<String> listaPreguntasDialogo;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem opcionCategorias;
    private javax.swing.JMenuItem opcionCuestionarios;
    private javax.swing.JMenuItem opcionModoJuego;
    private javax.swing.JMenuItem opcionPreguntas;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelDialogoFila1;
    private javax.swing.JPanel panelDialogoFila2;
    private javax.swing.JPanel panelDialogoFila3;
    private javax.swing.JPanel panelDialogoFila4;
    private javax.swing.JPanel panelInformacionPregunta;
    private javax.swing.JPanel panelPrincipal1;
    private javax.swing.JPanel panelPrinicipal;
    private javax.swing.JScrollPane tablaPreguntas;
    private javax.swing.JTextField textoRespuestaCorrecta;
    private javax.swing.JTextField textoRespuestaIncorrecta1;
    private javax.swing.JTextField textoRespuestaIncorrecta2;
    private javax.swing.JTextField textoRespuestaIncorrecta3;
    // End of variables declaration//GEN-END:variables
}
