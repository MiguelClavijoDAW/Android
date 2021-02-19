package com.example.trabajofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class pantalla3 extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText dni;
    private EditText usuario;
    private EditText pass;
    private EditText foto;
    private CheckBox perfil;
    private Button añadirUsuario;
    private SQLiteOpenHelper usdbh;
    private SQLiteDatabase db;
    private int aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);
        usdbh=new TrabajoFinalSQLiteHelper(this,"DBtf",null,1);
        nombre=findViewById(R.id.nombre);
        apellido=findViewById(R.id.apellido);
        dni=findViewById(R.id.dni);
        usuario=findViewById(R.id.usuario);
        pass=findViewById(R.id.pass);
        foto=findViewById(R.id.foto);
        perfil=findViewById(R.id.admin);
        añadirUsuario=findViewById(R.id.AñadirUsuario);
        db=usdbh.getWritableDatabase();
        añadirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db!=null){
                    if(perfil.isChecked()){
                        aux=1;
                    }else{
                        aux=0;
                    }
                    db.execSQL("INSERT INTO usuario (nombre,apellido,dni,usuario,contraseña,perfil,foto) VALUES (\'"+nombre.getText()+"\',\'"+apellido.getText()+"\',\'"+dni.getText()+"\',\'"+usuario.getText()+"\',\'"+pass.getText()+"\',"+aux+",\'"+foto.getText()+"\')");
                    db.close();
                }else{
                    Toast.makeText(pantalla3.this, "No se ha podido conectar con la BD", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}