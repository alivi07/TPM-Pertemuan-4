package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView nama,deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nama = (TextView) findViewById(R.id.names);
        deskripsi = (TextView) findViewById(R.id.deskription);

        Bundle bundle = getIntent().getExtras();
        String Nama = bundle.getString("name");
        nama.setText(Nama);
        String Deskripsi = bundle.getString("deskription");
        deskripsi.setText(Deskripsi);

    }
}
