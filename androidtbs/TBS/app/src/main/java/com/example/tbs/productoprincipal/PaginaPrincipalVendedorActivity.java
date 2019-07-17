package com.example.tbs.productoprincipal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.tbs.DetalleProductoActivity;
import com.example.tbs.PublicarAnuncioActivity;
import com.example.tbs.R;
import com.example.tbs.Utils.Data;
import com.example.tbs.perfiles.perfiles;
import com.example.tbs.misamigos;
import com.example.tbs.misanuncios;
import com.example.tbs.citas.miscitas;
import com.example.tbs.misfavoritos;
import com.example.tbs.personas.personas;
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
import androidx.fragment.app.FragmentTransaction;

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

public class PaginaPrincipalVendedorActivity extends AppCompatActivity //AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener/*,
        com.example.tbs.misanuncios.OnFragmentInteractionListener,
        com.example.tbs.citas.miscitas.OnFragmentInteractionListener,
        com.example.tbs.misfavoritos.OnFragmentInteractionListener,
        com.example.tbs.misamigos.OnFragmentInteractionListener */{


    misamigos  misamigos;
    misfavoritos misfavoritos;
    misanuncios misanuncios;
    miscitas miscitas;
  private ArrayList<models> listdata;
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
        misanuncios = new misanuncios();
        misfavoritos = new misfavoritos();
        misamigos = new misamigos();
        miscitas = new miscitas();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);


        loadComponets();
        if (Data.USER_ID != "") {
            getData();
        } else {
            Toast.makeText(this, Data.USER_ID, Toast.LENGTH_LONG).show();
        }
    }
/*

   // private void loadComponets() {
   //    list = findViewById(R.id.listview);


    //    listdata = new ArrayList<>();

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



    private void loadComponets() {
        list = findViewById(R.id.listaperfil);


        listdata = new ArrayList<models>();
    }

    public void clickfragments(View v){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        switch (v.getId()){
            case R.id.btnmisanuncios:
                transaction.replace(R.id.contenedoroficial,misanuncios);
                break;
            case R.id.btnmisfavoritos:
                transaction.replace(R.id.contenedoroficial,misfavoritos);
                break;

            case R.id.btnmisamigos:
                transaction.replace(R.id.contenedoroficial,misamigos);
                break;
            case R.id.btnmiscitas:
                transaction.replace(R.id.contenedoroficial,miscitas);
                break;
        }
        transaction.commit();
    }
    private void getData() {

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(Data.HOST_PRODUCT_SELLER + Data.USER_ID,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray data = response.getJSONArray("data");
                    for(int i = 0; i<data.length();i++){
                       models p = new models();
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
                    //    p.setLat(ob.getDouble("lat"));
                      //  p.setLog(ob.getDouble("log"));

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

        adapters adapter = new adapters(this, listdata);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(PaginaPrincipalVendedorActivity.this, listdata.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PaginaPrincipalVendedorActivity.this, DetalleProductoActivity.class);
                intent.putExtra("id",listdata.get(position).getId());
                startActivity(intent);
            }
        });}



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
    //@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.publicaranuncio) {
            // Handle the camera action
            Intent publicar_anuncio = new Intent(this, PublicarAnuncioActivity.class);
            startActivity(publicar_anuncio);


        } else if (id == R.id.nav_mismensajes) {
           Intent mismensajes= new Intent(this, personas.class);
            startActivity(mismensajes);

        } else if (id == R.id.nav_misfavoritos) {

        } else if (id == R.id.mi_perfil) {
            Intent irperfil = new Intent (this, perfiles.class);
            startActivity(irperfil);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onFragmentInteraction(Uri uri) {

    }
}
