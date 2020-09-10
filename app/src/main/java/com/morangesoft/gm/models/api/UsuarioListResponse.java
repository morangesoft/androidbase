package com.morangesoft.gm.models.api;

import com.morangesoft.gm.models.dto.UsuarioDto;

import java.util.List;

public class UsuarioListResponse {
    private String code;
    private String message;
    private List<UsuarioDto> obj;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UsuarioDto> getObj() {
        return obj;
    }

    public void setObj(List<UsuarioDto> obj) {
        this.obj = obj;
    }
}
