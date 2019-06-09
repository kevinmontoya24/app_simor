package com.example.kevinmontoyaardila.simor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class T_Registar_C extends AppCompatActivity {
    TextView BtnRegistro_U;
    TextView BtnRegistro_C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t__registar__c);

        BtnRegistro_U=findViewById(R.id.BtnRegistro_U);
        BtnRegistro_U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(T_Registar_C.this,Registro.class);
                T_Registar_C.this.startActivity(intentReg);
            }
        });

        BtnRegistro_C=findViewById(R.id.BtnRegistro_C);
        BtnRegistro_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(T_Registar_C.this,RegistroC.class);
                T_Registar_C.this.startActivity(intentReg);
            }
        });
    }
}
