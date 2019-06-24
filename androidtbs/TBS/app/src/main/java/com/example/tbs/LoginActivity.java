package com.example.tbs;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tbs.Utils.Data;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends AppCompatActivity  {
    EditText emailEdit, passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadComponents();
    }

    private void loadComponents() {
        emailEdit = findViewById(R.id.emailEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
    }

    public void crear_cuenta (View v){
        Intent btncrcrear_cuenta = new Intent(this, CrearCuentaActivity.class);
        startActivity(btncrcrear_cuenta);
    }
    public void iniciar_sesion (View v){
        if (emailEdit.getText().toString().isEmpty() || passwordEdit.getText().toString().isEmpty() ){
            Toast.makeText(this, "Los camposno puedene estar vacios", Toast.LENGTH_SHORT).show();
            return;
        }
        String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put("email",email);
        params.put("password",password);

        client.post(Data.HOST_USER_LOGIN,params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    String message = response.getString("message");
                    if (message != null){
                        Toast.makeText(LoginActivity.this,message , Toast.LENGTH_SHORT).show();
                        Data.TOKEN = response.getString("token");
                        Data.USER_ID = response.getString("idUsuario");
                        if (response.getString("tipo") == "comprador") {
                            Intent Iniciarsesion = new Intent(LoginActivity.this, PaginaPrincipalCompradorActivity.class);
                            startActivity(Iniciarsesion);
                        }else{
                            Intent Iniciarsesion = new Intent(LoginActivity.this, PaginaPrincipalVendedorActivity.class);
                            startActivity(Iniciarsesion);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    Toast.makeText(LoginActivity.this, errorResponse.getString("error"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }

}


