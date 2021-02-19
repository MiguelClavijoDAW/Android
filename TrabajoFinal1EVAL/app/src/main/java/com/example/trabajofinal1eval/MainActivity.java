package com.example.trabajofinal1eval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Definicion de elementos
    private ImageView mascota;
    private Button altaUsuario;
    private Button calculo;
    private SeekBar edad;
    private TextView nUsuario;
    private TextView nIntereses;
    private TextView verEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlace por id a los elementos
        mascota=findViewById(R.id.mascota);
        altaUsuario=findViewById(R.id.cambio1);
        //evento para cambiar de activity
        altaUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,formulario.class);
                startActivity(intent);
            }
        });

        edad=findViewById(R.id.barraedad);
        calculo=findViewById(R.id.calculo);
        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x=edad.getProgress();
                x+=116;
                Toast.makeText(MainActivity.this,"Numero de la suerte:"+x,Toast.LENGTH_LONG).show();
            }
        });
        nUsuario=findViewById(R.id.nombreUsuario);
        nIntereses=findViewById(R.id.Interesesnuevos);
        if(getIntent().hasExtra("nombre")){
            nUsuario.setText(getIntent().getExtras().getString("nombre"));
            nIntereses.setText(getIntent().getExtras().getString("intereses"));
        }
        verEdad=findViewById(R.id.verEdad);
        edad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int x=edad.getProgress()+16;
                 verEdad.setText(""+x);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void rotarImagen(View view){
        RotateAnimation animation = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        animation.setRepeatCount(Animation.RELATIVE_TO_SELF);
        animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);
    }
}