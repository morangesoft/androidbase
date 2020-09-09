package com.morangesoft.gm.models.api;

import com.morangesoft.gm.models.dto.ClienteDto;

import java.util.List;

public class ClienteListResponse {
    private int code;
    private String message;
    private List<ClienteDto> obj;

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

    public List<ClienteDto> getObj() {
        return obj;
    }

    public void setObj(List<ClienteDto> obj) {
        this.obj = obj;
    }
}
