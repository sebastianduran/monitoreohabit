package com.example.hotelkensymanager;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImportAdapter extends RecyclerView.Adapter<ImportAdapter.ImportViewHolder> {

    private Context context;
    private ArrayList<Ocupacion> ocupacions;

    public ImportAdapter (Context mContext, ArrayList<Ocupacion> mOcupations){
        this.context = mContext;
        this.ocupacions = mOcupations;
    }

    @NonNull
    @Override
    public ImportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.habitacion_item, parent,false);
        return new ImportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImportViewHolder holder, int position) {
        Ocupacion ocupacion = ocupacions.get(position);
        holder.txtHabitacion.setText(String.valueOf(ocupacion.getHabitacion()));
        if (ocupacion.isPresencia()<160){
            holder.btnPresencia.setBackgroundColor(Color.LTGRAY);
        }else if (ocupacion.isPresencia()>161 && ocupacion.isPresencia()<200){
            holder.btnPresencia.setBackgroundColor(Color.YELLOW);
        }
        else {
            holder.btnPresencia.setBackgroundColor(Color.GREEN);
        }

    }

    @Override
    public int getItemCount() {
        return ocupacions.size();
    }

    static class ImportViewHolder extends RecyclerView.ViewHolder{

        private TextView txtHabitacion;
        private Button btnPresencia;

        public ImportViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHabitacion = itemView.findViewById(R.id.text_habitacion);
            btnPresencia = itemView.findViewById(R.id.btn_presencia);

        }
    }

}
