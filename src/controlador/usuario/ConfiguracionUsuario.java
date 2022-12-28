package controlador.usuario;

import javax.swing.*;

/**
 * Esta clase guarda algunos datos que nos seran necesarios para
 * permitir el acceso al usuario a determinadas acciones
 *
 * @author fernando
 */
public class ConfiguracionUsuario {
    /**
     * Indica si el usuario es admin o no
     */
    private static String tipoUsuario;
    private static String nombreUsuario;

    public static void desactivarMenu(JMenu menu) {
        if (tipoUsuario.equals(Codigos.USUARIO_NORMAL)) {
            menu.setEnabled(false);
        }

    }

    public static String getTipoUsuario() {
        return tipoUsuario;
    }

    public static void setTipoUsuario(String tipoUsuario) {
        ConfiguracionUsuario.tipoUsuario = tipoUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        ConfiguracionUsuario.nombreUsuario = nombreUsuario;
    }
    public static String getNombreUsuario(){
        return nombreUsuario;
    }
}
