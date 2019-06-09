package com.example.kevinmontoyaardila.simor;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroC extends AppCompatActivity implements View.OnClickListener {

    EditText etnombreC, etusuarioC, etpasswordC, etedadC, etcuentaBC, etPlacaC, etSOATC, etmarcasC, etmodeloC;
    Button btn_registrarC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_c);

        etnombreC = findViewById(R.id.EditT_nomC);
        etusuarioC = findViewById(R.id.EditT_usuC);
        etpasswordC = findViewById(R.id.EditT_passC);
        etedadC = findViewById(R.id.EditText_ageC);
        etcuentaBC = findViewById(R.id.EditT_bancaria);
        etPlacaC = findViewById(R.id.EditT_placa);
        etSOATC = findViewById(R.id.EditT_soat);
        etmarcasC = findViewById(R.id.EditT_marca);
        etmodeloC = findViewById(R.id.EditT_modelo);

        btn_registrarC = findViewById(R.id.Btn_registroC);

        btn_registrarC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final String nameC=etnombreC.getText().toString();
        final String UsernameC=etusuarioC.getText().toString();
        final String passwordC =etpasswordC.getText().toString();
        final int ageC= Integer.parseInt(etedadC.getText().toString());
        final int CtoBancaria = Integer.parseInt(etcuentaBC.getText().toString());
        final String Placa=etPlacaC.getText().toString();
        final String SOAT=etSOATC.getText().toString();
        final String MarcaVh=etmarcasC.getText().toString();
        final String ModeloVh=etmodeloC.getText().toString();


        RegisterRequestC registerRequestC = new RegisterRequestC(nameC, UsernameC, ageC, passwordC, CtoBancaria, Placa, SOAT, MarcaVh, ModeloVh, new Response.Listener<String>() {
            @Override
            public void onResponse(String responseC) {
                try {
                    JSONObject jsonReponseC = new JSONObject(responseC);
                    boolean success = jsonReponseC.getBoolean("success");

                    if (success) {
                        Intent intentC = new Intent(RegistroC.this, MainActivity.class);
                        RegistroC.this.startActivity(intentC);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegistroC.this);
                        builder.setMessage("Error de Registro")
                                .setNegativeButton("Retry", null)
                                .create().show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistroC.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //RegisterRequestC registerRequestC = new RegisterRequestC(nameC, UsernameC, ageC, passwordC, CtoBancaria, Placa, SOAT, MarcaVh, ModeloVh, respoListenerC);
        RequestQueue queueC = Volley.newRequestQueue(RegistroC.this);
        queueC.add(registerRequestC);

    }
}
