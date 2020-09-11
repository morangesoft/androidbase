package com.morangesoft.gm.services;

import com.morangesoft.gm.models.api.ClienteListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IClienteService {
    @GET("clientes")
    Call<ClienteListResponse> Cliente_ReadAll();

}
