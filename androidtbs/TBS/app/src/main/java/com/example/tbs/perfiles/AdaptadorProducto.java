package com.example.tbs.perfiles;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.example.tbs.EditarProductoActivity;
import com.example.tbs.PaginaPrincipalCompradorActivity;
import com.example.tbs.R;
import com.example.tbs.Utils.Data;
import com.example.tbs.productoprincipal.models;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflate = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflate.inflate(R.layout.item_perfil, null);
        }

        ImageView eliminar =  convertView.findViewById(R.id.eliminarImage);
        ImageView editar =  convertView.findViewById(R.id.editarImage);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.delete(Data.HOST_PRODUCT + list.get(position).getId(),new JsonHttpResponseHandler(){
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                try {
                                    if (response.getString("message") !=null){
                                        Toast.makeText(context,response.getString("message"),Toast.LENGTH_LONG ).show();
                                        Intent intent = new Intent(context,PaginaPrincipalCompradorActivity.class);
                                        context.startActivity(intent);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                try {
                                    Toast.makeText(context,errorResponse.getString("error"),Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                                Toast.makeText(context, responseString , Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        Toast.makeText(context,"cancelado",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setMessage("Esta accion es irreversible")
                        .setTitle("Esta seguro de eliminar el producto?");


                AlertDialog dialog = builder.create();
                dialog.show();



            }
        });
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(context,EditarProductoActivity.class);


                intent.putExtra("id", list.get(position).getId() );
                context.startActivity(intent);
            }
        });

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

    }}



 /*   private Context context;
    private ArrayList<models> list;
    public AdaptadorProducto(Context context, ArrayList<models> list){
        this.context = context;
        this.list = list;

    }

    public AdaptadorProducto(perfiles context, ArrayList<models> listdata) {
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
            convertView =inflate.inflate(R.layout.item_producto, null);
        }

        ImageView eliminar =  convertView.findViewById(R.id.eliminarImage);
        ImageView editar =  convertView.findViewById(R.id.editarImage);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.delete(Data.HOST_PRODUCT + list.get(position).getId(),new JsonHttpResponseHandler(){
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                try {
                                    if (response.getString("message") !=null){
                                        Toast.makeText(context,response.getString("message"),Toast.LENGTH_LONG ).show();
                                        Intent intent = new Intent(context, PaginaPrincipalCompradorActivity.class);
                                        context.startActivity(intent);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                try {
                                    Toast.makeText(context,errorResponse.getString("error"),Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                                Toast.makeText(context, responseString , Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        Toast.makeText(context,"cancelado",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setMessage("Esta accion es irreversible")
                        .setTitle("Esta seguro de eliminar el producto?");


                AlertDialog dialog = builder.create();
                dialog.show();



            }
        });
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent  intent = new Intent(context, EditarProductoActivity.class);


              intent.putExtra("id", list.get(position).getId() );
              context.startActivity(intent);
            }
        });

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
*/