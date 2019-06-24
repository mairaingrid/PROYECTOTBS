package com.example.tbs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tbs.Utils.Data;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

import cz.msebera.android.httpclient.Header;

public class DetalleProductoActivity extends AppCompatActivity implements OnMapReadyCallback {

    TextView nombreText,descripcionText,categoriaText,estadoText,precioText,stockText,fechaText;
    ImageView fotoImage;
    GoogleMap mMap;
    MapView mapView;
    ItemProducto p = new ItemProducto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        loadComponents();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
            String id = intent.getExtras().getString("id");
            getData(id);
        }
         
    }

    private void loadComponents() {
        fotoImage =  findViewById(R.id.fotoImage);
        nombreText =   findViewById(R.id.nombreText);
        descripcionText = findViewById(R.id.descripcionText);
        categoriaText = findViewById(R.id.categoriaText);
        precioText = findViewById(R.id.precioText);
        stockText = findViewById(R.id.stockText);
        estadoText = findViewById(R.id.estadoText);
        fechaText = findViewById(R.id.fechaText);





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
                    p.setPrecio(ob.getDouble("precio"));
                    p.setStock(ob.getInt("stock"));
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


        nombreText.setText("Nombre : " + p.getNombre());

        descripcionText.setText("Descripcion : " + p.getDescripcion());
        categoriaText.setText("Categoria : " + p.getCategoria());
        estadoText.setText("Estado : " + p.getEstado());
        precioText.setText("Precio : " + String.valueOf(p.getPrecio()));
        stockText.setText( "Stock : " + String.valueOf(p.getStock()));
        fechaText.setText( "Fecha registro : " + p.getRegistro());
        Glide.with(this).load(Data.IP + p.getFoto()).into(fotoImage);
        loadDataMap();
    }

    private void loadDataMap() {
        LatLng ubicacion = new LatLng(p.getLat(),p.getLog());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,18));
        mMap.addMarker(new MarkerOptions().position(ubicacion).title("Ubicacion de " + p.getNombre()));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Toast.makeText(this, "ok mapa", Toast.LENGTH_SHORT).show();

    }
}
