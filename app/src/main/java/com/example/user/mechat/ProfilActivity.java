package com.example.user.mechat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {
    TextView nama,nomor,email;
    User user;
    SharedPreferences mylocaldata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        nama=(TextView)findViewById(R.id.tv_nama);
        nomor=(TextView)findViewById(R.id.tv_nomor);
        email=(TextView)findViewById(R.id.tv_email);
        mylocaldata = getSharedPreferences("mylocaldata", MODE_PRIVATE);
        user = getIntent().getParcelableExtra("user");

        nama.setText(user.getNama());
        nomor.setText(user.getTelepon());
        email.setText(user.getEmail());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuhome) {
            Intent intent = new Intent(ProfilActivity.this, MainActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }else if (item.getItemId() == R.id.menuprofil) {
            Intent intent = new Intent(this, ProfilActivity.class);
            intent.putExtra("user",user);
            startActivity(intent);
        }else if (item.getItemId() == R.id.menuUser) {
            startActivity(new Intent(ProfilActivity.this, UserListActivity.class));
        } else if (item.getItemId() == R.id.menuLogout) {
            startActivity(new Intent(ProfilActivity.this, LoginActivity.class));
            finish();
        }
        return true;
    }


}
