package com.example.carmitacg.myplayers.models.persistence.localdb.getting;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carmitacg.myplayers.models.entities.Entrenador;
import com.example.carmitacg.myplayers.models.persistence.localdb.PlayersSQLiteDatabase;
import com.example.carmitacg.myplayers.models.persistence.localdb.interfaces.IENTRENADORDATABASE;
import com.example.carmitacg.myplayers.models.persistence.localdb.interfaces.IEQUIPDATABASE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carmita c g on 01/03/2016.
 */
public class EntrenadorDatabaseTransaction implements IENTRENADORDATABASE {
    private PlayersSQLiteDatabase datasource;
    private SQLiteDatabase db;
    private Context context;

    public EntrenadorDatabaseTransaction(Context context){
        this.context = context;
        datasource = new PlayersSQLiteDatabase(context);

    }

    @Override
    public List<Entrenador> getEntrenadors() {
        EquipDatabaseTransaction equipDatabaseTransaction = new EquipDatabaseTransaction(context);

        db = datasource.getReadableDatabase();
        List<Entrenador> entrenadors = new ArrayList();
        Cursor c = db.rawQuery(
                "Select EntrenadorName, EntrenadorSurname, EquipId",
                new String[0]
        );

        if(c.moveToFirst()){
            while(!c.isAfterLast()){
                 String nomEquip = equipDatabaseTransaction.getEquipNom(
                        c.getString(c.getColumnIndex("EquipId"))
                );
                entrenadors.add(new Entrenador(

                        c.getString(c.getColumnIndex("EntrenadorName")),
                        c.getString(c.getColumnIndex("EntrenadorSurname")),
                        nomEquip
                ));
            }
        }
        return entrenadors;
    }
}
