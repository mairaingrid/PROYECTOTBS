package com.example.tbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class subir_foto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subir_foto);
    }

    public void irpublicar(View v) {
        Intent ir_publicar= new Intent(this, publicar_anuncio.class);
        startActivity(ir_publicar);

    }
}