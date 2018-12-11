package com.example.tantan.healthchecker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Draw a line graph base on user's records
 */
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


        GraphView graph = (GraphView) findViewById(R.id.graph);
        if (GlobalModel.getInstance().getRecords().size() > 0) {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
            LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>();
            for (int i = 0; i < GlobalModel.getInstance().getRecords().size(); i++) {
                DataPoint point = new DataPoint(i, GlobalModel.getInstance().getRecord(i).getBMI());
                DataPoint point1 = new DataPoint(i, 29);
                series.appendData(point, true, GlobalModel.getInstance().getRecords().size());
                series1.appendData(point1, true, GlobalModel.getInstance().getRecords().size());
            }
            series.setColor(Color.RED);
            series1.setColor(Color.BLUE);
            graph.addSeries(series);
            graph.addSeries(series1);
        }


    }

}
