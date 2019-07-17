package com.example.tbs.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tbs.R;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class chat extends AppCompatActivity {
    RecyclerView recicler ;
    ArrayList<modelschat> listarecycler;

    private EditText escribir;
    private Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        listarecycler = new ArrayList<modelschat>();
        recicler = (RecyclerView) findViewById(R.id.recycler);
        recicler.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        obtencion();
        adapterschat adapter = new adapterschat(getContext(), listarecycler);
        recicler.setAdapter(adapter);
        escribir=(EditText)findViewById(R.id.escribir);
        enviar=(Button)findViewById(R.id.send);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String mimensaje=null;

mimensaje=escribir.getText().toString();

            }
        });
    }
    public ArrayList<modelschat> obtencion() {
        List<modelschat> datos = new ArrayList<>();


        listarecycler.add(new modelschat("esaz", "telefono",""));
        listarecycler.add(new modelschat("getText", "7563",""));

        return listarecycler;

    }


}
