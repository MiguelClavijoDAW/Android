package com.example.trabajofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class pantalla3 extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText dni;
    private EditText usuario;
    private EditText pass;
    private Button seleccionar;
    private CheckBox perfil;
    private Button añadirUsuario;
    private SQLiteOpenHelper usdbh;
    private SQLiteDatabase db;
    private int aux;
    private static final int COD_SELECCIONA=20;

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
        seleccionar=findViewById(R.id.selecFoto);
        seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] opciones={"Foto","Galeria","Cancelar"};
                final AlertDialog.Builder builder=new AlertDialog.Builder(pantalla3.this);

                builder.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     if(opciones[which].equals("Foto")){
                       /* try {
                            abrirCamara();
                        }catch (IOException e){
                            e.printStackTrace();
                        }*/
                     }else if(opciones[which].equals("Galeria")){
                         Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                         intent.setType("image/");
                         startActivityForResult(intent.createChooser(intent,"Seleccione"),COD_SELECCIONA);
                     }else{
                         dialog.dismiss();
                     }
                    }
                });
            }
        });
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
                    db.execSQL("INSERT INTO usuario (nombre,apellido,dni,usuario,contraseña,perfil,foto) VALUES (\'"+nombre.getText()+"\',\'"+apellido.getText()+"\',\'"+dni.getText()+"\',\'"+usuario.getText()+"\',\'"+pass.getText()+"\',"+aux+",\'\')");
                    db.close();
                }else{
                    Toast.makeText(pantalla3.this, "No se ha podido conectar con la BD", Toast.LENGTH_LONG).show();
                }
            }
        });

        /*public void abrirCamara() {

        }*/

    }
}