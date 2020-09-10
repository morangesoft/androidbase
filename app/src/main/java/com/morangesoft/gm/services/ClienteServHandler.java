package com.morangesoft.gm.services;

import com.morangesoft.gm.models.api.ClienteListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ClienteServHandler {
    //private static final String startUrl = "http://127.0.0.1:8121/";
    private static final String startUrl = "http://192.168.1.2:8121/";

    public void  ReadAll(final ClienteListListener hdr){
        Retrofit r = new Retrofit.Builder()
                .baseUrl(startUrl)
                //.addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        IClienteService service = r.create(IClienteService.class);
        System.out.println("... about to cliente_readall()");
        Call<ClienteListResponse> call = service.Cliente_ReadAll();
        call.enqueue(new Callback<ClienteListResponse>() {
            @Override
            public void onResponse(Call<ClienteListResponse> call, Response<ClienteListResponse> response) {
                System.out.println("... onResponse cliente_readall()");
                 if (!response.isSuccessful()){
                     hdr.onError(response.code() + "", response.message());
                 }else{
                     hdr.onOk(response.body());
                 }
            }

            @Override
            public void onFailure(Call<ClienteListResponse> call, Throwable t) {
                hdr.onError(t.hashCode() + "", t.getMessage());
            }
        });
    }


    public interface ClienteListListener{
        void onOk(ClienteListResponse resp);
        void onError(String code, String descrip);
    }
}
