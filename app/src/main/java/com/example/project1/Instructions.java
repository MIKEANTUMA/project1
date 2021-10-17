package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instructions extends AppCompatActivity implements View.OnClickListener {
    private Button backToGame;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        backToGame = findViewById(R.id.backToGame);
        backToGame.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.backToGame){
            startActivity(new Intent(this,GameActivity.class));
        }
    }


}