package com.example.gosuslugiauthtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gosuslugiauthtestapp.auth.GosuslugiAuthActivity;

public class MainActivity extends AppCompatActivity {

    private static final int AUTH_VIA_GOSUSLUGI_REQUEST_CODE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btnAuthViaGosuslugi = findViewById(R.id.btn_auth_via_gosuslugi);
        btnAuthViaGosuslugi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, GosuslugiAuthActivity.class), AUTH_VIA_GOSUSLUGI_REQUEST_CODE);
            }
        });
    }
}
