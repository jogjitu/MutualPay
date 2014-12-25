package com.catchblocker.mutualpay;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.catchblocker.mutualpay.backend.Entites.Profile;
import com.catchblocker.mutualpay.backend.ProfileBase;


public class UserProfile extends ActionBarActivity {
    ProfileBase profileBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Button saveProfile = (Button) findViewById(R.id.btnSave);

        Button saveButton = (Button)findViewById(R.id.btnSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveProfile();
            }
        });

        Button viewButton = (Button)findViewById(R.id.btnView);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewProfile();
            }
        });

    }

    public void SaveProfile(){
        profileBase = new ProfileBase(getApplicationContext());
        EditText usernameText = (EditText)findViewById(R.id.textUserName);
        EditText passwordText = (EditText)findViewById(R.id.txtPNumber);
        String userName = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        Profile profile = new Profile(userName,password);
        profileBase.saveProfile(profile);
        TextView messageView = (TextView)findViewById(R.id.Message);
        messageView.setText("Saved successfully");
    }

    public void ViewProfile(){
        profileBase = new ProfileBase(getApplicationContext());
        TextView messageView = (TextView)findViewById(R.id.Message);
        messageView.setText("");
        TextView usernameView = (TextView)findViewById(R.id.Name);
        TextView PhoneView = (TextView)findViewById(R.id.PhoneNumber);
        usernameView.setText(profileBase.getProfile().getName());
        PhoneView.setText(profileBase.getProfile().getPhoneNumber());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
