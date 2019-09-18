package com.example.hng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button log;
    private Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText) findViewById(R.id.laname);
        pass = (EditText) findViewById(R.id.lpaso);
        log = (Button) findViewById(R.id.loglogin);
        reg = (Button) findViewById(R.id.logSignup);

        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor et = spf.edit();

        String p = spf.getString(getString(R.string.password),"");
        String name = spf.getString(getString(R.string.name),"");

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
