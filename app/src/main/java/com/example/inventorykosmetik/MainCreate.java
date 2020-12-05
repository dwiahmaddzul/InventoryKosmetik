package com.example.inventorykosmetik;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ebpom,Estok;
    private String Snama, Sbpom,Sstok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama2);
        Ebpom = (EditText) findViewById(R.id.create_bpom);
        Estok = (EditText) findViewById(R.id.create_stok);


        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sbpom = String.valueOf(Ebpom.getText());
                Sstok = String.valueOf(Estok.getText());
                if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(com.example.inventorykosmetik.MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sbpom.equals("")) {
                    Ebpom.requestFocus();
                    Toast.makeText(com.example.inventorykosmetik.MainCreate.this, "Silahkan isi Nama Spesies",
                            Toast.LENGTH_SHORT).show();
                } else if (Sstok.equals("")) {
                    Ebpom.requestFocus();
                    Toast.makeText(com.example.inventorykosmetik.MainCreate.this, "Silahkan isi stok",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ebpom.setText("");
                    Toast.makeText(com.example.inventorykosmetik.MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.Createkosmetik(new Kosmetik(null, Snama, Sbpom, Sstok));
                    Intent a = new Intent(com.example.inventorykosmetik.MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

