package com.example.carmitacg.myplayers.views.impl.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.carmitacg.myplayers.R;
import com.example.carmitacg.myplayers.models.entities.Jugador;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carmita c g on 28/02/2016.
 */
public class JugadorsAdapter extends ArrayAdapter<Jugador> implements Filterable {

    private LayoutInflater inflater;
    private Context context;
    private List<Jugador> jugadors;
    private List<Jugador> filteredData;

    public JugadorsAdapter(Context context, int resource, List<Jugador> objects) {
        super(context, resource, objects);
        filteredData = objects;
        this.jugadors = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        JugadorHolder holder = new JugadorHolder();

        if (row == null) {

            inflater = LayoutInflater.from(context);

            row = inflater.inflate(R.layout.jugadors_list_row, parent, false);

            holder.nomJugador = (TextView) row.findViewById(R.id.detail_nom_textview);

            row.setTag(holder);
        } else {
            holder = (JugadorHolder) row.getTag();
        }
        holder.nomJugador.setText(filteredData.get(position).getNom());


        return row;
    }


    class JugadorHolder {

        public TextView nomJugador;
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String filterString = constraint.toString().toLowerCase();

                FilterResults results = new FilterResults();

                final List<Jugador> list = jugadors;

                int count = list.size();
                final ArrayList<Jugador> nlist = new ArrayList<Jugador>(count);

                String filterableString;

                for (int i = 0; i < count; i++) {
                    filterableString = list.get(i).getNom();
                    if (filterableString.toLowerCase().contains(filterString)) {
                        nlist.add(new Jugador(
                                list.get(i).getNom(),
                                list.get(i).getCognom(),
                                list.get(i).getPosició(),
                                list.get(i).getGols(),
                                list.get(i).getPartitsJugats(),
                                list.get(i).getMitjanaGols(),
                                list.get(i).getEquip()
                        ));
                    }
                }

                results.values = nlist;
                results.count = nlist.size();

                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredData = (ArrayList<Jugador>) results.values;
                notifyDataSetChanged();
            }

        };
        return filter;
    }
}
