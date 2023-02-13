package test;

import controller.administrador.GestionCategorias;
import model.Categoria;
import org.junit.*;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class GestionCategoriasTest {
    @Test
    public void existeCategoria(){
        String[] categorias = {"Mamiferos","Anbifios","Animales Marinos","adadad","categoria","Reptiles"};
        boolean[] esperado = {true,true,true,false,false,true};
        boolean[] resultado = new boolean[esperado.length];
        for (int i = 0; i < categorias.length; i++) {
            resultado[i] = GestionCategorias.existeCategoria(categorias[i]);
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void insertarCategoria(){
        ArrayList<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("categoria1","descripcion"));
        categorias.add(new Categoria("categoria2","descripcion"));
        categorias.add(new Categoria("categoria3","descripcion"));
        int[] esperado = {1,1,1};
        int[] resultado = new int[esperado.length];
        for (int i = 0; i < categorias.size(); i++) {
            resultado[i] = GestionCategorias.insertarCategoria(categorias.get(i).getNombre(),categorias.get(i).getDescripcion());
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void borrarCategoria(){
        GestionCategorias.insertarCategoria("categoria","descripcion");
        boolean[] esperado = {true,false,false};
        boolean[] resultado = new boolean[esperado.length];
        resultado[0] = GestionCategorias.borrarCategoria("categoria");
        resultado[1] = GestionCategorias.borrarCategoria("aaa");
        resultado[2] = GestionCategorias.borrarCategoria("");
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void obtenerIdCategoria(){
        String[] categorias = {"Mamiferos","Anbifios","Animales Marinos","adadad","categoria","Reptiles"};
        int[] esperado = {1,3,4,-1,-1,9};
        int[] resultado = new int[esperado.length];
        for (int i = 0; i < categorias.length; i++) {
            resultado[i] = GestionCategorias.obtenerIdCategoria(categorias[i]);
        }
        assertArrayEquals(esperado,resultado);
    }
    @Test
    public void obtenerDescripcion(){
        String[] categorias = {"Mamiferos","Anbifios","Animales Marinos","adadad","categoria","Reptiles"};
        String[] esperado = {"En esta categoria encontraras preguntas sobre los diferentes animales mamiferos en el planeta",
                            "en esta categoria encontraras preguntas sobre anfibios",
                            "en esta categoria encontraras preguntas sobre animales marinos",
                            null,null,"En esta categoria encontraras preguntas sobre reptiles"
                            };
        String[] resultado = new String[esperado.length];
        for (int i = 0; i < categorias.length; i++) {
            resultado[i] = GestionCategorias.obtenerDescripcion(categorias[i]);
        }
        assertArrayEquals(resultado,esperado);
    }
    @Test
    public void obtenerCategoriaPregunta(){
        String[] preguntas = {"¿Cual es el mamifero mas grande del mundo?","Insecto sagrado en el antiguo egipto","asddada","Pez que tiene la boca en forma de ventosa"};
        String[] esperado = {"Mamiferos","Insectos y aracnidos",null,"Animales marinos"};
        String[] resultado = new String[esperado.length];
        for (int i = 0; i < preguntas.length; i++) {
            resultado[i] = GestionCategorias.obtenerCategoriaPregunta(preguntas[i]);
        }
        assertArrayEquals(resultado,esperado);
    }

}
