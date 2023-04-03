package controller.controlPartida;

import controller.tools.Colores;
import model.Partida;

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

    /**
     * Constructor parametrizado
     * @param partida es el objeto partida
     * @param btnOpcion1 es el boton donde se coloca la primera opcion
     * @param btnOpcion2 es el boton donde se coloca la segunda opcion
     * @param btnOpcion3 es el boton donde se coloca la tercera opcion
     * @param btnOpcion4 es el boton donde se coloca la cuarta opcion
     * @param enunciado es el boton donde se coloca el enunciado de la pregunta
     */
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
        btnOpcion1.setBackground(Colores.COLOR_AZUL_BOTONES);
        btnOpcion2.setBackground(Colores.COLOR_AZUL_BOTONES);
        btnOpcion3.setBackground(Colores.COLOR_AZUL_BOTONES);
        btnOpcion4.setBackground(Colores.COLOR_AZUL_BOTONES);
    }

    /**
     * Este metodo permite saber cuando se a terminado una partida,
     * es abstracto ya que cada partida terminara en cuando se de una situacion diferente
     *
     * @return true si se ha terminado la partida, false si no
     * @author Fernando
     */
    public abstract boolean fin();

    /**
     * Este metodo permite al usuario responder a una pregunta, es abstracto
     * ya que cada partida puede realizar una funcion a la hora de responder
     * una pregunta
     * @param boton es el boton que se pulsa
     * @return true si se acierta la pregunta, false si no
     */
    public abstract boolean responder(JButton boton);
}
