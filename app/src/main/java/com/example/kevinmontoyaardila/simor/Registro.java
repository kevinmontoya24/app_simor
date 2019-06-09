package com.example.kevinmontoyaardila.simor;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.gson.Gson;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity {

    EditText etnombre, etusuario, etpassword, etedad;
    Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etnombre = findViewById(R.id.EditT_nombre);
        etusuario = findViewById(R.id.EditT_usuario);
        etpassword = findViewById(R.id.EditT_password);
        etedad = findViewById(R.id.EditText_edad);

        btn_registrar = findViewById(R.id.Btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String name = etnombre.getText().toString();
                final String username = etusuario.getText().toString();
                final String password = etpassword.getText().toString();
                final int age = Integer.parseInt(etedad.getText().toString());

                Response.Listener<String> respoListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Gson g = new Gson();
                            JSONObject jsonReponse = new JSONObject(response);
                            boolean success = jsonReponse.getBoolean("success");

                            if (success == true) {
                                Intent intent = new Intent(Registro.this, MainActivity.class);
                                Registro.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                                builder.setMessage("Error de Registro")
                                        .setNegativeButton("Retry", null)
                                        .create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, respoListener);
                RequestQueue queue = Volley.newRequestQueue(Registro.this);
                queue.add(registerRequest);

            }
        });
    }
}
