/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.administrador;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import controlador.administrador.GestionCategorias;
import controlador.administrador.GestionPreguntas;
import modelo.Pregunta;
import vista.acceso.VentanaLogin;
import vista.administrador.dialogos.DialogoDatosPregunta;
import vista.juego.VentanaSeleccionarModoJuego;


import javax.swing.*;

/**
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
        barraMenu = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        opcionCerrarSesion = new javax.swing.JMenuItem();
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
        listaPreguntas.setForeground(new Color(255, 255, 255));
        listaPreguntas.setMaximumRowCount(50);
        listaPreguntas.setPreferredSize(new java.awt.Dimension(600, 40));
        listaPreguntas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                listaPreguntasItemStateChanged(evt);
            }
        });
        jPanel2.add(listaPreguntas);

        listaCategorias.setForeground(new Color(255, 255, 255));
        listaCategorias.setPreferredSize(new java.awt.Dimension(200, 40));
        listaCategorias.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                listaCategoriasItemStateChanged(evt);
            }
        });
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
        inputRespuestaCorrecta.setBackground(new Color(50, 255, 126, 100));
        inputRespuestaCorrecta.setHorizontalAlignment(JTextField.CENTER);
        jPanel3.add(inputRespuestaCorrecta);

        inputRespuestaIncorrecta1.setColumns(20);
        inputRespuestaIncorrecta1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaIncorrecta1.setForeground(new Color(255, 255, 255));
        inputRespuestaIncorrecta1.setBackground(new Color(255, 56, 56, 100));
        inputRespuestaIncorrecta1.setHorizontalAlignment(JTextField.CENTER);
        jPanel3.add(inputRespuestaIncorrecta1);

        inputRespuestaIncorrecta2.setColumns(20);
        inputRespuestaIncorrecta2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaIncorrecta2.setForeground(new Color(255, 255, 255));
        inputRespuestaIncorrecta2.setBackground(new Color(255, 56, 56, 100));
        inputRespuestaIncorrecta2.setHorizontalAlignment(JTextField.CENTER);
        jPanel3.add(inputRespuestaIncorrecta2);

        inputRespuestaIncorrecta3.setColumns(20);
        inputRespuestaIncorrecta3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputRespuestaIncorrecta3.setForeground(new Color(255, 255, 255));
        inputRespuestaIncorrecta3.setBackground(new Color(255, 56, 56, 100));
        inputRespuestaIncorrecta3.setHorizontalAlignment(JTextField.CENTER);
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
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jPanel4.add(btnInsertar);

        btnBorrar.setBackground(new Color(238, 82, 83));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setForeground(new Color(0, 0, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.setBorder(null);
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.setPreferredSize(new java.awt.Dimension(200, 60));
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBorrar);

        btnModificar.setBackground(new Color(238, 82, 83));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificar.setForeground(new Color(0, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setPreferredSize(new java.awt.Dimension(200, 60));
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnModificarActionListener(evt);
            }
        });
        jPanel4.add(btnModificar);
        panelPrincipal.add(jPanel4);

        menuUsuario.setText("Usuario");

        opcionModoJuego.setText("Seleccionar Modo de juego");
        opcionModoJuego.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        opcionModoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionModoJuegoActionPerformed(evt);
            }
        });
        menuUsuario.add(opcionModoJuego);
        opcionCerrarSesion.setText("Cerrar sesion");
        opcionCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        opcionCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                opcionCerrarSesionActionListener(evt);
            }
        });
        menuUsuario.add(opcionCerrarSesion);


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
        //Todo: poder las categorias

        colocarCategorias();
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionListener(ActionEvent evt) {
        /*
        obtenemos el enunciado antiguo de la pregunta, es importante tenerlo guardado
        porque puede ser modificado
         */
        String enunciadoAntiguo = listaPreguntas.getSelectedItem().toString();
        //Colocamos los datos de la pregunta seleccionada en los campos del dialogo
        DialogoDatosPregunta.setEnunciado(listaPreguntas.getSelectedItem().toString());
        DialogoDatosPregunta.setRespuestaCorrecta(inputRespuestaCorrecta.getText());
        DialogoDatosPregunta.setRespuestaIncorrecta1(inputRespuestaIncorrecta1.getText());
        DialogoDatosPregunta.setRespuestaIncorrecta2(inputRespuestaIncorrecta2.getText());
        DialogoDatosPregunta.setRespuestaIncorrecta3(inputRespuestaIncorrecta3.getText());
        //mostramos el dialogo y le indicamos que no restablezca los datos, lo hacemos pasandole un false
        DialogoDatosPregunta.mostrarDialogo(false);
        //obtenemos los datos una vez el usuario haya pulsado el boton de aceptar
        String enunciado = DialogoDatosPregunta.getEnunciado();
        String respuestaCorrecta = DialogoDatosPregunta.getRespuestaCorrecta();
        String respuestaIncorrecta1 = DialogoDatosPregunta.getRespuestaIncorrecta1();
        String respuestaIncorrecta2 = DialogoDatosPregunta.getRespuestaIncorrecta2();
        String respuestaIncorrecta3 = DialogoDatosPregunta.getRespuestaIncorrecta3();
        //creamos la pregunta con los datos recogidos
        Pregunta p = new Pregunta(enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3);
        //nos aseguramos de que no estan vacios
        if (enunciado.equals("") || respuestaCorrecta.equals("") || respuestaIncorrecta1.equals("")
                || respuestaIncorrecta2.equals("") || respuestaIncorrecta3.equals("")) {
            //en ese caso mostramos el mensaje de error
            JOptionPane.showMessageDialog(this, "Datos Erroneos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (GestionPreguntas.modificarPregunta(p, enunciadoAntiguo)) {//si se modifica la pregunta
            JOptionPane.showMessageDialog(this, "Pregunta Modificada Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            //borramos de la lista de preguntas el enunciado antiguo puesto que puede haber cambiado
            listaPreguntas.removeItem(enunciadoAntiguo);
            //añadimos a la lista de preguntas el enunciado nuevo
            listaPreguntas.addItem(enunciado);
            //seleccionamos en la lista de preguntas el enunciado nuevo para que el usuario no note el cambio
            listaPreguntas.setSelectedItem(enunciado);
        } else {//en caso de que no se pueda modificar la pregunta
            JOptionPane.showMessageDialog(this, "No se ha podido Modificar la pregunta", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void btnBorrarActionPerformed(ActionEvent evt) {
        try {
            String enunciado = listaPreguntas.getSelectedItem().toString();
            if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres realizar la accion?", "¿Estas seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                if (GestionPreguntas.borrarPregunta(enunciado)) {
                    JOptionPane.showMessageDialog(this, "Pregunta Borrada Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    listaPreguntas.removeItem(enunciado);
                } else {
                    StringBuilder cadena = new StringBuilder();
                    cadena.append("No se ha podido borrar la pregunta, las posibles causas son:\n");
                    cadena.append("\t > Ha ocurrido un error en la conexion a la base de datos\n");
                    cadena.append("\t > No dispones de los permisos necesarios para realizar esa accion\n");
                    cadena.append("\t > No se pueden borrar preguntas asignadas a un cuestionario\n");
                    cadena.append("\t> No se pueden borrar preguntas que hayan sido respondidas en alguna partida\n");
                    JOptionPane.showMessageDialog(this, cadena.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NullPointerException npe) {
            /*
            En caso de que ocurra la excepcion limpiamos las cajas porque
            significa que la lista de preguntas esta vacia y no hay ninguna
            seleccionada
             */
            inputRespuestaCorrecta.setText("");
            inputRespuestaIncorrecta1.setText("");
            inputRespuestaIncorrecta2.setText("");
            inputRespuestaIncorrecta3.setText("");
        }
    }

    private void btnInsertarActionPerformed(ActionEvent evt) {
        DialogoDatosPregunta.mostrarDialogo(true);
        //Obtenemos los datos del dialogo
        String enunciado = DialogoDatosPregunta.getEnunciado();
        String respuestaCorrecta = DialogoDatosPregunta.getRespuestaCorrecta();
        String respuestaIncorrecta1 = DialogoDatosPregunta.getRespuestaIncorrecta1();
        String respuestaIncorrecta2 = DialogoDatosPregunta.getRespuestaIncorrecta2();
        String respuestaIncorrecta3 = DialogoDatosPregunta.getRespuestaIncorrecta3();
        int idCategoria = GestionCategorias.obtenerIdCategoria(listaCategorias.getSelectedItem().toString());
        //nos aseguramos que los campos estan rellenos
        if (enunciado.equals("") || respuestaCorrecta.equals("") || respuestaIncorrecta1.equals("")
                || respuestaIncorrecta2.equals("") || respuestaIncorrecta3.equals("") || idCategoria == -1) {
            JOptionPane.showMessageDialog(this, "Datos Erroneos", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (GestionPreguntas.insertarPregunta(new Pregunta(enunciado, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3, idCategoria))) {
            JOptionPane.showMessageDialog(this, "Pregunta Insertada Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            listaPreguntas.addItem(enunciado);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha podido insertar la pregunta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listaPreguntasItemStateChanged(ItemEvent evt) {
        try {
            String[] datos = GestionPreguntas.obtenerRespuestas(listaPreguntas.getSelectedItem().toString());
            if (datos == null) {
                return;
            }
            GestionPreguntas.colocarRespuesta(inputRespuestaCorrecta, datos[0]);
            GestionPreguntas.colocarRespuesta(inputRespuestaIncorrecta1, datos[1]);
            GestionPreguntas.colocarRespuesta(inputRespuestaIncorrecta2, datos[2]);
            GestionPreguntas.colocarRespuesta(inputRespuestaIncorrecta3, datos[3]);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {
            /*
             * En caso de que se seleccione una categoria sin preguntas, ocurrira una expecion
             * porque no hay nada en la lista desplegable, entonces vaciamos las respuestas
             * para que no se queden las respuestas de la pregunta anterior
             */
            inputRespuestaCorrecta.setText("");
            inputRespuestaIncorrecta1.setText("");
            inputRespuestaIncorrecta2.setText("");
            inputRespuestaIncorrecta3.setText("");
        }
    }

    /**
     * Este metodo nos va a permitir colocar las preguntas de una categoria en la lista desplegable
     *
     * @author Fernando
     */
    private void listaCategoriasItemStateChanged(ItemEvent evt) {
        listaPreguntas.removeAllItems();
        ArrayList<String[]> preguntas = GestionPreguntas.obtenerPreguntas(listaCategorias.getSelectedItem().toString());
        for (String[] arr : preguntas) {
            listaPreguntas.addItem(arr[0]);
        }

    }

    /**
     * Este metodo permite colocar las categorias en la lista desplegable
     *
     * @author Fernando
     */
    public void colocarCategorias() {
        ArrayList<String> nombresCategorias = GestionCategorias.obtenerCategorias();
        for (String s : nombresCategorias) {
            listaCategorias.addItem(s);
        }
    }

    private void opcionCerrarSesionActionListener(ActionEvent evt) {
        VentanaLogin frame = new VentanaLogin();
        frame.setVisible(true);
        dispose();
    }

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
        VentanaAdministrarCuestionarios ventana = new VentanaAdministrarCuestionarios();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionCuestionariosActionPerformed

    private void opcionCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionCategoriasActionPerformed
        VentanaAdministrarCategorias ventana = new VentanaAdministrarCategorias();
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
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
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
    private javax.swing.JMenuItem opcionCerrarSesion;

    private javax.swing.JMenuItem opcionCategorias;
    private javax.swing.JMenuItem opcionCuestionarios;
    private javax.swing.JMenuItem opcionModoJuego;
    private javax.swing.JMenuItem opcionPreguntas;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
