package edu.iuh.bai14_firesbase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Regiter extends AppCompatActivity {
    private TextView tvSginIn;
    private EditText edtYourName, edtEmail, edtPass1, edtPass2;
    private Button btnRgister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);

        mAuth = FirebaseAuth.getInstance();

        edtYourName = findViewById(R.id.edtYourNameRegister);
        edtEmail = findViewById(R.id.edtEmailRegister);
        edtPass1 = findViewById(R.id.edtPaswordRegister1);
        edtPass2 = findViewById(R.id.edtPasswordRegister2);
        btnRgister = findViewById(R.id.btnRegisterInReguster);


        tvSginIn = findViewById(R.id.tvSigin);
        tvSginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Regiter.this, Sign_In.class);
                startActivity(intent);
            }
        });

        btnRgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        String email;
        String pass1, pass2, yourname;
        email = edtEmail.getText().toString();
        pass1 = edtPass1.getText().toString();
        pass2 = edtPass2.getText().toString();
        yourname = edtYourName.getText().toString();

//        if(TextUtils.isEmpty(email)){
//            Toast.makeText(this, "Vui lòng nhập email!!!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(TextUtils.isEmpty(pass1)){
//            Toast.makeText(this, "Vui lòng nhập mật khẩu!!!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(TextUtils.isEmpty(pass2)){
//            Toast.makeText(this, "Vui lòng nhập lại mật khẩu!!!", Toast.LENGTH_SHORT).show();
//            return;
//        }
        if(edtYourName.getText().length() == 0){
            edtYourName.setError("Làm ơn nhập tên của bạn!");
        }else if(edtEmail.getText().length() == 0){
            edtEmail.setError("Vui lòng nhập email của bạn!");
        }else if(edtPass1.getText().length() == 0){
            edtPass1.setError("Vui lòng nhập mật khẩu");
        }else if(edtPass2.getText().length() == 0){
            edtPass2.setError("Nhập lại mật khẩu lần 2");
        }else if(pass1.equals(pass2)){
            mAuth.createUserWithEmailAndPassword(email, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        User user = new User(yourname, email);
                        FirebaseDatabase.getInstance().getReference("User").
                                child(FirebaseAuth.getInstance().getCurrentUser().getUid()).
                                setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Regiter.this, "Đăng kí thành tài khoản thành công", Toast.LENGTH_SHORT).show();
                                    edtYourName.setText("");
                                    edtEmail.setText("");
                                    Intent intent = new Intent(Regiter.this, Finsh12.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(Regiter.this, "Đăng kí thất bại!!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            });
        }else{
            Toast.makeText(this, "Nhập lại mật khẩu lần 2 khớp với lần 1", Toast.LENGTH_SHORT).show();
        }

    }
}