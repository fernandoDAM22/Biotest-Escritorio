/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.usuario;

import controller.baseDeDatos.CopiaDeSeguridad;
import controller.tools.Colores;
import controller.usuario.Codigos;
import controller.usuario.ConfiguracionUsuario;
import controller.usuario.GestionUsuarios;
import model.Usuario;
import view.administrador.VentanaAdministrarCategorias;
import view.administrador.VentanaAdministrarCuestionarios;
import view.administrador.VentanaAdministrarPreguntas;
import view.administrador.VentanaAdministrarUsuarios;
import view.juego.VentanaSeleccionarModoJuego;
import view.usuario.paneles.PanelCambiarTelefono;
import view.usuario.paneles.PanelCambiarNombreUsuario;
import view.usuario.paneles.PanelCambiarPassword;
import view.usuario.paneles.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Esta clase permite al usuario gestionar su cuenta de usuario,
 * sus funciones son:
 * <ul>
 *     <li>Permitir al usuario cambiar su contraseña</li>
 *     <li>Permitir al usuario cambiar su email</li>
 *     <li>Permitir al usuario cambiar su numero de telefono</li>
 *     <li>Permitir al usuario cambiar su nombre de usuario</li>
 * </ul>
 * @author fernando
 */
public class VentanaAjustesUsuario extends javax.swing.JFrame {
    CardLayout cardLayout;
    PanelCambiarPassword panelCambiarPassword = null;
    PanelCambiarEmail panelCambiarEmail = null;
    PanelCambiarTelefono panelCambiarTelefono = null;
    PanelCambiarNombreUsuario panelCambiarNombreUsuario = null;

    /**
     * Creates new form VentanaAjustesUsuario
     */
    public VentanaAjustesUsuario() {
        initComponents();
        cardLayout = (CardLayout) panelCambios.getLayout();
        //panel para cambiar la contraseña
        panelCambiarPassword = new PanelCambiarPassword();
        panelCambios.add(panelCambiarPassword,"password");
        //panel para cambiar el Email
        panelCambiarEmail = new PanelCambiarEmail(txtEmail);
        panelCambios.add(panelCambiarEmail,"email");
        //panel para cambiar el telefono
        panelCambiarTelefono = new PanelCambiarTelefono(txtTelefono);
        panelCambios.add(panelCambiarTelefono,"telefono");
        //panel para cambiar el nombre de usuario
        panelCambiarNombreUsuario = new PanelCambiarNombreUsuario(txtUser);
        panelCambios.add(panelCambiarNombreUsuario,"user");

        //colocar los datos del usuario
        colocarDatos();
    }

    /**
     * Este metodo coloca los datos del usuario en los campos correspondientes
     */
    public void colocarDatos() {
        Usuario usuario = GestionUsuarios.obtenerDatosUsuario(ConfiguracionUsuario.getNombreUsuario());
        if(usuario != null) {
            txtUser.setText(usuario.getNombre());
            txtEmail.setText(usuario.getEmail());
            txtTelefono.setText(usuario.getTelefono());
            txtTipo.setText(usuario.getTipo());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        paneTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelContenedor = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        btnPassword = new javax.swing.JButton();
        btnEmail = new javax.swing.JButton();
        btnTelefono = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        panelOperaciones = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        panelCambios = new javax.swing.JPanel();
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

        opcionUsuarios = new javax.swing.JMenuItem();
        opcionExportar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Ajustes de usuario");
        paneTitulo.add(jLabel1);

        jPanel1.add(paneTitulo, java.awt.BorderLayout.PAGE_START);

        panelContenedor.setLayout(new java.awt.BorderLayout());

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 40));

        btnPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPassword.setText("Cambiar Contraseña");
        btnPassword.setBackground(Colores.COLOR_AZUL_BOTONES);
        btnPassword.setForeground(Colores.COLOR_NEGRO);
        btnPassword.setPreferredSize(new java.awt.Dimension(200, 50));
        btnPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswordActionPerformed(evt);
            }
        });
        panelBotones.add(btnPassword);

        btnEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEmail.setText("Cambiar Email");
        btnEmail.setBackground(Colores.COLOR_AZUL_BOTONES);
        btnEmail.setForeground(Colores.COLOR_NEGRO);
        btnEmail.setPreferredSize(new java.awt.Dimension(200, 50));
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });
        panelBotones.add(btnEmail);

        btnTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTelefono.setText("Cambiar telefono");
        btnTelefono.setBackground(Colores.COLOR_AZUL_BOTONES);
        btnTelefono.setForeground(Colores.COLOR_NEGRO);
        btnTelefono.setPreferredSize(new java.awt.Dimension(200, 50));
        btnTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelefonoActionPerformed(evt);
            }
        });
        panelBotones.add(btnTelefono);

        btnUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUser.setText("Cambiar nombre de usuario");
        btnUser.setBackground(Colores.COLOR_AZUL_BOTONES);
        btnUser.setForeground(Colores.COLOR_NEGRO);
        btnUser.setPreferredSize(new java.awt.Dimension(200, 50));
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        panelBotones.add(btnUser);

        panelContenedor.add(panelBotones, java.awt.BorderLayout.PAGE_START);

        panelOperaciones.setLayout(new java.awt.GridLayout(1, 2));

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre de usuario");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Correo electronico");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Telefono");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tipo de usuario");

        txtUser.setPreferredSize(new java.awt.Dimension(300, 30));

        txtEmail.setPreferredSize(new java.awt.Dimension(300, 30));

        txtTipo.setPreferredSize(new java.awt.Dimension(300, 30));

        txtTelefono.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(34, 34, 34)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        panelOperaciones.add(panelDatos);

        panelCambios.setBorder(javax.swing.BorderFactory.createTitledBorder("Operacion"));
        panelCambios.setLayout(new java.awt.CardLayout());
        panelOperaciones.add(panelCambios);

        panelContenedor.add(panelOperaciones, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelContenedor, java.awt.BorderLayout.CENTER);

        menuUsuario.setText("Usuario");

        opcionModoJuego.setText("Seleccionar Modo de juego");
        opcionModoJuego.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));opcionCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        opcionModoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionModoJuegoActionPerformed(evt);
            }
        });
        menuUsuario.add(opcionModoJuego);

        opcionCerrarSesion.setText("Cerrar Sesion");
        opcionCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        opcionCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionCerrarSesionActionPerformed(evt);
            }
        });

        opcionAjustesUsuario.setText("Ajustes de usuario");
        opcionAjustesUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));

        opcionAjustesUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                opcionAjustesUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(opcionAjustesUsuario);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );
        ConfiguracionUsuario.desactivarMenu(barraMenu,menuAdministrador);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionUsuariosActionPerformed(ActionEvent evt) {

        VentanaAdministrarUsuarios frame = new VentanaAdministrarUsuarios();
        frame.setVisible(true);
        dispose();
    }

    private void opcionAjustesUsuarioActionPerformed(ActionEvent evt) {
        VentanaAjustesUsuario frame = new VentanaAjustesUsuario();
        frame.setVisible(true);
        dispose();
    }

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cardLayout.show(panelCambios,"user");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cardLayout.show(panelCambios,"telefono");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cardLayout.show(panelCambios,"email");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cardLayout.show(panelCambios,"password");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void opcionModoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionModoJuegoActionPerformed
        VentanaSeleccionarModoJuego ventana = new VentanaSeleccionarModoJuego();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionModoJuegoActionPerformed

    private void opcionCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionCerrarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAjustesUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAjustesUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAjustesUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAjustesUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAjustesUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelCambios;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnPassword;
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnTelefono;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem opcionCategorias;
    private javax.swing.JMenuItem opcionCerrarSesion;
    private javax.swing.JMenuItem opcionCuestionarios;
    private javax.swing.JMenuItem opcionModoJuego;
    private javax.swing.JMenuItem opcionPreguntas;
    private javax.swing.JMenuItem opcionAjustesUsuario;
    private javax.swing.JMenu opcionCopiasDeSeguridad;
    private javax.swing.JMenuItem opcionExportar;
    private javax.swing.JMenuItem opcionImportar;
    private javax.swing.JMenuItem opcionUsuarios;
    private javax.swing.JPanel paneTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelOperaciones;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
