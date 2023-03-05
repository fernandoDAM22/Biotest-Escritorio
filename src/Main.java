import com.formdev.flatlaf.FlatDarkLaf;
import view.acceso.VentanaInicio;
import view.acceso.VentanaLogin;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            ImageIcon icon = new ImageIcon(Main.class.getResource("./view/acceso/images/IconoVentana.ico"));
            UIManager.put("Frame.icon", icon);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        VentanaInicio frame = new VentanaInicio();
        frame.setVisible(true);
    }
}