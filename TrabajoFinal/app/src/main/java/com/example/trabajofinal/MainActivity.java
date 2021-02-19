package com.example.trabajofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button listadoUsuario;
    private Button listadoIncidencia;
    private Button añadirUsuario;
    private Button añadirIncidencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listadoUsuario=findViewById(R.id.pantalla1);
        listadoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,pantalla1.class);
                startActivity(intent);
            }
        });
        listadoIncidencia=findViewById(R.id.pantalla2);
        listadoIncidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,pantalla2.class);
                startActivity(intent);
            }
        });
        añadirUsuario=findViewById(R.id.pantalla3);
        añadirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,pantalla3.class);
                startActivity(intent);
            }
        });
        añadirIncidencia=findViewById(R.id.pantalla4);
        añadirIncidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,pantalla4.class);
                startActivity(intent);
            }
        });
    }
}