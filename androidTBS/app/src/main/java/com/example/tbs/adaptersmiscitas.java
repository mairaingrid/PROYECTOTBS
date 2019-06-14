package com.example.tbs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adaptersmiscitas  extends RecyclerView.Adapter<adaptersmiscitas.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenmiscitas;
        TextView nombremiscitas;
         TextView descripcionmiscitas;
         TextView fechamiscitas;
        // ImageButton llamadamiscitas;

                public ViewHolder(@NonNull View itemView) {
            super(itemView);
         nombremiscitas = (TextView) itemView.findViewById(R.id.nombremiscitas);
            descripcionmiscitas = (TextView) itemView.findViewById(R.id.descripcionmiscitas);
            fechamiscitas = (TextView) itemView.findViewById(R.id.fechamiscita);
       //     llamadamiscitas = itemView.findViewById(R.id.llamarmiscitas);
            imagenmiscitas = (ImageView) itemView.findViewById(R.id.imgmiscitas);
        }
    }

    public List<modelsmiscitas> listaa;

    public adaptersmiscitas(List<modelsmiscitas> listaa) {
        this.listaa = listaa;
    }

    @Override
    public adaptersmiscitas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.miscitas, parent, false);
        adaptersmiscitas.ViewHolder viewHolder = new adaptersmiscitas.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(adaptersmiscitas.ViewHolder holder, int position) {
        holder.nombremiscitas.setText(listaa.get(position).getTitle());
        holder.descripcionmiscitas.setText(listaa.get(position).getDescripcion());
        holder.fechamiscitas.setText(listaa.get(position).getFechamiscitas());
        holder.imagenmiscitas.setImageResource(listaa.get(position).getImg());
 //       holder.llamadamiscitas.setTag(listaa.get(position).getLlamada());
    }

    @Override
    public int getItemCount() {
        return listaa.size();
    }
}