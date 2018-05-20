package com.example.dell.viewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PieData> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        PieData pieData1 = new PieData("A", 12.2f);
        PieData pieData2 = new PieData("B", 6.2f);
        mData.add(pieData1);
        mData.add(pieData2);
        PieView pieView = findViewById(R.id.pie_view);
        pieView.setMStartAngle(120);
        pieView.setMPieData(mData);
        */

        final CheckView checkView = findViewById(R.id.check_view);
        checkView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        Button buttonCheck = findViewById(R.id.check);
        Button buttonUncheck = findViewById(R.id.uncheck);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkView.check();
            }
        });

        buttonUncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkView.unCheck();
            }
        });

    }
}
