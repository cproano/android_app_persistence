package com.example.carmitacg.myplayers.models.persistence.localdb.interfaces;

import android.database.Cursor;

import com.example.carmitacg.myplayers.models.entities.Equip;

import java.util.List;

/**
 * Created by carmita c g on 01/03/2016.
 */
public interface IEQUIPDATABASE {
    public Cursor getAllEquips();
    public List<Equip> getAllEquipsAsList();
    public String getEquipId(String NomEquip);
    public String getEquipNom(String EquipId);

}
