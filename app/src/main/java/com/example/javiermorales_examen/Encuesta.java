package com.example.javiermorales_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;

public class Encuesta extends AppCompatActivity {


    EditText edtResp1 = null;
    CheckBox ch1P1 = null;
    CheckBox ch2P1 = null;
    CheckBox ch3P1 = null;

    RadioGroup grupo = null;
    RadioButton rb1 = null;
    RadioButton rb2 = null;

    Bundle datos = null;
    Button btnEnviar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        edtResp1 = (EditText)findViewById(R.id.edt_resp1);
        btnEnviar =(Button)findViewById(R.id.btn_Enviar);

        ch1P1 = (CheckBox)findViewById(R.id.cb1_q2);
        ch2P1 = (CheckBox)findViewById(R.id.cb2_q2);
        ch3P1 = (CheckBox)findViewById(R.id.cb3_q2);

        grupo = (RadioGroup)findViewById(R.id.grupo1);
        rb1 = (RadioButton)findViewById(R.id.rb1_q3);
        rb2 = (RadioButton)findViewById(R.id.rb2_q3);



        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Resumen.class);
                HashMap payload =  obtenerDatos();
                intent.putExtra("payload", payload);
                startActivity(intent);
            }
        });

    }

    private HashMap obtenerDatos() {
        HashMap data = new HashMap();
        String userLogged = "";
        String nombreEstudianet = "";


        datos = getIntent().getExtras();


        String respuesta1 = edtResp1.getText().toString();
        data.put("respuesta1", respuesta1);


        if (ch1P1.isChecked()){
            data.put("check1", ch1P1.getText().toString());
        }
        if (ch2P1.isChecked()){
            data.put("check2", ch2P1.getText().toString());
        }
        if (ch3P1.isChecked()){
            data.put("check3", ch3P1.getText().toString());
        }

        int gruposSelected = grupo.getCheckedRadioButtonId();

        if (gruposSelected>0){
            View vSelected= grupo.findViewById(gruposSelected);
            int indice = grupo.indexOfChild(vSelected);
            RadioButton rb = (RadioButton)  grupo.getChildAt(indice);
            data.put("p3",rb.getText().toString());
        }

        userLogged = datos.getString("userLogged");
        nombreEstudianet = datos.getString("nombreEstudiante");

        data.put("userLogged",userLogged);
        data.put("nombreEstudiante",nombreEstudianet);

        return data;

    }
}
