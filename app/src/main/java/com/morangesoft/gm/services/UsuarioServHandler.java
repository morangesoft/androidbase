package com.morangesoft.gm.services;

import com.morangesoft.gm.models.api.ClienteListResponse;
import com.morangesoft.gm.models.api.UsuarioListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioServHandler {
    //private static final String startUrl = "http://127.0.0.1:9020/moduserver/";
    private static final String startUrl = "http://192.168.1.2:9020/moduserver/";

    public void ReadAll(final UsuarioListListener hdr){
        Retrofit r = new Retrofit.Builder()
                .baseUrl(startUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUsuarioService service = r.create(IUsuarioService.class);
        Call<UsuarioListResponse> call = service.Usuario_ReadAll();
        call.enqueue(new Callback<UsuarioListResponse>() {
            @Override
            public void onResponse(Call<UsuarioListResponse> call, Response<UsuarioListResponse> response) {
                if (!response.isSuccessful()){
                    hdr.onError(response.code() + "", response.message());
                }else{
                    System.out.println("ok de okeys ...");
                    hdr.onOk(response.body());

                }
            }

            @Override
            public void onFailure(Call<UsuarioListResponse> call, Throwable t) {
                hdr.onError(t.hashCode() + "", t.getMessage());
            }
        });
    }


    public interface UsuarioListListener{
        void onOk(UsuarioListResponse resp);
        void onError(String code, String descrip);
    }
}
