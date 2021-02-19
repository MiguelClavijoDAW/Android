package com.example.trabajofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class pantalla1 extends AppCompatActivity {
    private EditText busquedadni;
    private EditText busquedanombre;
    private Button boton;
    private TextView verUsuario;
    private SQLiteOpenHelper usdbh;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        usdbh=new TrabajoFinalSQLiteHelper(this,"DBtf",null, 1);
        busquedadni=findViewById(R.id.busquedadni);
        busquedanombre=findViewById(R.id.busquedaNombre);
        boton=findViewById(R.id.botonBusqueda);
        verUsuario=findViewById(R.id.verUsuario);
       // verUsuario.setText("");
        db=usdbh.getWritableDatabase();
        if(db!=null){
            String sql="SELECT * FROM usuario";
            Cursor c= db.rawQuery(sql,null);
            if(c.moveToFirst()){
                do{
                    String nom=c.getString(1);
                    String dni=c.getString(3);
                    verUsuario.append("Nombre: "+nom+" DNI: "+dni+"\n");
                }while (c.moveToNext());
                db.close();
            }
        }else{
            Toast.makeText(this, "No se ha podido conectar con la BD", Toast.LENGTH_LONG).show();
        }


    }
}