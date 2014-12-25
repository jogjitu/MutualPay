package com.catchblocker.mutualpay.backend.Entites;

import android.content.Context;

/**
 * Created by Jitendra Jogeshwar on 12/25/2014.
 * Uesr profile entity
 */
public class Profile {

    private String key="ChangeLater";
    private String name;
    private String phoneNumber;


    public Profile(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber=phoneNumber;
    }



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
