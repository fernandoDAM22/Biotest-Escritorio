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
public class PartidaModoLibre extends GestionPartida{
    private ArrayList<Integer> idPreguntas;
    PilaSinRepetidos pila;
    private JLabel enunciado;
    private JButton btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4;
    Pregunta pregunta;
    private int contadorPreguntasCorrectas = 0, contadorRespuestasIncorrectas = 0;

    public PartidaModoLibre(Partida partida, JLabel labelPregunta, JButton btnOpcion1, JButton btnOpcion2, JButton btnOpcion3, JButton btnOpcion4) {
        super(partida);
        enunciado = labelPregunta;
        this.btnOpcion1 = btnOpcion1;
        this.btnOpcion2 = btnOpcion2;
        this.btnOpcion3 = btnOpcion3;
        this.btnOpcion4 = btnOpcion4;
        idPreguntas = GestionPreguntas.obtenerIds();
        pila = new PilaSinRepetidos();
    }

    public void seleccionarPregunta() {
        int tam = pila.size();
        while (tam == pila.size()) {
            int indice = (int) (Math.random() * idPreguntas.size());
            pila.push(idPreguntas.get(indice));
        }
    }

    public void obtenerDatos() {
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

    }

    private void colocarEnunciado(JLabel etiqueta, String texto) {
        etiqueta.setText(texto);
    }

    private void colocarRespuestas(JButton boton, String texto) {
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setText(texto);
    }

    public void responder(JButton boton) {
        if (boton.getText().equals(pregunta.getRespuestaCorrecta())) {
            boton.setBackground(Colores.correcto());
            contadorPreguntasCorrectas++;
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
        }
    }
    public void restablecerColores() {
        btnOpcion1.setBackground(Colores.colorInicial());
        btnOpcion2.setBackground(Colores.colorInicial());
        btnOpcion3.setBackground(Colores.colorInicial());
        btnOpcion4.setBackground(Colores.colorInicial());
    }

    @Override
    public boolean fin() {
        return false;
    }

    public int getContadorPreguntasCorrectas() {
        return contadorPreguntasCorrectas;
    }

    public int getContadorRespuestasIncorrectas() {
        return contadorRespuestasIncorrectas;
    }


}
