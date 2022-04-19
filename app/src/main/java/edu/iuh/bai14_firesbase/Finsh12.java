package edu.iuh.bai14_firesbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Finsh12 extends AppCompatActivity {
    private Button btnFinsh;
    private ImageButton imgbtnVui, imgbtnBuon, imgbtnGian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finsh12);

        imgbtnBuon = findViewById(R.id.imgbtnBuon);
        imgbtnGian = findViewById(R.id.imgbtnGian);
        imgbtnVui = findViewById(R.id.imgbtnVui);

        btnFinsh = findViewById(R.id.btnFinsh);
        btnFinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imgbtnBuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imgbtnVui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imgbtnGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}