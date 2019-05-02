package com.manolomon.notas;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.manolomon.notas.ws.HttpUtils;

public class AccesoActivity extends AppCompatActivity {

    private String json;
    private EditText txt_name;
    private EditText txt_password;

    private ProgressDialog pd_wait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        txt_name = (EditText)findViewById(R.id.txt_name);
        txt_password = (EditText)findViewById(R.id.txt_password);
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

    public void entrarOnClick (View view) {
        if (validar()) {
           String username = txt_name.getText().toString();
           String password = txt_password.getText().toString();
           WSPOSTLoginTask task = new WSPOSTLoginTask();
           task.execute(username, password);
        }
    }

    public boolean validar () {
        return !txt_name.getText().toString().isEmpty() || !txt_password.getText().toString().isEmpty();
    }

    private void resultadoEntrar() {
        hideProgressDialog();
    }

    class WSPOSTLoginTask extends AsyncTask <String, String, String> {

        @Override
        protected void onPreExecute () {
            showProgressDialog();
        }

        @Override
        protected String doInBackground (String ... params) {
            return HttpUtils.login(params[0], params[1]).getResult();
        }

        @Override
        protected void onPostExecute (String result) {
            super.onPostExecute(result);
            json = result;
            resultadoEntrar();
        }
    }
}
