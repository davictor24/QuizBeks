package com.example.ogbeks.quizbeks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ogbeks on 6/23/2017.
 */

public class QuizScorePageActivity extends AppCompatActivity {

    int score;
    String name;
    String shareText;
    String rating;
    private Button startQuizPreSubmitActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_page);
        score = getIntent().getIntExtra("yourScore", 0);
        name = getIntent().getStringExtra("yourName");
        TextView showScoreTextView = (TextView) findViewById(R.id.showScore);
        TextView showScoreRatingTextView = (TextView) findViewById(R.id.showScoreRating);
        switch (score) {
            case 1:
                rating = "Poor";
                showScoreRatingTextView.setTextColor(getResources().getColor(R.color.red));
                showScoreRatingTextView.setText(rating);
                break;
            case 2:
                showScoreRatingTextView.setTextColor(getResources().getColor(R.color.red));
                rating = "Fair";
                showScoreRatingTextView.setText(rating);
                break;
            case 3:
                showScoreRatingTextView.setTextColor(getResources().getColor(R.color.green));
                rating = "Good";
                showScoreRatingTextView.setText(rating);
                break;
            case 4:
                showScoreRatingTextView.setTextColor(getResources().getColor(R.color.green));
                rating = "Very good";
                showScoreRatingTextView.setText(rating);
                break;
            case 5:
                showScoreRatingTextView.setTextColor(getResources().getColor(R.color.green));
                rating = "Excellent!! The best.";
                showScoreRatingTextView.setText(rating);
                break;
            default:
                rating = "Fail";
                showScoreRatingTextView.setTextColor(getResources().getColor(R.color.red));
                showScoreRatingTextView.setText(rating);
        }

        shareText = getString(R.string.score_message, name, Integer.toString(score));
        showScoreTextView.setText(shareText);
    }

    public void shareScoreBtn(View v) {
        Intent intentShareScore = new Intent(Intent.ACTION_SEND);
        intentShareScore.setType("text/plain");
        intentShareScore.putExtra(Intent.EXTRA_TEXT, shareText + " in the QuizBeks app." + "\n" + "Visit https://www.dropbox.com/s/fjzereqm0b33xn9/QuizBek.apk?dl=0 to download and prove your knowledge");

        if (intentShareScore.resolveActivity(getPackageManager()) != null) {
            startActivity(intentShareScore);
        }
    }
}
