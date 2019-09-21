package com.example.hng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String ss = pss.getText().toString();

                if (TextUtils.isEmpty(nom)){
                    name.setError("Please Enter a valid Name");
                    name.requestFocus();
                }
                if (TextUtils.isEmpty(ss)){
                    pss.setError("Please Enter a Valid Password");
                    pss.requestFocus();
                }

                String thusr = spf.getString(getString(R.string.name),"");
                String thpss = spf.getString(getString(R.string.password),"");

                if((nom.equals(thusr) && ss.equals(thpss))){
                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "User does not exist", Toast.LENGTH_SHORT).show();
                }

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
