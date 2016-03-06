package com.example.carmitacg.myplayers.views.impl.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carmitacg.myplayers.R;
import com.example.carmitacg.myplayers.helpers.DownloadImagesTask;
import com.example.carmitacg.myplayers.helpers.JugadorsImageBuilder;
import com.example.carmitacg.myplayers.models.entities.Jugador;

import org.parceler.Parcels;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by carmita c g on 28/02/2016.
 */
public class JugadorDetailActivity extends AppCompatActivity {
    private TextView nom, cognom, posicio, gols, equip, mitjana;
    private Button button;
    private Intent i;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jugador_detail);
        i = getIntent();

        String nomJ = i.getStringExtra("nomJugador");
        String cogJ = i.getStringExtra("cognomJugador");
        String posJ = i.getStringExtra("posicio");
        String golsJ = i.getStringExtra("gols");
        String equipJ = i.getStringExtra("equip");
        String mitjanagols = i.getStringExtra("mitjana");
        findViews();
        setTextViews(nomJ,cogJ,posJ,golsJ, equipJ, mitjanagols);
        //url = getUrl(position);
        /*button.setOnClickListener(this);*/

    }

    private void findViews() {

        nom = (TextView) findViewById(R.id.detail_nom_textview);
        cognom = (TextView) findViewById(R.id.detail_cognom);
        posicio = (TextView) findViewById(R.id.detail_posicio);
        gols = (TextView) findViewById(R.id.detail_gols);
        equip = (TextView) findViewById(R.id.detail_equip);
        mitjana = (TextView) findViewById(R.id.detail_mitjana);

    }

    private void setTextViews(String nomJ, String cogJ, String posJ, String golsJ, String equipJ,String mitjanagols) {
        nom.setText(nomJ);
        cognom.setText(cogJ);
        posicio.setText(posJ);
        gols.setText(golsJ);
        equip.setText(equipJ);
        mitjana.setText(mitjanagols);
    }


    private String getUrl(int posicio){

        JugadorsImageBuilder jugadors = new JugadorsImageBuilder();
        return jugadors.get(posicio);

    }

/*    @Override
    public void onClick(View v) {
        *//*if(v.getId() == R.id.jugador_image){
*//**//*            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);*//**//*
*//**//*            DownloadImagesTask downloadImagesTask = new DownloadImagesTask();
            downloadImagesTask.execute(imatge);*//**//*
        }*//*
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_cancel){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.jugador_detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
