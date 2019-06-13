package com.example.tbs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adaptersmisfavoritos  extends RecyclerView.Adapter<adaptersmisfavoritos.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        private TextView descripcion;
        private TextView adicional;
        private TextView tit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcion =(TextView)itemView.findViewById(R.id.descripcion);
            adicional = (TextView)itemView.findViewById(R.id.adicional);
            tit  =itemView.findViewById(R.id.titulomisanuncios);
            imagen = (ImageView) itemView.findViewById(R.id.imgmisanuncios);
        }
    }
    public List<modelsmisfavoritos> listaa;

    public adaptersmisfavoritos (List<modelsmisfavoritos> listaa){
        this.listaa = listaa;
    }

    @Override
    public adaptersmisfavoritos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.misfavoritos,parent,false);
        adaptersmisfavoritos.ViewHolder viewHolder=new adaptersmisfavoritos.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(adaptersmisfavoritos.ViewHolder holder, int position){
        holder.tit.setText(listaa.get(position).getTitle());
        holder.descripcion.setText(listaa.get(position).getDescripcion());
        holder.adicional.setText(listaa.get(position).getAdicional());
        holder.imagen.setImageResource(listaa.get(position).getImg());
    }

    @Override
    public int getItemCount(){
        return listaa.size();
    }

}


