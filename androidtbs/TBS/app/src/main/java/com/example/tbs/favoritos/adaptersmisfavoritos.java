package com.example.tbs.favoritos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tbs.EditarProductoActivity;
import com.example.tbs.PaginaPrincipalCompradorActivity;
import com.example.tbs.R;
import com.example.tbs.Utils.Data;
import com.example.tbs.perfiles.ItemProducto;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class adaptersmisfavoritos  extends BaseAdapter{
    // RecyclerView.Adapter<adaptersmisfavoritos.ViewHolder> {
    CheckBox checkBox;
    private Context context;
    private ArrayList<modelsmisfavoritos> list;

    public adaptersmisfavoritos(Context context, ArrayList<modelsmisfavoritos> list){
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflate = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflate.inflate(R.layout.misfavoritos, null);

        }
        CheckBox checkBox = convertView.findViewById(R.id.favorito);
        ImageView foto = (ImageView) convertView.findViewById(R.id.fotoImage);
        TextView nombre =  (TextView) convertView.findViewById(R.id.nombreText);
        TextView descripcion = (TextView)convertView.findViewById(R.id.descripcionText);
        TextView categoria = (TextView)convertView.findViewById(R.id.categoriaText);
        TextView precio = (TextView)convertView.findViewById(R.id.precioText);
        TextView stock = (TextView)convertView.findViewById(R.id.stockText);

        Glide.with(this.context).load(Data.IP + this.list.get(position).getFoto()).into(foto);
        nombre.setText("Nombre : " + this.list.get(position).getNombre());

        descripcion.setText("Descripcion : " + this.list.get(position).getDescripcion());
        categoria.setText("Categoria : " + this.list.get(position).getCategoria());
        precio.setText("Precio : " + String.valueOf(this.list.get(position).getPrecio()));
        stock.setText( "Stock : " + String.valueOf(this.list.get(position).getStock()));

        return convertView;

    }}




    /*
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



*/