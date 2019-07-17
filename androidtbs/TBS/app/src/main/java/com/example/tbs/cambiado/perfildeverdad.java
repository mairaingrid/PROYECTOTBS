package com.example.tbs.cambiado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tbs.DetalleProductoActivity;
import com.example.tbs.perfiles.ItemProducto;
import com.example.tbs.R;
import com.example.tbs.Utils.Data;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

import static java.security.AccessController.getContext;

public class perfildeverdad extends AppCompatActivity {
    RecyclerView recicler;
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
       // recicler.setAdapter(adapter);

    }

    private void loadData() {
        final int position = 0;
        Toast.makeText(this, "no puee entrar", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(perfildeverdad.this, DetalleProductoActivity.class);
        intent.putExtra("id", listarecycler.get(position).getDescripcion());
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
                            p.setPrecio(ob.getString("precio"));
                            p.setStock(ob.getString("stock"));
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

        // AdaptadorProducto adapter = new AdaptadorProducto(this, listarecycler);

        //  recicler.setAdapter(adapter);

        //     recicler.setOnClickListener(new AdapterView.OnItemClickListener(){



          /*  @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(perfildeverdad.this,listarecycler.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(perfildeverdad.this, DetalleProductoActivity.class);
                intent.putExtra("id",listarecycler.get(position).getDescripcion());
                startActivity(intent);
            }

        });

    }
  */
 /*    private void getData(){

          AsyncHttpClient client = new AsyncHttpClient();

          client.get(Data.HOST_PRODUCT_SELLER + Data.USER_ID, new JsonHttpResponseHandler() {
              @Override
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
                          p.setFoto(ob.getInt("foto"));
                          p.setPrecio(ob.getDouble("precio"));
                          p.setStock(ob.getInt("stock"));
                          p.setRegistro(ob.getString("fechaRegistro"));
                          p.setLat(ob.getDouble("lat"));
                          p.setLog(ob.getDouble("log"));

                          listarecycler.add(p);
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
  }*/
    }
}
