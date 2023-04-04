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
    Color COLOR_CORRECTO = new Color(32, 191, 107);
    /**
     * Esta color se le coloca al boton que contiene una respuesta incorrecta
     */
    Color COLOR_INCORRECTO = new Color(252, 92, 101);
    /**
     * Este color es al azul que se le coloca a algunos botones
     */
     Color COLOR_AZUL_BOTONES = new Color(45, 152, 218);
    /**
     * Este es el color verde que se le asigna a los botones que aceptan la ejecucion
     * de alguna accion
     */
    Color COLOR_BOTON_ACEPTAR = new Color(32, 191, 107);
    /**
     * Este color se le asigna a los botones que cancelan la ejecucion
     * de alguna operacion
     */
    Color COLOR_BOTON_CANCELAR = new Color(235, 59, 90);
    /**
     * Este color es el color negro que se le asigna a las letras de
     * los botones
     */
    Color COLOR_NEGRO = Color.black;
    /**
     * Este color es el color amarillo que se le asigna a algunos botones,
     * principalmente a los botones de las ventanas que maneja el administrador
     */
    Color COLOR_AMARILLO_BOTONES = new Color(247, 183, 49);
    /**
     * Este color se le asigna de fondo a las ventanas de login y registro
     */
     Color COLOR_FONDO_VERDE = new Color(29, 209, 161);
    /**
     * Este es el color que se le asigna a la filas pares de la tabla
     */
    Color COLOR_FILAS_TABLA = new Color(85, 239, 196);
    /**
     * Este es el color que se le asigna a las filas de tabla que contiene preguntas falladas
     * en la ventana resultado
     */
    Color COLOR_PREGUNTAS_FALLADAS = new Color(252,92,101);
    /**
     * Este es el color que se le asigna a las filas de la tabla que contienen preguntas acertadas
     * en la ventana resultado
     */
    Color COLOR_PREGUNTAS_ACERTADAS = new Color(39, 191, 107);
    /**
     * Este es el color que se les da a las listas desplegables
     */
    Color COLOR_LISTAS = Color.white;
    Color COLOR_BLANCO = new Color(187, 187, 187);
}
