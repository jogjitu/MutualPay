package com.catchblocker.mutualpay;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.catchblocker.mutualpay.backend.Entites.Bill;

import java.sql.Date;
import java.util.UUID;


public class AddBill extends ActionBarActivity {
    public UUID GroupID;
    public int PaidByMember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);
        Button btnSaveBill = (Button) findViewById(R.id.btnSaveBill);
        btnSaveBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveBill();
            }

        });

        /*Get from bundle*/
        Bundle b = getIntent().getExtras();
        PaidByMember = b.getInt("CurrentUserPhone");
        GroupID  = UUID.fromString(b.getString("GroupID"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_bill, menu);
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

    public void SaveBill()
    {

        Bill newBill = new Bill();

        EditText amountText = (EditText)findViewById(R.id.txtAmount);
        newBill.setAmount(Double.valueOf(amountText.getText().toString()));
        EditText dateText = (EditText)findViewById(R.id.txtDate);
        newBill.setBillDate(Date.valueOf(dateText.getText().toString()));
        EditText remarkText = (EditText)findViewById(R.id.txtDescription);
        newBill.setRemark(remarkText.getText().toString());

        newBill.setPaidByMember(this.PaidByMember);
        newBill.setGroupID(this.GroupID);

        // Save to DB 4
    }
}
