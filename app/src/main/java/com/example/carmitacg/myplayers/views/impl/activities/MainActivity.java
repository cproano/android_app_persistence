package com.example.carmitacg.myplayers.views.impl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carmitacg.myplayers.R;
import com.example.carmitacg.myplayers.models.entities.Equip;
import com.example.carmitacg.myplayers.models.persistence.localdb.getting.EquipDatabaseTransaction;
import com.example.carmitacg.myplayers.models.persistence.localdb.inserting.JugadorInsertDB;
import com.example.carmitacg.myplayers.views.interfaces.IMAINVIEW;

import java.util.List;

/**
 * Created by carmita c g on 28/02/2016.
 */
public class MainActivity extends AppCompatActivity implements OnClickListener, IMAINVIEW {
    private List<Equip> equips;
    private Spinner equipsSpinner;
    private String[] equipsAsArray;
    private Intent i;
    private Button main_ok;
    private  ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.deleteDatabase("MyPlayers.db");
        setContentView(R.layout.main_view);

        prepareList();
        prepareViews();

    }

    private void prepareList(){
        equipsAsArray = getEquipsAsArray();
        adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, equipsAsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
    private void prepareViews(){
        main_ok = (Button) findViewById(R.id.main_ok);
        equipsSpinner = (Spinner) findViewById(R.id.main_spinner);
        equipsSpinner.setAdapter(adapter);
        main_ok.setOnClickListener(this);
    }
    private String[] getEquipsAsArray() {
        EquipDatabaseTransaction equipDatabaseTransaction = new EquipDatabaseTransaction(getBaseContext());

        equips = equipDatabaseTransaction.getAllEquipsAsList();

        equipsAsArray = new String[equips.size()];
        for (int i = 0; i < equipsAsArray.length; i++) {
            equipsAsArray[i] = equips.get(i).getEquipName();
        }
        return equipsAsArray;

    }

    @Override
    public void goToEntrenadorActivity() {
/*
        i = new Intent(getBaseContext(), EntrenadorActivity.class);
        startActivityForResult(i, 1);*/
    }

    @Override
    public void goToEquipActivity() {
        i = new Intent(getBaseContext(), EquipActivity.class);
        String nomEquip = "";
        EquipDatabaseTransaction equipDatabaseTransaction = new EquipDatabaseTransaction(getBaseContext());
        int pos = equipsSpinner.getSelectedItemPosition();
        nomEquip = equipsAsArray[pos];
        String equipId = equipDatabaseTransaction.getEquipId(nomEquip);
        i.putExtra("EquipId", equipId);
        startActivityForResult(i, 1);
        //Toast.makeText(getBaseContext(), "Próximament...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToJugadorsActivity() {
/*
        i = new Intent(getBaseContext(), JugadorsActivity.class);
        startActivityForResult(i, 1);*/
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.main_ok) {
            goToEquipActivity();
            //goToEntrenadorActivity();*/
            //goToJugadorsActivity();
        }
        /*if (v.getId() == R.id.main_jugadors) {
            goToJugadorsActivity();
        }*/
        /*if(v.getId() == R.id.main_equip){
            goToEquipActivity();
        }*/
    }
}
