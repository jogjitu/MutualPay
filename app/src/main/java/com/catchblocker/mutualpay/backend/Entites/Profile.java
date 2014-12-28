package com.catchblocker.mutualpay.backend.Entites;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jitendra Jogeshwar on 12/25/2014.
 * Uesr profile entity
 */
public class Profile implements Parcelable {

    private String key="ChangeLater";
    private String name;
    private String phoneNumber;


    public Profile(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber=phoneNumber;
    }

    public Profile(Parcel in){
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest,int flags){
        dest.writeString(name);
        dest.writeString(phoneNumber);
    }

    private void readFromParcel(Parcel in) {
        name = in.readString();
        phoneNumber = in.readString();
    }

    public static final Parcelable.Creator CREATOR =
      new Parcelable.Creator(){
        public Profile createFromParcel(Parcel in){
            return new Profile(in);
        }

        public Profile[] newArray(int size){
            return new Profile[size];
        }

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
