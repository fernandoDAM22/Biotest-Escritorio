/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.acceso;

import controller.tools.Colores;
import controller.tools.EventoFoco;
import controller.tools.Mensajes;
import controller.usuario.Codigos;
import controller.usuario.Registro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author fernando
 */
public class VentanaRegistro extends javax.swing.JFrame implements Codigos {



    /**
     * Creates new form VentanaRegistro
     */
    public VentanaRegistro() {
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
        panelTitulo = new javax.swing.JPanel();
        labelRegistrarse = new javax.swing.JLabel();
        labelCerrarError = new javax.swing.JLabel();
        labelError = new javax.swing.JLabel();
        panelFila1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        panelFila2 = new javax.swing.JPanel();
        labelEmail = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        panelFila3 = new javax.swing.JPanel();
        labelPassword = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        panelFila4 = new javax.swing.JPanel();
        labelPassword2 = new javax.swing.JLabel();
        inputPassword2 = new javax.swing.JPasswordField();
        panelFila5 = new javax.swing.JPanel();
        labelTelefono = new javax.swing.JLabel();
        inputTelefono = new javax.swing.JTextField();
        panelFila6 = new javax.swing.JPanel();
        panelErrores = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setLayout(new java.awt.GridLayout(8, 1));

        panelTitulo.setBackground(Colores.COLOR_FONDO_VERDE);

        labelRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelRegistrarse.setForeground(new java.awt.Color(0, 0, 0));
        labelRegistrarse.setText("REGISTRARSE");
        panelTitulo.add(labelRegistrarse);

        panelPrincipal.add(panelTitulo);

        panelFila1.setBackground(Colores.COLOR_FONDO_VERDE);

        labelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(0, 0, 0));
        labelNombre.setText("Nombre");
        labelNombre.setFocusable(false);
        labelNombre.setMaximumSize(new java.awt.Dimension(50, 16));
        labelNombre.setPreferredSize(new java.awt.Dimension(100, 16));
        panelFila1.add(labelNombre);

        inputNombre.setColumns(20);
        inputNombre.setBorder(null);
        inputNombre.setPreferredSize(new java.awt.Dimension(200, 30));
        inputNombre.setToolTipText("El nombre solo puede tener letras y espacios");
        inputNombre.addFocusListener(new EventoFoco());
        panelFila1.add(inputNombre);

        panelPrincipal.add(panelFila1);

        panelFila2.setBackground(Colores.COLOR_FONDO_VERDE);

        labelEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(0, 0, 0));
        labelEmail.setText("Email");
        labelEmail.setPreferredSize(new java.awt.Dimension(100, 16));
        panelFila2.add(labelEmail);

        inputEmail.setColumns(20);
        inputEmail.setBorder(null);
        inputEmail.setPreferredSize(new java.awt.Dimension(200, 30));
        inputEmail.setToolTipText("El email debe ser un email valido");
        inputEmail.addFocusListener(new EventoFoco());
        panelFila2.add(inputEmail);

        panelPrincipal.add(panelFila2);

        panelFila3.setBackground(Colores.COLOR_FONDO_VERDE);

        labelPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPassword.setForeground(new java.awt.Color(0, 0, 0));
        labelPassword.setText("Contreseña");
        labelPassword.setPreferredSize(new java.awt.Dimension(100, 16));
        panelFila3.add(labelPassword);

        inputPassword.setColumns(20);
        inputPassword.setBorder(null);
        inputPassword.setPreferredSize(new java.awt.Dimension(200, 30));
        inputPassword.setToolTipText("8 caracteres de los cuales uno debe ser un numero");
        inputPassword.addFocusListener(new EventoFoco());
        panelFila3.add(inputPassword);

        panelPrincipal.add(panelFila3);

        panelFila4.setBackground(Colores.COLOR_FONDO_VERDE);

        labelPassword2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPassword2.setForeground(new java.awt.Color(0, 0, 0));
        labelPassword2.setText("Contraseña 2");
        labelPassword2.setPreferredSize(new java.awt.Dimension(100, 16));
        inputPassword2.setToolTipText("8 caracteres de los cuales uno debe ser un numero");
        inputPassword2.addFocusListener(new EventoFoco());
        panelFila4.add(labelPassword2);

        inputPassword2.setColumns(20);
        inputPassword2.setBorder(null);
        inputPassword2.setPreferredSize(new java.awt.Dimension(200, 30));
        panelFila4.add(inputPassword2);

        panelPrincipal.add(panelFila4);

        panelFila5.setBackground(Colores.COLOR_FONDO_VERDE);

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTelefono.setForeground(new java.awt.Color(0, 0, 0));
        labelTelefono.setText("Telefono");
        labelTelefono.setPreferredSize(new java.awt.Dimension(100, 16));
        panelFila5.add(labelTelefono);

        inputTelefono.setColumns(20);
        inputTelefono.setBorder(null);
        inputTelefono.setPreferredSize(new java.awt.Dimension(200, 30));
        inputTelefono.setToolTipText("9 numeros");
        inputTelefono.addFocusListener(new EventoFoco());
        panelFila5.add(inputTelefono);

        panelPrincipal.add(panelFila5);

        panelFila6.setBackground(Colores.COLOR_FONDO_VERDE);

        btnCancelar.setBackground(Colores.COLOR_BOTON_CANCELAR);
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Volver");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.setToolTipText("Volver a la ventana de login");
        panelFila6.add(btnCancelar);



        btnRegistrarse.setBackground(Colores.COLOR_AZUL_BOTONES);
        btnRegistrarse.setBackground(Colores.COLOR_AZUL_BOTONES);
        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarse.setPreferredSize(new java.awt.Dimension(120, 40));
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        panelFila6.add(btnRegistrarse);

        panelPrincipal.add(panelFila6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        labelError.setPreferredSize(new Dimension(250,20));
        labelError.setText("");
        labelError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelError.setForeground(Color.RED);
        labelCerrarError.setForeground(Color.black);
        labelCerrarError.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelCerrarError.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                labelCerrarErrorMouseClicked(evt);
            }
        });
        labelCerrarError.setText("X");
        panelErrores.setBackground(Colores.COLOR_FONDO_VERDE);

        panelErrores.add(labelError);
        panelErrores.add(labelCerrarError);
        labelCerrarError.setVisible(false);
        panelPrincipal.add(panelErrores);



        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void labelCerrarErrorMouseClicked(MouseEvent evt) {
        labelCerrarError.setVisible(false);
        labelError.setText("");
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        VentanaLogin frame = new VentanaLogin();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        //registramos el usuario pasando los datos de los inputs
       int codigo = Registro.comprobarRegistro(inputNombre.getText(),inputEmail.getText(),inputPassword.getText(),inputPassword2.getText(), inputTelefono.getText());
       String mensaje = "";
       switch (codigo){
           //en funcion del codigo devuelto mostratemos un mensaje u otro
           case ERROR_CAMPOS_VACIOS:
               mensaje = "error " + Mensajes.RELLENE_TODOS_LOS_CAMPOS;
               break;
           case ERROR_NOMBRE:
               mensaje = Mensajes.ERROR_USERNAME;
               break;
           case ERROR_EMAIL:
               mensaje = Mensajes.ERROR_EMAIL;
                break;
           case ERROR_FORMATO_PASSWORD:
               mensaje = Mensajes.ERROR_FORMATO_PASSWORD;
               break;
           case ERROR_PASSWORDS:
               mensaje = Mensajes.ERROR_PASSWORDS;
               break;
           case ERROR_TELEFONO:
               mensaje = Mensajes.ERROR_TELEFONO;
               break;
           case ERROR_EXISTE_USUARIO:
               mensaje = Mensajes.ERROR_EXISTE_USUARIO;
               break;
           case CANCELADO:
               mensaje = Mensajes.OPERACION_CANCELADA;
               break;
           case CORRECTO:
               mensaje = Mensajes.USUARIO_REGISTRADO;
               break;
       }
       //mostramos el mensaje correspondiente
       if(codigo < 0){ //si el codigo es negativo es un error
            labelError.setText(mensaje);
            labelCerrarError.setVisible(true);
       }else{// si no es un mensaje informativo
           JOptionPane.showMessageDialog(null,mensaje,Mensajes.CORRECTO,JOptionPane.INFORMATION_MESSAGE);
           VentanaLogin frame = new VentanaLogin();
           frame.setVisible(true);
           dispose();
       }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JPasswordField inputPassword2;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPassword2;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelRegistrarse;
    private javax.swing.JLabel labelCerrarError;
    private javax.swing.JLabel labelError;
    private javax.swing.JPanel panelFila1;
    private javax.swing.JPanel panelFila2;
    private javax.swing.JPanel panelFila3;
    private javax.swing.JPanel panelFila4;
    private javax.swing.JPanel panelFila5;
    private javax.swing.JPanel panelFila6;
    private javax.swing.JPanel panelErrores;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
