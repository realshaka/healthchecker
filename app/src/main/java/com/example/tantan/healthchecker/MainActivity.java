package com.example.tantan.healthchecker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tantan.healthchecker.R;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements KeyListener {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2";

    private EditText editTextHeight;
    private EditText editTextWeight;
    private SeekBar seekBarHeight;
    private SeekBar seekBarWeight;
    private Switch xswitch;
    private TextView textViewheight;
    private TextView textViewWeight;
    BMI_calculator bmi_calculator;
    BMI_calculator_Imperial bmi_calculator_imperial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiating views with ID
        textViewheight = (TextView) findViewById(R.id.textView4);
        textViewWeight = (TextView) findViewById(R.id.textView5);
        editTextHeight = (EditText) findViewById(R.id.editText);
        editTextWeight = (EditText) findViewById(R.id.editText2);
        seekBarHeight = (SeekBar) findViewById(R.id.seekBarbmi);
        seekBarWeight = (SeekBar) findViewById(R.id.seekBarbmi2);

        seekBarHeight.setMax(210);
        seekBarWeight.setMax(160);


        xswitch = (Switch) findViewById(R.id.switch1);
        xswitch.setChecked(false);

       //Checks if enter key is pressed and then affects the seekerbar for height
        editTextHeight.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int keycod = event.getKeyCode();
                if (keycod == KeyEvent.KEYCODE_ENTER || keycod == KeyEvent.ACTION_UP){
                    int numforheight = Integer.parseInt(editTextHeight.getText().toString());
                    seekBarHeight.setProgress(numforheight);
                }
                return false;
            }


        });
        //Checks if done key is pressed and then affects the seekerbar for Weight
        editTextWeight.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    int numforweight = Integer.parseInt(editTextWeight.getText().toString());
                    seekBarWeight.setProgress(numforweight);
                }
                return false;
            }
        });
       // changes to be made when the switch button is pressed from metric to Imperial
        xswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                   seekBarHeight.setMax(6);
                   seekBarWeight.setMax(331);
                   textViewheight.setText("ft");
                   textViewWeight.setText("Lbs");
                } else{
                    seekBarHeight.setMax(210);
                    seekBarWeight.setMax(160);
                    textViewheight.setText("cm");
                    textViewWeight.setText("kg");
                }
            }
        });


        // Seeker_bar for height updated by user touch
        seekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarHeight.setProgress(progress);
                editTextHeight.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //Seeker_bar for weight updated by user touch
        seekBarWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarWeight.setProgress(progress);
                editTextWeight.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_calculator:
                        Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_records:
                        Intent intent2 = new Intent(MainActivity.this, RecordsActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_graph:
                        Intent intent3 = new Intent(MainActivity.this, GraphActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

    }


    // (Button) Calculates result and displays it in a new activity
    public void buttoncalculate(View view) {
        Intent intent = new Intent(this, DisplayResult.class);

        // Set the value in the edit text as the parameter for bmi object of class BMI_calculator when in METRIC
        if (editTextHeight.getText().toString().isEmpty() || editTextWeight.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this,
                    "Height or Weight cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            String strHeight = editTextHeight.getText().toString();
            String strWeight = editTextWeight.getText().toString();
            Double doubleWeight = Double.parseDouble(strWeight);
            Double doubleHeight = Double.parseDouble(strHeight);
            if (textViewWeight.getText().equals("Lbs") && !strHeight.equals("0") && !strWeight.equals("0")) {
                //calculation using the Imperial System
                bmi_calculator_imperial = new BMI_calculator_Imperial(doubleHeight, doubleWeight);
                bmi_calculator_imperial.calculate();
                String color = String.valueOf(bmi_calculator_imperial.getCalculations());
                String message = bmi_calculator_imperial.getResult();
                intent.putExtra(EXTRA_MESSAGE2, color);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            } else if (!strHeight.equals("0") && !strWeight.equals("0")) {
                //calculation using the metric system values
                bmi_calculator = new BMI_calculator(doubleHeight, doubleWeight);
                bmi_calculator.calculate();
                String color = String.valueOf(bmi_calculator.getCalculations());
                String message = bmi_calculator.getResult();
                intent.putExtra(EXTRA_MESSAGE, message);
                intent.putExtra(EXTRA_MESSAGE2, color);
                startActivity(intent);
            } else if (strHeight.equals("0") || strWeight.equals("0")) {
                //if the user puts a value of zero this message will be displayed
                Toast.makeText(MainActivity.this,
                        "Height or Weight cannot be 0", Toast.LENGTH_LONG).show();
            }       }
    }

    //unused code but nesecessary for the keylistener to work
    @Override
    public int getInputType() {
        return 0;
    }

    @Override
    public boolean onKeyDown(View view, Editable text, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(View view, Editable text, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyOther(View view, Editable text, KeyEvent event) {
        return false;
    }

    @Override
    public void clearMetaKeyState(View view, Editable content, int states) {

    }
}
