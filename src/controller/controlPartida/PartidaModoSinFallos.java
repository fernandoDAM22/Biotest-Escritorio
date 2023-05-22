package controller.controlPartida;

import controller.administrador.GestionPreguntas;
import controller.tools.Colores;
import controller.tools.PilaSinRepetidos;
import model.Partida;
import model.Pregunta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Esta clase nos permite jugar una partida en modo sin fallos
 */
public class PartidaModoSinFallos extends GestionPartida {
    PilaSinRepetidos pila;
    /**
     * Contienen los ids de todas las preguntas de la base de datos
     */
    private final ArrayList<Integer> idPreguntas;

    Pregunta pregunta;
    private int contadorPreguntasCorrectas;
    /**
     * Es el contador de las preguntas incorrectas en la partida
     */
    private int contadorRespuestasIncorrectas;
    /**
     * Numero de preguntas respondidas
     */
    private int numeroPreguntas;
    /**
     * Nos indica si se acerto la pregunta o no
     */
    boolean fallo;

    public PartidaModoSinFallos(Partida partida, JButton btnOpcion1, JButton btnOpcion2, JButton btnOpcion3, JButton btnOpcion4, JLabel enunciado) {
        super(partida, btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4, enunciado);
        pila = new PilaSinRepetidos();
        idPreguntas = GestionPreguntas.obtenerIds();
        contadorPreguntasCorrectas = 0;
        contadorRespuestasIncorrectas = 0;
        numeroPreguntas = 0;
        fallo = false;
        ConsultasPartida.insertarPartida(partida);
    }

    /**
     * Este metodo permite seleccionar una pregunta
     *
     * @author Fernando
     */
    public void seleccionarPregunta() {
        int tam = pila.size();
        //repetira el bucle hasta que se encuentre un numero el cual no este ya en la pila
        while (tam == pila.size()) {
            int indice = (int) (Math.random() * idPreguntas.size());
            pila.push(idPreguntas.get(indice));
        }
    }

    /**
     * Este metodo permite obtener los datos de la pregunta seleccionada y
     * colocarlos en la pantalla
     *
     * @return el id de la pregunta seleccionada
     */
    public int obtenerDatos() {
        //sacamos un id de la lista
        int id = pila.pop();
        /*
        borramos el id de la lista de ids de todas las preguntas, para evitar
        que se responde la misma pregunta mas de una vez en la misma partida
         */
        idPreguntas.removeIf(x -> x == id);
        //obtenemos los datos de la pregunta
        pregunta = GestionPreguntas.obtenerDatos(id);
        if (pregunta != null) {
            //colocamos el enunciado de la pregunta
            enunciado.setText(pregunta.getEnunciado());
            //obtenemos las respuestas de la pregunta
            String[] respuestas = pregunta.obtenerRespuestas();
            //desordenamos las respuesta
            Collections.shuffle(Arrays.asList(respuestas));
            //las colocamos en los botones
            JButton[] botones = {btnOpcion1,btnOpcion2,btnOpcion3,btnOpcion4};
            for (int i = 0; i < botones.length; i++) {
                colocarRespuestas(botones[i],respuestas[i]);
            }
        }
        return id;

    }

    /**
     * Este metodo permite realizar un ciclo, (seleccionar una pregunta, obtener los datos y restablecer los colores)
     *
     * @return el id de la pregunta que se ha seleccionado
     * @author Fernando
     */
    public int ciclo() {
        seleccionarPregunta();
        int numero = obtenerDatos();
        restablecerColores();
        numeroPreguntas++;
        return numero;
    }

    /**
     * Este metodo nos permite saber cuando se ha terminado la partida
     * @return true si se termina la partida, false si no
     * @author Fernando
     */
    @Override
    public boolean fin() {
        //si se falla una pregunta o se responden mas de 100 se termina la partida
        return fallo || numeroPreguntas >= 100;
    }

    /**
     * Este metodo permite responder una pregunta
     *
     * @param boton es el boton que se pulsa
     * @return true si se acierta la pregunta, false si no
     */
    public boolean responder(JButton boton) {
        if (boton.getText().equals(pregunta.getRespuestaCorrecta())) {
            boton.setBackground(Colores.COLOR_CORRECTO);
            contadorPreguntasCorrectas++;
            return true;
        } else {
            fallo = true;
            contadorRespuestasIncorrectas++;
            boton.setBackground(Colores.COLOR_INCORRECTO);
            if (btnOpcion1.getText().equals(pregunta.getRespuestaCorrecta())) {
                btnOpcion1.setBackground(Colores.COLOR_CORRECTO);
            }
            if (btnOpcion2.getText().equals(pregunta.getRespuestaCorrecta())) {
                btnOpcion2.setBackground(Colores.COLOR_CORRECTO);
            }
            if (btnOpcion3.getText().equals(pregunta.getRespuestaCorrecta())) {
                btnOpcion3.setBackground(Colores.COLOR_CORRECTO);
            }
            if (btnOpcion4.getText().equals(pregunta.getRespuestaCorrecta())) {
                btnOpcion4.setBackground(Colores.COLOR_CORRECTO);
            }
            return false;
        }
    }
    public int getContadorPreguntasCorrectas() {
        return contadorPreguntasCorrectas;
    }

    public int getContadorRespuestasIncorrectas() {
        return contadorRespuestasIncorrectas;
    }
}
