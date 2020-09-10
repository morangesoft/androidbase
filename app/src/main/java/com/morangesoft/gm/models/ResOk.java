package com.morangesoft.gm.models;

public class ResOk {
    private boolean ok;
    private String message;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTrue(){
        this.ok = true;
    }

    public void setFalse(){
        this.ok = false;
    }
}
