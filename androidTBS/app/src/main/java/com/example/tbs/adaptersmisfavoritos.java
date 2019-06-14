package com.example.tbs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adaptersmisfavoritos  extends RecyclerView.Adapter<adaptersmisfavoritos.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenanuncios;
        TextView descripcionanuncios;
        TextView costoanuncios;
        TextView cantidadanuncios;
        TextView telefonoanuncios;

        TextView adicional;
        public TextView tit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcionanuncios = (TextView) itemView.findViewById(R.id.descripcionmisanuncios);
            costoanuncios = (TextView) itemView.findViewById(R.id.preciomisanuncios);
            cantidadanuncios = (TextView) itemView.findViewById(R.id.cantidadmisanuncios);
            tit = itemView.findViewById(R.id.nombremiscitas);
            telefonoanuncios = itemView.findViewById(R.id.telefonomisanuncios);
            imagenanuncios = (ImageView) itemView.findViewById(R.id.imgmiscitas);
        }
    }

    public List<modelsmisfavoritos> listaa;

    public adaptersmisfavoritos(List<modelsmisfavoritos> listaa) {
        this.listaa = listaa;
    }

    @Override
    public adaptersmisfavoritos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.misfavoritos, parent, false);
        adaptersmisfavoritos.ViewHolder viewHolder = new adaptersmisfavoritos.ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(adaptersmisfavoritos.ViewHolder holder, int position) {
        holder.tit.setText(listaa.get(position).getTitle());
        holder.descripcionanuncios.setText(listaa.get(position).getDescripcion());
        holder.costoanuncios.setText(listaa.get(position).getCosto());
        holder.imagenanuncios.setImageResource(listaa.get(position).getImg());
        holder.telefonoanuncios.setText(listaa.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return listaa.size();
    }
}



