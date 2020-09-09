package com.morangesoft.gm.ui.clientes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.morangesoft.gm.R;
import com.morangesoft.gm.models.Cliente;
import com.morangesoft.gm.models.dto.ClienteDto;

import java.util.ArrayList;
import java.util.List;

public class ClienteListAdapter extends BaseAdapter {
    private LayoutInflater inf;
    private List<Cliente> list;

    public ClienteListAdapter(LayoutInflater inf, List<Cliente> srclist){
        this.inf = inf;
        this.list = srclist;
    }

    public ClienteListAdapter(LayoutInflater inf){
        this.inf = inf;
        this.list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.list.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cliente clie = this.list.get(position);
        if (convertView == null){
            convertView = inf.inflate(R.layout.cliente_listitem,null);
        }
        TextView tvnombres = convertView.findViewById(R.id.tvciNombres);
        TextView tvapellidos = convertView.findViewById(R.id.tvciApellidos);
        TextView tvfechanac = convertView.findViewById(R.id.tvciFechaNac);
        TextView tvsueldo = convertView.findViewById(R.id.tvciSueldo);
        tvnombres.setText(clie.getNombre());
        tvapellidos.setText(clie.getApellidos());
        tvfechanac.setText(clie.getFechanac());
        tvsueldo.setText(clie.getSueldo()+"");
        return convertView;
    }

    public void setSource(List<Cliente> newsrc){
        this.list = newsrc;
    }

    //set external source
    public void setSourceEx(List<ClienteDto> xsrc){
        this.list.clear();
        for (int i=0; i<xsrc.size(); i++) {
            ClienteDto dto = xsrc.get(i);
            Cliente c = new Cliente();
            c.set_id(dto.get_id());
            c.setNombre(dto.getNombre());
            c.setApellidos(dto.getApellidos());
            c.setFechanac(dto.getFechanac());
            c.setSueldo(dto.getSueldo());
            this.list.add(c);
        }
    }

}
