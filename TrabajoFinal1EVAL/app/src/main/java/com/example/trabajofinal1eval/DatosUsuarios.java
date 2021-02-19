package com.example.trabajofinal1eval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosUsuarios extends AppCompatActivity {
    private TextView nombre;
    private TextView apellidos;
    private TextView telefono;
    private TextView email;
    private TextView fecha;
    private TextView sexo;
    private TextView intereses;
    private Button enviar;
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuarios);


        nombre=findViewById(R.id.textnombre);
        apellidos=findViewById(R.id.textapellidos);
        telefono=findViewById(R.id.texttelefono);
        email=findViewById(R.id.textemail);
        fecha=findViewById(R.id.textfecha);
        sexo=findViewById(R.id.textsexo);
        intereses=findViewById(R.id.textintreses);
        nombre.setText(getIntent().getExtras().getString("nombre"));
        apellidos.setText(getIntent().getStringExtra("apellidos"));
        telefono.setText(getIntent().getStringExtra("telefono"));
        email.setText(getIntent().getStringExtra("email"));
        fecha.setText(getIntent().getStringExtra("fecha"));
        sexo.setText(getIntent().getStringExtra("sexo"));
        intereses.setText(getIntent().getStringExtra("intereses"));
        enviar=findViewById(R.id.menu);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DatosUsuarios.this,MainActivity.class);
                startActivity(intent);
            }
        });
        volver=findViewById(R.id.volver2);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DatosUsuarios.this,formulario.class);
                startActivity(intent);
            }
        });
    }
}