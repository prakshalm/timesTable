package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;

    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();
        int n=15;
        for (int j=1;j<n;j++){
            timesTableContent.add(Integer.toString(timesTableNumber*j));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = findViewById(R.id.timesTableSeekBar);
        timesTableListView = findViewById(R.id.timesTableListView);

        int max=20,current=1;
        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(current);
        generateTimesTable(current);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min =1, timesTableNumber;
                if(i<min){
                    timesTableSeekBar.setProgress(min);
                    timesTableNumber=min;
                }
                else
                    timesTableNumber=i;
                Log.i("SeekBar value", Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);
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
