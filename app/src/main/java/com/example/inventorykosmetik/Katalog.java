package com.example.inventorykosmetik;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class Katalog extends AppCompatActivity implements


        AdapterView.OnItemClickListener{

    public void btn_katalog(View view){
        Intent read = new Intent(Katalog.this, MainRead.class);
        startActivity(read);

    }


    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Kosmetik> listKosmetik = new ArrayList<Kosmetik>();



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listKosmetik);
        mListView = (ListView) findViewById(R.id.list_kosmetik);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listKosmetik.clear();
        List<Kosmetik> contacts = db.Readkosmetik();
        for (Kosmetik cn : contacts) {
            Kosmetik judulModel = new Kosmetik();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_bpom(cn.get_bpom());
            judulModel.set_stok(cn.get_stok());
            listKosmetik.add(judulModel);
            if ((listKosmetik.isEmpty()))
                Toast.makeText(Katalog.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Kosmetik obj_itemDetails = (Kosmetik)o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sbpom = obj_itemDetails.get_bpom();
        String Sstok = obj_itemDetails.get_stok();
        Intent goUpdel = new Intent(Katalog.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ibpom", Sbpom);
        goUpdel.putExtra("Istok", Sstok);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listKosmetik.clear();
        mListView.setAdapter(adapter_off);
        List<Kosmetik> contacts = db.Readkosmetik();
        for (Kosmetik cn : contacts) {
            Kosmetik judulModel = new Kosmetik();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_bpom(cn.get_bpom());
            judulModel.set_stok(cn.get_stok());
            listKosmetik.add(judulModel);
            if ((listKosmetik.isEmpty()))
                Toast.makeText(Katalog.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
