package com.example.Herbarium1818101;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Tanaman> listTanaman = new ArrayList<Tanaman>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listTanaman);
        mListView = (ListView) findViewById(R.id.list_tanamanobat);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listTanaman.clear();
        List<Tanaman> contacts = db.ReadTanamanobat();
        for (Tanaman cn : contacts) {
            Tanaman judulModel = new Tanaman();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_spname(cn.get_spname());
            judulModel.set_spname(cn.get_manfaat());
            listTanaman.add(judulModel);
            if ((listTanaman.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Tanaman obj_itemDetails = (Tanaman)o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sspname = obj_itemDetails.get_spname();
        String Smanfaat = obj_itemDetails.get_manfaat();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ispname", Sspname);
        goUpdel.putExtra("Imanfaat", Smanfaat);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listTanaman.clear();
        mListView.setAdapter(adapter_off);
        List<Tanaman> contacts = db.ReadTanamanobat();
        for (Tanaman cn : contacts) {
            Tanaman judulModel = new Tanaman();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_spname(cn.get_spname());
            judulModel.set_manfaat(cn.get_manfaat());
            listTanaman.add(judulModel);
            if ((listTanaman.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
