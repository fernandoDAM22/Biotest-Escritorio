package controlador.controlPartida;

import controlador.administrador.GestionPreguntas;
import controlador.herramientas.Colores;
import controlador.herramientas.PilaSinRepetidos;
import modelo.Partida;
import modelo.Pregunta;

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
    private ArrayList<Integer> idPreguntas;

    Pregunta pregunta;
    private int contadorPreguntasCorrectas;
    /**
     * Es el contador de las preguntas incorrectas en la partida
     */
    private int contadorRespuestasIncorrectas;
    private int numeroPreguntas;
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
        int id = pila.pop();
        idPreguntas.removeIf(x -> x == id);
        pregunta = GestionPreguntas.obtenerDatos(id);
        if (pregunta != null) {
            String[] respuestas = {pregunta.getRespuestaCorrecta(), pregunta.getRespuestaIncorrecta1(),
                    pregunta.getRespuestaIncorrecta2(), pregunta.getRespuestaIncorrecta3()};
            colocarEnunciado(enunciado, pregunta.getEnunciado());
            Collections.shuffle(Arrays.asList(respuestas));
            colocarRespuestas(btnOpcion1, respuestas[0]);
            colocarRespuestas(btnOpcion2, respuestas[1]);
            colocarRespuestas(btnOpcion3, respuestas[2]);
            colocarRespuestas(btnOpcion4, respuestas[3]);
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
        if(!fallo && numeroPreguntas < 100){
            return false;
        }
        return true;
    }

    /**
     * Este metodo permite responder una pregunta
     *
     * @param boton es el boton que se pulsa
     * @return true si se acierta la pregunta, false si no
     */
    public boolean responder(JButton boton) {
        if (boton.getText().equals(pregunta.getRespuestaCorrecta())) {
            boton.setBackground(Colores.correcto());
            contadorPreguntasCorrectas++;
            return true;
        } else {
            fallo = true;
            contadorRespuestasIncorrectas++;
            boton.setBackground(Colores.Incorrecto());
            if (btnOpcion1.getText().equals(pregunta.getRespuestaCorrecta())) {
                btnOpcion1.setBackground(Colores.correcto());
            }
            if (btnOpcion2.getText().equals(pregunta.getRespuestaCorrecta())) {
                btnOpcion2.setBackground(Colores.correcto());
            }
            if (btnOpcion3.getText().equals(pregunta.getRespuestaCorrecta())) {
                btnOpcion3.setBackground(Colores.correcto());
            }
            if (btnOpcion4.getText().equals(pregunta.getRespuestaCorrecta())) {
                btnOpcion4.setBackground(Colores.correcto());
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
