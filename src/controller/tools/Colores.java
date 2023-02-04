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
    private static final Color colorCorrecto = new Color(46, 204, 113);
    /**
     * Esta color se le coloca al boton que contiene una respuesta incorrecta
     */
    private static final Color colorIncorrecto = new Color(231, 76, 60);
    /**
     * Este color se coloca a los botones inicialmente
     */
    private static final Color colorInicial = new Color(72, 219, 251);
    /**
     * Este color se le asigna a los botones que no realizan ninguna
     * accion peligrosa, tales como cancelar, borrar modificar etc
     */
    private static final Color colorBotonSeguro = new Color(29, 209, 161);
    /**
     * Este color se le asigna a los botones que realizan alguna accion
     * peligrosa tal como cancelar, borrar, modificar etc
     */
    private  static final Color colorBotonPeligroso = new Color(238, 82, 83);
    /**
     * Este color se le asigna a los textos
     */
    private static  final Color colorNegro = Color.black;

    /**
     * Este metodo retorna el color que se le asigna al boton cuando se acierta una pregunta
     * @return colorCorrecto
     */
    public static Color correcto(){
        return colorCorrecto;
    }

    /**
     * Este metodo retorna el color que se le asigna al boton cuando se falla la pregunta
     * @return colorIncorrecto
     */
    public static Color incorrecto(){
        return colorIncorrecto;
    }

    /**
     * Este metodo retorna el color que se le asigna a los botones inicialmente
     * @return colorInicial
     */
    public static Color colorInicial(){
        return colorInicial;
    }

    /**
     * Este metodo retorna el color que se le asigna a los botones seguros
     * @return colorSeguro
     */
    public static Color colorBotonSeguro(){
        return colorBotonSeguro;
    }

    /**
     * Este metodo retorna el color que se le asigna a los botones peligrosos
     * @return colorPeligroso
     */
    public static Color colorBotonPeligroso(){
        return colorBotonPeligroso;
    }

    /**
     * Este metodo retorna el color negro
     * @return colorNegro
     */
    public static Color colorNegro(){
        return colorNegro;
    }
}
