package com.example.project1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import butterknife.BindView;
import butterknife.ButterKnife;




public class GameActivity extends AppCompatActivity {
    //AlertDialog.Builder builder;
    boolean submit;
    int s =0;
    int q1Attempts1 = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        TextView tv = findViewById(R.id.score_text);






        //question 1
        Button gq1a1 = (Button) findViewById(R.id.q1a1);
        Button gq1a2 = findViewById(R.id.q1a2);
        Button gq1a3 = findViewById(R.id.q1a3);
        Button gq1a4 = findViewById(R.id.q1a4);

        //question 2
        Button gq2a1 = findViewById(R.id.q2a1);
        Button gq2a2 = findViewById(R.id.q2a2);
        Button gq2a3 = findViewById(R.id.q2a3);
        Button gq2a4 = findViewById(R.id.q2a4);

        //question 3
        Button gq3a1 = findViewById(R.id.q3a1);
        Button gq3a2 = findViewById(R.id.q3a2);
        Button gq3a3 = findViewById(R.id.q3a3);
        Button gq3a4 = findViewById(R.id.q3a4);

        //question 4
        Button gq4a1 = findViewById(R.id.q4a1);
        Button gq4a2 = findViewById(R.id.q4a2);
        Button gq4a3 = findViewById(R.id.q4a3);
        Button gq4a4 = findViewById(R.id.q4a4);

        //question 5
        Button gq5a1 = findViewById(R.id.q5a1);
        Button gq5a2 = findViewById(R.id.q5a2);
        Button gq5a3 = findViewById(R.id.q5a3);
        Button gq5a4 = findViewById(R.id.q5a4);



            gq1a1.setOnClickListener(v -> {
                if(q1Attempts1 == 0) {
                    q1Attempts1++;

                    if(SubmitAlert() == true){
                        s+=100;
                        tv.setText("Score: "+ String.valueOf(s));
                        CorrectAlert();
                }
                        }
            });


//        int q1Attempts2 = 0; if(q1Attempts2 == 0){ gq1a2.setOnClickListener(v -> { alert.show();  });if(submit== true) q1Attempts2++; wrong.show();}
//        int q1Attempts3 = 0; if(q1Attempts3 == 0){ gq1a2.setOnClickListener(v -> { alert.show(); });if(submit== true) q1Attempts3++; wrong.show();}
//        int q1Attempts4 = 0; if(q1Attempts4 == 0){ gq1a2.setOnClickListener(v -> { alert.show(); });if(submit== true) q1Attempts4++; wrong.show();}
    }



    public boolean SubmitAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(GameActivity.this);
        alert.setMessage("Submit Answer?");

       // tv.setText("Score: "+ String.valueOf(s));
        alert.setPositiveButton("Yes",(v,a)->{
                submit = true;
        });

        alert.setNegativeButton("No",(v,a)->{
                submit = false;
                });
        alert.create().show();
        return submit;
    }
    public void CorrectAlert(){
        AlertDialog.Builder correct = new AlertDialog.Builder(this);
        correct.setMessage("Correct!");
        correct.create().show();
    }


    public void WrongAlert(){
        AlertDialog.Builder wrong = new AlertDialog.Builder(GameActivity.this);
        wrong.setMessage("Wrong!");
        wrong.create().show();
    }

}