package com.example.tbs.favoritos;

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
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class favoritoss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritoss);

        loadComponets();
        if (Data.USER_ID != "") {
            getData();
        } else {
            Toast.makeText(this, Data.USER_ID, Toast.LENGTH_LONG).show();
        }

    }

    private ArrayList<modelsmisfavoritos> listdata;
    ListView list;




    private void loadComponets() {
        list = findViewById(R.id.listafavorito);


        listdata = new ArrayList<modelsmisfavoritos>();



    }

    private void getData() {

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(Data.HOST_PRODUCT_SELLER + Data.USER_ID, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray data = response.getJSONArray("data");
                    for (int i = 0; i < data.length(); i++) {
                        modelsmisfavoritos p = new modelsmisfavoritos();
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

        adaptersmisfavoritos adapter = new adaptersmisfavoritos(this, listdata);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(favoritoss.this, listdata.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(favoritoss.this, DetalleProductoActivity.class);
                intent.putExtra("id", listdata.get(position).getId());
                startActivity(intent);
            }
        });

    }


}
