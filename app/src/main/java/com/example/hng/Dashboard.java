package com.example.hng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    private TextView usrname;
    private TextView hng;
    private TextView usrmail;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflt = getMenuInflater();
        inflt.inflate(R.menu.back,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int b = item.getItemId();
        if (b == R.id.usr_back){

            back();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void back(){
        Intent bck = new Intent(Dashboard.this,LoginActivity.class);
        startActivity(bck);
    }


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dashboard);
            usrname = (TextView)findViewById(R.id.usr_displayname);
            hng = (TextView)findViewById(R.id.hng_intro);
            usrmail = (TextView)findViewById(R.id.ml_display);


            SharedPreferences shdp = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor shdpet = shdp.edit();

            String nome = shdp.getString(getString(R.string.name),"");
            usrname.setText("Hi, " + nome + " Welcome to HNG");
            hng.setText("The HNG internship is a 3-month remote internship designed to find and develop the most talented software developers.Everyone is welcome to participate (there is no entrance exam).\n Anyone can log into the internship using their laptop. \nEach week, we give tasks. Those who complete them advance forward. We pay the interns weekly.\nThe intern coders are introduced to complex programming frameworks, and get to work on real world software. \nThe finalists are connected to the best companies in the tech ecosystem and get full time jobs and contracts immediately.\nThe HNG internship is a 3-month remote internship designed to find and develop the most talented software developers." + nome);
            String male = shdp.getString(getString(R.string.mail),"");
            usrmail.setText(male);



    }
}
