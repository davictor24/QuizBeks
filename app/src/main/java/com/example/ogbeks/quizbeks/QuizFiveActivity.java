package com.example.ogbeks.quizbeks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by ogbeks on 6/23/2017.
 */

public class QuizFiveActivity extends AppCompatActivity {
    int score = 0;
    boolean questionOneAnswer;
    boolean questionTwoAnswer;
    boolean questionThreeAnswer;
    boolean questionFourAnswer;
    boolean questionFiveScore;
    private Button startQuizPreSubmitActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_5);
        questionOneAnswer = getIntent().getBooleanExtra("QuestionOne", false);
        questionTwoAnswer = getIntent().getBooleanExtra("QuestionTwo", false);
        questionThreeAnswer = getIntent().getBooleanExtra("QuestionThree", false);
        questionFourAnswer = getIntent().getBooleanExtra("QuestionFour", false);
        startQuizPreSubmitActivityBtn = (Button) findViewById(R.id.launch_pre_submit_activity);
        startQuizPreSubmitActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPreSubmitActivity();
            }
        });
    }

    public void onRadioButtonFiveClicked(View view) {
        if (view.getTag().toString().matches("0")) {
            questionFiveScore = true;
        } else {
            questionFiveScore = false;
        }
    }

    public void calculateScore() {
        if (questionOneAnswer) {
            score += 1;
        }
        if (questionTwoAnswer) {
            score += 1;
        }
        if (questionThreeAnswer) {
            score += 1;
        }
        if (questionFourAnswer) {
            score += 1;
        }
        if (questionFiveScore) {
            score += 1;
        }
    }

    private void startPreSubmitActivity() {
        calculateScore();
        Intent startPreSubmitIntent = new Intent(this, QuizPreSubmitActivity.class);
        Log.v("Q5_answer", "Q5 = " + questionFiveScore);
        startPreSubmitIntent.putExtra("Scores", score);
        startActivity(startPreSubmitIntent);
        finish();
    }
}
