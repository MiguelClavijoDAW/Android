package com.example.a33;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button tostada;
    private Button boton2;
    private Button boton3;
    private TextView texto;
    private int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto=findViewById(R.id.textView);
        tostada=findViewById(R.id.tostada);
        boton2=findViewById(R.id.snackbar);
        boton3=findViewById(R.id.dialogo);
        tostada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ejemplo de tostada",Toast.LENGTH_LONG).show();
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton2.setEnabled(false);
                Snackbar snack= Snackbar.make(v,"pruebas de Snackbar", BaseTransientBottomBar.LENGTH_INDEFINITE);
                snack.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boton2.setEnabled(true);
                    }
                });
                snack.show();

            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("¿Sumar 1?");
                builder.setTitle("Prueba de diálogo");
                builder.setCancelable(false);
                builder.setPositiveButton("Sí", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int
                                    which) {
                                int
                                        valorActual = Integer.parseInt(texto.getText().toString
                                        ());

                                texto.setText(String.valueOf(valorActual + 1));
                            }
                        });
                AlertDialog.Builder no = builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int
                            which) {
                    }
                });
                builder.show();
            }
        });


    }
}