package com.example.tbs.productoprincipal;

import androidx.appcompat.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tbs.EditarProductoActivity;
import com.example.tbs.PaginaPrincipalCompradorActivity;
import com.example.tbs.R;
import com.example.tbs.Utils.Data;
import com.example.tbs.crear_cita;
import com.example.tbs.perfiles.ItemProducto;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class adapters extends BaseAdapter {//RecyclerView.Adapter<adapters.ViewHolder> {

    private Context context;
    ImageButton citas;
    ImageButton mensaje;
    CheckBox  checkBox;
    private ArrayList<models> list;
    public adapters(Context context, ArrayList<models> list){
        this.context = context;
        this.list = list;

    }

    public adapters(PaginaPrincipalVendedorActivity context, ArrayList<ItemProducto> listdata) {
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

       /* ImageView eliminar =  convertView.findViewById(R.id.eliminarImage);
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
        });*/

        ImageView foto =  convertView.findViewById(R.id.fotoImage);
        TextView nombre =   convertView.findViewById(R.id.nombreText);
        TextView descripcion = convertView.findViewById(R.id.descripcionText);
        TextView categoria = convertView.findViewById(R.id.categoriaText);
        TextView precio = convertView.findViewById(R.id.precioText);
        TextView stock = convertView.findViewById(R.id.stockText);
         CheckBox checkBox = convertView.findViewById(R.id.favorito);
         ImageButton  citas= convertView.findViewById(R.id.citas);
         ImageButton mensaje= convertView.findViewById(R.id.mensaje);
        Glide.with(this.context).load(Data.IP + this.list.get(position).getFoto()).into(foto);
        nombre.setText("Nombre : " + this.list.get(position).getNombre());

        descripcion.setText("Descripcion : " + this.list.get(position).getDescripcion());
        categoria.setText("Categoria : " + this.list.get(position).getCategoria());
        precio.setText("Precio : " + String.valueOf(this.list.get(position).getPrecio()));
        stock.setText( "Stock : " + String.valueOf(this.list.get(position).getStock()));
        //checkBox.setText("favorito"+String.valueOf(this.list(position).getCheckbox()));
        /** ********************************importante************/
        if (checkBox.isChecked()){

        }else{}

        citas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, crear_cita.class);
               // intent.putExtra("fotoImage", list.get(position).getFoto());
                intent.putExtra("nombreText", list.get(position).getNombre());
                intent.putExtra("descripcionText", list.get(position).getDescripcion());
                intent.putExtra("precioText", list.get(position).getPrecio());
                intent.putExtra("stockText", list.get(position).getStock());
                intent.putExtra("categoriaText", list.get(position).getCategoria());
                context.startActivity(intent);
            }
        });

        return convertView;

    }}
  /*  public static class ViewHolder extends RecyclerView.ViewHolder{

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
            tit  =itemView.findViewById(R.id.nombremiscitas);
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
