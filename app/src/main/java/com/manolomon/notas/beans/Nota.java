package com.manolomon.notas.beans;

import java.sql.Date;

/**
 *
 * @author Manolomon
 */
public class Nota {

    private Integer idNota;
    private Integer idUsuario;
    private String titulo;
    private String contenido;
    private Date tiempoCreacion;

    public Nota() {
    }

    public Nota(Integer idNota, Integer idUsuario, String titulo, String contenido, Date tiempoCreacion) {
        this.idNota = idNota;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.contenido = contenido;
        this.tiempoCreacion = tiempoCreacion;
    }

    /**
     * @return the idNota
     */
    public Integer getIdNota() {
        return idNota;
    }

    /**
     * @param idNota the idNota to set
     */
    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the tiempoCreacion
     */
    public Date getTiempoCreacion() {
        return tiempoCreacion;
    }

    /**
     * @param tiempoCreacion the tiempoCreacion to set
     */
    public void setTiempoCreacion(Date tiempoCreacion) {
        this.tiempoCreacion = tiempoCreacion;
    }

}