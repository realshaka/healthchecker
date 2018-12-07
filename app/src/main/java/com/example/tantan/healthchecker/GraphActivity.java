package com.example.tantan.healthchecker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

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
                        Intent intent1 = new Intent(GraphActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_records:
                        Intent intent2 = new Intent(GraphActivity.this, RecordsActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_graph:
                        Intent intent3 = new Intent(GraphActivity.this, GraphActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
}
