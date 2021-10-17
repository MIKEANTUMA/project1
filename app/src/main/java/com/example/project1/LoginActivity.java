package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity{

    EditText username;
    EditText password;
    Button login;
    SharedPreferences sharedpreferences;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String USERNAME = "USERNAME_KEY";
    public static final String PASSWORD = "PASSWORD_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        //opening the shared preferences to obtain usernames and passwords
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        sharedpreferences = getSharedPreferences(MYPREF, MODE_PRIVATE);
        if (sharedpreferences.contains(USERNAME)) {
            username.setText(sharedpreferences.getString(USERNAME, ""));
        }
        if (sharedpreferences.contains(PASSWORD)) {
            password.setText(sharedpreferences.getString(PASSWORD, ""));

        }


       login.setOnClickListener(v -> {

           //getting the username and password
           String user = username.getText().toString();
           String pass = password.getText().toString();

           //checking if its an existing user
           if (sharedpreferences.contains(USERNAME) && sharedpreferences.contains(PASSWORD)) {
               //if existing user is true then takes us to the app
               Intent intent = new Intent(this, GameActivity.class);
               startActivity(intent);
           } else {
               Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_LONG).show();
           }
       });



        //if the user is not existing then they can register
//        public void register (View view){
//            Intent intent = new Intent(this, Register.class);
//            startActivity(intent);
//        }

    }
}