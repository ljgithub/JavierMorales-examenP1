package com.example.javiermorales_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    Bundle datos;
    TextView userLogged = null;
    Button botonEnviar = null;
    EditText nomEst = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        userLogged = (TextView) findViewById(R.id.txt_materia2);
        botonEnviar = (Button)findViewById(R.id.btn_guardar);
        nomEst = (EditText)findViewById(R.id.edt_Nombre);

        datos = getIntent().getExtras();
        final String usuarioLogeado = datos.getString("userLoggedIn");
        userLogged.setText("Bienvenido " + usuarioLogeado);




        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Encuesta.class);
                intent.putExtra("userLogged", usuarioLogeado);
                intent.putExtra("nombreEstudiante", nomEst.getText().toString());
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Datos Guardados con Exito", Toast.LENGTH_LONG).show();
            }
        });

    }
}
