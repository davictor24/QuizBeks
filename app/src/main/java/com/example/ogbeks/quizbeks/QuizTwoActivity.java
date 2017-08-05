package com.example.ogbeks.quizbeks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by ogbeks on 6/23/2017.
 */

public class QuizTwoActivity extends AppCompatActivity {

    boolean questionOneAnswer;
    boolean questionTwoAnswer;
    private Button startQuizThreeActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_2);

        startQuizThreeActivityBtn = (Button) findViewById(R.id.launch_quiz_3_activity);
        startQuizThreeActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizThreeActivity();
            }
        });

        questionOneAnswer = getIntent().getBooleanExtra("QuestionOne", false);
        Log.v("Q1_answer", "Q1 = " + questionOneAnswer);

    }

    private void startQuizThreeActivity() {
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.quiz_two_checkbox_one);
        CheckBox checkbox2 = (CheckBox) findViewById(R.id.quiz_two_checkbox_two);
        CheckBox checkbox3 = (CheckBox) findViewById(R.id.quiz_two_checkbox_three);
        CheckBox checkbox4 = (CheckBox) findViewById(R.id.quiz_two_checkbox_four);

        Boolean checkbox1Ans = checkbox1.isChecked();
        Boolean checkbox2Ans = checkbox2.isChecked();
        Boolean checkbox3Ans = checkbox3.isChecked();
        Boolean checkbox4Ans = checkbox4.isChecked();
        if (checkbox4Ans && checkbox3Ans && !checkbox1Ans && !checkbox2Ans) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            questionTwoAnswer = true;
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            questionTwoAnswer = false;
        }
        Intent startQuizThreeIntent = new Intent(this, QuizThreeActivity.class);
        startQuizThreeIntent.putExtra("QuestionTwo", questionTwoAnswer);
        startQuizThreeIntent.putExtra("QuestionOne", questionOneAnswer);
        Log.v("Q2_answer", "Q2 = " + questionTwoAnswer);
        startActivity(startQuizThreeIntent);
        finish();

    }
}
