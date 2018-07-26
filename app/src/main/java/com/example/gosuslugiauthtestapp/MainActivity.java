package com.example.gosuslugiauthtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.gosuslugiauthtestapp.auth.GosuslugiAuthActivity;
import com.example.gosuslugiauthtestapp.auth.model.AuthDataDTO;

public class MainActivity extends AppCompatActivity {

    private static final int AUTH_VIA_GOSUSLUGI_REQUEST_CODE = 1001;
    private TextView tvAuthData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btnAuthViaGosuslugi = findViewById(R.id.btn_auth_via_gosuslugi);
        tvAuthData = findViewById(R.id.tv_auth_data);
        tvAuthData.setMovementMethod(new ScrollingMovementMethod());
        btnAuthViaGosuslugi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, GosuslugiAuthActivity.class), AUTH_VIA_GOSUSLUGI_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == AUTH_VIA_GOSUSLUGI_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            AuthDataDTO authData = data.getParcelableExtra(GosuslugiAuthActivity.EXTRA_AUTH_RESULT);
            tvAuthData.setText(authData.toString());
        }
    }
}
