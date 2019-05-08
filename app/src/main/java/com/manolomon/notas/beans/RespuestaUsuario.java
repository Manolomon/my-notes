package com.manolomon.notas.beans;

public class RespuestaUsuario {
    private Usuario usuario;
    private Respuesta respuesta;

    public RespuestaUsuario() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }
}