/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.usuario.paneles;

import controller.tools.*;
import controller.usuario.Codigos;
import controller.usuario.ConfiguracionUsuario;
import controller.usuario.GestionUsuarios;
import controller.usuario.Login;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 * Esta clase pinta el panel que permite al usuario cambiar su nombre de usuario
 * @author Fernando
 */
public class PanelCambiarNombreUsuario extends javax.swing.JPanel {
    JTextField txtNombreUsuario;
    private static final Logger logger = LoggerUtil.getLogger(PanelCambiarNombreUsuario.class);
    /**
     * Creates new form panelCambiarNombreUsuario
     */
    public PanelCambiarNombreUsuario(JTextField txtNombreUsuario) {
        initComponents();
        this.txtNombreUsuario = txtNombreUsuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Contraseña");
        jLabel1.setForeground(Colores.COLOR_BLANCO);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre de usuario");
        jLabel2.setForeground(Colores.COLOR_BLANCO);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(150, 50));
        btnCancelar.setBackground(Colores.COLOR_BOTON_CANCELAR);
        btnCancelar.setForeground(Colores.COLOR_NEGRO);

        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setPreferredSize(new java.awt.Dimension(150, 50));
        btnAceptar.setBackground(Colores.COLOR_BOTON_ACEPTAR);
        btnAceptar.setForeground(Colores.COLOR_NEGRO);

        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(txtUsername))
                    .addContainerGap(44, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(115, 115, 115)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(307, Short.MAX_VALUE)))
        );
        txtUsername.addFocusListener(new EventoFoco());
        txtPassword.addFocusListener(new EventoFoco());
        txtPassword.setForeground(Colores.COLOR_BLANCO);
        txtUsername.setForeground(Colores.COLOR_BLANCO);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void limpiarCampos() {
        txtPassword.setText("");
        txtPassword.setText("");
    }

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         /*
          antes de pasar a realizar la operacion de modificacion comprobamos que los campos no estan vacios,
          de esta forma evitamos que al usuario se le muestren mensajes de error si pulsa el boton accidentalmente
         */
        if(String.valueOf(txtPassword.getPassword()).equals("") || txtUsername.getText().equals("")){
            //simplemente, cortamos la ejecucion del metodo
            return;
        }
        //ahora pasamos a realizar todas las comprobaciones necesarias antes de modificar el nombre de usuario
        if(Login.login(ConfiguracionUsuario.getNombreUsuario(), String.valueOf(txtPassword.getPassword())) == Codigos.ERROR_PASSWORD_INCORRECTA){
            //primero se comprueba que la contraseña antigua sea correcta
            JOptionPane.showMessageDialog(this, Mensajes.PASSWORD_INCORRECTA,Mensajes.ERROR,JOptionPane.ERROR_MESSAGE);
        }else if(ComprobarDatos.existeUsuario(txtUsername.getText()) > 0){
            JOptionPane.showMessageDialog(this,Mensajes.ERROR_EXISTE_USUARIO,Mensajes.ERROR,JOptionPane.ERROR_MESSAGE);
        }else if(!ComprobarDatos.comprobarNombre(txtUsername.getText())){
            JOptionPane.showMessageDialog(this,Mensajes.ERROR_USERNAME,Mensajes.ERROR,JOptionPane.ERROR_MESSAGE);
        }else if(JOptionPane.showConfirmDialog(null, Mensajes.MENSAJE_CONFIRMACION, Mensajes.TITULO_CONFIRMACION, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
            if(GestionUsuarios.cambiarNombre(ConfiguracionUsuario.getNombreUsuario(), txtUsername.getText())){
                JOptionPane.showMessageDialog(this, Mensajes.USUARIO_CAMBIADO,Mensajes.CORRECTO, JOptionPane.INFORMATION_MESSAGE);
                registrarCambio();
                txtNombreUsuario.setText(txtUsername.getText());
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(this, Mensajes.ERROR_CAMBIAR_USERNAME,Mensajes.ERROR,JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * Este metodo permite registrar en el log que el usuario cambio su nombre de usuario
     * @author Fernando
     */
    private void registrarCambio(){
        StringBuilder cadena = new StringBuilder();
        cadena.append("El usuario ");
        cadena.append(ConfiguracionUsuario.getNombreUsuario());
        cadena.append(" cambio su nombre de usuario en la fecha: ");
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
        cadena.append(formatter.format(fecha));
        logger.info(cadena.toString());
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
