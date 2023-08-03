package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Question;
    EditText Scoreboard;
    String []questions = {"1. Is java compiled by the JDK compiler?" , "2. Is JVM used for running java code?" , "3. Is red colored a primary color?" , "4. Does birds have wings?", "5. Did will smith slapped jack?"};
    String []answers = {"True" , "True" , "True" , "True", "True"};
    Button button;
    Button button2;
    Button button3;
    Button button4;
    int truecount=0;
    int falsecount=0;
    int score = 0;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Question = findViewById(R.id.Question);
        Scoreboard = findViewById(R.id.score);
        button = findViewById(R.id.True);
        button2 = findViewById(R.id.False);
        button3 = findViewById(R.id.next);
        button4 = findViewById(R.id.viewscore);

        Question.setText(questions[0]);

            button.setOnClickListener(view -> {
             if(button.getText().toString().equals(answers[1])){
                    truecount++ ;
                }
                else {
                    falsecount++;
                }
            });
            button2.setOnClickListener(view -> {
                if(button.getText().toString().equals(answers[1])){
                    falsecount++ ;
                }
                else {
                    truecount++;
                }
            });
            button3.setOnClickListener(view -> {
                Question.setText(questions[count]);
                count++;
            });
            button4.setOnClickListener(view -> {
                score = truecount -  falsecount ;
                String Scoreboard_text= Integer.toString(score);
                Scoreboard.setText(Scoreboard_text);
            });
    }

}