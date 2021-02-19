package com.example.a32a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto=findViewById(R.id.TextoAcambiar);

    }
     public void cambiarTexto1(View view){
        texto.setTextColor(Color.RED);
    }

   public void cambiarTexto2(View view){
        texto.setTextColor(Color.BLUE);
   }

}

