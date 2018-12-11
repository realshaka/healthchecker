package com.example.tantan.healthchecker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

                    case R.id.navigation_records:
                        Intent intent2 = new Intent(RecordsActivity.this, RecordsActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_graph:
                        Intent intent3 = new Intent(RecordsActivity.this, GraphActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

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




}
