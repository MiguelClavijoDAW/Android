package com.example.proyectos_consultas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText codigo;
    private EditText nombre;
    private Button insertar;
    private Button eliminar;
    private Button modificar;
    private Button consulta;
    UsuariosSQLiteHelper usdbh=new UsuariosSQLiteHelper(this,"DBUsuarios",null,1);
    private SQLiteOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=usdbh.getWritableDatabase();
        setContentView(R.layout.activity_main);
        codigo=findViewById(R.id.codigo);
        nombre=findViewById(R.id.nombre);
        insertar=findViewById(R.id.insertar);
        eliminar=findViewById(R.id.eliminar);
        modificar=findViewById(R.id.modificar);
        consulta=findViewById(R.id.consulta);



    }
}