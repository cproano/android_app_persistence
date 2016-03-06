package com.example.carmitacg.myplayers.models.entities;

import com.example.carmitacg.myplayers.models.persistence.localdb.getting.EstadiDatabaseTransaction;

/**
 * Created by carmita c g on 01/03/2016.
 */
public class Equip {
    private String EquipName, EquipPresident, EstadiName, EstadiId;

    public Equip(String EquipName, String EquipPresident, String EstadiId,String EstadiName){
        this.EquipName = EquipName;
        this.EquipPresident = EquipPresident;
        this.EstadiId = EstadiId;
        this.EstadiName = EstadiName;
    }

    public String getEstadiId() {
        return EstadiId;
    }

    public String getEquipName() {
        return EquipName;
    }

    public String getEquipPresident() {
        return EquipPresident;
    }

    public String getEstadiName() {
        return EstadiName;
    }
}
