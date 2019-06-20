package com.example.tbs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class subir_foto extends AppCompatActivity implements View.OnClickListener {
    ImageView imagen;
   /* ImageView imagenadicional1;
    ImageView imagenadicional2;
    ImageView imagenadicional3;*/
    Button galeria;
    int movil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subir_foto);
      imagen = (ImageView) findViewById(R.id.imagenprincipal);
      /*  imagenadicional1 = (ImageView) findViewById(R.id.imagenadicional1);
        imagenadicional2 = (ImageView) findViewById(R.id.imagenadicional2);
        imagenadicional3 = (ImageView) findViewById(R.id.imagenadicional3);*/
        galeria = (Button) findViewById(R.id.galeria);

      /*  imagenadicional1.setOnClickListener(this);
        imagenadicional2.setOnClickListener(this);
        imagenadicional3.setOnClickListener(this);*/

    }

  /*  public void irpublicar(View v) {
        Intent ir_publicar= new Intent(this, publicar_anuncio.class);
        startActivity(ir_publicar);

    }*/
    @Override
    public void onClick(View v){
        galeria();
        //esto hace que la imAGEN chica al seleccionarse tiene que actualizarse en la principal
        /*switch (v.getId()){
            case R.id.imagenadicional1:
               imagenprincipal.setImageResource(R.mipmap.image1);
               movil = R.mipmap.image1;
               break;

            case R.id.imagenadicional2:
                imagenprincipal.setImageResource(R.mipmap.image2);
                movil = R.mipmap.image2;

                break;

            case R.id.imagenadicional3:
                imagenprincipal.setImageResource(R.mipmap.image3);
                movil = R.mipmap.image3;

                break;
            case R.id.subirfoto:
                Bitmap imagen = BitmapFactory.decodeStream(getResources().openRawResource(movil));
                try {
                    getApplicationContext().setWallpaper(imagen);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast mensaje = Toast.makeText(this, "que funione",Toast.LENGTH_SHORT);
                mensaje.show();

                break;

*/
        }

    @SuppressLint("IntentReset")
    private void galeria() {
        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"seleccionxcxces"),90);

    }
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if (RESULT_OK==resultCode){
            Uri path=data.getData();
            imagen.setImageURI(path);
        }

}
}