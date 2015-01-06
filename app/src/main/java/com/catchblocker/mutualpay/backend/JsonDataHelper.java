package com.catchblocker.mutualpay.backend;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.catchblocker.mutualpay.GroupActivity;
import com.catchblocker.mutualpay.backend.Entites.Group;
import com.catchblocker.mutualpay.backend.Entites.Profile;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by Kailash Dave on 12/28/2014.
 * This class will help in reading and writing
 * to Json file
 */
public class JsonDataHelper {

    public static String NotificationPathFormat = "Notifications/{0}.json";
    public static String RequestPathFormat = "Requests/{0}.json";
    public static String BillPathFormat = "Bills/{0}.json";


    public static String GetNotificationPathForJSON(Profile profile){
        return String.format(NotificationPathFormat, profile.getPhoneNumber());
    }

    public static String GetBillPathForGroup(Group group)
    {
        return String.format(BillPathFormat, group.getGroupId());
    }

    public static String GetMemberGroupRequestPath(Profile profile)
    {
        return String.format(RequestPathFormat, profile.getPhoneNumber());
    }



}
