package com.example.carmitacg.myplayers.views.impl.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import com.example.carmitacg.myplayers.R;

import com.example.carmitacg.myplayers.models.entities.Jugador;
import com.example.carmitacg.myplayers.models.persistence.localdb.getting.PlayersDatabaseTransaction;
import com.example.carmitacg.myplayers.models.persistence.localdb.inserting.JugadorInsertDB;
import com.example.carmitacg.myplayers.views.impl.adapters.JugadorsAdapter;

import java.util.List;

/**
 * Created by carmita c g on 28/02/2016.
 */
public class JugadorsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private ListView llista;
    private ImageView image;
    private List<Jugador> jugadors;
    private Intent i;
    private JugadorsAdapter adapter;
    private String equipId;
    private String catId;
    private AppBarLayout barLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        //jugadors = new JugadorsBuilder();

        i = getIntent();
        equipId = i.getStringExtra("equipId");
        catId = i.getStringExtra("catId");
        prepareViews();


        jugadors = getJugadors(equipId, catId);


        if (jugadors.size() == 0) {

            insertJugadors();
            jugadors = getJugadors(equipId, catId);
        }

        adapter = new JugadorsAdapter(getBaseContext(), R.layout.jugadors_view, jugadors);
        llista.setAdapter(adapter);
        llista.setOnItemClickListener(this);
    }

    private void insertJugadors() {

        JugadorInsertDB insertDB = new JugadorInsertDB(getBaseContext());

        switch (catId) {

            case "1":
                insertDB.insertQuartaCatalana();
                break;
            case "2":

                break;
            case "3":

                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                insertDB.insertAleviJugadors();
                break;
            case "7":
                break;
        }

    }

    private void prepareViews() {
        llista = (ListView) findViewById(R.id.jugadors_list);
        //image = (ImageView) findViewById(R.id.team_image);
        barLayout = (AppBarLayout) findViewById(R.id.app_bar);
        switch (catId) {
            case "1":
                barLayout.setBackgroundResource(R.mipmap.quarta_catalana);
                break;
            case "6":
                barLayout.setBackgroundResource(R.mipmap.alevi_b);
                break;
        }
        //barLayout.setBackgroundResource(R.mipmap.alevi);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private List<Jugador> getJugadors(String equipId, String catId) {
        PlayersDatabaseTransaction playersDatabaseTransaction = new PlayersDatabaseTransaction(getBaseContext());
        return playersDatabaseTransaction.getAllPlayersAsList(equipId, catId);
    }

    private List<Jugador> getJugadorsFiltrats(String filtre, String catId) {
        PlayersDatabaseTransaction playersDatabaseTransaction = new PlayersDatabaseTransaction(getBaseContext());

        return playersDatabaseTransaction.getJugadorsFiltered(filtre, catId);

    }

/*    @Override
    protected void onStart() {
        super.onStart();
        DownloadImagesTask imagesTask = new DownloadImagesTask();
        imagesTask.execute(image);
    }*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        goToJugadorDetailActivity(position);


    }

    private void goToJugadorDetailActivity(int position) {
        i = new Intent(getBaseContext(), JugadorDetailActivity.class);
        i.putExtra("nomJugador", jugadors.get(position).getNom());
        i.putExtra("cognomJugador", jugadors.get(position).getCognom());
        i.putExtra("posicio", jugadors.get(position).getPosició());
        i.putExtra("gols", String.valueOf(jugadors.get(position).getGols()));
        i.putExtra("equip", jugadors.get(position).getEquip());
        i.putExtra("mitjana", Float.toString(jugadors.get(position).getMitjanaGols()));
        startActivityForResult(i, 1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_new_jugador) {
            i = new Intent(getBaseContext(), NewJugadorActivity.class);

            i.putExtra("catId", catId);
            i.putExtra("equipId", equipId);
            startActivityForResult(i, 1);
        }
        if (item.getItemId() == R.id.cancel) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.jugadors_menu, menu);

        SearchView searchView = (SearchView) menu.getItem(0).getActionView();


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        return (super.onCreateOptionsMenu(menu));
    }


    @Override
    protected void onRestart() {
        jugadors = getJugadors(equipId, catId);
        llista.setAdapter(new JugadorsAdapter(getBaseContext(), R.layout.jugadors_view, jugadors));
        super.onRestart();

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_search_player) {

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        adapter.getFilter().filter(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<Jugador> jugadors = getJugadorsFiltrats(newText, catId);
        adapter = new JugadorsAdapter(getBaseContext(), R.layout.jugadors_view, jugadors);
        adapter.getFilter().filter(newText);
        llista.setAdapter(adapter);
        return true;
    }

}
