import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import view.acceso.VentanaLogin;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            FlatLaf.setup(new FlatDarkLaf());
            UIManager.put("Frame.icon", new ImageIcon(Main.class.getResource("/images/IconoVentana.ico")));
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        VentanaLogin frame = new VentanaLogin();
        frame.setVisible(true);
    }
}