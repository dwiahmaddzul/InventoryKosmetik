package com.example.inventorykosmetik;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Kosmetik> movieItems;

    public CustomListAdapter(Activity activity, List<Kosmetik> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView bpom = (TextView) convertView.findViewById(R.id.text_bpom);
        TextView stok = (TextView) convertView.findViewById(R.id.text_stok);
        //TextView harga = (TextView) convertView.findViewById(R.id.text_total);
        Kosmetik m = movieItems.get(position);
        nama.setText("Nama : "+ m.get_nama());
        bpom.setText("BPOM : "+ m.get_bpom());
        stok.setText("Stok : "+ m.get_stok());
       // batalkan nampilin harga, bikin simple aja
        // Double Total = Double.parseDouble(m.get_stok())*20000;
        //harga.setText("Harga Total : "+ Double.toString(Total));
        return convertView;
    }
}

