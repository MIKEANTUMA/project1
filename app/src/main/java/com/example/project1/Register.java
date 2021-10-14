package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText fn;
    EditText ln ;
    EditText dob ;
    EditText em ;
    EditText un;
    EditText pw;
    TextView tv;
    TextView usern;

    SharedPreferences sharedpreferences;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String USERNAME = "USERNAME_KEY";
    public static final String PASSWORD = "PASSWORD_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       //getting all the variable's the user inputs
        fn = findViewById(R.id.firstName);
        ln = findViewById(R.id.lastName);
         dob = findViewById(R.id.DoB);
         em = findViewById(R.id.emial);
         un = findViewById(R.id.username);
        pw = findViewById(R.id.password);
        tv = findViewById(R.id.passwordvaild);
        usern = findViewById(R.id.usernamevaild);

        //opening the shared preference file to share the new user to
        un =findViewById(R.id.username);
        pw = findViewById(R.id.password);
        sharedpreferences = getSharedPreferences(MYPREF,MODE_PRIVATE);
        if (sharedpreferences.contains(USERNAME)) {
            un.setText(sharedpreferences.getString(USERNAME, ""));
        }
        if (sharedpreferences.contains(PASSWORD)) {
            pw.setText(sharedpreferences.getString(PASSWORD, ""));

        }

        //checking if the password is greater then 8 chars
        pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 8) {
                    tv.setVisibility(View.VISIBLE);
                } else {
                    tv.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        //checking if the username is less then 30 but greater then 3
        un.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 3 || s.length() > 30) {
                    usern.setVisibility(View.VISIBLE);
                } else {
                    usern.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }



    public void button1(View view) {

        //making sure that no fields are empty
        if(fn.getText().length() == 0
                || ln.getText().length() == 0
                || dob.getText().length() ==0
                || em.getText().length() == 0
                || un.getText().length() == 0
                || pw.getText().length() == 0
                || emailValidator(em)){
            Toast.makeText(getApplicationContext(),"Invalid input", Toast.LENGTH_LONG).show();
            return;
        }
        //if no fields are empty then write info to a shared preference file
        else{
        String n = un.getText().toString();
        String e = pw.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USERNAME, n);
        editor.putString(PASSWORD, e);
        editor.apply();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);}

   }

   //check to see if its a valid email the user entered
    // i found this function on geeks for geeks - https://www.geeksforgeeks.org/implement-email-validator-in-android/
    public boolean emailValidator(EditText etMail) {

        // extract the entered data from the EditText
        String emailToText = em.getText().toString();

        // Android offers the inbuilt patterns which the entered
        // data from the EditText field needs to be compared with
        // In this case the the entered data needs to compared with
        // the EMAIL_ADDRESS, which is implemented same below
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {

            Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}