package com.catchblocker.mutualpay.backend;

import com.catchblocker.mutualpay.backend.Entites.Bill;
import com.catchblocker.mutualpay.backend.Entites.GroupMember;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by public on 1/3/2015.
 */
public class BillProcessor {

    public void RefreshBillList(String billJson)
    {
        // convert string to json
        ArrayList<Bill> newBills = new ArrayList<Bill>();
        for (int i=0; i< newBills.size(); i++)
        {

            Bill bill = newBills.get(i);
            // Save bill to db4o
        }
    }

    public ArrayList<Bill> GetOfflineBills()
    {
        ArrayList<Bill> newBills = new ArrayList<Bill>();
        // Get all bills from db4o Where ISSynchronized = FALSE
        return newBills;
    }

    /*public Map<String, ArrayList<Bill>> GetBillsToSync(UUID GroupID)
    {
        String currentUserPhone = ""; // Get Current user number
        Map<String, ArrayList<Bill>> billsForProfile = new HashMap<String, ArrayList<Bill>>();
        ArrayList<GroupMember> members = new ArrayList<GroupMember>();
        // get the group object from db4 and loop through all members

        ArrayList<Bill> bills = new ArrayList<Bill>();
        for (int i = 0; i< members.size(); i++)
        {
           GroupMember member = members.get(i);
            if (member.getPhoneNumber() == currentUserPhone)
            {
                billsForProfile.put(member.getPhoneNumber(), bills);
            }
        }
        return billsForProfile;
    }*/
}
