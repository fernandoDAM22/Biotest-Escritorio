/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.juego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.controlPartida.*;
import controller.tools.Colores;
import controller.tools.Mensajes;
import controller.tools.TipoPartida;
import controller.usuario.ConfiguracionUsuario;
import controller.usuario.GestionUsuarios;
import model.Partida;
import view.administrador.VentanaAdministrarCategorias;
import view.administrador.VentanaAdministrarCuestionarios;
import view.administrador.VentanaAdministrarPreguntas;


import javax.swing.*;

/**
 * Esta ventana permite al usuario jugar una partida, los tipos
 * de partida disponibles son:
 * <ul>
 *     <li>Partida Modo libre</li>
 *     <li>Partida Modo clasico</li>
 *     <li>Partida Modo sin fallos</li>
 *     <li>Partida Modo Cuestionario</li>
 * </ul>
 * <hr>
 * @author Fernando
 */
public class VentanaJugar extends javax.swing.JFrame {
    /**
     * Tipo de la partida que se esta jugando
     */
    private TipoPartida tipoPartida;
    /**
     * Partida modo libre por si el usuario decice jugar este tipo de partida
     */
    private PartidaModoLibre partidaModoLibre;
    /**
     * Partida modo sin fallos por si el usuario decice jugar este tipo de partida
     */
    private PartidaModoSinFallos partidaModoSinFallos;
    /**
     * Partida modo clasico por si el usuario decice jugar este tipo de partida
     */
    private PartidaModoClasico partidaModoClasico;
    /**
     * Partida modo cuestionario por si el usuario decice jugar este tipo de partida
     */
    private PartidaCuestionario partidaCuestionario;
    /**
     * Objeto de tipo modelo para la partida
     */
    private Partida partida;
    /**
     * Bandera para saber si la pregunta a sido respondida o no
     */
    private boolean bandera;
    /**
     * Id de la pregunta que se esta respondiendo
     */
    private int idPregunta;
    /**
     * Id de la partida que se esta jugando
     */
    private int idPartida;
    /**
     * Id del usuario que esta jugando la partida
     */
    private int idUsuario;

    /**
     * Constructor de la partida
     * @param tipoPartida es el tipo de partido que se va a jugar
     * @author Fernando
     */
    public VentanaJugar(TipoPartida tipoPartida) {
        this.tipoPartida = tipoPartida;
        bandera = true;
        initComponents();
        setLocationRelativeTo(null);
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
        //se inicia la partida en funcion del tipo de partida elegido
        switch (tipoPartida) {
            case MODO_LIBRE -> jugarModoLibre();
            case MODO_SIN_FALLOS -> jugarModoSinFallos();
            case MODO_CLASICO -> jugarModoClasico();
            case CUESTIONARIOS -> jugarCuestionarios();
        }
    }    /**
     * Este metodo permite guardar el id de la partida y el id del usuario
     * @author Fernando
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
        //nos aseguramos de que no hayan errores al obtener los datos
        if (idPartida == -1 || idUsuario == -1) {
            return;
        }
        partida = new Partida(idPartida, tipoPartida.toString(), idUsuario);
        partidaModoLibre = new PartidaModoLibre(partida, btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4, labelPregunta);
        idPregunta = partidaModoLibre.ciclo();
    }

    /**
     * Este metodo permite jugar una partida en modo sin fallos
     * @author Fernando
     */
    private void jugarModoSinFallos() {
        iniciarPartida();
        //nos aseguramos de que no hayan errores al obtener los datos
        if (idPartida == -1 || idUsuario == -1) {
            return;
        }
        partida = new Partida(idPartida, tipoPartida.toString(), idUsuario);
        partidaModoSinFallos = new PartidaModoSinFallos(partida, btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4, labelPregunta);
        idPregunta = partidaModoSinFallos.ciclo();
    }
    /**
     * Este metodo permite jugar una partida en modo clasico
     * @author Fernando
     */
    private void jugarModoClasico() {
        iniciarPartida();
        //nos aseguramos de que no hayan errores al obtener los datos
        if (idPartida == -1 || idUsuario == -1) {
            return;
        }
        partida = new Partida(idPartida, tipoPartida.toString(), idUsuario);
        partidaModoClasico = new PartidaModoClasico(partida, btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4, labelPregunta);
        partidaModoClasico.seleccionarPregunta();
        idPregunta = partidaModoClasico.ciclo();

    }

