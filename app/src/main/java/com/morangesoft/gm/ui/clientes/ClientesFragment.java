package com.morangesoft.gm.ui.clientes;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.morangesoft.gm.R;
import com.morangesoft.gm.models.api.ClienteListResponse;
import com.morangesoft.gm.services.ClienteServHandler;

public class ClientesFragment extends Fragment {

    private ListView lvclientes;
    private ClienteListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.cliente_list,null);
        lvclientes = vw.findViewById(R.id.lvClientes);
        //adapter = new ClienteListAdapter(getLayoutInflater());
        return vw;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //startView();
    }

    private void startView(){
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                ClienteServHandler svr = new ClienteServHandler();
                svr.ReadAll(new ClienteServHandler.ClienteListListener() {
                    @Override
                    public void onOk(ClienteListResponse resp) {
                        adapter.setSourceEx(resp.getObj());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(String code, String descrip) {

                    }
                });
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();
    }

}
