package com.example.javiermorales_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class Resumen extends AppCompatActivity {

    Bundle data =  null;

    HashMap payload  = null;

    TextView saludo = null;
    String usuarioLogeado="";
    String nombreEstudiante = "";


    TextView resp1 = null;
    TextView resp2 = null;
    TextView resp3 = null;
    TextView nombreEst = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        resp1= (TextView)findViewById(R.id.txt_resp1);
        resp2= (TextView)findViewById(R.id.txt_resp2);
        resp3= (TextView)findViewById(R.id.txt_resp3);


        saludo = (TextView)findViewById(R.id.txt_materia4);

        data = getIntent().getExtras();

        /*Recupero la info cargada desde la Encuesta*/
        payload = (HashMap) data.getSerializable("payload");


        /*Extraido el usuario que viene seteado desde el bundle de Registro*/
        data.getString("userLogged");
        usuarioLogeado = payload.get("userLogged").toString();
        data.getString("nombreEstudiante");
        nombreEstudiante = payload.get("nombreEstudiante").toString();

        nombreEst.setText(nombreEstudiante);
        saludo.setText(usuarioLogeado);
        cargarData();

    }

    private void cargarData() {

        resp1.setText((CharSequence) payload.get("respuesta1"));
        StringBuilder frase = new StringBuilder();
        String respuesta2 ="";
        if(payload.containsKey("check1")){
            frase.append((CharSequence) payload.get("check1").toString());
            frase.append(" - ");
        }if(payload.containsKey("check2")){
            frase.append((CharSequence) payload.get("check2").toString());
            frase.append(" - ");
        }
        if(payload.containsKey("check3")){
            frase.append((CharSequence) payload.get("check3").toString());
            frase.append(" - ");
        }

        respuesta2 = frase.toString();
        resp2.setText(respuesta2);
        resp3.setText((CharSequence) payload.get("p3"));
    }
}
