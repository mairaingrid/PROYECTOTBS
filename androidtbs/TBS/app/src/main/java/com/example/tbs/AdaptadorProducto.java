package com.example.tbs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tbs.Utils.Data;

import java.util.ArrayList;

public class AdaptadorProducto extends BaseAdapter {

    private Context context;
    private ArrayList<ItemProducto> list;
    public AdaptadorProducto(Context context, ArrayList<ItemProducto> list){
        this.context = context;
        this.list = list;

    }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflate = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflate.inflate(R.layout.item_producto, null);
        }
        ImageView foto =  convertView.findViewById(R.id.fotoImage);
        TextView nombre =   convertView.findViewById(R.id.nombreText);
        TextView descripcion = convertView.findViewById(R.id.descripcionText);
        TextView categoria = convertView.findViewById(R.id.categoriaText);
        TextView precio = convertView.findViewById(R.id.precioText);
        TextView stock = convertView.findViewById(R.id.stockText);

        Glide.with(this.context).load(Data.IP + this.list.get(position).getFoto()).into(foto);
        nombre.setText("Nombre : " + this.list.get(position).getNombre());

        descripcion.setText("Descripcion : " + this.list.get(position).getDescripcion());
        categoria.setText("Categoria : " + this.list.get(position).getCategoria());
        precio.setText("Precio : " + String.valueOf(this.list.get(position).getPrecio()));
        stock.setText( "Stock : " + String.valueOf(this.list.get(position).getStock()));

        return convertView;
    }

}
