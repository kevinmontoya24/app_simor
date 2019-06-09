package com.example.kevinmontoyaardila.simor;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequestC extends StringRequest {
    private static final String LOGIN_REQUEST_URL="https://simorprueba.000webhostapp.com/LoginC.php";
    private Map<String,String> params;
    public LoginRequestC( String UsernameC, String passwordC, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params=new HashMap<>();

        params.put("UsernameC", UsernameC);
        params.put("passwordC", passwordC);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

