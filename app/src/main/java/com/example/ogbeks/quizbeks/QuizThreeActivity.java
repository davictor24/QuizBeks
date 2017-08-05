package com.example.ogbeks.quizbeks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ogbeks on 6/23/2017.
 */

public class QuizThreeActivity extends AppCompatActivity {

    boolean questionThreeScore;
    boolean questionOneAnswer;
    boolean questionTwoAnswer;
    private Button startQuizFourActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_3);

        startQuizFourActivityBtn = (Button) findViewById(R.id.launch_quiz_4_activity);
        startQuizFourActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizFourActivity();
            }
        });
        questionOneAnswer = getIntent().getBooleanExtra("QuestionOne", false);
        questionTwoAnswer = getIntent().getBooleanExtra("QuestionTwo", false);
    }

    public void onRadioButtonTwoClicked(View view) {
        if ((view.getTag().toString()).matches("1")) {
            questionThreeScore = true;

        } else {
            questionThreeScore = false;
        }
    }

    private void startQuizFourActivity() {
        if (questionThreeScore) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();

        }
        Intent startQuizFourIntent = new Intent(this, QuizFourActivity.class);
        startQuizFourIntent.putExtra("QuestionThree", questionThreeScore);
        startQuizFourIntent.putExtra("QuestionTwo", questionTwoAnswer);
        startQuizFourIntent.putExtra("QuestionOne", questionOneAnswer);
        Log.v("Q3_answer", "Q3 = " + questionThreeScore);
        startActivity(startQuizFourIntent);
        finish();
    }
}
