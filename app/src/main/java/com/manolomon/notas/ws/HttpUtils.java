package com.manolomon.notas.ws;

import android.util.Log;

import com.manolomon.notas.beans.Respuesta;
import com.manolomon.notas.beans.RespuestaUsuario;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {

    private static final String URL_NOTAS_WS = "http://192.168.0.15:8084/WSBlocNotas/webresources";
    private static final Integer CONNECT_TIMEOUT = 4000; //MILISEGUNDOS
    private static final Integer READ_TIMEOUT = 10000; //MILISEGUNDOS

    public static String login(String telefono, String password) {
        HttpURLConnection c = null;
        String res = null;
        try {
            URL u = new URL(URL_NOTAS_WS + "/usuarios/login");
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("POST");
            c.setDoOutput(true);
            c.setConnectTimeout(CONNECT_TIMEOUT);
            c.setReadTimeout(READ_TIMEOUT);

            DataOutputStream wr = new DataOutputStream(
                    c.getOutputStream());
            String urlParameters = String.format("telefono=%s&password=%s", telefono, password);
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            Integer status = c.getResponseCode();
            if (status == 200 || status == 201) {
                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();
                res = sb.toString();
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            res = (ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            res = (ex.getMessage());
        } finally {
            if (c != null) {
                c.disconnect();
            }
        }
        return res;
    }

    public static String regitrar(String nombre, String telefono, String password) {
        HttpURLConnection c = null;
        String res = null;
        try {
            URL u = new URL(URL_NOTAS_WS + "/usuarios/registrar");
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("POST");
            c.setDoOutput(true);
            c.setConnectTimeout(CONNECT_TIMEOUT);
            c.setReadTimeout(READ_TIMEOUT);

            DataOutputStream wr = new DataOutputStream(
                    c.getOutputStream());
            String urlParameters = String.format("nombre=%s&telefono=%s&password=%s", nombre,  telefono, password);
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            Integer status = c.getResponseCode();
            if (status == 200 || status == 201) {
                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();
                res = sb.toString();
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            res = (ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            res = (ex.getMessage());
        } finally {
            if (c != null) {
                c.disconnect();
            }
        }
        return res;
    }

    public static String getNotas(String idUsuario) {
        HttpURLConnection c = null;
        String res = null;
        try {
            URL u = new URL(URL_NOTAS_WS + "/notas/getusernotes/" + idUsuario);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(CONNECT_TIMEOUT);
            c.setReadTimeout(READ_TIMEOUT);
            c.connect();
            Integer status = c.getResponseCode();
            Log.v("WS_LOG",""+status);
            if (status == 200 || status == 201) {
                if (c.getInputStream() != null) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    res = sb.toString();
                }
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            res = (ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            res = (ex.getMessage());
        } finally {
            if (c != null) {
                c.disconnect();
            }
        }
        return res;
    }

    public static String agregarNota(String idUsuario, String titulo, String contenido) {
        HttpURLConnection c = null;
        String res = null;
        try {
            URL u = new URL(URL_NOTAS_WS + "/notas/agregar");
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("POST");
            c.setDoOutput(true);
            c.setConnectTimeout(CONNECT_TIMEOUT);
            c.setReadTimeout(READ_TIMEOUT);

            DataOutputStream wr = new DataOutputStream(c.getOutputStream());
            String urlParameters = String.format("idUsuario=%s&titulo=%s&contenido=%s", idUsuario, titulo, contenido);
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            Integer status = c.getResponseCode();
            if (status == 200 || status == 201) {
                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();
                res = sb.toString();
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            res = (ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            res = (ex.getMessage());
        } finally {
            if (c != null) {
                c.disconnect();
            }
        }
        return res;
    }
}
