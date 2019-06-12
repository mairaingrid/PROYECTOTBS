package com.example.tbs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adaptersmisfavoritos  extends RecyclerView.Adapter<adapters.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        private TextView descripcion;
        private TextView adicional;
        private TextView tit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcion =(TextView)itemView.findViewById(R.id.descripcion);
            adicional = (TextView)itemView.findViewById(R.id.adicional);
            tit  =itemView.findViewById(R.id.titulo);
            imagen = (ImageView) itemView.findViewById(R.id.img);
        }
    }
    public List<models> listaa;

    public adaptersmisfavoritos (List<models> listaa){
        this.listaa = listaa;
    }

    @Override
    public adapters.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perfil,parent,false);
        adapters.ViewHolder viewHolder=new adapters.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(adapters.ViewHolder holder, int position){
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


