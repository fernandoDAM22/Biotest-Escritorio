package test;

import com.kitfox.svg.A;
import controller.administrador.GestionCuestionarios;
import controller.administrador.GestionPreguntas;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class GestionCuestionariosTest {
    @Test
    public void existeCuestionario(){
        String[] cuestionarios = {"Examen Mamiferos","prueba","adasdad"};
        boolean[] esperado = {true,true,false};
        boolean[] resultado = new boolean[esperado.length];
        for (int i = 0; i < cuestionarios.length; i++) {
            resultado[i] = GestionCuestionarios.existeCuestionario(cuestionarios[i]);
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void obtenerCuestionarios(){
        ArrayList<String> esperado = new ArrayList<>();
        esperado.add("Examen Mamiferos");
        esperado.add("Prueba");
        ArrayList<String> resultado = GestionCuestionarios.obtenerCuestionarios("Mamiferos");
        assertArrayEquals(esperado.toArray(),resultado.toArray());
    }
    @Test
    public void obtenerId(){
        String[] cuestionarios = {"Examen Mamiferos","prueba","adasdad"};
        int[] esperado = {1,16,-1};
        int[] resultado = new int[esperado.length];
        for (int i = 0; i < cuestionarios.length; i++) {
            resultado[i] = GestionCuestionarios.obtenerId(cuestionarios[i]);
        }
        assertArrayEquals(resultado,esperado);
    }
    @Test
    public void insertarPregunta(){
        int[] preguntas = {620,621,622,623,624,1,623};
        boolean[] esperado = {true,true,true,true,true,false,false};
        boolean[] resultado = new boolean[esperado.length];
        for (int i = 0; i < preguntas.length; i++) {
            resultado[i] = GestionCuestionarios.insertarPregunta(16,preguntas[i]);
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void borrarPregunta(){
        int[] preguntas = {620,621,622,623,624,1,623};
        boolean[] esperado = {true,true,true,true,true,false,false};
        boolean[] resultado = new boolean[esperado.length];
        for (int i = 0; i < preguntas.length; i++) {
            resultado[i] = GestionCuestionarios.borrarPregunta(16,preguntas[i]);
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void obtenerDescripcion(){
        String[] cuestionarios = {"Examen Mamiferos","prueba","adasdad"};
        String[] esperado = {"Examen de los mamiferos para tercero de la eso","Cuestionario de prueba",null};
        String[] resultado = new String[esperado.length];
        for (int i = 0; i < cuestionarios.length; i++) {
            resultado[i] = GestionCuestionarios.obtenerDescripcion(cuestionarios[i]);
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void obtenerCuestionariosCompletos(){
        ArrayList<String> esperado = new ArrayList<>();
        esperado.add("Examen Mamiferos");
        ArrayList<String> resultado = GestionCuestionarios.obtenerCuestionariosCompletos();
        assertArrayEquals(esperado.toArray(),resultado.toArray());
    }
    @Test
    public void obtenerIdPreguntas(){
        ArrayList<Integer> esperado = new ArrayList<>();
        esperado.add(613);
        esperado.add(614);
        esperado.add(617);
        esperado.add(623);
        esperado.add(630);
        esperado.add(634);
        esperado.add(638);
        esperado.add(642);
        esperado.add(644);
        esperado.add(658);
        esperado.add(659);
        ArrayList<Integer> resultado = GestionCuestionarios.obtenerIdPreguntas("Examen Mamiferos");
        assertArrayEquals(esperado.toArray(),resultado.toArray());

    }
}
