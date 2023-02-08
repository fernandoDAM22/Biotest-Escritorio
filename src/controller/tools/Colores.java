package controller.tools;

import java.awt.*;

/**
 * Esta clase contiene colores que se usan en la interfaz
 * @author Fernando
 */
public interface Colores {
    /**
     * Este color se coloca al boton que contiene la respuesta correcta
     */
    Color COLOR_CORRECTO = new Color(46, 204, 113);
    /**
     * Esta color se le coloca al boton que contiene una respuesta incorrecta
     */
    Color COLOR_INCORRECTO = new Color(231, 76, 60);
    /**
     * Este color es al azul que se le coloca a algunos botones
     */
     Color COLOR_AZUL_BOTONES = new Color(72, 219, 251);
    /**
     * Este es el color verde que se le asigna a los botones que aceptan la ejecucion
     * de alguna accion
     */
    Color COLOR_BOTON_ACEPTAR = new Color(29, 209, 161);
    /**
     * Este color se le asigna a los botones que cancelan la ejecucion
     * de alguna operacion
     */
    Color COLOR_BOTON_CANCELAR = new Color(238, 82, 83);
    /**
     * Este color es el color negro que se le asigna a las letras de
     * los botones
     */
    Color COLOR_NEGRO = Color.black;
    /**
     * Este color es el color amarillo que se le asigna a algunos botones,
     * principalmente a los botones de las ventanas que maneja el administrador
     */
    Color COLOR_AMARILLO_BOTONES = new Color(255, 211, 42);
    /**
     * Este color se le asigna de fondo a las ventanas de login y registro
     */
     Color COLOR_FONDO_VERDE = new Color(29, 209, 161);
}
