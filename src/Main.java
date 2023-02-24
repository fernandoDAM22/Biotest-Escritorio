import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import view.acceso.VentanaLogin;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
       try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        VentanaLogin frame = new VentanaLogin();
        frame.setVisible(true);
    }
}