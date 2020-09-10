package com.morangesoft.gm.models;

import java.util.Date;

public class ClienteUI extends Cliente {
    private String fechanacStr;
    private Date fechanacDT;
    private String sueldoStr;

    public String getFechanacStr() {
        return fechanacStr;
    }

    public void setFechanacStr(String fechanacStr) {
        this.fechanacStr = fechanacStr;
    }

    public Date getFechanacDT() {
        return fechanacDT;
    }

    public void setFechanacDT(Date fechanacDT) {
        this.fechanacDT = fechanacDT;
    }

    public String getSueldoStr() {
        return sueldoStr;
    }

    public void setSueldoStr(String sueldoStr) {
        this.sueldoStr = sueldoStr;
    }

    public Cliente prepare(){
        Cliente cl = new Cliente();
        cl.setNombre(getNombre());
        cl.setApellidos(getApellidos());
        cl.setFechanac(getFechanac());
        cl.setCasado(getCasado());
        cl.setSueldo(Float.parseFloat(sueldoStr));
        return cl;
    }
}
