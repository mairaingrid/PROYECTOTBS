package com.example.tbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crear_cuenta (View v){
        Intent btncrcrear_cuenta = new Intent(this, crear_cuenta.class);
        startActivity(btncrcrear_cuenta);
    }
    public void iniciar_sesion (View v){
        Intent Iniciarsesion = new Intent(this, pagina_principal.class);
        startActivity(Iniciarsesion);
    }

}


