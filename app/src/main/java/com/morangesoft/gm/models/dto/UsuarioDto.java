package com.morangesoft.gm.models.dto;

public class UsuarioDto {
    private int id_usu;
    private String nombres;
    private String apellidos;
    private String email;
    private boolean conalergias;
    private String qalergias;
    private boolean conseguro;
    private String qseguro;
    private String tipodoc;
    private String numerodoc;
    private Number fechanac;
    private String pin;
    private boolean clave;
    private String segpregunta;
    private String segrespuesta;

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConalergias() {
        return conalergias;
    }

    public void setConalergias(boolean conalergias) {
        this.conalergias = conalergias;
    }

    public String getQalergias() {
        return qalergias;
    }

    public void setQalergias(String qalergias) {
        this.qalergias = qalergias;
    }

    public boolean isConseguro() {
        return conseguro;
    }

    public void setConseguro(boolean conseguro) {
        this.conseguro = conseguro;
    }

    public String getQseguro() {
        return qseguro;
    }

    public void setQseguro(String qseguro) {
        this.qseguro = qseguro;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getNumerodoc() {
        return numerodoc;
    }

    public void setNumerodoc(String numerodoc) {
        this.numerodoc = numerodoc;
    }

    public Number getFechanac() {
        return fechanac;
    }

    public void setFechanac(Number fechanac) {
        this.fechanac = fechanac;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isClave() {
        return clave;
    }

    public void setClave(boolean clave) {
        this.clave = clave;
    }

    public String getSegpregunta() {
        return segpregunta;
    }

    public void setSegpregunta(String segpregunta) {
        this.segpregunta = segpregunta;
    }

    public String getSegrespuesta() {
        return segrespuesta;
    }

    public void setSegrespuesta(String segrespuesta) {
        this.segrespuesta = segrespuesta;
    }
}
