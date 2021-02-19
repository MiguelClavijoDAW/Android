package com.example.trabajofinal1eval;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Array;

public class formulario extends AppCompatActivity {

    private Button atras;
    private Button enviar1;
    private EditText nombreid;
    private EditText apellidosid;
    private EditText telefonoid;
    private EditText emailid;
    private EditText fechaid;
    private RadioButton hombre;
    private RadioButton musicaid;
    private RadioButton deporteid;
    private RadioButton tecnoid;
    private String sexo;
    private  String intereses="";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        //valores del formulario
        ////////////////////////////////////////////////////////////////////////
        nombreid=findViewById(R.id.nombre);
        apellidosid=findViewById(R.id.apellidos);
        telefonoid=findViewById(R.id.telefono);
        emailid=findViewById(R.id.email);
        fechaid=findViewById(R.id.fecha);
        hombre=findViewById(R.id.hombre);
        musicaid=findViewById(R.id.musica);
        deporteid=findViewById(R.id.deporte);
        tecnoid=findViewById(R.id.tecnologia);
        ////////////////////////////////////////////////////////////////////////
        atras=findViewById(R.id.volver1);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(formulario.this,MainActivity.class);
                startActivity(intent);
            }
        });
        enviar1=findViewById(R.id.enviar);
        enviar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hombre.isChecked()){
                    sexo="hombre";
                }else{
                    sexo="Mujer";
                }
                if(musicaid.isChecked()){
                    intereses+="Musica";
                }
                if(deporteid.isChecked()){
                    if(intereses.equals("")){
                        intereses+="Deportes";
                    }else{
                        intereses+=", Deportes";
                    }
                }
                if(tecnoid.isChecked()){
                    if(intereses.equals("")){
                        intereses+="Tecnologia";
                    }else{
                        intereses+=", Tecnologia";
                    }
                }
                Intent intent=new Intent(formulario.this,MainActivity.class);
                intent.putExtra("nombre",nombreid.getText().toString());
                //intent.putExtra("apellidos",apellidosid.getText().toString());
                //intent.putExtra("telefono",telefonoid.getText().toString());
                //intent.putExtra("email",emailid.getText().toString());
                //intent.putExtra("fecha",fechaid.getText().toString());
                //intent.putExtra("sexo",sexo);
                intent.putExtra("intereses", intereses);
                startActivity(intent);
            }
        });
    }

}