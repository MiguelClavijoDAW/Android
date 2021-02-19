package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch elec;
    ImageButton imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen=findViewById(R.id.imagen1);
        elec=(Switch) findViewById(R.id.Elector);
        elec.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener () {

            @Override
            public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    imagen.setImageResource(R.drawable.noche);

                }
                else {
                    imagen.setImageResource(R.drawable.dia);
                }
            }
        });
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(imagen.getRotation()==0){
                imagen.setRotation(180);
            }else{
                imagen.setRotation(0);
            }
            }
        });

    }





}