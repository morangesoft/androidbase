package com.morangesoft.gm.ui.clientes;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.morangesoft.gm.R;
import com.morangesoft.gm.models.Cliente;
import com.morangesoft.gm.models.api.ClienteListResponse;
import com.morangesoft.gm.services.ClienteServHandler;
import com.morangesoft.gm.ui.dialogs.KillDialog;

public class ClientesFragment extends Fragment {

    private ListView lvclientes;
    private ClienteListAdapter adapter;
    private boolean flgloaded = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.cliente_list,null);
        lvclientes = vw.findViewById(R.id.lvClientes);
        adapter = new ClienteListAdapter(getLayoutInflater());
        lvclientes.setAdapter(adapter);
        adapter.onEditClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(((Cliente)v.getTag()).toString());
                ClienteEditDialog dlg = new ClienteEditDialog();
                dlg.setEditMode((Cliente)v.getTag());
                dlg.show(getFragmentManager(),"editcliedlg");
            }
        };
        adapter.onKillClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KillDialog dlg = new KillDialog();
                dlg.show(getFragmentManager(),"killdlgclie");
            }
        };
        //System.out.println("onCreateView ... ClientesFragment!");

        return vw;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new ClienteTask().execute();
    }



    private class ClienteTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            //System.out.println("doInBackground ... ClientesFragment!");
            ClienteServHandler svr = new ClienteServHandler();
            svr.ReadAll(new ClienteServHandler.ClienteListListener() {
                @Override
                public void onOk(ClienteListResponse resp) {
                    //System.out.println("xxxx" + resp.getObj().size() + " elements");
                    adapter.setSourceEx(resp.getObj());
                    adapter.notifyDataSetChanged();
                }
                @Override
                public void onError(String code, String descrip) {
                    System.out.println("error " + code + " " + descrip);
                }
            });
            return null;
        }
    }
}
