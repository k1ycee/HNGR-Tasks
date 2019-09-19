package com.example.hng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private  SharedPreferences spf;
    SharedPreferences.Editor et;
    private EditText name;
    private EditText pss;
    private Button log;
    private Button reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name =  findViewById(R.id.laname);
        pss =  findViewById(R.id.lpaso);
        log =  findViewById(R.id.loglogin);
        reg =  findViewById(R.id.logSignup);


        spf = PreferenceManager.getDefaultSharedPreferences(this);
        et = spf.edit();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = name.getText().toString();
                et.putString(getString(R.string.name),nom);
                et.commit();

                String ss = pss.getText().toString();
                et.putString(getString(R.string.password),ss);
                et.commit();

                Intent dashbd = new Intent(LoginActivity.this, Dashboard.class);
                startActivity(dashbd);

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ma = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(ma);
            }
        });
    }
}
