package com.example.tbs;

import android.content.Intent;
import android.os.Bundle;

import com.example.tbs.Utils.Data;
import com.example.tbs.perfiles.ItemProducto;
import com.example.tbs.productoprincipal.PaginaPrincipalVendedorActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class EditarProductoActivity extends AppCompatActivity {

    private ImageView fotoImage;
    private EditText nombreEdit,descripcionEdit, precioEdit, stockEdit;
    Button btnGuardar;
    String id ;
    ItemProducto p = new ItemProducto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        loadComponents();

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
            id = intent.getExtras().getString("id");
            getData(id);
        }

    }


    private void loadComponents() {

        nombreEdit =   findViewById(R.id.nombreEdit);
        descripcionEdit = findViewById(R.id.descripcionEdit);
        //categoriaEdit = findViewById(R.id.categoriaEdit);
        precioEdit = findViewById(R.id.precioEdit);
        stockEdit = findViewById(R.id.stockEdit);
        //estadoEdit = findViewById(R.id.estadoEdit);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient client= new AsyncHttpClient();
                client.patch(Data.HOST_PRODUCT  + id,new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject ob) {


                        try {

                            if (ob.getString("message") != null){
                                Toast.makeText(EditarProductoActivity.this, ob.getString("message"), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(EditarProductoActivity.this, PaginaPrincipalVendedorActivity.class);
                                startActivity(intent);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        try {
                            if (errorResponse.get("error") != null){
                                Toast.makeText(EditarProductoActivity.this, errorResponse.get("error").toString(), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });


    }

    private void getData(String id) {
        AsyncHttpClient client= new AsyncHttpClient();
        client.get(Data.HOST_PRODUCT + "/" + id,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject ob) {


                try {


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

                    setData();


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

    private void setData() {
        Toast.makeText(this, Data.IP + p.getFoto(), Toast.LENGTH_SHORT).show();


        nombreEdit.setText(p.getNombre());

        descripcionEdit.setText(p.getDescripcion());
       // categoriaText.setText( p.getCategoria());
        //estadoText.setText(p.getEstado());
        precioEdit.setText(p.getPrecio().toString());
        stockEdit.setText( p.getStock().toString());

    }
}
