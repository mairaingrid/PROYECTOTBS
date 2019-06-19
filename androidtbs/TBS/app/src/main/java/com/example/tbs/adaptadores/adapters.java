package com.example.tbs.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tbs.R;
import com.example.tbs.modelos_datainfo.models;

import java.util.List;

public class adapters extends RecyclerView.Adapter<adapters.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{



        ImageView imagenanuncios;
        TextView descripcionanuncios;
        TextView costoanuncios;
        TextView cantidadanuncios;
        TextView telefonoanuncios;

        TextView adicional;
        public TextView tit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcionanuncios =(TextView)itemView.findViewById(R.id.descripcionmisanuncios);
            costoanuncios = (TextView)itemView.findViewById(R.id.preciomisanuncios);
            cantidadanuncios = (TextView)itemView.findViewById(R.id.cantidadmisanuncios);
            tit  =itemView.findViewById(R.id.nombremisfavoritos);
            telefonoanuncios=itemView.findViewById(R.id.telefonomisanuncios);
            imagenanuncios = (ImageView) itemView.findViewById(R.id.imgmiscitas);
        }
    }
    public List<models> listaa;

    public adapters (List<models> listaa){
        this.listaa = listaa;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perfil,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.tit.setText(listaa.get(position).getTitle());
        holder.descripcionanuncios.setText(listaa.get(position).getDescripcion());
        holder.costoanuncios.setText(listaa.get(position).getCosto());
        holder.imagenanuncios.setImageResource(listaa.get(position).getImg());
        holder.telefonoanuncios.setText(listaa.get(position).getTelefono());
    }

    @Override
    public int getItemCount(){
        return listaa.size();
    }

   /* private Context context;
    private ArrayList<models> list;
    public adapters (Context context, ArrayList<models> list){
        this.context = context;
        this.list= list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

// llama al itemperfil
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflate = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflate.inflate(R.layout.item_perfil,parent, false);
        }
            ImageView img = convertView.findViewById(R.id.img);
             TextView ti = convertView.findViewById(R.id.titulo);
             TextView des = convertView.findViewById(R.id.descripcion);
             TextView adicional =convertView.findViewById(R.id.adicional);

             img.setImageResource(this.list.get(position).getImg());
             ti.setText(this.list.get(position).getTitle());
               des.setText(this.list.get(position).getDescripcion());
            adicional.setText(this.list.get(position).getAdicional());
        return convertView;
    }*/
}
