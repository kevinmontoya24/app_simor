package com.example.kevinmontoyaardila.simor;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText et_usuario, et_password, et_UsuarioC, et_passwordC;
    TextView tv_registrar;
    Button btn_registrar;
    Button btn_log;

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_usuario=(EditText) findViewById(R.id.TV_usu);
        et_password= (EditText) findViewById(R.id.TV_pass);
        et_UsuarioC = (EditText) findViewById(R.id.TV_usu);
        et_passwordC = (EditText) findViewById(R.id.TV_pass);
        btn_log = (Button) findViewById(R.id.btn_log);

        tv_registrar = findViewById(R.id.tv_registrar);
        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this,T_Registar_C.class);
                MainActivity.this.startActivity(intentReg);
            }
        });
            btn_log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String username = et_usuario.getText().toString();
                    final String password = et_password.getText().toString();
                    final String UsernameC = et_UsuarioC.getText().toString();
                    final String passwordC = et_passwordC.getText().toString();

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try{
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    String name = jsonResponse.getString("name");
                                    int age  = jsonResponse.getInt("age");

                                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                                    intent.putExtra("name", name);
                                    intent.putExtra("username", username);
                                    intent.putExtra("age", age);
                                    intent.putExtra("password", password);

                                    MainActivity.this.startActivity(intent);
                                }else{
                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                    builder.setMessage("Error de Login")
                                            .setNegativeButton("Retry", null)
                                            .create().show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    queue.add(loginRequest);

                    //----
                    Response.Listener<String> responseListenerC = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String responseC) {
                            try{
                                JSONObject jsonResponseC = new JSONObject(responseC);
                                boolean success = jsonResponseC.getBoolean("success");
                                if (success) {
                                    String nameC = jsonResponseC.getString("nameC");
                                    int ageC  = jsonResponseC.getInt("ageC");

                                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                                    intent.putExtra("nameC", nameC);
                                    intent.putExtra("username", username);
                                    intent.putExtra("ageC", ageC);
                                    intent.putExtra("password", password);

                                    MainActivity.this.startActivity(intent);
                                }else{
                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                    builder.setMessage("Error de Login")
                                            .setNegativeButton("Retry", null)
                                            .create().show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    LoginRequestC loginRequestC = new LoginRequestC(UsernameC, passwordC, responseListenerC);
                    RequestQueue queueC = Volley.newRequestQueue(MainActivity.this);
                    queueC.add(loginRequestC);

                }
            });



    }
}
