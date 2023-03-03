/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.juego;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import controller.baseDeDatos.CopiaDeSeguridad;
import controller.tools.Colores;
import controller.tools.Mensajes;
import controller.tools.TipoPartida;
import controller.usuario.Codigos;
import controller.usuario.ConfiguracionUsuario;
import view.administrador.VentanaAdministrarUsuarios;
import view.juego.dialogos.DialogoElegirCuestionario;
import view.acceso.VentanaLogin;
import view.administrador.VentanaAdministrarCategorias;
import view.administrador.VentanaAdministrarCuestionarios;
import view.administrador.VentanaAdministrarPreguntas;
import view.usuario.VentanaAjustesUsuario;

import javax.swing.*;

/**
 * Esta clase permite al usuario seleccionar un modo de juego
 * y pasar a la ventana jugar para jugar una partida
 * @author fernando
 */
public class VentanaSeleccionarModoJuego extends javax.swing.JFrame {
    boolean puedeContinuar = true;

    /**
     * Creates new form VentanaSeleccionarModoJuego
     */
    public VentanaSeleccionarModoJuego() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        panelCentro = new javax.swing.JPanel();
        panelBotonesModoJuego = new javax.swing.JPanel();
        btnModoLibre = new javax.swing.JToggleButton();
        btnModoSinFallos = new javax.swing.JToggleButton();
        btnModoClasico = new javax.swing.JToggleButton();
        btnModoCuestionarios = new javax.swing.JToggleButton();
        panelControles = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        panelDescripcion = new javax.swing.JPanel();
        labelDescripcion = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        opcionCerrarSesion = new javax.swing.JMenuItem();
        opcionModoJuego = new javax.swing.JMenuItem();
        opcionAjustesUsuario = new javax.swing.JMenuItem();
        menuAdministrador = new javax.swing.JMenu();
        opcionPreguntas = new javax.swing.JMenuItem();
        opcionCuestionarios = new javax.swing.JMenuItem();
        opcionCategorias = new javax.swing.JMenuItem();
        opcionCopiasDeSeguridad = new javax.swing.JMenu();
        opcionUsuarios = new javax.swing.JMenuItem();
        opcionImportar = new javax.swing.JMenuItem();
        opcionUsuarios = new javax.swing.JMenuItem();
        opcionExportar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccionar modo de juego");
        jLabel1.setPreferredSize(new java.awt.Dimension(38, 50));
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        panelCentro.setLayout(new java.awt.GridLayout(3, 1));

