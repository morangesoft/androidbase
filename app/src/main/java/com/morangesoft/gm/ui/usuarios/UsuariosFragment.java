package com.morangesoft.gm.ui.usuarios;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.morangesoft.gm.R;
import com.morangesoft.gm.models.api.UsuarioListResponse;
import com.morangesoft.gm.services.UsuarioServHandler;

public class UsuariosFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.usuarios_list,null);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return vw;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new UsuarioTask().execute();
    }

    private class UsuarioTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            UsuarioServHandler svr = new UsuarioServHandler();
            svr.ReadAll(new UsuarioServHandler.UsuarioListListener() {
                @Override
                public void onOk(UsuarioListResponse resp) {
                    System.out.println("Aqui ...");
                }

                @Override
                public void onError(String code, String descrip) {
                    System.out.println("Error ..." + code + " " + descrip);
                }
            });
            return null;
        }
    }
}
