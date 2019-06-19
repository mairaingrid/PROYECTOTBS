package com.example.tbs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import java.util.List;

public class adaptersmisfavoritos  extends RecyclerView.Adapter<adaptersmisfavoritos.ViewHolder>implements View.OnClickListener{

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
      //  this.itemCli
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */


    public static class ViewHolder<itemClickListener> extends RecyclerView.ViewHolder  {
        Context context;
        ImageView imagenanuncios;
        TextView descripcionanuncios;
        TextView costoanuncios;
        TextView cantidadanuncios;
        TextView telefonoanuncios;
        CheckBox estrellitadondeestas;

        TextView adicional;
        public TextView tit;
        itemClickListener itemClickListener;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcionanuncios = (TextView) itemView.findViewById(R.id.descripcionmisanuncios);
            costoanuncios = (TextView) itemView.findViewById(R.id.preciomisanuncios);
            cantidadanuncios = (TextView) itemView.findViewById(R.id.cantidadmisanuncios);
            tit = itemView.findViewById(R.id.nombremiscitas);
            telefonoanuncios = itemView.findViewById(R.id.telefonomisanuncios);
            imagenanuncios = (ImageView) itemView.findViewById(R.id.imgmiscitas);
         //   estrellitadondeestas= itemView.findViewById(R.id.starfavorito);
           // estrellitadondeestas=setOnClickListener(this);

        //    estrellitadondeestas.setOnClickListener(this);
        }
    public void setItemClickListener(itemClickListener ic){
            this.itemClickListener=ic;
    }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
  /*      @Override
        public void onClick(View v) {
            //este hay que ver
            this.itemClickListener.onItemClick(v.getLayoutParams());
        }*/
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
   //    holder.estrellitadondeestas.setTag(listaa.get(position).getStar());



    /*    holder.setItemClickListener(new iiemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                CheckBox chk = (CheckBox) v;

                //asignaaa
                if(chk.isChecked()){
                    adaptersmisfavoritos.add(listaa.get(ic));

                }
                else if(!chk.isChecked()) {
                }

                }

        });*/

    }


    @Override
    public int getItemCount() {
        return listaa.size();
    }
}



