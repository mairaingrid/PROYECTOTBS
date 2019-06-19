package com.example.tbs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adaptersmisamigos extends RecyclerView.Adapter<adaptersmisamigos.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagenanuncios;

        TextView telefonoanuncios;


        public TextView tit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tit = itemView.findViewById(R.id.nombremiscitas);
            telefonoanuncios = itemView.findViewById(R.id.telefonomisanuncios);
            imagenanuncios = (ImageView) itemView.findViewById(R.id.imgmiscitas);
        }
    }

    public List<modelsmisamigos> listaa;

    public adaptersmisamigos(List<modelsmisamigos> listaa) {
        this.listaa = listaa;
    }

    @Override
    public adaptersmisamigos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menumisamigos, parent, false);
        adaptersmisamigos.ViewHolder viewHolder = new adaptersmisamigos.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(adaptersmisamigos.ViewHolder holder, int position) {
        holder.tit.setText(listaa.get(position).getTitle());


        holder.imagenanuncios.setImageResource(listaa.get(position).getImg());
        holder.telefonoanuncios.setText(listaa.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return listaa.size();
    }


}