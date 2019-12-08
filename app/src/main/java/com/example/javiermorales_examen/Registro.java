package com.example.javiermorales_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Registro extends AppCompatActivity {

    Bundle datos;
    TextView userLogged = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        userLogged = (TextView) findViewById(R.id.txt_materia2);

        datos = getIntent().getExtras();
        String usuarioLogeado = datos.getString("userLoggedIn");
        userLogged.setText("Bienvenido " + usuarioLogeado);



    }
}
