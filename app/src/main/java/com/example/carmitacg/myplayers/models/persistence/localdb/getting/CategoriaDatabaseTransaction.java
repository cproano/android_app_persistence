package com.example.carmitacg.myplayers.models.persistence.localdb.getting;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carmitacg.myplayers.models.entities.Categoria;
import com.example.carmitacg.myplayers.models.persistence.localdb.PlayersSQLiteDatabase;
import com.example.carmitacg.myplayers.models.persistence.localdb.interfaces.ICATEGORIADATABASE;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carmita c g on 04/03/2016.
 */
public class CategoriaDatabaseTransaction implements ICATEGORIADATABASE {

    private PlayersSQLiteDatabase datasource;
    private SQLiteDatabase db;
    private Context context;

    public CategoriaDatabaseTransaction(Context context){
        datasource = new PlayersSQLiteDatabase(context);
        this.context = context;
    }

    @Override
    public List<Categoria> getCategoriesByEquipId(String EquipId) {
        List<Categoria> categories = new ArrayList<>();
        db = datasource.getReadableDatabase();

        Cursor c = db.rawQuery("Select * from CATEGORIA where EquipId = ?", new String[]{EquipId});

        c.moveToFirst();
        while(!c.isAfterLast()){

            categories.add(new Categoria(
                    c.getString(c.getColumnIndex("CategoriaId")),
                    c.getString(c.getColumnIndex("Descripcio")),
                    c.getString(c.getColumnIndex("EquipId"))
            ));
            c.moveToNext();
        }
        return categories;
    }

    @Override
    public void insertCategoria(Categoria categoria) {

    }
}
