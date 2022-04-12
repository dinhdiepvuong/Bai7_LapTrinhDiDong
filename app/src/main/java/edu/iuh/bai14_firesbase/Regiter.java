package edu.iuh.bai14_firesbase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Regiter extends AppCompatActivity {
    TextView tvSginIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);

        tvSginIn = findViewById(R.id.tvSigin);
        tvSginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Regiter.this, Sign_In.class);
                startActivity(intent);
            }
        });
    }
}