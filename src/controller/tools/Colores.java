package controller.tools;

import java.awt.*;

/**
 * Esta clase contiene colores que se usan en la interfaz
 * @author Fernando
 */
public class Colores {
    /**
     * Este color se coloca al boton que contiene la respuesta correcta
     */
    static Color colorCorrecto = new Color(46, 204, 113);
    /**
     * Esta color se le coloca al boton que contiene una respuesta incorrecta
     */
    static Color colorIncorrecto = new Color(231, 76, 60);
    /**
     * Este color se coloca a los botones inicialmente
     */
    static Color colorInicial = new Color(72, 219, 251);
    /**
     * Este color se le asigna a los botones que no realizan ninguna
     * accion peligrosa, tales como cancelar, borrar modificar etc
     */
    static Color colorBotonSeguro = new Color(29, 209, 161);
    /**
     * Este color se le asigna a los botones que realizan alguna accion
     * peligrosa tal como cancelar, borrar, modificar etc
     */
    static Color colorBotonPeligroso = new Color(238, 82, 83);

    public static Color correcto(){
        return colorCorrecto;
    }
    public static Color Incorrecto(){
        return colorIncorrecto;
    }
    public static Color colorInicial(){
        return colorInicial;
    }
    public static Color colorBotonSeguro(){
        return colorBotonSeguro;
    }
    public static Color getColorBotonPeligroso(){
        return colorBotonPeligroso;
    }
}
