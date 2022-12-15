package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase modelo de la partida
 * @author Fernando
 */
public class Partida {
    private int id;
    private LocalDate fecha;
    private int puntuacion;
    private String tipo;
    private int idUsuario;
    private ArrayList<Pregunta> preguntas;

    /**
     * Constructor vacio
     */
    public Partida() {
    }

    /**
     * Este constructor establece por defecto la puntuacion a 0
     * y la fecha a la fecha actual del sistema
     * @param id es el id de la partida
     * @param tipo es el tipo de la partida
     * @param idUsuario es el id del usuario que juega la partida
     * @param preguntas es la lista de preguntas de la partida
     */
    public Partida(int id, String tipo, int idUsuario, ArrayList<Pregunta> preguntas) {
        this.id = id;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.preguntas = preguntas;
        this.puntuacion = 0;
        this.fecha = LocalDate.now();
    }

    /**
     * Constructor parametrizado
     * @param id es el id de la partida
     * @param fecha es la fecha en la que se jugo la partida
     * @param puntuacion es la puntuacion de la partida
     * @param tipo es el tipo de la partida
     * @param idUsuario es el id del usuario que juega la partida
     */
    public Partida(int id, LocalDate fecha, int puntuacion, String tipo, int idUsuario) {
        this.id = id;
        this.fecha = fecha;
        this.puntuacion = puntuacion;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.preguntas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", puntuacion=" + puntuacion +
                ", tipo='" + tipo + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
