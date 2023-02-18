package test;
import com.kitfox.svg.A;
import controller.administrador.GestionCategorias;
import controller.administrador.GestionPreguntas;
import model.Categoria;
import model.Pregunta;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class GestionPreguntasTest {
    @Test
    public void obtenerRespuestas(){
        String[] preguntas = {"¿Cual es el mamifero mas grande del mundo?","asdasd"};
        ArrayList<String[]> esperado = new ArrayList<>();
        esperado.add(new String[]{"Ballena azul","Elefante","Rinoceronte","Hipopotamo"});
        esperado.add(null);
        ArrayList<String[]> resultado = new ArrayList<>();
        for(String s: preguntas){
            resultado.add(GestionPreguntas.obtenerRespuestas(s));
        }
        assertArrayEquals(esperado.toArray(), resultado.toArray());
    }
    @Test
    public void insertarPregunta(){
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("prueba1","a","a","a","a",26));
        preguntas.add(new Pregunta("prueba2","a","a","a","a",26));
        preguntas.add(new Pregunta("prueba3","a","a","a","a",26));
        preguntas.add(new Pregunta("prueba3","a","a","a","a",26));
        preguntas.add(new Pregunta("prueba4","a","a","a","a",27));
        boolean[] esperado = {true,true,true,true,false};
        boolean[] resultado = new boolean[esperado.length];
        for (int i = 0; i < preguntas.size(); i++) {
            resultado[i] = GestionPreguntas.insertarPregunta(preguntas.get(i));
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void borrarPregunta(){
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("prueba1","a","a","a","a",26));
        preguntas.add(new Pregunta("prueba2","a","a","a","a",26));
        GestionPreguntas.insertarPregunta(preguntas.get(0));
        GestionPreguntas.insertarPregunta(preguntas.get(1));
        preguntas.add(new Pregunta("","","","",""));
        boolean[] esperado = {true,true,false};
        boolean[] resultado = new boolean[esperado.length];
        for (int i = 0; i < preguntas.size(); i++) {
            resultado[i] = GestionPreguntas.borrarPregunta(preguntas.get(i).getEnunciado());
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void obtenerId(){
        String[] preguntas = {"¿Cual es el mamifero mas grande del mundo?","Primate que tiene el pelo rojizo","hola"};
        int[] esperado = {613,615,-1};
        int[] resultado = new int[esperado.length];
        for (int i = 0; i < preguntas.length; i++) {
            resultado[i] = GestionPreguntas.obtenerId(preguntas[i]);
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void existePregunta(){
        ArrayList<String> preguntas = new ArrayList<>();
        preguntas.add("¿Cual es el mamifero mas grande del mundo?");
        preguntas.add("Primate que tiene el pelo rojizo");
        preguntas.add("Animal que Hiberna");
        preguntas.add("prueba");
        preguntas.add("aaaaaaaaaa");
        boolean[] esperado = {true,true,true,false,false};
        boolean[] resultado = new boolean[esperado.length];
        for (int i = 0; i < preguntas.size(); i++) {
            resultado[i] = GestionPreguntas.existePregunta(preguntas.get(i));
        }
        assertArrayEquals(esperado,resultado);



    }


}
