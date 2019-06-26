package com.example.tbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class chatprincipal extends AppCompatActivity {
    Integer image;
    String descrip, title;

    ImageView image2;
    TextView descrip2, title2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatprincipal);


        //llamada a datos del chat
        /**colocar valores
*/      image2=findViewById(R.id.imgenchat);
        descrip2=findViewById(R.id.adicional);
        title2=findViewById(R.id.title);

        image=getIntent().getIntExtra("img",0);
        descrip=getIntent().getStringExtra("adicional");
        title=getIntent().getStringExtra("title");

        image2.setImageResource(image);
        descrip2.setText(descrip);
        title2.setText(title);
    }
}
