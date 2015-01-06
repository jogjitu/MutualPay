package com.catchblocker.mutualpay;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.catchblocker.mutualpay.R;
import com.catchblocker.mutualpay.backend.Entites.Group;
import com.catchblocker.mutualpay.backend.JsonDataHelper;

import java.util.UUID;

public class GroupActivity extends ActionBarActivity {
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Button btnAddGroup = (Button)findViewById(R.id.btnAddGroup);
        btnAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddGroupActivity.class);
                startActivity(intent);
                AddGroup();
            }
        });

        Button btnViewGroup = (Button)findViewById(R.id.btnViewGroup);
        ListView groups = (ListView)findViewById(R.id.listView_groupname);
        progressDialog = new ProgressDialog(GroupActivity.this);
        btnViewGroup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(AddGroupActivity.class.toString(), "Clicked on view groups");
                new GetGroupRequests(progressDialog).execute("https://api.myjson.com/bins/19phb");

//                Log.d(JsonDataHelper.class.toString(),);

            }
        });

    }

    public void AddGroup(){

    }

    public void AddBill()
    {
        Intent intent = new Intent(getApplicationContext(),AddBill.class);
        startActivity(intent);
        Bundle b = new Bundle();
        b.putInt("CurrentUserPhone", 1); //phone number
        b.putString("GroupID", ""); // current group id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group, menu);
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
