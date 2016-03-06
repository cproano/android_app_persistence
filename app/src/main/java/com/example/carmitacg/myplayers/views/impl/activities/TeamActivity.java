package com.example.carmitacg.myplayers.views.impl.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.carmitacg.myplayers.R;
import com.example.carmitacg.myplayers.helpers.DownloadImagesTask;

public class TeamActivity extends AppCompatActivity {

    private ImageView image;
    private CollapsingToolbarLayout toolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        //Drawable drawable = this.getResources().getDrawable(R.drawable.alevi_b, getTheme());
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.setBackground(getDrawable(R.mipmap.alevi_b));
        //image = (ImageView) findViewById(R.id.image);

        //image.setTag("http://agrupaciopatrocinios.com/wp-content/uploads/2015/07/alevi%CC%81-B.jpg");
       // toolbarLayout.setBackgroundResource(R.drawable.alevi_b);
       // toolbarLayout.setContentScrimResource(R.drawable.alevi_b);
        //image.setImageResource(R.drawable.alevi_b);
/*        DownloadImagesTask downloadImagesTask = new DownloadImagesTask();
        downloadImagesTask.execute(image);*/

        //BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), "C:/Users/charlie/AndroidStudioProjects/MyPlayers/alevi_B.jpg");
        //toolbarLayout.setContentScrimResource(R.drawable.alevi_b);
        //toolbarLayout.setContentScrim(bitmapDrawable);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
}
