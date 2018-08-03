package com.example.gosuslugiauthtestapp.main.model;

import com.google.gson.annotations.SerializedName;

public class MainViewModel {

    @SerializedName("firstName")
    private String firstName = "";

    @SerializedName("lastName")
    private String lastName = "";

    @SerializedName("birthDate")
    private String birthDate = "";

    @SerializedName("birthPlace")
    private String birthPlace = "";

    @SerializedName("trusted")
    private Boolean trusted;

    @SerializedName("gender")
    private String gender = "";

    @SerializedName("citizenship")
    private String citizenship = "";

    @SerializedName("snils")
    private String snils = "";

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public Boolean getTrusted() {
        return trusted;
    }

    public String getGender() {
        return gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getSnils() {
        return snils;
    }
}
