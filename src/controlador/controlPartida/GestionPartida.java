package controlador.controlPartida;

import modelo.Partida;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Esta clase contiene los metodos necesarios para llevar a cabo una partida
 *
 * @author Fernando
 */
public abstract class GestionPartida {
    Partida partida;
    JButton btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4;
    JLabel enunciado;


    public GestionPartida(Partida partida, JButton btnOpcion1, JButton btnOpcion2, JButton btnOpcion3, JButton btnOpcion4, JLabel enunciado) {
        this.partida = partida;
        this.btnOpcion1 = btnOpcion1;
        this.btnOpcion2 = btnOpcion2;
        this.btnOpcion3 = btnOpcion3;
        this.btnOpcion4 = btnOpcion4;
        this.enunciado = enunciado;
    }

    /**
     * Este metodo nos permite generar un id para la partida
     *
     * @return un id valido, -1 si ocurre algun error
     * @author Fernando
     */

    public static int obtenerId() {
        int numero = 1;
        ArrayList<Integer> ids = ConsultasPartida.obtenerId();
        if (ids == null) {
            return -1;
        }
        while (ids.contains(numero)) {
            numero++;
        }
        return numero;
    }

    public abstract boolean fin();

    public abstract boolean responder(JButton boton);
}
