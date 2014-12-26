package com.catchblocker.mutualpay.backend;

import android.content.Context;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.io.File;

/**
 * Created by Jitendra Jogeshwar on 12/26/2014.
 * This will help performing CRUD operations on
 * database
 */
public class DBProvider
{
    private static final String DATABASE_PATH = "MutualPayDB";
    private Context context;

    public DBProvider(Context context){
        this.context = context;
    }

    public ObjectContainer openDb(){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), String.valueOf(context.getDir("data", Context.MODE_APPEND))+"\\"+DATABASE_PATH);
        return db;
    }

    public void closeDb(ObjectContainer db){
        db.close();
    }


}
