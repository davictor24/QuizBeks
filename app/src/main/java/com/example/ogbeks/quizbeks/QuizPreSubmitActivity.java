package com.example.ogbeks.quizbeks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ogbeks on 6/23/2017.
 */

public class QuizPreSubmitActivity extends AppCompatActivity {
    String name;
    int quizScore;
    private Button startQuizScorePageActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_submit_score);
        quizScore = getIntent().getIntExtra("Scores", 0);
        startQuizScorePageActivityBtn = (Button) findViewById(R.id.launch_score_page_activity);
        startQuizScorePageActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScorePageActivity();
            }
        });
    }

    private void startScorePageActivity() {
        EditText yourName = (EditText) findViewById(R.id.your_name);
        name = yourName.getText().toString();
        if (name.matches("")) {
            yourName.setError("Please input your name");
            yourName.requestFocus();
        } else {
            Intent startScorePageIntent = new Intent(this, QuizScorePageActivity.class);
            startScorePageIntent.putExtra("yourName", name);
            startScorePageIntent.putExtra("yourScore", quizScore);
            startActivity(startScorePageIntent);
            finish();
        }
    }
}
