package com.example.carmitacg.myplayers.models.persistence.localdb.interfaces;

import android.database.Cursor;

import com.example.carmitacg.myplayers.models.entities.Entrenador;

import java.util.List;

/**
 * Created by carmita c g on 01/03/2016.
 */
public interface IENTRENADORDATABASE {
    public List<Entrenador> getEntrenadors();
}
