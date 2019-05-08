package com.manolomon.notas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.manolomon.notas.ws.HttpUtils;

public class DetalleActivity extends AppCompatActivity {

    private String idNota;
    private String idUsuario;

    private EditText txt_name;
    private EditText txt_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Intent intent = getIntent();
        this.idNota = intent.getStringExtra("idNota");
        this.idUsuario = intent.getStringExtra("idUsuario");

        this.txt_name = (EditText)findViewById(R.id.txt_name);
        this.txt_note = (EditText)findViewById(R.id.txt_note);
    }

    public void guardarNotaOnClick(View view) {
        if (txt_name.getText().toString().isEmpty()){
            txt_name.setError(getString(R.string.detalle_error));
        } else {
            if (idNota == null) {
                String res = HttpUtils.agregarNota(idUsuario,txt_name.getText().toString(), txt_note.getText().toString());
                if (res != null) {
                    finish();
                } else {
                    Toast.makeText(this, getString(R.string.detalle_bad_response), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
