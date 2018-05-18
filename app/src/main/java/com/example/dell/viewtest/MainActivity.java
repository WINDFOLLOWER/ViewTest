package com.example.dell.viewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PieData> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PieData pieData1 = new PieData("A", 12.2f);
        PieData pieData2 = new PieData("B", 6.2f);
        mData.add(pieData1);
        mData.add(pieData2);
        PieView pieView = findViewById(R.id.pie_view);
        pieView.setMStartAngle(120);
        pieView.setMPieData(mData);
    }
}
