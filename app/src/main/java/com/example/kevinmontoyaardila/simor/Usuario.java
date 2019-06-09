package com.example.kevinmontoyaardila.simor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {
    TextView tvNombre, tvUsuarios, tvEdad, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        tvNombre = findViewById(R.id.TextV_nombre);
        tvUsuarios = findViewById(R.id.TextV_usuario);
        tvEdad = findViewById(R.id.TextV_edad);
        tvPassword = findViewById(R.id.TextV_password);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        int age = intent.getIntExtra("age",-1);

        tvNombre.setText(name);
        tvUsuarios.setText(username);
        tvPassword.setText(password);
        tvEdad.setText(age+"");
    }
}
