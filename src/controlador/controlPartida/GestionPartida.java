package controlador.controlPartida;

import controlador.herramientas.Colores;
import modelo.Partida;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Esta clase contiene los metodos necesarios para llevar a cabo una partida
 *
 * @author Fernando
 */
public abstract class GestionPartida {
    /**
     * Objeto partida
     */
    Partida partida;
    /**
     * Boton que contiene una respuesta
     */
    JButton btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4;
    /**
     * Etiqueta que contiene el enunciado de la pregunta
     */
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
    /**
     * Este metodo permite colocar el enunciado de una pregunta en la pantalla
     * @param etiqueta es la etiqueta donde se coloca el enunciado
     * @param texto es el enunciado que se coloca
     * @author Fernando
     */
    public void colocarEnunciado(JLabel etiqueta, String texto) {
        etiqueta.setText(texto);
    }

    /**
     * Este metodo permite colocar una respuesta en un boton
     * @param boton es el boton donde se coloca la respuesta
     * @param texto es la respuesta donde se coloca
     * @author Fernando
     */
    public void colocarRespuestas(JButton boton, String texto) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setText(texto);
    }
    /**
     * Este metodo restablece los colores de los botones a su color inicial
     * @author Fernando
     */
    public void restablecerColores() {
        btnOpcion1.setBackground(Colores.colorInicial());
        btnOpcion2.setBackground(Colores.colorInicial());
        btnOpcion3.setBackground(Colores.colorInicial());
        btnOpcion4.setBackground(Colores.colorInicial());
    }

    public abstract boolean fin();

    public abstract boolean responder(JButton boton);
}
