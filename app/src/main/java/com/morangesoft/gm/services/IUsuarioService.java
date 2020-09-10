package com.morangesoft.gm.services;

import com.morangesoft.gm.models.api.UsuarioListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IUsuarioService {
    @GET("listallusuario")
    Call<UsuarioListResponse> Usuario_ReadAll();
}
