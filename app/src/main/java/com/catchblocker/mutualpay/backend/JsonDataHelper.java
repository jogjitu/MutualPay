package com.catchblocker.mutualpay.backend;

import android.os.AsyncTask;
import android.util.Log;

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
public class JsonDataHelper extends AsyncTask<String, String,String> {

    public static String NotificationPathFormat = "Notifications/{0}.json";
    public static String RequestPathFormat = "Requests/{0}.json";
    public static String BillPathFormat = "Bills/{0}.json";
    private Exception exception;


    protected String doInBackground(String... urls){
       try{
           String s = getJson(urls[0]);
           Log.d(JsonDataHelper.class.toString(),s);
           return s;
       }
       catch (Exception e){
           this.exception =e;
           return null;
       }
    }


    protected void onPostExecute(String test){

    }


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

    public String getJson(String url){
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = client.execute(httpGet);
            StatusLine statusLine = httpResponse.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if(statusCode == 200){
                HttpEntity httpEntity = httpResponse.getEntity();
                InputStream content = httpEntity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while((line = reader.readLine())!= null){
                    builder.append(line);
                }
            }
            else {
                Log.d(JsonDataHelper.class.toString(), "Failed download json");
            }
        }
        catch (ClientProtocolException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return builder.toString();
    }


}
