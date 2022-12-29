package controlador.controlPartida;

import controlador.administrador.GestionPreguntas;
import controlador.herramientas.Colores;
import controlador.herramientas.PilaSinRepetidos;
import modelo.Partida;
import modelo.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Esta clase contiene los metodos necesarios para jugar una partida en modo libre
 *
 * @author Fernando
 */
public class PartidaModoLibre extends GestionPartida {
    /**
     * Contienen los ids de todas las preguntas de la base de datos
     */
    private ArrayList<Integer> idPreguntas;
    /**
     * Es la estructura de datos que usaremos para seleccionar las preguntas
     */
    PilaSinRepetidos pila;
    /**
     * Es el objeto de la clase pregunta
     */
    Pregunta pregunta;
    /**
     * Es el contador de las preguntas correctas en la partida
     */
    private int contadorPreguntasCorrectas = 0;
    /**
     * Es el contador de las preguntas incorrectas en la partida
     */
    private int contadorRespuestasIncorrectas = 0;
    int numeroPreguntas = 0;

    public PartidaModoLibre(Partida partida, JButton btnOpcion1, JButton btnOpcion2, JButton btnOpcion3, JButton btnOpcion4, JLabel enunciado) {
        super(partida, btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4, enunciado);
        idPreguntas = GestionPreguntas.obtenerIds();
        pila = new PilaSinRepetidos();
        ConsultasPartida.insertarPartida(partida);
    }

    /**
     * Este metodo permite seleccionar una pregunta
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
     * Este metodo permite colocar el enunciado de una pregunta en la pantalla
     * @param etiqueta es la etiqueta donde se coloca el enunciado
     * @param texto es el enunciado que se coloca
     * @author Fernando
     */
    private void colocarEnunciado(JLabel etiqueta, String texto) {
        etiqueta.setText(texto);
    }

    /**
     * Este metodo permite colocar una respuesta en un boton
     * @param boton es el boton donde se coloca la respuesta
     * @param texto es la respuesta donde se coloca
     * @author Fernando
     */
    private void colocarRespuestas(JButton boton, String texto) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setText(texto);
    }

    /**
     * Este metodo permite responder una pregunta
     * @param boton es el boton que se pulsa
     * @return true si se acierta la pregunta, false si no
     */
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
     * Este metodo restablece los colores de los botones a su color inicial
     * @author Fernando
     */
    public void restablecerColores() {
        btnOpcion1.setBackground(Colores.colorInicial());
        btnOpcion2.setBackground(Colores.colorInicial());
        btnOpcion3.setBackground(Colores.colorInicial());
        btnOpcion4.setBackground(Colores.colorInicial());
    }

    /**
     * Este metodo permite identificar cuando se termina una partida
     * @return false si se han respondido menos de 100 preguntas, cuando se llega a las 100 retorna true
     * @author Fernando
     */
    @Override
    public boolean fin() {
       if(numeroPreguntas <= 100){
           return false;
       }else {
           return true;
       }
    }

    public int getContadorPreguntasCorrectas() {
        return contadorPreguntasCorrectas;
    }

    public int getContadorRespuestasIncorrectas() {
        return contadorRespuestasIncorrectas;
    }


}
