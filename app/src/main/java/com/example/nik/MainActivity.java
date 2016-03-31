package com.example.nik;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nik.generator.NetworkApiGenerator;
import com.example.nik.interfaces.MovieServiceInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

public class MainActivity extends AppCompatActivity {

    private MovieServiceInterface mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });








    }

    public  void getdetails(View v)
    {
        send();
    }


    public  void send()

    {


        final TypedInput in;

        JSONObject jsonObject=new JSONObject();
        try {

            jsonObject.put("password", "rajat321");
            jsonObject.put("email", "rajatjain2009@gmail.com");
        }
        catch(JSONException e)
        {

        }

        Log.d("CompleteJSON", jsonObject.toString());

        mv = NetworkApiGenerator.createService(MovieServiceInterface.class);

        try {
            in = new TypedByteArray("application/json", jsonObject.toString().getBytes("UTF-8"));



        mv.confirmSlot("rajatjain2009@gmail.com","rajat321", new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {

                Log.d("Success Response", response.getBody().toString());
                Log.d("Success Response", "Response 2 : " + response2.getBody());
                try {
                    JSONObject jsonObject1 = new JSONObject( new String( ((TypedByteArray) response.getBody()).getBytes() ) );
                    Log.d("Success Response", "JSON : " + jsonObject1.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
