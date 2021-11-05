package com.furkankurt.krakenrestapidataget;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    int[] dizi1= new int[1];
    int[] dizi2= new int[1];
    int[] dizi3= new int[1];
    int[] dizi4= new int[1];
    TextView txtgrid1;
    TextView txtgrid2;
    TextView txtgrid3;
    TextView txtgrid4;
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 5000;
    int btc1;
    int btc2;
    int btc3;
    int btc4;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtgrid1=findViewById(R.id.TxtGrid1);
        txtgrid2=findViewById(R.id.TxtGrid2);
        txtgrid3=findViewById(R.id.TxtGrid3);
        txtgrid4=findViewById(R.id.TxtGrid4);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Lütfen Bekleyiniz");
        progressDialog.setCancelable(true);
        progressDialog.show();
        new AsenkronDataBTC1Get().execute();
        new AsenkronDataBTC2Get().execute();
        new AsenkronDataETH1Get().execute();
        new AsenkronDataETH2Get().execute();
    }
    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {

                handler.postDelayed(runnable, delay);
                new AsenkronDataBTC1Get().execute();
                new AsenkronDataBTC2Get().execute();
                new AsenkronDataETH1Get().execute();
                new AsenkronDataETH2Get().execute();
            }
        }, delay);
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable); //stop handler when activity not visible super.onPause();
    }


    private class AsenkronDataBTC1Get extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... voids) {
            JSONReader js=new JSONReader();
            String Gelendata=js.Read("https://api.kraken.com/0/public/Ticker?pair=xbtusd");
            try{
                JSONObject object=new JSONObject(Gelendata);
                JSONObject object1=object.getJSONObject("result");
                JSONObject object2=object1.getJSONObject("XXBTZUSD");
                JSONArray array=object2.getJSONArray("a");
                for (int a=0;a<=0;a++)
                {
                    dizi1[0]=array.getInt(a);
                    if(dizi1[0]>btc1) {
                        //KIRMIZI
                        txtgrid1.setText("BTCUSD-A: "+array.getString(a));
                        txtgrid1.setTextColor(Color.parseColor("#008000"));
                    }
                    else if(dizi1[0]<btc1)
                    {
                        //YEŞİL
                        txtgrid1.setText("BTCUSD-A: "+array.getString(a));
                        txtgrid1.setTextColor(Color.parseColor("#ff2400"));

                    }
                    btc1=array.getInt(a);

                }
            }
            catch (JSONException e)
            {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            super.onPostExecute(unused);
        }
    }
    private class AsenkronDataBTC2Get extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            JSONReader js=new JSONReader();
            String Gelendata=js.Read("https://api.kraken.com/0/public/Ticker?pair=xbtusd");
            try{
                JSONObject object=new JSONObject(Gelendata);
                JSONObject object1=object.getJSONObject("result");
                JSONObject object2=object1.getJSONObject("XXBTZUSD");
                JSONArray array=object2.getJSONArray("b");
                for (int a=0;a<=0;a++)
                {

                    dizi2[0]=array.getInt(a);
                    if(dizi2[0]>btc2) {
                        //KIRMIZI
                        txtgrid2.setText("BTCUSD-B: "+array.getString(a));
                        txtgrid2.setTextColor(Color.parseColor("#008000"));
                    }
                    else if(dizi2[0]<btc2)
                    {
                        //YEŞİL
                        txtgrid2.setText("BTCUSD-B: "+array.getString(a));
                        txtgrid2.setTextColor(Color.parseColor("#ff2400"));

                    }
                    btc2=array.getInt(a);

                }
            }
            catch (JSONException e)
            {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            super.onPostExecute(unused);
        }
    }
    private class AsenkronDataETH1Get extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            JSONReader js=new JSONReader();
            String Gelendata=js.Read("  https://api.kraken.com/0/public/Ticker?pair=ETHUSD");
            try{
                JSONObject object=new JSONObject(Gelendata);
                JSONObject object1=object.getJSONObject("result");
                JSONObject object2=object1.getJSONObject("XETHZUSD");
                JSONArray array=object2.getJSONArray("a");
                for (int a=0;a<=0;a++)
                {
                    dizi3[0]=array.getInt(a);
                    if(dizi3[0]>btc3) {
                        //KIRMIZI
                        txtgrid3.setText("ETHUSD-A: "+array.getString(a));
                        txtgrid3.setTextColor(Color.parseColor("#008000"));
                    }
                    else if(dizi3[0]<btc3)
                    {
                        //YEŞİL
                        txtgrid3.setText("ETHUSD-A: "+array.getString(a));
                        txtgrid3.setTextColor(Color.parseColor("#ff2400"));

                    }
                    btc3=array.getInt(a);
                }
            }
            catch (JSONException e)
            {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            super.onPostExecute(unused);
        }
    }
    private class AsenkronDataETH2Get extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            JSONReader js=new JSONReader();
            String Gelendata=js.Read("  https://api.kraken.com/0/public/Ticker?pair=ETHUSD");
            try{
                JSONObject object=new JSONObject(Gelendata);
                JSONObject object1=object.getJSONObject("result");
                JSONObject object2=object1.getJSONObject("XETHZUSD");
                JSONArray array=object2.getJSONArray("b");
                for (int a=0;a<=0;a++)
                {

                    dizi4[0]=array.getInt(a);
                    if(dizi4[0]>btc4) {
                        //KIRMIZI
                        txtgrid4.setText("ETHUSD-B: "+array.getString(a));
                        txtgrid4.setTextColor(Color.parseColor("#008000"));
                    }
                    else if(dizi4[0]<btc4)
                    {
                        //YEŞİL
                        txtgrid4.setText("ETHUSD-B: "+array.getString(a));
                        txtgrid4.setTextColor(Color.parseColor("#ff2400"));

                    }
                    btc4=array.getInt(a);
                }
            }
            catch (JSONException e)
            {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            super.onPostExecute(unused);
        }
    }
}