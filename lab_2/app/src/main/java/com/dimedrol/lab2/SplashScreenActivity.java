package com.dimedrol.lab2;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {

    private IRequester ir = NetworkService.getInstance().get_req();
    private TechData dat = new TechData();
    //private ArrayList<Tech> dat = new ArrayList<>();
    private MyAsyncTask task = (MyAsyncTask) new MyAsyncTask();

    class MyAsyncTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {
            Call<ArrayList<Tech>> call = ir.getTechs();
            try
            {
                Response<ArrayList<Tech>> response = call.execute();
                ArrayList<Tech> arr = response.body();
                assert arr != null;
                dat.addAll(arr);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void o) {
            super.onPostExecute(o);
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(!isOnline(this))
        {
            Toast.makeText(this, "Missing connection", Toast.LENGTH_LONG).show();
            return;
        }
        else task.execute();
    }

    public static boolean isOnline(Context context)
    {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
