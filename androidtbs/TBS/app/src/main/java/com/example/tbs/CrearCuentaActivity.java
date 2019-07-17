package com.example.tbs;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tbs.Utils.Data;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class CrearCuentaActivity extends AppCompatActivity implements  View.OnClickListener{
    EditText nombreEdit, passwordEdit,repasswordEdit,emailEdit;
    Button btnMapa, btnAceptar, btnCancelar;
    Spinner tipoSpinner;
    TextView latText, logText;
    String tipo;
    Double lat,log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
    loadComponents();
    }

    private void loadComponents() {
        nombreEdit = findViewById(R.id.nombreEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        repasswordEdit = findViewById(R.id.repasswordEdit);
        emailEdit = findViewById(R.id.emailEdit);
         latText = findViewById(R.id.latText);
        logText = findViewById(R.id.logText);

        tipoSpinner = findViewById(R.id.tipoSpinner);

        tipoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipo = parent.getItemAtPosition(position).toString();
                Toast.makeText(CrearCuentaActivity.this, tipo, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        btnAceptar = findViewById(R.id.btnAceptar);
        btnMapa = findViewById(R.id.btnMapa);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnAceptar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        btnMapa.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAceptar: crearCuenta();break;
            case R.id.btnMapa: getUbicacion();break;
            case R.id.btnCancelar: cancelar();break;

        }
    }

    private void getUbicacion() {
        Intent intent = new Intent(this,ObtenerUbicacionActivity.class);
        startActivityForResult(intent,100);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 100) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                lat = data.getDoubleExtra("lat",0.0);
                log = data.getDoubleExtra("log",0.0);

                latText.setText(lat.toString());
                logText.setText(String.valueOf(log));

            }
        }
    }


    private void crearCuenta() {
        String nombre = nombreEdit.getText().toString();
        String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        String repassword = repasswordEdit.getText().toString();
        if (!password.equals(repassword)){
            Toast.makeText(this,"las contraseñas no coinciden " +password+ "-"+repassword,Toast.LENGTH_SHORT).show();
            return;
        }
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params =new RequestParams();
        params.put("email",email);
        params.put("nombre",nombre);
        params.put("password",password);
        params.put("tipo",tipo);
        params.put("lat",lat);
        params.put("log",log);

        client.post(Data.HOST_USER,params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {

                    if (response.getString("message" )!= null){
                        Toast.makeText(CrearCuentaActivity.this, response.getString("message"), Toast.LENGTH_SHORT).show();
                        CrearCuentaActivity.this.finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                try {
                    Toast.makeText(CrearCuentaActivity.this, errorResponse.getString("error"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    private void cancelar() {
        finish();
    }
}
