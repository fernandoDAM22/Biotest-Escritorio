/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.juego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.controlPartida.*;
import controlador.herramientas.TipoPartida;
import controlador.usuario.ConfiguracionUsuario;
import controlador.usuario.GestionUsuarios;
import modelo.Cuestionario;
import modelo.Partida;
import vista.administrador.VentanaAdministrarCategorias;
import vista.administrador.VentanaAdministrarCuestionarios;
import vista.administrador.VentanaAdministrarPreguntas;

import javax.swing.*;

/**
 * @author fernando
 */
public class VentanaJugar extends javax.swing.JFrame {
    private TipoPartida tipoPartida;
    private PartidaModoLibre partidaModoLibre;
    private PartidaModoSinFallos partidaModoSinFallos;
    private PartidaModoClasico partidaModoClasico;
    private PartidaCuestionario partidaCuestionario;
    private Partida partida;
    private boolean bandera;
    private int idPregunta;
    private int idPartida, idUsuario;

    /**
     * Creates new form VentanaJugar
     */
    public VentanaJugar() {
        initComponents();
    }

    public VentanaJugar(TipoPartida tipoPartida) {
        this.tipoPartida = tipoPartida;
        bandera = true;
        initComponents();
        jugar();
    }

    /**
     * Este metodo permite iniciar una partida
     *
     * @author Fernando
     */
    private void jugar() {
        if (tipoPartida != TipoPartida.MODO_LIBRE) {
            panelControles.remove(btnFinalizar);
        }
        switch (tipoPartida) {
            case MODO_LIBRE -> jugarModoLibre();
            case MODO_SIN_FALLOS -> jugarModoSinFallos();
            case MODO_CLASICO -> jugarModoClasico();
            case CUESTIONARIOS -> jugarCuestionarios();
        }
    }

    /**
     * Este metodo permite guardar el id de la partida y el id del usuario
     */
    private void iniciarPartida() {
        idPartida = GestionPartida.obtenerId();
        idUsuario = GestionUsuarios.obtenerIdUsuario(ConfiguracionUsuario.getNombreUsuario());
    }

    /**
     * Este metodo permite jugar una partida en modo libre
     *
     * @author Fernando
     */
    private void jugarModoLibre() {
        iniciarPartida();
        if (idPartida == -1 || idUsuario == -1) {
            return;
        }
        partida = new Partida(idPartida, tipoPartida.toString(), idUsuario);
        partidaModoLibre = new PartidaModoLibre(partida, btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4, labelPregunta);
        idPregunta = partidaModoLibre.ciclo();
    }

    private void jugarModoSinFallos() {
        iniciarPartida();
        if (idPartida == -1 || idUsuario == -1) {
            return;
        }
        partida = new Partida(idPartida, tipoPartida.toString(), idUsuario);
        partidaModoSinFallos = new PartidaModoSinFallos(partida, btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4, labelPregunta);
        idPregunta = partidaModoSinFallos.ciclo();
    }

    private void jugarModoClasico() {
        iniciarPartida();
        if (idPartida == -1 || idUsuario == -1) {
            return;
        }
        partida = new Partida(idPartida, tipoPartida.toString(), idUsuario);
        partidaModoClasico = new PartidaModoClasico(partida, btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4, labelPregunta);
        partidaModoClasico.seleccionarPregunta();
        idPregunta = partidaModoClasico.ciclo();

    }


