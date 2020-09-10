package com.morangesoft.gm.ui.clientes;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.morangesoft.gm.R;
import com.morangesoft.gm.models.ClienteUI;
import com.morangesoft.gm.models.ResOk;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClienteEditDialog extends DialogFragment{

    private ClienteUI selclie;
    private TextInputEditText teclienombres;
    private TextInputEditText teclieapellidos;
    private TextInputEditText tecliesueldo;
    private TextView tvcliefechanac;
    private CheckBox chkcliecasado;

    private DatePickerDialog.OnDateSetListener fechaListener;

    public View.OnClickListener onGuardarClick;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.NoGapsFix);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.cliente_edit,null);
        startDialog(vw);
        return vw;
    }

    private String tryEdit(TextInputEditText editobj){
        if (editobj == null) return "";
        if (editobj.getText() == null) return "";
        return editobj.getText().toString();
    }

    private ClienteUI readFrom(){
        ClienteUI c = new ClienteUI();
        c.setNombre(tryEdit(teclienombres));
        c.setApellidos(tryEdit(teclieapellidos));
        if (tvcliefechanac.getTag()!= null) {
            Date dt = (Date) tvcliefechanac.getTag();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
            c.setFechanacStr(df.format(dt));
            c.setFechanac(dt.getTime());
        }else{
            c.setFechanacStr("");
        }
        c.setSueldoStr(tryEdit(tecliesueldo));
        c.setCasado(chkcliecasado.isChecked());
        return c;
    }

    private ResOk hasErrors(ClienteUI any){
        ResOk r = new ResOk();
        r.setTrue();
        if (any.getNombre().isEmpty()){
            r.setFalse();
            r.setMessage("Falta escribir el / los nombres.");
            return r;
        }
        if (any.getApellidos().isEmpty()){
            r.setFalse();
            r.setMessage("Falta escribir los apellidos.");
            return r;
        }
        if (any.getFechanacStr().isEmpty()){
            r.setFalse();
            r.setMessage("Falta definir la fecha de nacimiento.");
            return r;
        }
        if (any.getSueldoStr().isEmpty()){
            r.setFalse();
            r.setMessage("Falta definir el sueldo.");
            return r;
        }
        return r;
    }
    private void showMsg(String msg){
        Toast.makeText(getActivity().getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
    private void startDialog(View anyview){
        selclie = new ClienteUI();

        teclienombres = anyview.findViewById(R.id.teclieNombres);
        teclieapellidos = anyview.findViewById(R.id.teclieApellidos);
        tecliesueldo = anyview.findViewById(R.id.teclieSueldo);
        tvcliefechanac = anyview.findViewById(R.id.tvclieFechaNac);
        tvcliefechanac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cv = Calendar.getInstance();
                int year = cv.get(Calendar.YEAR);
                int month = cv.get(Calendar.MONTH);
                int day = cv.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dtpicker = new DatePickerDialog(getActivity(), fechaListener, year, month, day);
                dtpicker.show();
            }
        });

        chkcliecasado = anyview.findViewById(R.id.chkclieCasado);

        //---------------------------------------------------------------------

        Button bnsave = anyview.findViewById(R.id.bnclieEditSave);
        bnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onGuardarClick != null){
                    ClienteUI c = readFrom();
                    ResOk res = hasErrors(c);
                    if (!res.isOk()){
                        showMsg(res.getMessage());
                        return;
                    }
                    v.setTag(c.prepare());
                    onGuardarClick.onClick(v);
                    dismiss();
                }
            }
        });
        Button bncancel = anyview.findViewById(R.id.bnclieEditCancel);
        bncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        fechaListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //System.out.println("date selected : " + year +  " " + month + " " + dayOfMonth);
                Date fecha = new Date(year,month,dayOfMonth);
                tvcliefechanac.setText("Fecha Nacimiento: " + dayOfMonth + "/" + month + "/" + year);
                tvcliefechanac.setTag(fecha);
            }
        };


    }
}
