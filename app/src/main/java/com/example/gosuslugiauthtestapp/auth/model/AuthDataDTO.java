package com.example.gosuslugiauthtestapp.auth.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthDataDTO implements Parcelable{

    private static final String KEY_ACCESS_TOKEN = "accesstoken";
    private static final String KEY_REFRESH_TOKEN = "refreshtoken";
    private static final String KEY_EXPIRES_IN = "expiresin";
    private static final String KEY_BEGIN_DATE = "begindate";
    private static final String KEY_END_DATE = "enddate";
    private static final String KEY_CREATE_DATE = "createdate";
    private static final String KEY_SID = "sid";
    private static final String KEY_SBJ_ID = "sbjid";

    private String accessToken = "";

    private String refreshToken = "";

    private String expiresIn = "";

    private String beginDate = "";

    private String endDate = "";

    private String createDate = "";

    private String sid = "";

    private String sbjId = "";

    protected AuthDataDTO(Parcel in) {
        accessToken = in.readString();
        refreshToken = in.readString();
        expiresIn = in.readString();
        beginDate = in.readString();
        endDate = in.readString();
        createDate = in.readString();
        sid = in.readString();
        sbjId = in.readString();
    }

    public static AuthDataDTO parse(String authDataString){
        AuthDataDTO authDataDTO = new AuthDataDTO();
        String[] pairs = authDataString.split("&");
        for (String pair : pairs){
            String[] parts = pair.split("=", 2);
            switch (parts[0].toLowerCase()){
                case KEY_ACCESS_TOKEN:
                    authDataDTO.setAccessToken(parts[1]);
                    break;
                case KEY_REFRESH_TOKEN:
                    authDataDTO.setRefreshToken(parts[1]);
                    break;
                case KEY_EXPIRES_IN:
                    authDataDTO.setExpiresIn(parts[1]);
                    break;
                case KEY_BEGIN_DATE:
                    authDataDTO.setBeginDate(parts[1]);
                    break;
                case KEY_END_DATE:
                    authDataDTO.setEndDate(parts[1]);
                    break;
                case KEY_CREATE_DATE:
                    authDataDTO.setCreateDate(parts[1]);
                    break;
                case KEY_SID:
                    authDataDTO.setSid(parts[1]);
                    break;
                case KEY_SBJ_ID:
                    authDataDTO.setSbjId(parts[1]);
                    break;
            }
        }

        return authDataDTO;
    }

    public AuthDataDTO() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSbjId() {
        return sbjId;
    }

    public void setSbjId(String sbjId) {
        this.sbjId = sbjId;
    }

    public static final Creator<AuthDataDTO> CREATOR = new Creator<AuthDataDTO>() {
        @Override
        public AuthDataDTO createFromParcel(Parcel in) {
            return new AuthDataDTO(in);
        }

        @Override
        public AuthDataDTO[] newArray(int size) {
            return new AuthDataDTO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(accessToken);
        dest.writeString(refreshToken);
        dest.writeString(expiresIn);
        dest.writeString(beginDate);
        dest.writeString(endDate);
        dest.writeString(createDate);
        dest.writeString(sid);
        dest.writeString(sbjId);
    }

    @Override
    public String toString() {
        return "AuthDataDTO : { \n" +
                "accessToken: " + accessToken + "\n" +
                "refreshToken: " + refreshToken + "\n" +
                "expiresIn: " + expiresIn + "\n" +
                "beginDate: " + beginDate + "\n" +
                "endDate: " + endDate +"\n" +
                "createDate: " + createDate + "\n" +
                "sid: " + sid + "\n" +
                "sbjId: " + sbjId + "\n" + "}";
    }
}