    private void jugarCuestionarios() {
        iniciarPartida();
        if (idPartida == -1 || idUsuario == -1) {
            return;
        }
        partida = new Partida(idPartida,tipoPartida.toString(),idUsuario);
        partidaCuestionario = new PartidaCuestionario(partida,btnOpcion1,btnOpcion2,btnOpcion3,btnOpcion4,labelPregunta);
        partidaCuestionario.seleccionarPregunta();
        idPregunta = partidaCuestionario.ciclo();
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
        panelInformacion = new javax.swing.JPanel();
        panelControles = new javax.swing.JPanel();
        labelRespuestasIncorrectas = new javax.swing.JLabel();
        labelRespuestasCorrectas = new javax.swing.JLabel();
        panelPregunta = new javax.swing.JPanel();
        labelPregunta = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        btnOpcion1 = new javax.swing.JButton();
        btnOpcion2 = new javax.swing.JButton();
        btnOpcion3 = new javax.swing.JButton();
        btnOpcion4 = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
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

        panelInformacion.setPreferredSize(new java.awt.Dimension(1000, 10));
        panelInformacion.setLayout(new java.awt.BorderLayout());


        labelRespuestasIncorrectas.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        labelRespuestasIncorrectas.setForeground(new Color(238, 82, 83));
        labelRespuestasIncorrectas.setText("Respuestas Incorrectas: ");
        labelRespuestasIncorrectas.setPreferredSize(new java.awt.Dimension(220, 0));
        panelInformacion.add(labelRespuestasIncorrectas, java.awt.BorderLayout.LINE_START);

        labelRespuestasCorrectas.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        labelRespuestasCorrectas.setForeground(new Color(29, 209, 161));
        labelRespuestasCorrectas.setText("Respuestas Correctas: ");
        labelRespuestasCorrectas.setPreferredSize(new java.awt.Dimension(220, 0));
        panelInformacion.add(labelRespuestasCorrectas, java.awt.BorderLayout.LINE_END);

        panelPrincipal.add(panelInformacion);

        labelPregunta.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        labelPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPregunta.setText("Aqui va el texto de la pregunta");
        labelPregunta.setPreferredSize(new java.awt.Dimension(1000, 50));
        panelPregunta.add(labelPregunta);

        panelPrincipal.add(panelPregunta);

        btnOpcion1.setBackground(new Color(72, 219, 251));
        btnOpcion1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        btnOpcion1.setForeground(new Color(0, 0, 0));
        btnOpcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpcion1.setPreferredSize(new java.awt.Dimension(220, 50));
        btnOpcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                responder(evt);
            }
        });
        panelOpciones.add(btnOpcion1);

        btnOpcion2.setBackground(new Color(72, 219, 251));
        btnOpcion2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        btnOpcion2.setForeground(new Color(0, 0, 0));
        btnOpcion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpcion2.setPreferredSize(new java.awt.Dimension(220, 50));
        btnOpcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                responder(evt);
            }
        });
        panelOpciones.add(btnOpcion2);

        btnOpcion3.setBackground(new Color(72, 219, 251));
        btnOpcion3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOpcion3.setForeground(new Color(0, 0, 0));
        btnOpcion3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpcion3.setPreferredSize(new java.awt.Dimension(220, 50));
        btnOpcion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                responder(evt);
            }
        });
        panelOpciones.add(btnOpcion3);

        btnOpcion4.setBackground(new Color(72, 219, 251));
        btnOpcion4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOpcion4.setForeground(new Color(0, 0, 0));
        btnOpcion4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpcion4.setPreferredSize(new java.awt.Dimension(220, 50));
        btnOpcion4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                responder(evt);
            }
        });
        panelOpciones.add(btnOpcion4);

        panelPrincipal.add(panelOpciones);

        panelControles.setLayout(new java.awt.FlowLayout());

        btnFinalizar.setBackground(new Color(238, 82, 83));
        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizar.setForeground(new Color(0, 0, 0));
        btnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizar.setPreferredSize(new java.awt.Dimension(220, 50));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnFinalizarActionListener(evt);
            }
        });

        panelControles.add(btnFinalizar);

        panelControles.setLayout(new java.awt.FlowLayout());
        btnSiguiente.setBackground(new Color(29, 209, 161));
        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSiguiente.setForeground(new Color(0, 0, 0));
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSiguiente.setPreferredSize(new java.awt.Dimension(220, 50));
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnSiguienteActionListener(evt);
            }
        });
        btnSiguiente.setText("Siguiente");

        panelControles.add(btnSiguiente);

        panelPrincipal.add(panelControles);


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
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        ConfiguracionUsuario.desactivarMenu(barraMenu, menuAdministrador);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionListener(ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres realizar la accion?", "¿Estas seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
            lanzarVentanaResultado();
            dispose();
        }
    }

    /**
     * Este metodo permite establecer la puntuacion a la partida una vez a terminado
     *
     * @author Fernando
     */
    private void colocarPuntuacion() {
        int puntuacion = 0;
        switch (tipoPartida) {
            case MODO_LIBRE:
                puntuacion = partidaModoLibre.getContadorPreguntasCorrectas();
                break;
            case MODO_SIN_FALLOS:
                puntuacion = partidaModoSinFallos.getContadorPreguntasCorrectas();
                break;
            case MODO_CLASICO:
                puntuacion = partidaModoClasico.getContadorPreguntasCorrectas();
                break;
            case CUESTIONARIOS:
                puntuacion = partidaCuestionario.getContadorPreguntasCorrectas();
                break;
        }
        ConsultasPartida.establecerPuntuacion(partida.getId(), puntuacion);
    }

    private void btnSiguienteActionListener(ActionEvent evt) {
        if (bandera) {
            JOptionPane.showMessageDialog(null, "Debe responder a la pregunta antes de pasar a la siguiente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        switch (tipoPartida) {
            case MODO_LIBRE:
                if (!partidaModoLibre.fin()) {
                    bandera = true;
                    idPregunta = partidaModoLibre.ciclo();
                } else {
                    lanzarVentanaResultado();
                }
                break;
            case MODO_SIN_FALLOS:
                if (!partidaModoSinFallos.fin()) {
                    bandera = true;
                    idPregunta = partidaModoSinFallos.ciclo();
                } else {
                    lanzarVentanaResultado();
                }
                break;
            case MODO_CLASICO:
                if (partidaModoClasico.fin()) {
                    bandera = true;
                    idPregunta = partidaModoClasico.ciclo();
                } else {
                    lanzarVentanaResultado();
                }
                break;
            case CUESTIONARIOS:
                if(partidaCuestionario.fin()){
                    bandera = true;
                    idPregunta = partidaCuestionario.ciclo();
                }else {
                    lanzarVentanaResultado();
                }
                break;
        }
    }

    private void lanzarVentanaResultado() {
        colocarPuntuacion();
        VentanaResultado frame = new VentanaResultado(idPartida);
        frame.setVisible(true);
        dispose();
    }

    /**
     * Este metodo permite responder una pregunta
     *
     * @param evt es el boton que se pulsa
     */
    private void responder(ActionEvent evt) {
        boolean acertada;
        switch (tipoPartida) {
            case MODO_LIBRE -> responderModoLibre(evt);
            case MODO_SIN_FALLOS -> responderModoSinFallos(evt);
            case MODO_CLASICO -> responderModoClasico(evt);
            case CUESTIONARIOS -> responderCuestionario(evt);
        }
    }

    private void responderModoClasico(ActionEvent evt) {
        if (bandera) {
            JButton button = (JButton) evt.getSource();
            boolean acertada = partidaModoClasico.responder(button);
            bandera = false;
            labelRespuestasCorrectas.setText("Respuestas correctas: " + partidaModoClasico.getContadorPreguntasCorrectas());
            labelRespuestasIncorrectas.setText("Respuestas incorrectas " + partidaModoClasico.getContadorRespuestasIncorrectas());
            ConsultasPartida.insertarPregunta(partida.getId(), idPregunta, acertada);
        }
    }

    private void responderModoSinFallos(ActionEvent evt) {
        if (bandera) {
            JButton button = (JButton) evt.getSource();
            boolean acertada = partidaModoSinFallos.responder(button);
            bandera = false;
            labelRespuestasCorrectas.setText("Respuestas correctas: " + partidaModoSinFallos.getContadorPreguntasCorrectas());
            labelRespuestasIncorrectas.setText("Respuestas incorrectas " + partidaModoSinFallos.getContadorRespuestasIncorrectas());
            ConsultasPartida.insertarPregunta(partida.getId(), idPregunta, acertada);
        }
    }

    /**
     * Este metodo permite responder una pregunta cuando se esta jugando una partida en modo libre
     *
     * @param evt es el boton que se pulsa
     */
    private void responderModoLibre(ActionEvent evt) {
        //solo se permite pulsar un boton, hasta que se coloque otra pregunta
        if (bandera) {
            JButton button = (JButton) evt.getSource();
            boolean acertada = partidaModoLibre.responder(button);
            bandera = false;
            labelRespuestasCorrectas.setText("Respuestas correctas: " + partidaModoLibre.getContadorPreguntasCorrectas());
            labelRespuestasIncorrectas.setText("Respuestas incorrectas " + partidaModoLibre.getContadorRespuestasIncorrectas());
            ConsultasPartida.insertarPregunta(partida.getId(), idPregunta, acertada);
        }
    }
    private void responderCuestionario(ActionEvent evt){
        if(bandera){
            JButton button = (JButton) evt.getSource();
            boolean acertada = partidaCuestionario.responder(button);
            bandera = false;
            labelRespuestasCorrectas.setText("Respuestas correctas: " + partidaCuestionario.getContadorPreguntasCorrectas());
            labelRespuestasIncorrectas.setText("Respuestas incorrectas " + partidaCuestionario.getContadorRespuestasIncorrectas());
            ConsultasPartida.insertarPregunta(partida.getId(), idPregunta, acertada);
        }
    }

    private void opcionModoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionModoJuego6ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres salir, no has finalizado la partida", "¿Estas seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
            VentanaSeleccionarModoJuego ventana = new VentanaSeleccionarModoJuego();
            ventana.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_opcionModoJuego6ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJugar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnOpcion1;
    private javax.swing.JButton btnOpcion2;
    private javax.swing.JButton btnOpcion3;
    private javax.swing.JButton btnOpcion4;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnFinalizar;

    private javax.swing.JLabel labelPregunta;
    private javax.swing.JLabel labelRespuestasCorrectas;
    private javax.swing.JLabel labelRespuestasIncorrectas;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem opcionCategorias;
    private javax.swing.JMenuItem opcionCuestionarios;
    private javax.swing.JMenuItem opcionModoJuego;
    private javax.swing.JMenuItem opcionPreguntas;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelControles;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelPregunta;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}
