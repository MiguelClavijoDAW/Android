package com.example.a34;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class Formulario extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido1;
    private EditText apellido2;
    private EditText edad;
    private Button agregar;
    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nombre=findViewById(R.id.nombre);
        apellido1=findViewById(R.id.apellido1);
        apellido2=findViewById(R.id.Apellido2);
        edad=findViewById(R.id.edad);
        gson=new Gson();
        Bundle extra=getIntent().getExtras();
        agregar=findViewById(R.id.agregar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom=nombre.getText().toString();
                if(!nom.equals("")){

                }else{
                    Toast.makeText(Formulario.this,"El campo nombre es Obligatorio",Toast.LENGTH_LONG);
                }
            }
        });
    }
}