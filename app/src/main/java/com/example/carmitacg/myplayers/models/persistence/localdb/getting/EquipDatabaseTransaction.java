package com.example.carmitacg.myplayers.models.persistence.localdb.getting;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carmitacg.myplayers.models.entities.Equip;
import com.example.carmitacg.myplayers.models.persistence.localdb.PlayersSQLiteDatabase;
import com.example.carmitacg.myplayers.models.persistence.localdb.interfaces.IEQUIPDATABASE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carmita c g on 01/03/2016.
 */
public class EquipDatabaseTransaction implements IEQUIPDATABASE {

    private PlayersSQLiteDatabase datasource;
    private SQLiteDatabase db;

    public EquipDatabaseTransaction(Context context){
        datasource = new PlayersSQLiteDatabase(context);
    }
    @Override
    public Cursor getAllEquips() {
        db = datasource.getReadableDatabase();

        return db.rawQuery(
                "Select * from EQUIP",
                new String[0]
        );
    }

    @Override
    public List<Equip> getAllEquipsAsList() {
        List<Equip> equips = new ArrayList();
        Cursor c = getAllEquips();
        String EquipNom = "";
        if(c.moveToFirst()){
            while(!c.isAfterLast()){
                EquipNom = getEquipNom(c.getString(c.getColumnIndex("EquipId")));
                equips.add(
                        new Equip(
                                c.getString(
                                        c.getColumnIndex("EquipName")
                                ),
                                c.getString(
                                        c.getColumnIndex("EquipPresident")
                                ),
                                c.getString(
                                        c.getColumnIndex("EquipId")
                                ),
                                EquipNom


                ));
                c.moveToNext();
            }
        }
        return equips;
    }

    @Override
    public String getEquipId(String NomEquip) {
        db = datasource.getReadableDatabase();
        Cursor c = db.rawQuery(
                "select EquipId from EQUIP where EquipName = ?",
                new String[]{
                        NomEquip
                }
        );
        c.moveToFirst();
        String EquipId = c.getString(c.getColumnIndex("EquipId"));
        c.close();
        return EquipId;
    }

    @Override
    public String getEquipNom(String EquipId) {

        db = datasource.getReadableDatabase();
        Cursor c = db.rawQuery(
                "select EquipName from EQUIP where EquipId = ?",
                new String[]{
                        EquipId
                }
        );
        c.moveToFirst();
        String nom = c.getString(c.getColumnIndex("EquipName"));
        c.close();
        return nom;
    }
}
