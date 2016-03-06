package com.example.carmitacg.myplayers.models.persistence.localdb.interfaces;

import android.database.Cursor;

import com.example.carmitacg.myplayers.models.entities.Jugador;

import java.util.List;

/**
 * Created by carmita c g on 29/02/2016.
 */
public interface IPLAYERSDATABASETRANSACTION {

    public Cursor getAllPlayersAsCursor();
    public List<Jugador> getAllPlayersAsList(String EquipId, String CategoriaId);
    public Jugador getJugadorById(String id);
    public void updateJugador(String[] values, String PlayerId);
    public void insertJugador(String[] values);
    public Cursor getPlayersByCategory( String EquipId, String CategoryId);
}
