package com.example.user.mechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    User user;
    EditText nama,nohp,email;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nama=(EditText)findViewById(R.id.etnama);
        nohp=(EditText)findViewById(R.id.etNomorHP);
        email=(EditText)findViewById(R.id.etemail);
        register=(Button) findViewById(R.id.btRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = new User();
                user.setNama(nama.getText().toString());
                user.setEmail(email.getText().toString());
                user.setTelepon(nohp.getText().toString());
                user.register();
                Toast.makeText(getApplicationContext(), "Register Sukses", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }
}
