package com.example.kevinmontoyaardila.simor;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequestC extends StringRequest {
//https://localhost/simor_prueba/RegisterC.php
    private static final String REGISTER_REQUEST_URL="https://simorprueba.000webhostapp.com/RegisterC.php";
    private Map<String, String> params;

    public RegisterRequestC(String nameC, String UsernameC, int ageC,String passwordC,int CtoBancaria, String Placa, String SOAT,String MarcaVh,String ModeloVh, Response.Listener<String> listener, Response.ErrorListener error){
        super(Method.POST, REGISTER_REQUEST_URL, listener, error);
        params = new HashMap<>();
        params.put("nameC", nameC);
        params.put("UsernameC", UsernameC);
        params.put("ageC", ageC+"");
        params.put("passwordC", passwordC);
        params.put("CtoBancaria", CtoBancaria+"");
        params.put("Placa", Placa);
        params.put("SOAT", SOAT);
        params.put("MarcaVh", MarcaVh);
        params.put("ModeloVh", ModeloVh);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
