package com.morangesoft.gm.ui.clientes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.morangesoft.gm.R;
import com.morangesoft.gm.models.ClieSelector;
import com.morangesoft.gm.models.Cliente;
import com.morangesoft.gm.models.dto.ClienteDto;

import java.util.ArrayList;
import java.util.List;

public class ClienteListAdapter extends BaseAdapter {
    private LayoutInflater inf;
    private List<Cliente> list;

    private View oldSelector = null;
    private ImageView oldKillImageV = null;
    private ImageView oldEditImageV = null;

    private int selectedIndex = -1;
    private ClieSelector selectedClieObj;

    public View.OnClickListener onEditClick;
    public View.OnClickListener onKillClick;

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
        return 0; //this.list.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cliente clie = this.list.get(position);
        if (convertView == null){
            convertView = inf.inflate(R.layout.cliente_listitem,null);
        }
        View selector = convertView.findViewById(R.id.vwciSelector);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldSelector.setVisibility(View.INVISIBLE);
                oldEditImageV.setVisibility(View.INVISIBLE);
                oldKillImageV.setVisibility(View.INVISIBLE);

                //System.out.println(v.getTag().toString());
                ClieSelector clisel = (ClieSelector)v.getTag();
                selectedClieObj = clisel;
                //System.out.println("clicking here : " + clisel.index);
                clisel.selector.setVisibility(View.VISIBLE);
                clisel.edit.setVisibility(View.VISIBLE);
                clisel.kill.setVisibility(View.VISIBLE);

                oldSelector = clisel.selector;
                oldEditImageV = clisel.edit;
                oldKillImageV = clisel.kill;

            }
        });
        if (oldSelector != null){
            oldSelector.setVisibility(View.INVISIBLE);
            oldEditImageV.setVisibility(View.INVISIBLE);
            oldKillImageV.setVisibility(View.INVISIBLE);
        }

        TextView tvnombres = convertView.findViewById(R.id.tvciNombres);
        TextView tvapellidos = convertView.findViewById(R.id.tvciApellidos);
        TextView tvfechanac = convertView.findViewById(R.id.tvciFechaNac);
        TextView tvsueldo = convertView.findViewById(R.id.tvciSueldo);
        tvnombres.setText(clie.getNombre());
        tvapellidos.setText(clie.getApellidos());
        tvfechanac.setText(clie.getFechanac()+"");
        tvsueldo.setText(clie.getSueldo()+"");
        ImageView ivedit = convertView.findViewById(R.id.ivciEdit);
        ivedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onEditClick != null){
                    v.setTag(selectedClieObj.data);
                    onEditClick.onClick(v);
                }
            }
        });
        ImageView ivkill = convertView.findViewById(R.id.ivciDelete);
        ivkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onKillClick != null){
                    v.setTag(selectedClieObj.data);
                    onKillClick.onClick(v);
                }
            }
        });
        oldSelector = selector;
        oldEditImageV = ivedit;
        oldKillImageV = ivkill;
        convertView.setTag(new ClieSelector(position,selector,ivedit,ivkill,clie));
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
