package com.example.carmitacg.myplayers.models.entities;

/**
 * Created by carmita c g on 01/03/2016.
 */
public class Entrenador {

    private String nom, cognom, EquipNom;

    public Entrenador(String nom, String cognom, String equipNom) {
        this.nom = nom;
        this.cognom = cognom;
        EquipNom = equipNom;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getEquipNom() {
        return EquipNom;
    }
}
