package com.example.a32a4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioButton lunes;
    RadioButton martes;
    RadioButton miercoles;
    RadioButton jueves;
    RadioButton viernes;
    RadioButton sabado;
    RadioButton domingo;
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lunes=findViewById(R.id.lunes);
        martes=findViewById(R.id.martes);
        miercoles=findViewById(R.id.miercoles);
        jueves=findViewById(R.id.jueves);
        viernes=findViewById(R.id.viernes);
        sabado=findViewById(R.id.sabado);
        domingo=findViewById(R.id.domingo);
        texto=findViewById(R.id.texto);
    }
    public void cambiar(View v){
        if(lunes.isChecked()){
            texto.setText("Lunes");
        }
        if(martes.isChecked()){
            texto.setText("Martes");
        }
        if(miercoles.isChecked()){
            texto.setText("Miercoles");
        }
        if(jueves.isChecked()){
            texto.setText("Jueves");
        }
        if(viernes.isChecked()){
            texto.setText("Viernes");
        }
        if(sabado.isChecked()){
            texto.setText("Sabado");
        }
        if(domingo.isChecked()){
            texto.setText("Domingo");
        }
    }
}