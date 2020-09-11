package com.morangesoft.gm.models.api;

import com.morangesoft.gm.models.dto.ClienteDto;

public class ClienteEditResponse {
    private int code;
    private String message;
    private ClienteDto obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ClienteDto getObj() {
        return obj;
    }

    public void setObj(ClienteDto obj) {
        this.obj = obj;
    }
}
