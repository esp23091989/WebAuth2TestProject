package com.example.gosuslugiauthtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.gosuslugiauthtestapp.auth.GosuslugiAuthActivity;
import com.example.gosuslugiauthtestapp.auth.model.AuthDataDTO;
import com.example.gosuslugiauthtestapp.main.MainActivity;
import com.example.gosuslugiauthtestapp.preferences.PreferenceManager;

public class StartActivity extends AppCompatActivity {

    private static final int AUTH_VIA_GOSUSLUGI_REQUEST_CODE = 1001;
    private TextView tvAuthData;
    private PreferenceManager preferenceManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceManager = PreferenceManager.getInstance();
        AuthDataDTO authDataDTO = preferenceManager.getAuthData();
        if(authDataDTO != null)
            openMainView();

        View btnAuthViaGosuslugi = findViewById(R.id.btn_auth_via_gosuslugi);
        tvAuthData = findViewById(R.id.tv_auth_data);
        tvAuthData.setMovementMethod(new ScrollingMovementMethod());
        btnAuthViaGosuslugi.setOnClickListener(view -> startActivityForResult(new Intent(StartActivity.this, GosuslugiAuthActivity.class), AUTH_VIA_GOSUSLUGI_REQUEST_CODE));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == AUTH_VIA_GOSUSLUGI_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            AuthDataDTO authData = data.getParcelableExtra(GosuslugiAuthActivity.EXTRA_AUTH_RESULT);
            preferenceManager.setAuthData(authData);
            openMainView();
        }
    }

    public void openMainView(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
