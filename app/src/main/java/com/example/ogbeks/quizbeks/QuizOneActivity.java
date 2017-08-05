package com.example.ogbeks.quizbeks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by ogbeks on 6/23/17.
 */

public class QuizOneActivity extends AppCompatActivity {

    boolean questionOneScore;
    private Button startQuizTwoActivityBtn;
    private RadioButton quizOneRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_1);

        startQuizTwoActivityBtn = (Button) findViewById(R.id.launch_quiz_2_activity);
        startQuizTwoActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizTwoActivity();
            }
        });
    }

    public void onRadioButtonOneClicked(View view) {
        if ((view.getTag().toString().matches("2"))) {

            questionOneScore = true;
        } else {

            questionOneScore = false;
        }
    }

    private void startQuizTwoActivity() {
        if (questionOneScore) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }
        Intent startQuizTwoIntent = new Intent(this, QuizTwoActivity.class);
        startQuizTwoIntent.putExtra("QuestionOne", questionOneScore);
        Log.v("Q1_answer", "Q1 = " + questionOneScore);
        startActivity(startQuizTwoIntent);
        finish();
    }
}
