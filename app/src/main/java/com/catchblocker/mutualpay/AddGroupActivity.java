package com.catchblocker.mutualpay;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.catchblocker.mutualpay.backend.Entites.Group;
import com.catchblocker.mutualpay.backend.Entites.Profile;
import com.catchblocker.mutualpay.backend.GroupBase;

import java.util.ArrayList;
import java.util.List;


public class AddGroupActivity extends ListActivity {

    ArrayList<String> list = new ArrayList<String>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        Button btnAddGroupMember = (Button) findViewById(R.id.btnAddGroup);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        btnAddGroupMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.textboxAddItem);
                list.add(edit.getText().toString());
                edit.setText("");
                adapter.notifyDataSetChanged();
                setListAdapter(adapter);
            }
        });

        Button btnSaveGroup = (Button) findViewById(R.id.btnSaveGroup);
        btnSaveGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveGroup();
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_group, menu);
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

    private void saveGroup() {
        Group group = new Group();
        GroupBase groupBase = new GroupBase();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        EditText groupNameText = (EditText)findViewById(R.id.textGroupName);
        group.setGroupName(groupNameText.getText().toString());
        EditText currencyText = (EditText)findViewById(R.id.textCurrency);
        group.setCurrency(currencyText.getText().toString());
        ArrayList<Profile> members = new ArrayList<Profile>();
        String listValue;
        Profile profile;
        for(int i = 0; i < adapter.getCount();i++){
            listValue = adapter.getItem(i).toString();

            profile = new Profile(listValue.split(" ")[0],listValue.split(" ")[1]);
            members.add(profile);
        }
        group.setGroupMembers(members);
        groupBase.storeGroup(group,getApplicationContext());
        viewGroup();
    }

    public void viewGroup(){
        TextView groupNameText = (TextView)findViewById(R.id.textShowGroup);
        GroupBase groupBase = new GroupBase();
        List<Group> groups = groupBase.getAllGroups(getApplicationContext());
        groupNameText.setText(groups.get(groups.size()-1).getGroupName());
    }
}
