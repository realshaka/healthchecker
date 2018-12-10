package com.example.tantan.healthchecker;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tantan.healthchecker.db.RecordDatabase;
import com.example.tantan.healthchecker.repository.RecordRepository;

import java.util.List;

public class RecordsActivity extends AppCompatActivity {
    public static final String EXTRA = "com.example.tantan.healthchecker";
    private static final String TAG = "showRecord";
    private RecordRepository recordRepository;
    private RecordDatabase recordDatabase;
    private RecyclerView recyclerView;
    private RecordListAdapter recordListAdapter;

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
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL));
        //recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, this));

        updateRecordList();

    }
     private void updateRecordList() {
            recordRepository.getRecords().observe(this, new Observer<List<Record>>() {
                @Override
                public void onChanged(@Nullable List<Record> records) {
                    if (records.size() > 0) {
                        if (recordListAdapter == null) {
                            recordListAdapter = new RecordListAdapter(records);
                            recyclerView.setAdapter(recordListAdapter);
                        }
                    }
                }
            });
    }






}
