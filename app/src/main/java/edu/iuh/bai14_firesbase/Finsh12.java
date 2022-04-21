package edu.iuh.bai14_firesbase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Finsh12 extends AppCompatActivity {
    private Button btnFinsh;
    private ImageButton imgbtnHappy, imgbtnUnhappy, imgbtnNormal;

    private int happy_num = 0;
    private int unhappy_num = 0;
    private int normal_num = 0;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finsh12);

        imgbtnUnhappy = findViewById(R.id.imgbtnUnhappy);
        imgbtnNormal = findViewById(R.id.imgbtnNornal);
        imgbtnHappy = findViewById(R.id.imgbtnHappy);

        final DatabaseReference ref = database.getReference("User").
                child(FirebaseAuth.getInstance().getCurrentUser().getUid());;

        btnFinsh = findViewById(R.id.btnFinsh);
        btnFinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imgbtnUnhappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Finsh12.this, "Unhappy!!!...Thank you", Toast.LENGTH_SHORT).show();
                final DatabaseReference ref = database.getReference("User").
                        child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("unhappy");

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            unhappy_num = Integer.parseInt(snapshot.getValue().toString());
                            unhappy_num++;
                            ref.setValue(unhappy_num);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        imgbtnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Finsh12.this, "Happy!!!...Thank you", Toast.LENGTH_SHORT).show();
                final DatabaseReference ref = database.getReference("User").
                        child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("happy");

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            happy_num = Integer.parseInt(snapshot.getValue().toString());
                            happy_num++;
                            ref.setValue(happy_num);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        imgbtnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Finsh12.this, "Normal!!!... Thank you", Toast.LENGTH_SHORT).show();
                final DatabaseReference ref = database.getReference("User").
                        child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("normal");

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            normal_num = Integer.parseInt(snapshot.getValue().toString());
                            normal_num++;
                            ref.setValue(normal_num);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}