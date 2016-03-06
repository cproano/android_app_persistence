package com.example.carmitacg.myplayers.models.persistence.localdb.getting;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.carmitacg.myplayers.helpers.JugadorsBuilder;
import com.example.carmitacg.myplayers.models.entities.Jugador;
import com.example.carmitacg.myplayers.models.persistence.localdb.PlayersSQLiteDatabase;
import com.example.carmitacg.myplayers.models.persistence.localdb.interfaces.IPLAYERSDATABASETRANSACTION;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carmita c g on 29/02/2016.
 */
public class PlayersDatabaseTransaction implements IPLAYERSDATABASETRANSACTION{
    private PlayersSQLiteDatabase datasource;
    private SQLiteDatabase db;
    private Context context;
    public PlayersDatabaseTransaction(Context context){
        datasource = new PlayersSQLiteDatabase(context);
    this.context = context;
    }

    @Override
    public Cursor getAllPlayersAsCursor() {
        db = datasource.getReadableDatabase();

        return db.rawQuery("Select * from JUGADOR", new String[0]);
    }


    @Override
    public List<Jugador> getAllPlayersAsList(String EquipId, String CategoriaId) {
        List<Jugador> jugadors = new ArrayList();
        EquipDatabaseTransaction equipDatabaseTransaction = new EquipDatabaseTransaction(context);
        Cursor curs = getPlayersByCategory(EquipId,CategoriaId);
        String nomEquip = "";
        if(curs.moveToFirst()){
            while(!curs.isAfterLast()){

                jugadors.add(new Jugador(
                        curs.getString(curs.getColumnIndex("JugadorName")),
                        curs.getString(curs.getColumnIndex("JugadorSurname")),
                        curs.getString(curs.getColumnIndex("Posicio")),
                        Integer.parseInt(curs.getString(curs.getColumnIndex("JugadorGoals"))),
                        Integer.parseInt(curs.getString(curs.getColumnIndex("JugadorMatches"))),
                        Float.parseFloat(curs.getString(curs.getColumnIndex("JugadorMitjanaGols"))),
                        equipDatabaseTransaction.getEquipNom(
                                curs.getString(curs.getColumnIndex("EquipId"))
                        )
                        ));
                curs.moveToNext();
            }
        }
        return jugadors;
    }

    @Override
    public Jugador getJugadorById(String id) {

        EquipDatabaseTransaction equipDatabaseTransaction = new EquipDatabaseTransaction(context);
                db = datasource.getReadableDatabase();

        Cursor curs = db.rawQuery(
                "select JugadorName, JugadorSurname,Posicio, JugadorGoals, JugadorMatches, JugadorMitjanaGols, EquipId from JUGADOR where JugadorId = ?",
                new String[]
                        {
                                id
                        }
        );
        //Ens movem cap el primer objecte del cursor, 0, perquè per defecte es col·loca en l'objecte -1. Retornaria error
        curs.moveToFirst();
        String equipName = equipDatabaseTransaction.getEquipNom(curs.getString(curs.getColumnIndex("EquipId")));
        Jugador jugador = new Jugador(
                curs.getString(curs.getColumnIndex("JugadorName")),
                curs.getString(curs.getColumnIndex("JugadorSurname")),
                curs.getString(curs.getColumnIndex("Posicio")),
                Integer.parseInt(curs.getString(curs.getColumnIndex("JugadorGoals"))),
                Integer.parseInt(curs.getString(curs.getColumnIndex("JugadorMatches"))),
                Float.parseFloat(curs.getString(curs.getColumnIndex("JugadorMitjanaGols"))),
                equipName
        );
        return jugador;
    }

    @Override
    public void updateJugador(String[] values, String PlayerId) {


    }

    public Cursor getPlayersFiltered(String filter, String catId){
        db = datasource.getReadableDatabase();

        return db.rawQuery("Select * from JUGADOR where CategoriaId = ? and JugadorName LIKE ?", new String[]{catId,filter+"%"});
    }
    public List<Jugador> getJugadorsFiltered(String filtre, String catId){
        List<Jugador> jugadors = new ArrayList();
        EquipDatabaseTransaction equipDatabaseTransaction = new EquipDatabaseTransaction(context);
        Cursor curs = getPlayersFiltered(filtre, catId);
        String nomEquip = "";
        if(curs.moveToFirst()){
            while(!curs.isAfterLast()){

                jugadors.add(new Jugador(
                        curs.getString(curs.getColumnIndex("JugadorName")),
                        curs.getString(curs.getColumnIndex("JugadorSurname")),
                        curs.getString(curs.getColumnIndex("Posicio")),
                        Integer.parseInt(curs.getString(curs.getColumnIndex("JugadorGoals"))),
                        Integer.parseInt(curs.getString(curs.getColumnIndex("JugadorMatches"))),
                        Float.parseFloat(curs.getString(curs.getColumnIndex("JugadorMitjanaGols"))),
                        equipDatabaseTransaction.getEquipNom(
                                curs.getString(curs.getColumnIndex("EquipId"))
                        )
                ));
                curs.moveToNext();
            }
        }
        return jugadors;
    }
    @Override
    public void insertJugador(String[] values) {
        db = datasource.getReadableDatabase();

        db.execSQL("insert into JUGADOR(JugadorName, JugadorSurname, Posicio, JugadorGoals, JugadorMatches, JugadorMitjanaGols, EquipId, CategoriaId) values(?,?,?,?,?,?,?,?)", values);
    }

    @Override
    public Cursor getPlayersByCategory( String EquipId, String CategoryId) {

        db = datasource.getReadableDatabase();

        return db.rawQuery("Select * from JUGADOR where EquipId = ? and CategoriaId = ?", new String[]{ EquipId, CategoryId});

    }
}
