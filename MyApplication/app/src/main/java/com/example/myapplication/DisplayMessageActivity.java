package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DisplayMessageActivity extends AppCompatActivity {
    private int [] imagenes={R.drawable.tenor,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    private void cambiarImagen(){
        ImageView saludo= (ImageView)findViewById(R.id.imageView);
        Random numeros= new Random();
        int posicion=numeros.nextInt(4);
        saludo.setImageResource(imagenes[posicion]);
    }
    public void botonImagen(View view){
        cambiarImagen();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
        cambiarImagen();
    }
}