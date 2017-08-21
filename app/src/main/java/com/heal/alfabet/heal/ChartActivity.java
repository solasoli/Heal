package com.heal.alfabet.heal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    private static final String TAG = "ChartActivity";

    LineGraphSeries<DataPoint> xSeries;

    private EditText chartEditText;
    private Button chartSubmitButton;

    GraphView chart;
    ChartHelper chartHelper;
    SQLiteDatabase sqLiteDatabase;

    private ArrayList<Xvalue> Xvaluearray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        //nama - nama :D

        chartEditText = (EditText) findViewById(R.id.editText2);
        chart = (GraphView) findViewById(R.id.chart);
        chartSubmitButton = (Button) findViewById(R.id.chartSubmitButton);
        Xvaluearray = new ArrayList<>();

       

        chartHelper = new ChartHelper(this);
        sqLiteDatabase = chartHelper.getWritableDatabase();

        exqButton();




    }

    private void exqButton() {
        chartSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int xVal=Integer.parseInt(String.valueOf(chartEditText.getText()));

                chartHelper.inserData(xVal);
                xSeries=new LineGraphSeries<DataPoint>(getData());
            }
        });
    }

    private DataPoint[] getData() {
        String[] columns={"xValue"};
        Cursor cursor=sqLiteDatabase.query("MyTable", columns,null,null,null,null,null,null,null);

        DataPoint dp=new DataPoint[cursor.getCount()];

        for (int i=0)
    }


}
