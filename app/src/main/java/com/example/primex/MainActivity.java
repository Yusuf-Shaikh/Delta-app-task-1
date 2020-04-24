package com.example.primex;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button startquiz;
    private int highscore = 0 ;
    private TextView highscores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        highscores = (TextView) findViewById(R.id.highscores);
        startquiz = (Button) findViewById(R.id.begin);
        startquiz.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityquiz();
            }
        });
        showhighscore();
        String temp = "Highscore : " + highscore;
        highscores.setText(temp);
    }
    public void openActivityquiz() {
        Intent quizintent = new Intent(MainActivity.this,questionsActivity.class);
        startActivity(quizintent);
    }
    public void showhighscore() {
        SharedPreferences sharedPreferences = getSharedPreferences("highscore",MODE_PRIVATE);
        highscore = sharedPreferences.getInt("score",MODE_PRIVATE);
    }
    @Override
    public void onBackPressed() {
    }
}