    /**
     * Este metodo permite jugar una partida resolviendo un cuestionario
     * @author Fernando
     */
    private void jugarCuestionarios() {
        //nos aseguramos de que no hayan errores al obtener los datos
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        panelPrincipal.setLayout(new java.awt.GridLayout(4, 1));

        panelInformacion.setPreferredSize(new java.awt.Dimension(1000, 10));
        panelInformacion.setLayout(new java.awt.BorderLayout());


        labelRespuestasIncorrectas.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        labelRespuestasIncorrectas.setForeground(Colores.COLOR_PREGUNTAS_FALLADAS);
        labelRespuestasIncorrectas.setText("Respuestas Incorrectas: ");
        labelRespuestasIncorrectas.setPreferredSize(new java.awt.Dimension(220, 0));
        panelInformacion.add(labelRespuestasIncorrectas, java.awt.BorderLayout.LINE_START);

        labelRespuestasCorrectas.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        labelRespuestasCorrectas.setForeground(Colores.COLOR_PREGUNTAS_ACERTADAS);
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

        btnOpcion1.setBackground(Colores.COLOR_AZUL_BOTONES);
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

        btnOpcion2.setBackground(Colores.COLOR_AZUL_BOTONES);
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

        btnOpcion3.setBackground(Colores.COLOR_AZUL_BOTONES);
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

        btnOpcion4.setBackground(Colores.COLOR_AZUL_BOTONES);
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

        btnFinalizar.setBackground(Colores.COLOR_BOTON_CANCELAR);
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
        btnSiguiente.setBackground(Colores.COLOR_BOTON_ACEPTAR);
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
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionListener(ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(null, Mensajes.MENSAJE_CONFIRMACION, Mensajes.TITULO_CONFIRMACION, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
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
        //obtenemos la puntuacion en funcion de la partida que se ha jugado
        int puntuacion = switch (tipoPartida) {
            case MODO_LIBRE -> partidaModoLibre.getContadorPreguntasCorrectas();
            case MODO_SIN_FALLOS -> partidaModoSinFallos.getContadorPreguntasCorrectas();
            case MODO_CLASICO -> partidaModoClasico.getContadorPreguntasCorrectas();
            case CUESTIONARIOS -> partidaCuestionario.getContadorPreguntasCorrectas();
        };
        //realizamos una consulta de modificacion para colocar la puntuacion
        ConsultasPartida.establecerPuntuacion(partida.getId(), puntuacion);
    }

    private void btnSiguienteActionListener(ActionEvent evt) {
        //nos aseguramos de que la pregunta no ha sido ya respondida
        if (bandera) {
            JOptionPane.showMessageDialog(null, "Debe responder a la pregunta antes de pasar a la siguiente", Mensajes.ERROR, JOptionPane.ERROR_MESSAGE);
            return;
        }
        //en funcion del tipo de partida se llama al metodo ciclo de la partida correspondiente
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

    /**
     * Este metodo permite lanzar la ventana de resultado
     * @author Fernando
     */
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
        //en funcion del tipo de partida llamamos al metodo responder de la partida correspondiente
        switch (tipoPartida) {
            case MODO_LIBRE -> responderModoLibre(evt);
            case MODO_SIN_FALLOS -> responderModoSinFallos(evt);
            case MODO_CLASICO -> responderModoClasico(evt);
            case CUESTIONARIOS -> responderCuestionario(evt);
        }
    }

    /**
     * Este metodo permite responder una pregunta en una partida de modo clasico
     * @param evt es el boton que se pulsa
     * @author Fernando
     */
    private void responderModoClasico(ActionEvent evt) {
        //nos aseguramos de que la partida no esta respondida ya
        if (bandera) {
            JButton button = (JButton) evt.getSource();
            boolean acertada = partidaModoClasico.responder(button);
            //se marca que la pregunta ya ha sido respondida
            bandera = false;
            //se actualizan los contadores de respuestas correctas e incorrectas
            labelRespuestasCorrectas.setText("Respuestas correctas: " + partidaModoClasico.getContadorPreguntasCorrectas());
            labelRespuestasIncorrectas.setText("Respuestas incorrectas: " + partidaModoClasico.getContadorRespuestasIncorrectas());
            ConsultasPartida.insertarPregunta(partida.getId(), idPregunta, acertada);
        }
    }
    /**
     * Este metodo permite responder una pregunta en una partida de modo sin fallos
     * @param evt es el boton que se pulsa
     * @author Fernando
     */
    private void responderModoSinFallos(ActionEvent evt) {
        //nos aseguramos de que la partida no esta respondida ya
        if (bandera) {
            JButton button = (JButton) evt.getSource();
            boolean acertada = partidaModoSinFallos.responder(button);
            //se marca que la pregunta ya ha sido respondida
            bandera = false;
            //se actualizan los contadores de respuestas correctas e incorrectas
            labelRespuestasCorrectas.setText("Respuestas correctas: " + partidaModoSinFallos.getContadorPreguntasCorrectas());
            labelRespuestasIncorrectas.setText("Respuestas incorrectas: " + partidaModoSinFallos.getContadorRespuestasIncorrectas());
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
            //se marca que la pregunta ya ha sido respondida
            bandera = false;
            //se actualizan los contadores de respuestas correctas e incorrectas
            labelRespuestasCorrectas.setText("Respuestas correctas: " + partidaModoLibre.getContadorPreguntasCorrectas());
            labelRespuestasIncorrectas.setText("Respuestas incorrectas: " + partidaModoLibre.getContadorRespuestasIncorrectas());
            ConsultasPartida.insertarPregunta(partida.getId(), idPregunta, acertada);
        }
    }
    private void responderCuestionario(ActionEvent evt){
        //nos aseguramos de que la pregunta no ha sido respondida ya
        if(bandera){
            JButton button = (JButton) evt.getSource();
            boolean acertada = partidaCuestionario.responder(button);
            //se marca que la pregunta ya ha sido respondida
            bandera = false;
            //se actualizan los contadores de respuestas correctas e incorrectas
            labelRespuestasCorrectas.setText("Respuestas correctas: " + partidaCuestionario.getContadorPreguntasCorrectas());
            labelRespuestasIncorrectas.setText("Respuestas incorrectas: " + partidaCuestionario.getContadorRespuestasIncorrectas());
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpcion1;
    private javax.swing.JButton btnOpcion2;
    private javax.swing.JButton btnOpcion3;
    private javax.swing.JButton btnOpcion4;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnFinalizar;

    private javax.swing.JLabel labelPregunta;
    private javax.swing.JLabel labelRespuestasCorrectas;
    private javax.swing.JLabel labelRespuestasIncorrectas;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelControles;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelPregunta;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}
