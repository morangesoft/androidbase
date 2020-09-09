package com.morangesoft.gm.models;

public class Cliente {
    private int _id;
    private String nombre;
    private String apellidos;
    private  int fechanac;
    private Boolean casado;
    private Float sueldo;
    private String usuario;
    private String pass;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getFechanac() {
        return fechanac;
    }

    public void setFechanac(int fechanac) {
        this.fechanac = fechanac;
    }

    public Boolean getCasado() {
        return casado;
    }

    public void setCasado(Boolean casado) {
        this.casado = casado;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Cliente(){

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechanac=" + fechanac +
                ", casado=" + casado +
                ", sueldo=" + sueldo +
                ", usuario='" + usuario + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
