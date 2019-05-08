package com.manolomon.notas.beans;

/**
 *
 * @author Manolomon Codigos de error del metodo 1 - Nombre vacio 2 - Telefono
 *         vacio 3 - Telefono no son 10 digitos 4 - Contraseña vacía 5 - Fallo
 *         en envio de SMS 6 - Usuario ya registrado 7 - Token vacío 8 - Token erroneo
 *         9 - Usuario o contraseña erróneos
 *         98 - Error en la operación 99 - Exception.printStackTrace()
 */

public class Respuesta {
    private boolean error;
    private Integer errorcode;
    private String mensaje;

    public Respuesta() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}