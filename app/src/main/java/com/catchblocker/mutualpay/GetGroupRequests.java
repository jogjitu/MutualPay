package com.catchblocker.mutualpay;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import com.catchblocker.mutualpay.backend.GetJsonHelper;
import com.catchblocker.mutualpay.backend.JsonDataHelper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jitendra Jogeshwar on 1/2/2015.
 * This class will check any group requests for the member
 * and return if any exists
 */
public class GetGroupRequests extends AsyncTask<String, String,Void> {

    private Exception exception;
    private ProgressDialog progressDialog;
    private int statusCode;

    public GetGroupRequests(ProgressDialog progressDialog){
        this.progressDialog = progressDialog;
    }


    protected void onPreExecute(){
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

    }

    protected Void doInBackground(String... params){
        try{

            performJsonRequest("post",params[0],params[1]);
            if(statusCode == 200) {
                Log.d(GetGroupRequests.class.toString(), "Group saved");
            }
            else{
                Log.d(GetGroupRequests.class.toString(), "Group not saved");
            }

        }
        catch (Exception e){
            this.exception =e;

        }
        return null;
    }


    protected void onPostExecute(Void test){
        progressDialog.dismiss();
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


    public int postJson(String url,String key,String value){
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        try{
            List<NameValuePair> valuePairs = new ArrayList<NameValuePair>(3);
            valuePairs.add(new BasicNameValuePair("auth","9f5bf4669b7c34462db6d76ecd0380ec"));
            valuePairs.add(new BasicNameValuePair("key",key));
            valuePairs.add(new BasicNameValuePair("value",value));
            httpPost.setEntity(new UrlEncodedFormEntity(valuePairs));
            HttpResponse response = client.execute(httpPost);

            StringBuilder sb = new StringBuilder();
            try{
                BufferedReader bufferedReade= new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()),65278);
                String line = null;
                while ((line = bufferedReade.readLine())!=null){
                    sb.append(line);
                }
            }
            catch (IOException e) { e.printStackTrace(); }
            catch (Exception e) { e.printStackTrace(); }
            Log.d("Response String", sb.toString());

            return response.getStatusLine().getStatusCode();
        }
        catch (ClientProtocolException e){
            Log.d(GetJsonHelper.class.toString(),e.getMessage());
            return 0;
        }
        catch (IOException e){
            Log.d(GetJsonHelper.class.toString(),e.getMessage());
            return 0;
        }

    }

    public void performJsonRequest(String requestType,String key,String value){

        switch (requestType){
            case "post":
                statusCode = postJson("http://192.168.0.13/jsonapi/json/set.php",key,value);
                break;

        }

    }
}
