package com.example.tantan.healthchecker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * This class contain a listview to display records of users by timeline
 */
public class RecordsActivity extends AppCompatActivity {
    public static final String EXTRA = "package com.example.tantan.healthchecker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

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
                        Intent intent1 = new Intent(RecordsActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;



                    case R.id.navigation_graph:
                        Intent intent3 = new Intent(RecordsActivity.this, GraphActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
        if(GlobalModel.getInstance().getRecords().size() == 0) {
            loadSaveFile();
        }



        ListView lv = findViewById(R.id.recordListView);
        lv.setAdapter(new ArrayAdapter<Record>(this, android.R.layout.simple_list_item_1, GlobalModel.getInstance().getRecords()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("onRecordClick", "onItemClick" + i + ")");
                Intent nextActivity = new Intent(RecordsActivity.this, ShowRecordDetails.class);
                nextActivity.putExtra(EXTRA, i);
                startActivity(nextActivity);
            }
        });
    }


    private void loadSaveFile() {
        try {
             FileInputStream fis = openFileInput("healthchecker.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
             StringBuilder sb = new StringBuilder();
             String line;
             while((line = reader.readLine()) != null) {
                  sb.append(line);
            }
            String json = sb.toString();
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Record>>(){}.getType();
            ArrayList<Record> records = gson.fromJson(json,listType);
            for(int i = 0; i <= records.size(); i++) {
                GlobalModel.getInstance().addRecord(records.get(i));
            }
            Log.d("checkArray", String.valueOf(records.size()));
            System.out.print(records);
            Log.d("load file", "loadfile");
            records.get(0);
        } catch (Exception e) {
            Log.d("DEBUG", "Cannot load file");
        }

    }

}