        panelBotonesModoJuego.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 100));
        btnModoLibre.setBackground(Colores.COLOR_AZUL_BOTONES);
        grupoBotones.add(btnModoLibre);
        btnModoLibre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModoLibre.setForeground(new Color(0, 0, 0));
        btnModoLibre.setText("Modo Libre");
        btnModoLibre.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnModoLibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                colocarDescripcion(evt);
            }
        });
        btnModoLibre.setPreferredSize(new java.awt.Dimension(150, 50));
        panelBotonesModoJuego.add(btnModoLibre);

        btnModoSinFallos.setBackground(Colores.COLOR_AZUL_BOTONES);
        grupoBotones.add(btnModoSinFallos);
        btnModoSinFallos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModoSinFallos.setForeground(new Color(0, 0, 0));
        btnModoSinFallos.setText("Modo sin fallos");
        btnModoSinFallos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnModoSinFallos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                colocarDescripcion(evt);
            }
        });
        btnModoSinFallos.setPreferredSize(new java.awt.Dimension(150, 50));
        panelBotonesModoJuego.add(btnModoSinFallos);

        btnModoClasico.setBackground(Colores.COLOR_AZUL_BOTONES);
        grupoBotones.add(btnModoClasico);
        btnModoClasico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModoClasico.setForeground(new Color(0, 0, 0));
        btnModoClasico.setText("Modo Clasico");
        btnModoSinFallos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnModoClasico.setPreferredSize(new java.awt.Dimension(150, 50));
        btnModoClasico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                colocarDescripcion(evt);
            }
        });
        panelBotonesModoJuego.add(btnModoClasico);

        btnModoCuestionarios.setBackground(Colores.COLOR_AZUL_BOTONES);
        grupoBotones.add(btnModoCuestionarios);
        btnModoCuestionarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModoCuestionarios.setForeground(new Color(0, 0, 0));
        btnModoCuestionarios.setText("Cuestionarios");
        btnModoCuestionarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnModoCuestionarios.setPreferredSize(new java.awt.Dimension(150, 50));
        btnModoCuestionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                colocarDescripcion(evt);
            }
        });
        panelBotonesModoJuego.add(btnModoCuestionarios);

        panelCentro.add(panelBotonesModoJuego);

        panelControles.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 50));

        btnCancelar.setBackground(Colores.COLOR_BOTON_CANCELAR);
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new Color(0, 0, 0));
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnCancelarActionListener(evt);
            }
        });
        btnCancelar.setPreferredSize(new java.awt.Dimension(150, 50));
        panelControles.add(btnCancelar);

        btnJugar.setBackground(Colores.COLOR_BOTON_ACEPTAR);
        btnJugar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnJugar.setForeground(new Color(0, 0, 0));
        btnJugar.setText("Jugar");
        btnJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnJugar.setPreferredSize(new java.awt.Dimension(150, 50));
        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnJugarActionListener(evt);
            }
        });
        panelControles.add(btnJugar);

        panelCentro.add(panelControles);

        panelDescripcion.setLayout(new java.awt.GridLayout(1, 0));

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelDescripcion.add(labelDescripcion);

        panelCentro.add(panelDescripcion);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        menuUsuario.setText("Usuario");


        opcionModoJuego.setText("Seleccionar Modo de juego");
        opcionModoJuego.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));

        opcionModoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionModoJuego6ActionPerformed(evt);
            }
        });

        menuUsuario.add(opcionModoJuego);
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
        opcionCerrarSesion.setText("Cerrar sesion");
        opcionCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        opcionCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                opcionCerrarSesionActionListener(evt);
            }
        });
        menuUsuario.add(opcionCerrarSesion);

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
                opcionExportarActionPeformed(evt);;
            }
        });
        opcionCopiasDeSeguridad.add(opcionImportar);
        opcionCopiasDeSeguridad.add(opcionExportar);
        menuAdministrador.add(opcionCopiasDeSeguridad);
        opcionUsuarios.setText("Usuarios");
        opcionUsuarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.ALT_MASK));
        opcionUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                opcionUsuariosActionPerformed(evt);
            }
        });
        menuAdministrador.add(opcionUsuarios);


        barraMenu.add(menuAdministrador);

        setJMenuBar(barraMenu);
        ConfiguracionUsuario.desactivarMenu(barraMenu, menuAdministrador);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionUsuariosActionPerformed(ActionEvent evt) {
        VentanaAdministrarUsuarios frame = new VentanaAdministrarUsuarios();
        frame.setVisible(true);
        dispose();
    }

    private void opcionExportarActionPeformed(ActionEvent evt) {
        if(JOptionPane.showConfirmDialog(null, Mensajes.CONFIRMACION_BACKUP, Mensajes.TITULO_CONFIRMACION   , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) != 0){
            return;
        }
        if(CopiaDeSeguridad.crearCopia()){
            JOptionPane.showMessageDialog(this,Mensajes.BACKUP_CORRECTO,Mensajes.CORRECTO,JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,Mensajes.ERROR_BACKUP,Mensajes.ERROR,JOptionPane.ERROR_MESSAGE);
        }
    }

    private void opcionImportarActionPerformed(ActionEvent evt) {
        int estado = CopiaDeSeguridad.restaurarCopia();
        if(estado == Codigos.CORRECTO){
            JOptionPane.showMessageDialog(this,Mensajes.IMPORTACION_CORRECTA,Mensajes.CORRECTO,JOptionPane.INFORMATION_MESSAGE);
        }else if(estado == Codigos.ERROR){
            JOptionPane.showMessageDialog(this,Mensajes.ERROR_IMPORTACION,Mensajes.ERROR,JOptionPane.ERROR_MESSAGE);
        }

    }

    private void opcionAjustesUsuarioActionPerformed(ActionEvent evt) {
        VentanaAjustesUsuario frame = new VentanaAjustesUsuario();
        frame.setVisible(true);
        dispose();
    }

    private void btnCancelarActionListener(ActionEvent evt) {
        grupoBotones.clearSelection();
        labelDescripcion.setText("");
    }

    /**
     * Este metodo coloca la descripcion del modo de juego en funcion
     * de la opcion que se seleccione
     *
     * @param evt es el boton que se ha pulsado
     * @author Fernando
     */
    private void colocarDescripcion(ActionEvent evt) {
        JToggleButton button = (JToggleButton) evt.getSource();
        if (btnModoLibre.equals(button)) {
            labelDescripcion.setText(Mensajes.DESCRIPCION_MODO_LIBRE);
        } else if (btnModoSinFallos.equals(button)) {
            labelDescripcion.setText(Mensajes.DESCRIPCION_MODO_SIN_FALLOS);
        } else if (btnModoClasico.equals(button)) {
            labelDescripcion.setText(Mensajes.DESCRIPCION_MODO_CLASICO);
        } else {
            labelDescripcion.setText(Mensajes.DESCRIPCION_CUESTIONARIOS);
        }

    }

    /**
     * Este metodo nos permite seleccionar una partida
     *
     * @return el tipo de partida seleccionada, null si ocurre algun error
     * @author Fernando
     */
    private String seleccionarPartida() {
        ButtonModel modeloBoton = grupoBotones.getSelection();
        // Iterar a través de todos los botones del grupo
        for (Enumeration<AbstractButton> botones = grupoBotones.getElements(); botones.hasMoreElements();) {
            JToggleButton boton = (JToggleButton) botones.nextElement();
            if (boton.getModel() == modeloBoton) {
                // Este es el botón seleccionado
                return boton.getText();
            }
        }
        return null;
    }

    private void btnJugarActionListener(ActionEvent evt) {
        //obtenemos el tipo de partida
        String mensaje = seleccionarPartida();
        TipoPartida tipoPartida = null;
        //comprobamos que no ocurra algun error
        if (mensaje == null) {
            JOptionPane.showMessageDialog(null, Mensajes.SELECCIONE_MODO_JUEGO, Mensajes.ERROR, JOptionPane.ERROR_MESSAGE);
        } else {
            //se establece el tipo de partida en funcion boton seleccionado
            switch (mensaje) { // se establece el tipo de partida elegido
                case "Modo Libre" -> tipoPartida = TipoPartida.MODO_LIBRE;
                case "Modo sin fallos" -> tipoPartida = TipoPartida.MODO_SIN_FALLOS;
                case "Modo Clasico" -> tipoPartida = TipoPartida.MODO_CLASICO;
                case "Cuestionarios" -> {
                    /*
                     * En caso del modo cuestionarios debemos obtener primero el cuestionario
                     * que se va a jugar
                     */
                    DialogoElegirCuestionario.mostrarDialogo();
                    boolean elegido = DialogoElegirCuestionario.obtenerEstado();
                    if (!elegido) {
                        return;
                    }
                    tipoPartida = TipoPartida.CUESTIONARIOS;
                }
            }
        }
        VentanaJugar frame = new VentanaJugar(tipoPartida);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        dispose();

    }

    private void opcionCerrarSesionActionListener(ActionEvent evt) {
        VentanaLogin frame = new VentanaLogin();
        frame.setVisible(true);
        dispose();
    }

    private void opcionModoJuego6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionModoJuego6ActionPerformed
        VentanaSeleccionarModoJuego ventana = new VentanaSeleccionarModoJuego();
        ventana.setVisible(true);
        dispose();
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
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnJugar;
    private javax.swing.JToggleButton btnModoClasico;
    private javax.swing.JToggleButton btnModoCuestionarios;
    private javax.swing.JToggleButton btnModoLibre;
    private javax.swing.JToggleButton btnModoSinFallos;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem opcionCategorias;
    private javax.swing.JMenuItem opcionCuestionarios;
    private javax.swing.JMenuItem opcionModoJuego;
    private javax.swing.JMenuItem opcionAjustesUsuario;
    private javax.swing.JMenuItem opcionCerrarSesion;
    private javax.swing.JMenuItem opcionPreguntas;
    private javax.swing.JMenu opcionCopiasDeSeguridad;
    private javax.swing.JMenuItem opcionUsuarios;
    private javax.swing.JMenuItem opcionExportar;
    private javax.swing.JMenuItem opcionImportar;
    private javax.swing.JPanel panelBotonesModoJuego;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelControles;
    private javax.swing.JPanel panelDescripcion;
    // End of variables declaration//GEN-END:variables
}
