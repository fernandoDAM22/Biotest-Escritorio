package controlador.usuario;

public interface Codigos {
    int CORRECTO = 1;
    int ERROR_CAMPOS_VACIOS = -1;
    int ERROR_NOMBRE = -2;
    int ERROR_EMAIL = -3;
    int ERROR_PASSWORDS = -4;
    int ERROR_FORMATO_PASSWORD = -5;
    int ERROR_TELEFONO = -6;

    String USUARIO_NORMAL = "user";
}
