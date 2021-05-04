package com.example.sqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sqlite.database.DBController;

public class TampilData extends AppCompatActivity {

    DBController controller = new DBController(this);

    TextView tNama,tTelpon;
    String nama, telpon;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        tNama = findViewById(R.id.textNama);
        tTelpon = findViewById(R.id.textTelpon);

        Bundle bundle = getIntent().getExtras();

        nama = bundle.getString("nama");
        telpon = bundle.getString("telpon");
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tNama.setText(nama);
        tTelpon.setText(telpon);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}