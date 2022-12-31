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
    /**
     * Contiene el nombre del usuario logueado
     */
    private static String nombreUsuario;

    /**
     * Este metodo permite eliminar un menu de la barra de menu,
     * se usa para eliminar el menu de administrador en caso de que
     * el usuario logueado no sea administrador
     * @param barraMenu es la barra de menu
     * @param menu es el menu que queremos desactivar
     */
    public static void desactivarMenu(JMenuBar barraMenu,JMenu menu) {
        if (tipoUsuario.equals(Codigos.USUARIO_NORMAL)) {
            barraMenu.remove(menu);
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
