package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView3;
    private TextView textView5;
    private NumberPicker picker1;
    private String[] pickerVals;
    private SeekBar seekbar;
    private SeekBar seekbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picker1 = findViewById(R.id.numberpicker_main_picker);
        picker1.setMinValue(0);
        picker1.setMaxValue(17);
        pickerVals = new String[] {"2002", "2003", "2004", "2005", "2006","2007", "2008", "2009", "2010", "2011","2012", "2013", "2014", "2015", "2016","2017","2018","2019","2020"};
        picker1.setDisplayedValues(pickerVals);

        picker1.setDisplayedValues(pickerVals);
        picker1.setWrapSelectorWheel(true);

        picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                textView.setText("Selected Text : "+pickerVals[i]);

            }
        });



        SeekBar seekBar = (SeekBar)findViewById(R.id.seekbar);
        final TextView seekBarValue = (TextView)findViewById(R.id.textView5);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar seekBar1 = (SeekBar)findViewById(R.id.seekbar1);
        final TextView seekBarValue1 = (TextView)findViewById(R.id.textView3);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar1, int progressa, boolean fromUser) {
                seekBarValue1.setText(String.valueOf(progressa));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar1) {
            }
        });
    }
}