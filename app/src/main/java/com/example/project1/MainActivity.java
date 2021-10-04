package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    SharedPreferences sharedpreferences;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String USERNAME = "USERNAME_KEY";
    public static final String PASSWORD = "PASSWORD_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username =findViewById(R.id.username);
        password = findViewById(R.id.password);
        sharedpreferences = getSharedPreferences(MYPREF,MODE_PRIVATE);
        if (sharedpreferences.contains(USERNAME)) {
            username.setText(sharedpreferences.getString(USERNAME, ""));
        }
        if (sharedpreferences.contains(PASSWORD)) {
            password.setText(sharedpreferences.getString(PASSWORD, ""));

        }
    }

    public void login(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if (sharedpreferences.contains(USERNAME) && sharedpreferences.contains(PASSWORD)) {
            Intent intent = new Intent(this,app.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid input", Toast.LENGTH_LONG).show();
        }




//            //Toast.makeText(getApplicationContext(),user, Toast.LENGTH_LONG).show();
//            if(username.getText().length() == 0 || password.getText().length() == 0){
//                Toast.makeText(getApplicationContext(),"Invalid input", Toast.LENGTH_LONG).show();
//            }
//            else{
//                Toast.makeText(getApplicationContext(),"Logged in, Success", Toast.LENGTH_LONG).show();
//
//            }
    }

    public void register(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}