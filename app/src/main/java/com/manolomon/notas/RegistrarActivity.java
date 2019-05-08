package com.manolomon.notas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.manolomon.notas.ws.HttpUtils;

public class RegistrarActivity extends AppCompatActivity {

    private EditText txt_username;
    private EditText txt_telefono;
    private EditText txt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        this.txt_username = (EditText) findViewById(R.id.txt_usernameregistrar);
        this.txt_telefono = (EditText) findViewById(R.id.txt_telefono);
        this.txt_password= (EditText) findViewById(R.id.txt_passwordregistrar);
    }

    public boolean camposInvalidos() {
        return txt_username.getText().toString().isEmpty() || txt_telefono.getText().toString().isEmpty() ||
                txt_password.getText().toString().isEmpty();
    }

    public void registrarUsuarioOnClick(View view) {
        if (camposInvalidos()){
            Toast.makeText(this, getString(R.string.acceso_invalido), Toast.LENGTH_SHORT).show();
        } else {
            String res = HttpUtils.regitrar(txt_username.getText().toString(), txt_telefono.getText().toString(), txt_password.getText().toString());
            if (res != null) {
                Intent i = new Intent(this, ConfirmarActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(this, getString(R.string.detalle_error), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
