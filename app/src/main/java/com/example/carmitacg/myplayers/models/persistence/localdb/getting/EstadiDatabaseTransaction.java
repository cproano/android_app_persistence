package com.example.carmitacg.myplayers.models.persistence.localdb.getting;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carmitacg.myplayers.models.persistence.localdb.PlayersSQLiteDatabase;
import com.example.carmitacg.myplayers.models.persistence.localdb.interfaces.IESTADIDATABASE;

/**
 * Created by carmita c g on 01/03/2016.
 */
public class EstadiDatabaseTransaction implements IESTADIDATABASE {


    private PlayersSQLiteDatabase datasource;
    private SQLiteDatabase db;

    public EstadiDatabaseTransaction(Context context){
        datasource = new PlayersSQLiteDatabase(context);
    }
    @Override
    public String getEstadiNom(String EstadiId) {
        db = datasource.getReadableDatabase();
        Cursor c = db.rawQuery(
                "Select EstadiName from ESTADI where EstadiId = ?",
                new String[]{
                        EstadiId
                }
        );
        c.moveToFirst();
        return c.getString(c.getColumnIndex("EstadiName"));
    }
}
