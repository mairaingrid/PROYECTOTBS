package com.example.tbs.perfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tbs.DetalleProductoActivity;
import com.example.tbs.R;
import com.example.tbs.Utils.Data;
import com.example.tbs.productoprincipal.models;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class perfiles extends AppCompatActivity {
    private ArrayList<ItemProducto> listdata;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfiles);

        loadComponets();
        if (Data.USER_ID != "") {
            getData();
        } else {
            Toast.makeText(this, Data.USER_ID, Toast.LENGTH_LONG).show();
        }
    }

    private void loadComponets() {
        list = findViewById(R.id.listaperfil);


        listdata = new ArrayList<ItemProducto>();

        /*Integer[] images = new Integer[]{R.drawable.brand, R.drawable.fresa, R.drawable.fruts, R.drawable.uvas, R.drawable.brand};
        String[] titles = new String[]{"AUTO", "CELULAR", "BICICLETA", "VENTILADOR", "DESPERTADOR"};
        String[] descrip = new String[]{"vendo auto costo 25.000$ cantida 5,disponible", "vendo celular samsung costo 150bs", "vendo bicicleta costo 300bs cantidad 4, disponible", "vendo ventilador, costo 200bs, cantidad 5, disponible", "vendo despertador, costo 100bs,cantidad 10 , disponible"};
        //ArrayList<ItemProducto> listdata =new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ItemProducto info = new ItemProducto();
            info.setImg(images[i]);
            info.setTitle(titles[i]);
            info.setDescripcion(descrip[i]);
            listdata.add(info);

        }

        */

//list.setOnItemClickListener(this);
//grid.setAdapter(adapter);
//spinner.setAdapter(adapter);


 }

    private void getData() {

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(Data.HOST_PRODUCT_SELLER + Data.USER_ID, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray data = response.getJSONArray("data");
                    for (int i = 0; i < data.length(); i++) {
                        ItemProducto p = new ItemProducto();
                        JSONObject ob = data.getJSONObject(i);
                        p.setId(ob.getString("_id"));
                        p.setNombre(ob.getString("nombre"));
                        p.setDescripcion(ob.getString("descripcion"));
                        p.setCategoria(ob.getString("categoria"));
                        p.setEstado(ob.getString("estado"));
                        p.setFoto(ob.getString("foto"));
                        p.setPrecio(ob.getString("precio"));
                        p.setStock(ob.getString("stock"));
                        p.setRegistro(ob.getString("fechaRegistro"));
//                        p.setLat(ob.getDouble("lat"));
   //                     p.setLog(ob.getDouble("log"));

                        listdata.add(p);
                    }
                    loadData();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

    }

    private void loadData() {

        AdaptadorProducto adapter = new AdaptadorProducto(this, listdata);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(perfiles.this, listdata.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(perfiles.this, DetalleProductoActivity.class);
                intent.putExtra("id", listdata.get(position).getId());
                startActivity(intent);
            }
        });

    }


    }









    /*    RecyclerView recicler;
    ArrayList<ItemProducto> listarecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfildeverdad);
        listarecycler = new ArrayList<ItemProducto>();
        recicler = (RecyclerView) findViewById(R.id.recyclerperfiloficial);
        recicler.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        // obtencion();
        loadData();
        adaptersperfil adapter = new adaptersperfil(getContext(), listarecycler);
        recicler.setAdapter(adapter);

    }

    private void loadData() {
        final int position = 0;
        Toast.makeText(this, "no puee entrar", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(perfiles.this, DetalleProductoActivity.class);
//        intent.putExtra("id", listarecycler.get(position).getDescripcion());
        startActivity(intent);
        if (!Data.TOKEN.equals("")) {
            AsyncHttpClient client = new AsyncHttpClient();
            client.get(Data.HOST_PRODUCT_SELLER, new JsonHttpResponseHandler() {
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            ItemProducto p = new ItemProducto();
                            JSONObject ob = response.getJSONObject(i);
                            p.setId(ob.getString("_id"));
                            p.setNombre(ob.getString("nombre"));
                            p.setDescripcion(ob.getString("descripcion"));
                            p.setCategoria(ob.getString("categoria"));
                            p.setEstado(ob.getString("estado"));
                            p.setFoto(ob.getString("foto"));
                            p.setPrecio(ob.getDouble("precio"));
                            p.setStock(ob.getInt("stock"));
                            p.setRegistro(ob.getString("fechaRegistro"));
                            p.setLat(ob.getDouble("lat"));
                            p.setLog(ob.getDouble("log"));
                            //    JSONObject obj = response.getJSONObject(i);
                            listarecycler.add(p);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }

            });
        }

    }}*/

