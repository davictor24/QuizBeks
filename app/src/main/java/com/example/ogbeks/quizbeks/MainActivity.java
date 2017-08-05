package com.example.ogbeks.quizbeks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startQuizActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startQuizActivityBtn = (Button) findViewById(R.id.launch_quiz_activity);
        startQuizActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity();
            }
        });
    }

    private void startQuizActivity() {
        Intent startQuizIntent = new Intent(this, QuizOneActivity.class);
        startActivity(startQuizIntent);
    }
}
