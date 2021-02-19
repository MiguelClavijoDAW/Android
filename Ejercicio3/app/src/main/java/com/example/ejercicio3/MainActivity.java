package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioButton suma;
    RadioButton resta;
    RadioButton multiplicacion;
    RadioButton division;
    EditText n1;
    EditText n2;
    Button calcular;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        suma=findViewById(R.id.suma);
        resta=findViewById(R.id.resta);
        multiplicacion=findViewById(R.id.multiplicacion);
        division=findViewById(R.id.division);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        calcular=findViewById(R.id.calcular);
        resultado=findViewById(R.id.resultado);

    }
    public float suma(float x, float y){
        return x+y;
    }
    public float resta(float x, float y){

        return x-y;
    }
    public float multiplicacion(float x, float y){
        return x*y;
    }
    public float division(float x, float y){
        return x/y;
    }

    public void calculo(View view){
        if(suma.isChecked()){
            float re=suma(Float.parseFloat(n1.getText().toString()),Float.parseFloat(n2.getText().toString()));
            resultado.setText(Float.toString(re));
        }else if (resta.isChecked()){
            float re=resta(Float.parseFloat(n1.getText().toString()),Float.parseFloat(n2.getText().toString()));
            resultado.setText(Float.toString(re));
        }else if(multiplicacion.isChecked()){
            float re=multiplicacion(Float.parseFloat(n1.getText().toString()),Float.parseFloat(n2.getText().toString()));
            resultado.setText(Float.toString(re));
        }else if(division.isChecked()){
            float re=division(Float.parseFloat(n1.getText().toString()),Float.parseFloat(n2.getText().toString()));
            resultado.setText(Float.toString(re));
        }else{
            resultado.setText("NaN");
        }
    }
}