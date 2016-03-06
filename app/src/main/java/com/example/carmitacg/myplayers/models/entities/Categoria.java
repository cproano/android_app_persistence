package com.example.carmitacg.myplayers.models.entities;

/**
 * Created by carmita c g on 04/03/2016.
 */
public class Categoria  {

    private final String categoriaId;
    private final String equipId;
    private final String descripcio;

    public Categoria(String categoriaId,String descripcio, String equipId){
        this.categoriaId = categoriaId;
        this.descripcio = descripcio;
        this.equipId = equipId;


    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public String getEquipId() {
        return equipId;
    }

    public String getDescripcio() {
        return descripcio;
    }
}
