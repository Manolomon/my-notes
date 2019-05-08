package com.manolomon.notas.beans;

/**
 *
 * @author Manolomon
 */
public class Usuario {
    private Integer idUsuario;
    private String nombre;
    private String telefono;
    private String tiempoRegistro;
    private String tokenAcceso;
    private Integer idEstatus;
    private String tiempoValidacion;
    private String password;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String telefono, String tiempoRegistro, String tokenAcceso, Integer idEstatus, String tiempoValidacion, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tiempoRegistro = tiempoRegistro;
        this.tokenAcceso = tokenAcceso;
        this.idEstatus = idEstatus;
        this.tiempoValidacion = tiempoValidacion;
        this.password = password;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the tiempoRegistro
     */
    public String getTiempoRegistro() {
        return tiempoRegistro;
    }

    /**
     * @param tiempoRegistro the tiempoRegistro to set
     */
    public void setTiempoRegistro(String tiempoRegistro) {
        this.tiempoRegistro = tiempoRegistro;
    }

    /**
     * @return the tokenAcceso
     */
    public String getTokenAcceso() {
        return tokenAcceso;
    }

    /**
     * @param tokenAcceso the tokenAcceso to set
     */
    public void setTokenAcceso(String tokenAcceso) {
        this.tokenAcceso = tokenAcceso;
    }

    /**
     * @return the idEstatus
     */
    public Integer getIdEstatus() {
        return idEstatus;
    }

    /**
     * @param idEstatus the idEstatus to set
     */
    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    /**
     * @return the tiempoValidacion
     */
    public String getTiempoValidacion() {
        return tiempoValidacion;
    }

    /**
     * @param tiempoValidacion the tiempoValidacion to set
     */
    public void setTiempoValidacion(String tiempoValidacion) {
        this.tiempoValidacion = tiempoValidacion;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}