package com.example.ogbeks.quizbeks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ogbeks on 6/23/2017.
 */

public class QuizFourActivity extends AppCompatActivity {
    String quiz_four_answer;
    boolean save_quiz_four_ans;
    boolean questionOneAnswer;
    boolean questionTwoAnswer;
    boolean questionThreeAnswer;
    private Button startQuizFiveActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_4);
        questionOneAnswer = getIntent().getBooleanExtra("QuestionOne", false);
        questionTwoAnswer = getIntent().getBooleanExtra("QuestionTwo", false);
        questionThreeAnswer = getIntent().getBooleanExtra("QuestionThree", false);
        startQuizFiveActivityBtn = (Button) findViewById(R.id.launch_quiz_5_activity);
        startQuizFiveActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizFiveActivity();
            }
        });
    }

    private void startQuizFiveActivity() {
        EditText quiz_four_ans = (EditText) findViewById(R.id.quiz_four_answer);
        if (quiz_four_ans.getText().toString().matches("")) {
            quiz_four_ans.setError("You have not answered the question");
            quiz_four_ans.requestFocus();
        } else {
            quiz_four_answer = quiz_four_ans.getText().toString().toLowerCase();
            if (quiz_four_answer.matches("pride")) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                save_quiz_four_ans = true;
            } else {
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                save_quiz_four_ans = false;
            }

            Intent startQuizFiveIntent = new Intent(this, QuizFiveActivity.class);
            startQuizFiveIntent.putExtra("QuestionFour", save_quiz_four_ans);
            startQuizFiveIntent.putExtra("QuestionThree", questionThreeAnswer);
            startQuizFiveIntent.putExtra("QuestionTwo", questionTwoAnswer);
            startQuizFiveIntent.putExtra("QuestionOne", questionOneAnswer);
            Log.v("Q4_answer", "Q4 = " + save_quiz_four_ans);
            startActivity(startQuizFiveIntent);
            finish();
        }
    }
}
