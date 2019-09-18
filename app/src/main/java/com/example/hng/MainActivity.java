package com.example.hng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor edit;
    private EditText name,birthday,mail,phone,password;
    private CheckBox Rem;
    private Button Sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name = (EditText) findViewById(R.id.usr_name);
        birthday = (EditText) findViewById(R.id.usr_birth);
        mail = (EditText) findViewById(R.id.usr_mail);
        phone = (EditText) findViewById(R.id.usr_phn);
        password = (EditText)findViewById(R.id.usr_password);
        Rem = (CheckBox) findViewById(R.id.usr_rem);
        Sign = (Button) findViewById(R.id.usr_login);


        pref = PreferenceManager.getDefaultSharedPreferences(this);
        edit = pref.edit();


        checkpreferences();



        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Rem.isChecked()){
                    edit.putString(getString(R.string.Rem),"True");
                    edit.apply();

                    String ail = mail.getText().toString();
                    edit.putString(getString(R.string.mail), ail);
                    edit.apply();

                    String pss = password.getText().toString();
                    edit.putString(getString(R.string.password), pss);
                    edit.apply();

                    String nm = name.getText().toString();
                    edit.putString(getString(R.string.name), nm);
                    edit.apply();

                    String bd = birthday.getText().toString();
                    edit.putString(getString(R.string.birth), bd);
                    edit.apply();

                    String pn = phone.getText().toString();
                    edit.putString(getString(R.string.phone), pn);
                    edit.apply();

                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);

                }else {
                       edit.putString(getString(R.string.Rem),"False");
                        edit.apply();

                        edit.putString(getString(R.string.mail), "");
                        edit.apply();

                        edit.putString(getString(R.string.password), "");
                        edit.apply();

                        edit.putString(getString(R.string.name),"");
                        edit.apply();

                        edit.putString(getString(R.string.birth),"");
                        edit.apply();

                        edit.putString(getString(R.string.phone),"");
                        edit.apply();

                        Intent intent = new Intent(MainActivity.this,Dashboard.class);
                        startActivity(intent);
                }
            }
        });
    }

    private void checkpreferences(){

        String chkbox = pref.getString(getString(R.string.Rem),"False");
        String pass = pref.getString(getString(R.string.password),"");
        String ml = pref.getString(getString(R.string.mail),"");
        String usr = pref.getString(getString(R.string.name),"");
        String bt = pref.getString(getString(R.string.birth),"");
        String phn = pref.getString(getString(R.string.phone),"");

        mail.setText(ml);
        password.setText(pass);
        name.setText(usr);
        birthday.setText(bt);
        phone.setText(phn);

        if (chkbox.equals("True")){
            Rem.setChecked(true);
        }
        if (chkbox.equals("False")){
            Rem.setChecked(false);
        }

    }
}
