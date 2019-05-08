package com.manolomon.notas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.manolomon.notas.beans.Nota;
import com.manolomon.notas.ws.HttpUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NotasActivity extends AppCompatActivity {

    private String json;
    private List<Nota> notas;
    private String idUsuario;
    Type notasType = new TypeToken<ArrayList<Nota>>(){}.getType();

    private ListView listaNotas;
    private ProgressDialog pd_wait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        this.listaNotas = (ListView) findViewById(R.id.notasLista);

        Intent intent = getIntent();
        this.idUsuario = intent.getStringExtra("idUsuario");

        WSGETNotasTask taskNotas = new WSGETNotasTask();
        taskNotas.execute(idUsuario);
    }

    public void agregarNotaOnClick(View view){
        Intent i = new Intent(this, DetalleActivity.class);
        i.putExtra("idUsuario", idUsuario);
        startActivity(i);
    }

    private void showProgressDialog() {
        pd_wait = new ProgressDialog(this);
        pd_wait.setMessage(getString(R.string.acceso_progress_wait));
        pd_wait.setCancelable(false);
        pd_wait.show();
    }

    private void hideProgressDialog() {
        if (pd_wait.isShowing()) {
            pd_wait.hide();
        }
    }

    private void cargarListaNotas(){
        hideProgressDialog();
        System.out.println(json);
        if (json!= null) {
            notas = new Gson().fromJson(json, notasType);
            if (notas != null) {
                List<String> listaNombresNotas = new ArrayList<>();
                for(Nota nota : notas){
                    System.out.println("Nota:" + nota.getTitulo());
                    listaNombresNotas.add(nota.getTitulo());
                }
                ArrayAdapter adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, listaNombresNotas);
                listaNotas.setAdapter(adapter);
            } else {
                Toast.makeText(this, "No se encontraron notas", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class WSGETNotasTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute () {
            json = null;
            showProgressDialog();
        }

        @Override
        protected String doInBackground (String ... params) {
            return HttpUtils.getNotas(params[0]);
        }

        @Override
        protected void onPostExecute (String result) {
            super.onPostExecute(result);
            json = result;
            cargarListaNotas();
        }
    }
}
