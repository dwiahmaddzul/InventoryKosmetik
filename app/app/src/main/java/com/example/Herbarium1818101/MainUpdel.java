package com.example.Herbarium1818101;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sspname,Smanfaat;
    private EditText Enama, Espname,Emanfaat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sspname = i.getStringExtra("Ispname");
        Smanfaat = i.getStringExtra("Imanfaat");
        Enama = (EditText) findViewById(R.id.updel_name);
        Espname = (EditText) findViewById(R.id.updel_spname);
        Espname = (EditText) findViewById(R.id.updel_manfaat);
        Enama.setText(Snama);
        Espname.setText(Sspname);
        Emanfaat.setText(Smanfaat);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sspname = String.valueOf(Espname.getText());
                Smanfaat = String.valueOf(Emanfaat.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sspname.equals("")){
                    Espname.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi spname",
                            Toast.LENGTH_SHORT).show();
                } else if (Smanfaat.equals("")){
                    Emanfaat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi manfaat",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateTanamanobat(new Tanaman(Sid, Snama, Sspname,Smanfaat));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteTanamanobat(new Tanaman(Sid, Snama, Sspname,Smanfaat));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

