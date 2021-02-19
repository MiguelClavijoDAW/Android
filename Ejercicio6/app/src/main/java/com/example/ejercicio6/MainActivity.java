package com.example.ejercicio6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button boton;
    ImageView imagen;
    int x=0;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=findViewById(R.id.boton1);
        imagen=findViewById(R.id.imagen1);

    }
    public void cambiar(){
        if(x==0){
            imagen.setImageResource(R.drawable.android_salto);
            x=1;
        }else{
            imagen.setImageResource(R.drawable.android_quieto);
            x=0;
        }
    }
    public void onClick(View view){
        if(boton.getText()=="Iniciar"){
            boton.setText("Parar");
            handler.postDelayed( new Runnable() {
                public void run() {
                    cambiar();
                    handler.postDelayed(this,1000);
                }
            },0);
        }else{
            boton.setText("Iniciar");
        }
    }

}