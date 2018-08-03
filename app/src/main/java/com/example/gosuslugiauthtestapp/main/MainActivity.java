package com.example.gosuslugiauthtestapp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gosuslugiauthtestapp.R;
import com.example.gosuslugiauthtestapp.StartActivity;
import com.example.gosuslugiauthtestapp.app.App;
import com.example.gosuslugiauthtestapp.auth.model.AuthDataDTO;
import com.example.gosuslugiauthtestapp.main.model.MainViewModel;
import com.example.gosuslugiauthtestapp.preferences.PreferenceManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvFirstName)
    public TextView tvFirstName;

    @BindView(R.id.tvLastName)
    public TextView tvLastName;

    @BindView(R.id.tvGender)
    public TextView tvGender;

    @BindView(R.id.tvSNILS)
    public TextView tvSNILS;

    @BindView(R.id.tvNationality)
    public TextView tvNationality;

    @BindView(R.id.tvDateOfBirth)
    public TextView tvDateOfBirth;

    @BindView(R.id.tvPlaceOfBirth)
    public TextView tvPlaceOfBirth;

    @BindView(R.id.tvTrusted)
    public TextView tvTrusted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        AuthDataDTO authDataDTO = PreferenceManager.getInstance().getAuthData();
        if(authDataDTO != null)
            App.getInstance().getApiService()
                    .getUserInfo(authDataDTO.getSbjId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::showUserData, e -> {
                        if(e instanceof HttpException && ((HttpException) e).code() == 401){
                            PreferenceManager.getInstance().clearAuthData();
                            Intent intent = new Intent(this, StartActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    });
    }

    private void showUserData(MainViewModel data) {
        tvFirstName.setText("Имя : " + data.getFirstName());
        tvLastName.setText("Фамилия : " + data.getLastName());
        tvGender.setText("Пол : " + data.getGender());
        tvDateOfBirth.setText("Дата рождения : " + data.getBirthDate());
        tvPlaceOfBirth.setText("Место рождения : " + data.getBirthPlace());
        tvNationality.setText("Гражданство : " + data.getCitizenship());
        tvSNILS.setText("СНИЛС : " + data.getSnils());
        tvTrusted.setText("Trusted : " + data.getTrusted());
    }
}
