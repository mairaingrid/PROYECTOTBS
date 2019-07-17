package com.example.tbs.citas;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
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

public class adaptersmiscitas  extends BaseAdapter {

            private Context context;
            private ArrayList<modelsmiscitas> list;

    public adaptersmiscitas(Context context, ArrayList<modelsmiscitas> list){
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
                convertView =inflate.inflate(R.layout.miscitas, null);
            }
                EditText cantidad= convertView.findViewById(R.id.cantidad);
            TextView estado =  convertView.findViewById(R.id.estado);
            TextView direccion =   convertView.findViewById(R.id.dirreccion);
            TextView fecha = convertView.findViewById(R.id.fecha);
            TextView hora = convertView.findViewById(R.id.hora);
            RatingBar clasificacion = convertView.findViewById(R.id.clasificacion);

                ImageView foto =  convertView.findViewById(R.id.fotoImage);
                TextView nombre =   convertView.findViewById(R.id.nombreText);
                TextView descripcion = convertView.findViewById(R.id.descripcionText);
                TextView categoria = convertView.findViewById(R.id.categoriaText);
                TextView precio = convertView.findViewById(R.id.precioText);
                TextView stock = convertView.findViewById(R.id.stockText);



                //  TextView stock = convertView.findViewById(R.id.stockText);

          //  Glide.with(this.context).load(Data.IP + this.list.get(position).getFoto()).into(foto);
            estado.setText("estado : " + this.list.get(position).getEstado());
            cantidad.setText("cantidad :"+ this.list.get(position).getcantidad());
            direccion.setText("direccion : " + this.list.get(position).getDireccion());
            fecha.setText("fecha : " + this.list.get(position).getFecha());
            hora.setText("hora : " + String.valueOf(this.list.get(position).getHora()));
            clasificacion.setNumStars(Integer.parseInt(String.valueOf(this.list.get(position).getClasificacion())));


             //   Glide.with(this.context).load(Data.IP + this.list.get(position).getFoto()).into(foto);
                nombre.setText("Nombre : " + this.list.get(position).getNombre());

                descripcion.setText("Descripcion : " + this.list.get(position).getDescripcion());
                categoria.setText("Categoria : " + this.list.get(position).getCategoria());
                precio.setText("Precio : " + String.valueOf(this.list.get(position).getPrecio()));
                stock.setText( "Stock : " + String.valueOf(this.list.get(position).getStock()));

                return convertView;

        }}
