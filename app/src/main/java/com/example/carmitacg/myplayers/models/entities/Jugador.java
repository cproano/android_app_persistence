package com.example.carmitacg.myplayers.models.entities;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by carmita c g on 28/02/2016.
 */
public class Jugador{

    private String nom, cognom, posició, equip;
    private int gols;
    private float  mitjanaGols;
    private int partitsJugats;
    public Jugador(String nom, String cognom, String posició, int gols,  int partitsJugats, float mitjanaGols, String nomEquip) {
        this.nom = nom;
        this.cognom = cognom;
        this.posició = posició;
        this.gols = gols;
        this.equip = nomEquip;
        this.mitjanaGols = mitjanaGols;
        this.partitsJugats = partitsJugats;

    }

    public String getEquip() {
        return equip;
    }

    public int getGols() {
        return gols;
    }

    public float getMitjanaGols() {
        return mitjanaGols;
    }

    public int getPartitsJugats() {
        return partitsJugats;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getPosició() {
        return posició;
    }
}
