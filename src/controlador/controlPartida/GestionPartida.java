package controlador.controlPartida;

import modelo.Partida;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Esta clase contiene los metodos necesarios para llevar a cabo una partida
 * @author Fernando
 */
public abstract class GestionPartida {
    Partida partida;


    public GestionPartida(Partida partida) {
        this.partida = partida;
    }

    /**
     * Este metodo nos permite generar un id para la partida
     * @return un id valido, -1 si ocurre algun error
     * @author Fernando
     */

    public static int obtenerId(){
        int numero = 0;
        ArrayList<Integer> ids = ConsultasPartida.obtenerId();
        if(ids == null){
            return -1;
        }
        while (ids.contains(numero)){
            numero++;
        }
        return numero;
    }
    public abstract boolean fin();
    public abstract void responder(JButton boton);
}
