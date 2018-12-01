package com.example.omistaja.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editText2;
    private SeekBar seekBar1;
    private SeekBar seekBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaring views with ID
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        seekBar1 = (SeekBar) findViewById(R.id.seekBarbmi);
        seekBar2 = (SeekBar) findViewById(R.id.seekBarbmi2);


        seekBar1.setMax(200);
        seekBar2.setMax(150);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //Update Seekbar value after entering a number
                if (!s.toString().isEmpty()) {
                   int num = Integer.parseInt(editText.getText().toString());
                    seekBar1.setProgress(num);
                }

            }
        });

        // Seeker_bar for height updated by user touch
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    seekBar1.setProgress(progress);
                    editText.setText(progress + "");


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //Update Seekbar2 value after entering a number
                if(!s.toString().isEmpty()) {
                    seekBar2.setProgress(Integer.parseInt(s.toString()));
                }

            }
        });
            //Seeker_bar for weight updated by user touch
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar2.setProgress(progress);
                editText2.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
