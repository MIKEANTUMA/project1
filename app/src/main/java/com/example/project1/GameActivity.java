package com.example.project1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;



public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    // setting up things
    private Button falseButton;
    private Button trueButton;
    private Button nextButton;
    private Button prevButton;
    private Button instructionButton;
    private TextView scoreTv;
    int score =0;
    private Button logoutButton;
    private boolean userChoose;

    private TextView questionTextView;
    private int correct = 0;
    // to keep current question track
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            // array of objects of class Question
            // providing questions from string
            // resource and the correct ans
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, true),
            new Question(R.string.question4, false),
            new Question(R.string.question5, true),
    };



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        instructionButton = findViewById(R.id.instructions);
        scoreTv = findViewById(R.id.score);
        logoutButton = findViewById(R.id.logout);
        questionTextView = findViewById(R.id.answer_text_view);

        //i found this on line how you can just set up the on click listener like this
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        instructionButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);

    }
    // setting up the on click listener like this makes for less code
    // because i just have to check what the view equals,
    // instead of creating an on click method for every button
    // im not to sure how it fully works id like to go over it in class
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.false_button){
            userChoose = false;
            SubmitAlert();

        }
        if(v.getId() == R.id.true_button){
            userChoose = true;
            SubmitAlert();
        }

        if(v.getId() == R.id.next_button){
            if(currentQuestionIndex < 5){
                currentQuestionIndex++;
                if(currentQuestionIndex == 5){
                    questionTextView.setText(getString(R.string.correct, correct));
                    nextButton.setVisibility(View.INVISIBLE);
                    prevButton.setVisibility(View.INVISIBLE);
                    trueButton.setVisibility(View.INVISIBLE);
                    falseButton.setVisibility(View.INVISIBLE);
                    questionTextView.setText("CORRECTNESS IS " + correct + " " + "OUT OF 5");
                }
                else{updateQuestion();}
            }
        }
        if(v.getId() == R.id.prev_button){
            if(currentQuestionIndex > 0){
                currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                updateQuestion();
            }
        }

        if(v.getId() == R.id.instructions){
          Intent intent = new Intent(this, Instructions.class);
           startActivity(intent);
        }
        if(v.getId() == R.id.logout){
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    private void checkAnswer(boolean userChoose) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();

        if(userChoose == answerIsTrue)
        {
            Toast.makeText(GameActivity.this, "Right!", Toast.LENGTH_SHORT).show();
            score+=100;
            scoreTv.setText("Score: "+score);
            correct++;
        }
        else{
            Toast.makeText(GameActivity.this, "Wrong :(", Toast.LENGTH_SHORT).show();
        }

    }

    private void updateQuestion() {
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerId());
    }

    public void SubmitAlert(){

        AlertDialog.Builder alert = new AlertDialog.Builder(GameActivity.this);
        alert.setMessage("Submit Answer?");

        alert.setPositiveButton("Yes",(v,a)->{
            checkAnswer(userChoose);
        });

        alert.setNegativeButton("No",(v,a)->{

                });
        alert.create().show();

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