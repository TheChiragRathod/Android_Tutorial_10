package com.rku.tutorial10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    JSONArray itemjsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);

    }

    //AsyncTask class created to manipulate the process in background --------
    class MyAsyncTask extends AsyncTask
    {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog=new ProgressDialog(MainActivity.this);
            dialog.setTitle("Fetching Data...");
            dialog.show();
        }


        @Override
        protected Object doInBackground(Object[] objects)
        {
            StringBuffer responce=new StringBuffer();

            try
            {
                URL url = new URL(MyUtil.USER_URL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStreamReader ir = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(ir);
                String inputLine = null;
                while ((inputLine = br.readLine()) != null)
                {
                    responce.append(inputLine);
                }
                br.close();
                ir.close();
                itemjsonArray = new JSONArray(responce.toString());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }








    }


    //AsyncTask class Code finished --------
}