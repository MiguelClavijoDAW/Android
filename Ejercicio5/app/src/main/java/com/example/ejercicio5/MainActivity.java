package com.example.ejercicio5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch elec;
    ImageButton imagen;
    private Object v;

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
                rotarImagen(imagen);
            }
        });
    }
    public void rotarImagen(View view){
        RotateAnimation animation = new RotateAnimation(imagen.getRotation(), 180,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(2000);
        view.startAnimation(animation);
    }
}