package com.morangesoft.gm.services;

import com.morangesoft.gm.models.api.ClienteEditResponse;
import com.morangesoft.gm.models.api.ClienteListResponse;
import com.morangesoft.gm.models.dto.ClienteDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface IClienteService {
    @GET("clientes")
    Call<ClienteListResponse> Cliente_ReadAll();

    @POST("cliente")
    Call<ClienteEditResponse> Cliente_Add(@Body ClienteDto newclie);

    @PATCH("cliente")
    Call<ClienteEditResponse> Cliente_Edit(@Body ClienteDto editclie);

}
