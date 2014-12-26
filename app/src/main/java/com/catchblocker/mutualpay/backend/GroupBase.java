package com.catchblocker.mutualpay.backend;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.catchblocker.mutualpay.backend.Entites.Group;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Jitendra Jogeshwar on 12/26/2014.
 * This class will perform action Group entity
 */
public class GroupBase {
    private DBProvider dbProvider;
    private ObjectContainer db;

    public void storeGroup(Group group, Context context){
        dbProvider = new DBProvider(context);
        db = dbProvider.openDb();
        db.store(group);
        db.commit();
        dbProvider.closeDb(db);
        Log.d("Group with name: " + group.groupName,"stored successfully");
    }

    public List<Group> fetchGroup(Group group, Context context){
        dbProvider = new DBProvider(context);
        db = dbProvider.openDb();
        ObjectSet groupList = db.queryByExample(group);
        List<Group> groups = new ArrayList<Group>();
        dbProvider.closeDb(db);
        if (groupList.hasNext()) {
            groups.add((Group) groupList.next());
        }
        return groups;
    }

    public List<Group> getAllGroups(Context context){
        Group group = new Group();
        dbProvider = new DBProvider(context);
        db = dbProvider.openDb();
        ObjectSet groupList = db.queryByExample(group);
        List<Group> groups = new ArrayList<Group>();

        if (groupList.hasNext()) {
            groups.add((Group) groupList.next());
        }
        dbProvider.closeDb(db);
        return groups;

    }

    public void updateGroup(Group group, Context context){
        dbProvider = new DBProvider(context);
        db = dbProvider.openDb();
        ObjectSet groupList = db.queryByExample(group);
        if (groupList.hasNext()){
            Group groupFound = (Group) groupList.next();
            groupFound.setCurrency(group.currency);
            groupFound.setGroupMembers(group.GroupMembers);
            groupFound.setGroupName(group.groupName);
            db.store(groupFound);
            db.commit();
            Log.d("Group with name: " + group.groupName,"updated successfully");
        }
        dbProvider.closeDb(db);
    }

    public void deleteGroup(Group group, Context context){
        dbProvider = new DBProvider(context);
        db = dbProvider.openDb();
        ObjectSet groupList = db.queryByExample(group);
        if (groupList.hasNext()){
            Group groupFound = (Group) groupList.next();
            db.delete(group);
            db.commit();
            Log.d("Group with name: " + group.groupName,"deleted successfully");
        }
        dbProvider.closeDb(db);
    }
}
