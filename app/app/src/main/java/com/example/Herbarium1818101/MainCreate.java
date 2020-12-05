package com.example.Herbarium1818101;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Espname,Emanfaat;
    private String Snama, Sspname,Smanfaat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Espname = (EditText) findViewById(R.id.create_spname);
        Emanfaat = (EditText) findViewById(R.id.create_manfaat);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sspname = String.valueOf(Espname.getText());
                Smanfaat = String.valueOf(Emanfaat.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sspname.equals("")){
                    Espname.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Nama Spesies",
                            Toast.LENGTH_SHORT).show();
                } else if (Smanfaat.equals("")){
                    Espname.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Manfaat",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Espname.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateTanamanobat(new Tanaman(null, Snama, Sspname,Smanfaat));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

