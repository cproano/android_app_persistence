package com.example.carmitacg.myplayers.views.impl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.carmitacg.myplayers.R;
import com.example.carmitacg.myplayers.models.entities.Equip;
import com.example.carmitacg.myplayers.models.entities.Jugador;
import com.example.carmitacg.myplayers.models.persistence.localdb.getting.EquipDatabaseTransaction;
import com.example.carmitacg.myplayers.models.persistence.localdb.getting.PlayersDatabaseTransaction;

import java.util.List;

/**
 * Created by carmita c g on 28/02/2016.
 */
public class NewJugadorActivity extends AppCompatActivity {
    private EditText nom, cognom, posicio, gols, matches;
    private Spinner equipsSpinner;
    private List<Equip> equips;
    private String[] equipsAsArray;
    private Intent i;
    private String catId;
    private String equipId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nou_jugador);
        catId = getIntent().getStringExtra("catId");
        equipId = getIntent().getStringExtra("equipId");
        findViews();
/*
        Aquest tros que està comentat, ja no serveix degut a que, com que passem l'id de l'equip i de la categoria a la qual volem afegir el jugador, no cal seleccionar cap equip
 equipsAsArray = getEquipsAsArray();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, equipsAsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        equipsSpinner.setAdapter(adapter);*/
    }

   /* private String[] getEquipsAsArray() {
        EquipDatabaseTransaction equipDatabaseTransaction = new EquipDatabaseTransaction(getBaseContext());

        equips = equipDatabaseTransaction.getAllEquipsAsList();

        equipsAsArray = new String[equips.size()];
        for(int i = 0; i < equipsAsArray.length; i++){
            equipsAsArray[i] = equips.get(i).getEquipName();
        }
        return equipsAsArray;

    }
*/
    private void findViews() {
        //EditText
        nom = (EditText) findViewById(R.id.nou_nom_edit);
        cognom = (EditText) findViewById(R.id.nou_cognom_edit);
        posicio = (EditText) findViewById(R.id.nou_posicio_edit);
        gols = (EditText) findViewById(R.id.nou_gols_edit);
        matches = (EditText) findViewById(R.id.nou_matches_edit);
//        equipsSpinner = (Spinner) findViewById(R.id.equips_spinner);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_jugador_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add_player){
            addPlayer();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void addPlayer() {

        String mitjana = calcularMitjana(gols, matches);
        PlayersDatabaseTransaction playersDatabaseTransaction = new PlayersDatabaseTransaction(getBaseContext());
        playersDatabaseTransaction.insertJugador(new String[]{
                nom.getText().toString(),
                cognom.getText().toString(),
                posicio.getText().toString(),
                gols.getText().toString(),
                matches.getText().toString(),
                mitjana,
                equipId,
                catId
        });
    }
    //Mètode que serveix per calcular la mitjana de gols per partit

    private String calcularMitjana(EditText gols, EditText partits) {
        int goals = Integer.parseInt(gols.getText().toString());
        int matches = Integer.parseInt(partits.getText().toString());
        float mitjana = (float) goals / matches;
        return String.format("%.1f",mitjana);
    }
}
