package controlador.usuario;

public interface Codigos {
    /**
     * Este codigo se manda cuando se inserta el usuario
     */
    int INSERTADO  = 1;
    /**
     * Este codigo se manda cuando algunos de los campos
     * del formulacio estan vacios
     */
    int ERROR_CAMPOS_VACIOS = -1;
    /**
     * Este codigo se manda cuando el nombre no cumple con el formato,
     * formato: (solo letras y espacios)
     */
    int ERROR_NOMBRE = -2;
    /**
     * Este codigo se manda cuando el email del usuario
     * no cumple con las caracteristicas
     */
    int ERROR_EMAIL = -3;
    /**
     * Este codigo se manda cuando las dos contraseñas no coinciden
     */
    int ERROR_PASSWORDS = -4;
    /**
     * Este codigo se manda cuando la contraseña no cumple
     * con el formato, formato: (8 caracteres de los cuales
     * uno debe ser un numero)
     */
    int ERROR_FORMATO_PASSWORD = -5;
    /**
     * Este codigo se manda cuando el telefono no cumple con el
     * formato, formato: (9 numeros)
     */
    int ERROR_TELEFONO = -6;
    /**
     * Este error se manda cuando el usuario pulsa el boton
     * de cancelar
     */
    int CANCELADO = -7;

    /**
     * Esta cadena indica que el usuario va a ser tipo user
     */
    String USUARIO_NORMAL = "user";
}
