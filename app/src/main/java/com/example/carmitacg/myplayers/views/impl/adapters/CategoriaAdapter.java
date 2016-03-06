package com.example.carmitacg.myplayers.views.impl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.carmitacg.myplayers.R;
import com.example.carmitacg.myplayers.models.entities.Categoria;

import java.util.List;

/**
 * Created by carmita c g on 04/03/2016.
 */
public class CategoriaAdapter extends ArrayAdapter<Categoria> {

    private List<Categoria> categories;
    private Context context;

    public CategoriaAdapter(Context context, int resource, List<Categoria> objects) {
        super(context, resource, objects);
        this.categories = objects;
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        CategoriaHolder holder = new CategoriaHolder();
        if (row == null) {

            row = LayoutInflater.from(context).inflate(R.layout.categoria_list_row, parent, false);

            holder.descripcioCategoria = (TextView) row.findViewById(R.id.categoria_descripcio);

            row.setTag(holder);

        } else {
            holder = (CategoriaHolder) row.getTag();
        }

        holder.descripcioCategoria.setText(categories.get(position).getDescripcio());

        return row;
    }


    class CategoriaHolder {

        public TextView descripcioCategoria;

        public CategoriaHolder() {

        }

    }
}
