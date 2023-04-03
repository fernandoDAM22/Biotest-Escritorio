package model;

import java.util.ArrayList;

/**
 * Clase modelo del cuestionario
 * @author Fernando
 */
public class Cuestionario {
    /**
     * Id del cuestionario
     */
    private int id;
    /**
     * Nombre del cuestionario
     */
    private String nombre;
    /**
     * Id de la categoria, esta id corresponde con el id de la categoria correspondiente
     */
    private int idCategoria;
    /**
     * Descripcion del cuestionario
     */
    private String descripcion;
    /**
     * Lista de preguntas del cuestionario
     */
    private ArrayList<Pregunta> preguntas;

    public Cuestionario(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Cuestionario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", idCategoria=" + idCategoria +
                ", preguntas=" + preguntas +
                '}';
    }
}
