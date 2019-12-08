package com.example.javiermorales_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button botonLogin = null;
    TextView saludos = null;
    EditText txt_user = null;
    EditText txt_pass = null;
    Button btn_irActivity  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botonLogin = (Button)findViewById(R.id.btn_login);
        txt_user = (EditText)findViewById(R.id.edt_user);
        txt_pass = (EditText)findViewById(R.id.edt_pass);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_user.getText().toString().equals("estudiante2019") && txt_pass.getText().toString().equals("uisrael.2019")){
                    Intent intent = new Intent(view.getContext(), Registro.class);
                    intent.putExtra("userLoggedIn",txt_user.getText().toString());
                    startActivity(intent);
                }else Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_LONG).show();
            }
        });
    }
}
