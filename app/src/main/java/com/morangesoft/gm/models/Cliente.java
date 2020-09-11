package com.morangesoft.gm.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
    private String _id;
    private String nombre;
    private String apellidos;
    private  long fechanac;
    private Boolean casado = false;
    private Float sueldo;
    private String usuario;
    private String pass;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
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

    public long getFechanac() {
        return fechanac;
    }

    public void setFechanac(long fechanac) {
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

    public String fechanacStr(){
        Date d = new Date(this.getFechanac());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        return sdf.format(d);
    }
}
