package com.example.tbs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tbs.Utils.Data;
import com.example.tbs.Utils.Methods;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;

import cz.msebera.android.httpclient.Header;

public class PublicarAnuncioActivity extends AppCompatActivity implements View.OnClickListener{
    EditText nombreEdit,descripcionEdit,precioEdit,stockEdit;
    Spinner categoriaSpinner,estadoSpinner;
    Double lat, log;
    TextView localizacionText;
    Button btnUbicacion, btnPublicar, btnFoto;
    ImageView fotoImage;

    String categoria,estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_anuncio);
        loadComponents();

    }

    private void loadComponents() {
        nombreEdit = findViewById(R.id.nombreEdit);
        descripcionEdit = findViewById(R.id.descripcionEdit);
        precioEdit = findViewById(R.id.precioEdit);
        stockEdit = findViewById(R.id.stockEdit);

        fotoImage = findViewById(R.id.fotoImage);

        categoriaSpinner = findViewById(R.id.categoriaSpinner);
        estadoSpinner = findViewById(R.id.estadoSpinner);

        categoriaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoria = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        estadoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                estado = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        localizacionText = findViewById(R.id.localizacionText);

        btnUbicacion =findViewById(R.id.btnMapa);
        btnPublicar =findViewById(R.id.btnPublicar);
        btnFoto =findViewById(R.id.btnFoto);

        btnUbicacion.setOnClickListener(this);
        btnFoto.setOnClickListener(this);
        btnPublicar.setOnClickListener(this);




    }

    private void publicar() {

        if (precioEdit.getText().toString().equals("") || nombreEdit.getText().toString().equals("")){
            Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
            return;
        }

        if (path == null || path == ""){
            Toast.makeText(this, "Debe seleccionar una imagen", Toast.LENGTH_SHORT).show();
            return;
        }
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();

        File file = new File(path);
        try {
            params.put("foto", file,"image/jpeg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        params.put("vendedor",Data.USER_ID);//idRestaurant
        params.put("nombre", nombreEdit.getText());
        params.put("descripcion", descripcionEdit.getText());
        params.put("stock", stockEdit.getText());

        params.put("precio", precioEdit.getText());
        params.put("categoria", categoria);
        params.put("estado", estado);
        params.put("log", log);
        params.put("lat", lat);



        client.post(Data.HOST_PRODUCT,params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    String message = response.getString("message");

                    if (message != null) {
                        Toast.makeText(PublicarAnuncioActivity.this, message, Toast.LENGTH_SHORT).show();
                        path = "";
                        nombreEdit.getText().clear();
                        descripcionEdit.getText().clear(); //limpiar
                        //getData();
                        PublicarAnuncioActivity.this.finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

                try {
                    Toast.makeText(PublicarAnuncioActivity.this,errorResponse.getString("error"),Toast.LENGTH_LONG);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFoto: cargarImagen();break;
            case R.id.btnMapa: getUbicacion();break;
            case R.id.btnPublicar:publicar();break;
        }
    }



    private void getUbicacion() {
        Intent intent = new Intent(this,ObtenerUbicacionActivity.class);
        startActivityForResult(intent,200);
    }


    //DESDE AQUI VA LA PARTE DE LA FOTO
    final int COD_GALERIA=10;
    final int COD_CAMERA=20;
    String path;
    private void cargarImagen() {

        final CharSequence[] opciones={"Tomar Foto","Galeria","Cancelar"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(PublicarAnuncioActivity.this);
        alertOpciones.setTitle("Seleccione una Opción");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")){
                    tomarFotografia();
                }else{
                    if (opciones[i].equals("Galeria")){
                        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"),COD_GALERIA);
                    }else{
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();

    }
    private void tomarFotografia() {

        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Methods.FileAndPath fileAndPath= Methods.createFile(path);
        File file = fileAndPath.getFile();
        path = fileAndPath.getPath();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri fileuri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);

            camera.putExtra(MediaStore.EXTRA_OUTPUT, fileuri);
            //BuildConfig.APPLICATION_ID + ".provider"
        } else {
            camera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        }
        startActivityForResult(camera, COD_CAMERA);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode==RESULT_OK){
            switch (requestCode){
                case COD_GALERIA:
                    Uri imgPath = data.getData();
                    fotoImage.setImageURI(imgPath);
                    path = Methods.getRealPathFromURI(this,imgPath);
                    Toast.makeText(PublicarAnuncioActivity.this, path, Toast.LENGTH_SHORT).show();
                    break;
                case COD_CAMERA:
                    Toast.makeText(PublicarAnuncioActivity.this, path, Toast.LENGTH_SHORT).show();
                    loadImageCamera();


                    break;
                case 200:
                    if (resultCode == RESULT_OK) {
                        lat = data.getDoubleExtra("lat",0.0);
                        log = data.getDoubleExtra("log",0.0);

                        localizacionText.setText("Localizacion : Ok");

                    };
            }
        }
    }


    private void loadImageCamera() {
        Bitmap img = BitmapFactory.decodeFile(path);
        if(img != null) {
            fotoImage.setImageBitmap(img);

        }
    }

}
