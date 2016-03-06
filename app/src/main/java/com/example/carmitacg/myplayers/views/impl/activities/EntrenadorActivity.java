package com.example.carmitacg.myplayers.views.impl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carmitacg.myplayers.R;
import com.example.carmitacg.myplayers.helpers.DownloadImagesTask;

/**
 * Created by carmita c g on 28/02/2016.
 */
public class EntrenadorActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView nom,  descripcio;
    private ImageView imatge;
    private String url;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrenador_view);
        url = "http://ichef.bbci.co.uk/news/999/mcs/media/images/80888000/jpg/_80888657_anon.jpg";
        nom = (EditText) findViewById(R.id.entrenador_nom);
        descripcio = (TextView) findViewById(R.id.entrenador_descripcio);
        button = (Button) findViewById(R.id.comprovar);
        imatge = (ImageView) findViewById(R.id.entrenador_imatge);
        imatge.setTag(url);
        descripcio.setText(R.string.descripcio);
        button.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        DownloadImagesTask downloadImagesTask = new DownloadImagesTask();
        downloadImagesTask.execute(imatge);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.comprovar){
            if(comprovarText()){
                String tag = "http://opinions.laveupv.com/imatges/articles/_78365113_pep_guardiola_getty3.jpg";
                imatge.setTag(tag);
                DownloadImagesTask downloadImagesTask = new DownloadImagesTask();
                downloadImagesTask.execute(imatge);
            }else{
                nom.setText("");
                Toast.makeText(getBaseContext(), "ERROR, TORNA-HO A PROVAR.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean comprovarText() {

        if(nom.getText().toString().equals("Pep")){
            return true;
        }else{
            return false;
        }
    }
}
