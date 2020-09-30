package com.rku.tutorial10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;

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
        protected Object doInBackground(Object[] objects) {
            return null;
        }
    }


    //AsyncTask class Code finished --------
}