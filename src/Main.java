import com.formdev.flatlaf.FlatDarkLaf;
import controlador.herramientas.ComprobarDatos;
import vista.acceso.VentanaLogin;
import vista.juego.VentanaSeleccionarModoJuego;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
       try {
            UIManager.setLookAndFeel( new FlatDarkLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        VentanaLogin frame = new VentanaLogin();
        frame.setVisible(true);
    }
}