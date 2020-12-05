package com.example.inventorykosmetik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sbpom,Sstok;
    private EditText Enama, Estok, Ebpom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sbpom = i.getStringExtra("Ibpom");
        Sstok = i.getStringExtra("Istok");
        Enama = (EditText) findViewById(R.id.updel_name);
        Ebpom = (EditText) findViewById(R.id.updel_bpom);
        Estok = (EditText) findViewById(R.id.updel_stok);
        Enama.setText(Snama);
        Ebpom.setText(Sbpom);
        Estok.setText(Sstok);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sbpom = String.valueOf(Ebpom.getText());
                Sstok = String.valueOf(Estok.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(com.example.inventorykosmetik.MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sbpom.equals("")){
                    Ebpom.requestFocus();
                    Toast.makeText(com.example.inventorykosmetik.MainUpdel.this, "Silahkan isi bpom",
                            Toast.LENGTH_SHORT).show();
                } else if (Sstok.equals("")){
                    Estok.requestFocus();
                    Toast.makeText(com.example.inventorykosmetik.MainUpdel.this, "Silahkan isi stok",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.Updatekosmetik(new Kosmetik(Sid, Snama, Sbpom,Sstok));
                    Toast.makeText(com.example.inventorykosmetik.MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.Deletekosmetik(new Kosmetik(Sid, Snama, Sbpom,Sstok));
                Toast.makeText(com.example.inventorykosmetik.MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Button btnplus = (Button) findViewById(R.id.btn_plus);
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Sstok = String.valueOf(Estok.getText());
                String Nilai = Sstok;
                Integer Nilaibaru = Integer.parseInt(Nilai);
                Nilaibaru =Nilaibaru+1;

                Estok.setText(Nilaibaru);
            }
        });


    }
}

