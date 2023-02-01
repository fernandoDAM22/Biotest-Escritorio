package controller.controlPartida;

import controller.administrador.GestionCuestionarios;
import controller.administrador.GestionPreguntas;
import controller.tools.Colores;
import controller.tools.PilaSinRepetidos;
import model.Partida;
import model.Pregunta;
import view.juego.dialogos.DialogoElegirCuestionario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class PartidaCuestionario extends GestionPartida{
    PilaSinRepetidos pila;
    /**
     * Contienen los ids de todas las preguntas de la base de datos
     */
    private ArrayList<Integer> idPreguntas;
    /**
     * Objeto de la clase pregunta donde guardamos los datos de la pregunta
     */
    Pregunta pregunta;
    /**
     * Es el contador de las respuestas correctas de la partida
     */
    private int contadorPreguntasCorrectas;
    /**
     * Es el contador de las preguntas incorrectas en la partida
     */
    private int contadorRespuestasIncorrectas;

    public PartidaCuestionario(Partida partida, JButton btnOpcion1, JButton btnOpcion2, JButton btnOpcion3, JButton btnOpcion4, JLabel enunciado) {
        super(partida, btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4, enunciado);
        pila = new PilaSinRepetidos();
        idPreguntas = GestionCuestionarios.obtenerIdPreguntas(DialogoElegirCuestionario.obtenerCuestionarioElegido());
        contadorPreguntasCorrectas = 0;
        contadorRespuestasIncorrectas = 0;
        ConsultasPartida.insertarPartida(partida);
    }

    /**
     * Este metodo nos permite saber cuando se ha terminado una partida
     * @return true si se termina, false si no
     * @author Fernando
     */
    @Override
    public boolean fin() {
        //negamos pila.isEmpty(), si la pila esta llena retorna false, y si esta vacia retorna true
        return !pila.isEmpty();
    }

    /**
     * Este metodo nos permite responder una pregunta
     * @param boton es el boton que se pulsa
     * @return true si se acierta la pregunta, false si no
     * @author Fernando
     */
    @Override
    public boolean responder(JButton boton) {
        if (boton.getText().equals(pregunta.getRespuestaCorrecta())) {
            boton.setBackground(Colores.correcto());
            contadorPreguntasCorrectas++;
            return true;
        } else {
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
     * Este metodo permite seleccionar una pregunta
     *
     * @author Fernando
     */
    public void seleccionarPregunta() {
        while (pila.size() < 10) {
            int indice = (int) (Math.random() * idPreguntas.size());
            pila.push(idPreguntas.get(indice));
        }
    }

    /**
     * Este metodo nos permite realizar un ciclo en la partida, (seleccionar una
     * nueva pregunta y restablecer los colores de los botones
     * @return el id de la pregunta seleccionada
     */
    public int ciclo() {
        int numero = obtenerDatos();
        restablecerColores();
        return numero;
    }


    public int getContadorPreguntasCorrectas() {
        return contadorPreguntasCorrectas;
    }

    public int getContadorRespuestasIncorrectas() {
        return contadorRespuestasIncorrectas;
    }
}