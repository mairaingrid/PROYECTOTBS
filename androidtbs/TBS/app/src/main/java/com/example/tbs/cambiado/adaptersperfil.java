package com.example.tbs.cambiado;

import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tbs.perfiles.ItemProducto;

import java.security.AccessControlContext;
import java.util.ArrayList;

public class adaptersperfil {//extends RecyclerView.Adapter<adaptersperfil.ViewHolder> {


    public adaptersperfil(AccessControlContext context, ArrayList<ItemProducto> listarecycler) {
    }

    //public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView imagenanuncios;
        TextView descripcionanuncios;
        TextView costoanuncios;
        TextView cantidadanuncios;
        TextView categoria;
        ListView listatraslado;
        TextView estado;
        ImageButton imagetxt;
        ImageButton imagecita;
        CheckBox imafavorito;
        TextView tit;

       /* public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagecita = (ImageButton) itemView.findViewById(R.id.imagecitas);
            imafavorito = (CheckBox) itemView.findViewById(R.id.imgfavorito);
            estado = (TextView) itemView.findViewById(R.id.estado);

            imagetxt = (ImageButton) itemView.findViewById(R.id.imagemensaje);
            descripcionanuncios = (TextView) itemView.findViewById(R.id.descripcionarticulo);
            costoanuncios = (TextView) itemView.findViewById(R.id.precioarticulo);
            cantidadanuncios = (TextView) itemView.findViewById(R.id.cantidadarticulo);
            tit = itemView.findViewById(R.id.tituloarticulo);
            categoria = itemView.findViewById(R.id.categoriaarticulo);
            imagenanuncios = (ImageView) itemView.findViewById(R.id.img);
//   listatraslado = (ListView)itemView.findViewById(R.id.lista);

      /*      if (imafavorito.isChecked()) {
                AsyncHttpClient favorito = new AsyncHttpClient();
                RequestParams params= new RequestParams();

                params.add("vendedor", tit.getText().toString());
                params.add("nombre", descripcionanuncios.getText().toString());
                params.add("stock", cantidadanuncios.getText().toString());
                params.add("categoria", categoria.getText().toString());
                params.add("estado", estado.getText().toString());
                params.add("fechaRegistro", tit.getText().toString());
                params.add("favorito", imafavorito.getText().toString());
              //  params.add("nombre", tit.getText().toString());
              //  params.add("nombre", tit.getText().toString());
                favorito.post(Data.HOST_FAVORITO, params, new JsonHttpResponseHandler(){
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response){
                        if (response.has("roles")){
                          //  Toast.makeText(adaptersperfil.this,"se movio a favoritos", Toast.LENGTH_SHORT ).show();
                            /**hacer intent minuto 55.34 **/
        /*                }
                    }
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse){

                    }
                });
            } else {

            }

        }
    }*/
    }
    /*}
    public List<modelsperfil> listaa;

    public adaptersperfil(AccessControlContext context, List<modelsperfil> listaa) {
        this.listaa = listaa;
    }

    @Override
    public adaptersperfil.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemperfiless, parent, false);
        adaptersperfil.ViewHolder viewHolder = new adaptersperfil.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.cantidadanuncios.setText(listaa.get(position).getCantidad());
        holder.tit.setText(listaa.get(position).getTitle());
        holder.descripcionanuncios.setText(listaa.get(position).getDescripcion());
        holder.costoanuncios.setText(listaa.get(position).getCosto());
        holder.imagenanuncios.setImageResource(listaa.get(position).getImg());
        holder.categoria.setText(listaa.get(position).getCategoria());
        //holder.imagecita.setImageResource(listaa.get(position.getImagemensaje());
        holder.imafavorito.setChecked(listaa.get(position).getImagefavorito());
        // holder.imagetxt.setImageResource(listaa.get(position).getButtonTxt());
/**este va a chat*/
   /*     holder.imagetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), chat.class);
                //agregar otros
            //    intent.putExtra("imagenmiscitas", listaa.get(position).getImg());
                intent.putExtra("descrpcionmiscitas", listaa.get(position).getDescripcion());
                (v.getContext()).startActivity(intent);
                AsyncHttpClient irpersonachat = new AsyncHttpClient();
                RequestParams params= new RequestParams();

                params.add("nombre", listaa.get(position).toString());


                irpersonachat.post(Data.HOST_MENSAJE, params, new JsonHttpResponseHandler() {
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        if (response.has("roles")) {
                            //  Toast.makeText(adaptersperfil.this,"se movio a favoritos", Toast.LENGTH_SHORT ).show();
                            /**hacer intent minuto 55.34 **/
              /*          }
                    }
              });
            }
        });
*/

      /*  holder.imagecita.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), crear_cita.class);
                (v.getContext()).startActivity(intent);
                AsyncHttpClient ircita = new AsyncHttpClient();
                RequestParams params = new RequestParams();

                params.add("vendedor", listaa.get(position).toString());
                params.add("nombre", listaa.get(position).toString());
                params.add("stock", listaa.get(position).toString());
                params.add("categoria", listaa.get(position).toString());
                params.add("estado", listaa.get(position).toString());
                params.add("fechaRegistro", listaa.get(position).toString());
                params.add("favorito", listaa.get(position).toString());

                ircita.post(Data.HOST_CITAS, params, new JsonHttpResponseHandler() {
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        if (response.has("roles")) {
                            //  Toast.makeText(adaptersperfil.this,"se movio a favoritos", Toast.LENGTH_SHORT ).show();
                            /**hacer intent minuto 55.34 **/
          /*              }
                    }

            });
            }
        });
    }
     /*   if (imafavorito.isChecked) {
            holder.imafavorito.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), miscitas.class)
                            validarfavorito();
                }

                private void validarfavorito() {
                    if(i)
                }
            });
        }

    }
*//*
    @Override
    public int getItemCount() {
        return listaa.size();
    }
*/
