package com.example.carmitacg.myplayers.models.persistence.localdb.interfaces;

import com.example.carmitacg.myplayers.models.entities.Categoria;

import java.util.List;

/**
 * Created by carmita c g on 04/03/2016.
 */
public interface ICATEGORIADATABASE {

    public List<Categoria> getCategoriesByEquipId(String EquipId);

    public void insertCategoria(Categoria categoria);
}
