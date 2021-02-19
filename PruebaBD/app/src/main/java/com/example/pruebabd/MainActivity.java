package com.example.pruebabd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button insertar;
    private Button eliminar;
    private Button modificar;
    private EditText codigo;
    private EditText nombre;
    private SQLiteDatabase db;
    private Button consul;
    private TextView ver;

    //Abrimos la base de datos 'DBUsuarios' en modo escritura
    UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuario", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=usdbh.getWritableDatabase();

        if (db != null) {
            insertar=findViewById(R.id.insertar);
            eliminar=findViewById(R.id.eliminar);
            modificar=findViewById(R.id.modificar);
            consul=findViewById(R.id.consul);
            codigo=findViewById(R.id.codigo);
            nombre=findViewById(R.id.nombre);
            ver=findViewById(R.id.ver);
            insertar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    db=usdbh.getWritableDatabase();
                    if(db!=null) {
                        ContentValues usuario = new ContentValues();
                        usuario.put("codigo", String.valueOf(codigo));
                        usuario.put("nombre", String.valueOf(nombre));
                        db.insert("Usuario", null, usuario);
                        Toast.makeText(MainActivity.this, "Usuario añadido", Toast.LENGTH_LONG).show();
                        db.close();
                    }else{
                        Toast.makeText(MainActivity.this, "No se ha podido conectar con la BD", Toast.LENGTH_LONG).show();
                    }
                }

            });

            consul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db=usdbh.getWritableDatabase();
                    if(db!=null) {
                        Cursor x = db.rawQuery("SELECT * FROM Usuario ", null);
                        ver.setText("");
                        ver.append("Codigo-" + x.getString(0));
                        db.close();
                        x.close();
                    }else{
                        Toast.makeText(MainActivity.this, "No se ha podido conectar con la BD", Toast.LENGTH_LONG).show();
                    }
                }
            });

            eliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db=usdbh.getWritableDatabase();
                    if(db!=null) {
                    ContentValues usuario=new ContentValues();
                    usuario.put("codigo", String.valueOf(codigo));
                    usuario.put("nombre", String.valueOf(nombre));
                    db.delete("Usuario","codigo="+codigo,null);
                    Toast.makeText(MainActivity.this,"Usuario Eliminado", Toast.LENGTH_LONG).show();
                    db.close();
                    }else{
                        Toast.makeText(MainActivity.this, "No se ha podido conectar con la BD", Toast.LENGTH_LONG).show();
                    }
                }
            });

            modificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        db=usdbh.getWritableDatabase();
                        if(db!=null) {
                    ContentValues usuario=new ContentValues();
                    usuario.put("nombre", String.valueOf(nombre));
                    db.update("Usuario",usuario,"codigo="+codigo,null);
                    Toast.makeText(MainActivity.this,"Usuario modificado", Toast.LENGTH_LONG).show();
                    db.close();
                }else{
                    Toast.makeText(MainActivity.this, "No se ha podido conectar con la BD", Toast.LENGTH_LONG).show();
                    db.close();
                    }
                }
            });


        }else{
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Fallo al conectar con la Base de Datos");
            builder.setTitle("Error Base de Datos");
            AlertDialog.Builder no = builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int
                        which) {
                }
            });
            builder.show();
        }
     db.close();}
}