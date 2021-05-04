package com.example.sqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.database.DBController;
import java.util.HashMap;

public class EditData extends AppCompatActivity {

    private EditText editNm,editTlpn;
    private Button btnsimpan;
    String id, nama, telpon;
    ActionBar actionBar;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        editNm = findViewById(R.id.editNama);
        editTlpn = findViewById(R.id.editTelpon);
        btnsimpan = findViewById(R.id.btnSimpan);

        Bundle bundle =getIntent().getExtras();

        id = bundle.getString("id");
        nama = bundle.getString("nama");
        telpon =bundle.getString("telpon");
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editNm.setText(nama);
        editTlpn.setText(telpon);

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = editNm.getText().toString();
                telpon = editTlpn.getText().toString();

                if(nama.isEmpty() || telpon.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Data Belum Lengkap", Toast.LENGTH_SHORT).show();
                }
                else {
                    HashMap<String , String > nilai = new HashMap<>();
                    nilai.put("id", id);
                    nilai.put("nama", nama);
                    nilai.put("telpon", telpon);

                    controller.editKontak(nilai);

                    callHome();
                }
            }
        });
    }
    public void callHome() {
        Intent i = new Intent(EditData.this, MainActivity.class);
        startActivity(i);
        finish();
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