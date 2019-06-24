package com.example.tbs;

import android.content.Intent;
import android.os.Bundle;

import com.example.tbs.Utils.Data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class PaginaPrincipalVendedorActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<ItemProducto> listdata;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal_vendedor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        loadComponets();
        if (Data.USER_ID != ""){
            getData();
        }else{
            Toast.makeText(this, Data.USER_ID, Toast.LENGTH_LONG).show();
        }
    }


    private void loadComponets() {
        list = findViewById(R.id.listview);


        listdata = new ArrayList<>();

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

        client.get(Data.HOST_PRODUCT_SELLER + Data.USER_ID,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray data = response.getJSONArray("data");
                    for(int i = 0; i<data.length();i++){
                        ItemProducto p = new ItemProducto();
                        JSONObject ob = data.getJSONObject(i);
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

    private void loadData (){

        AdaptadorProducto adapter = new AdaptadorProducto(this, listdata);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(PaginaPrincipalVendedorActivity.this, listdata.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PaginaPrincipalVendedorActivity.this,DetalleProductoActivity.class);
                intent.putExtra("id",listdata.get(position).getId());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pagina_principal_vendedor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_logout) {
            Data.TOKEN = "";
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.publicaranuncio) {
            // Handle the camera action
            Intent publicar_anuncio = new Intent(this, PublicarAnuncioActivity.class);
            startActivity(publicar_anuncio);


        } else if (id == R.id.nav_mismensajes) {
       //     Intent mismensajes= new Intent(this,mimensajes.class);
           // startActivity(mismensajes);

        } else if (id == R.id.nav_misfavoritos) {

        } else if (id == R.id.mi_perfil) {
            Intent irperfil = new Intent (this, miperfil.class);
            startActivity(irperfil);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
