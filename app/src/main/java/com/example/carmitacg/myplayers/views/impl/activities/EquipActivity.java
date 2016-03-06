package com.example.carmitacg.myplayers.views.impl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.carmitacg.myplayers.R;
import com.example.carmitacg.myplayers.helpers.DownloadImagesTask;
import com.example.carmitacg.myplayers.models.entities.Categoria;
import com.example.carmitacg.myplayers.models.persistence.localdb.getting.CategoriaDatabaseTransaction;
import com.example.carmitacg.myplayers.views.impl.adapters.CategoriaAdapter;

import java.util.List;

/**
 * Created by carmita c g on 28/02/2016.
 */
public class EquipActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView cat_lv;
    private ImageView esc_iv;
    private ImageView eq_iv;
    private List<Categoria> categories;
    private CategoriaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equip_layout);
        String EquipId = getIntent().getStringExtra("EquipId");
        prepareList(EquipId);
        PrepareViews();
        prepareImageView(EquipId);


    }

    private void prepareImageView(String equipId) {
        switch (equipId) {
            case "1":
                esc_iv.setTag("http://www.escudosdefutbol.stg7.net/catalunya/catacua27/La%20Canya.jpg");
                eq_iv.setTag("http://agrupaciopatrocinios.com/wp-content/uploads/2015/07/La-Canya.jpg");
                break;

        }
    }


    private void prepareList(String EquipId) {
        categories = getCategoriesByEquip(EquipId);

    }

    private void downloadImage() {

        DownloadImagesTask downloadImagesTask1 = new DownloadImagesTask();
        DownloadImagesTask downloadImagesTask2 = new DownloadImagesTask();

        downloadImagesTask1.execute(esc_iv);
        downloadImagesTask2.execute(eq_iv);
    }

    private List<Categoria> getCategoriesByEquip(String equipId) {

        CategoriaDatabaseTransaction categoriaDatabaseTransaction = new CategoriaDatabaseTransaction(getBaseContext());
        return categoriaDatabaseTransaction.getCategoriesByEquipId(equipId);
    }

    private void PrepareViews() {
        cat_lv = (ListView) findViewById(R.id.equip_list);
        esc_iv = (ImageView) findViewById(R.id.escut_view);
        eq_iv = (ImageView) findViewById(R.id.equip_image);
        adapter = new CategoriaAdapter(getBaseContext(), R.layout.equip_layout, categories);
        cat_lv.setAdapter(adapter);
        cat_lv.setOnItemClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        downloadImage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //getMenuInflater().inflate(R.menu.jugadors_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /*if(item.getItemId() == R.id.action_search_player){

        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String catId = categories.get(position).getCategoriaId();
        String equipId = categories.get(position).getEquipId();

        Intent i = new Intent(getBaseContext(), JugadorsActivity.class);
        i.putExtra("catId", catId);
        i.putExtra("equipId", equipId);

        startActivityForResult(i, 1);
    }
}
