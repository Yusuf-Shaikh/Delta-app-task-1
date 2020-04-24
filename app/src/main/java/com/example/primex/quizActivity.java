package com.example.primex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quizActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT ="com.example.application.EXTRA_TEXT";
    Button home;
    TextView highcore,prescore;
    private int highscore = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent quizintent = getIntent();
        String text = quizintent.getStringExtra(questionsActivity.EXTRA_TEXT);

        home = (Button) findViewById(R.id.home);
        highcore = (TextView) findViewById(R.id.highscore);
        prescore = (TextView) findViewById(R.id.prescore);
        showhighscore();
        prescore.setText(text);
        int previousscore = Integer.parseInt(text);
        if(previousscore>highscore){
            highscore = previousscore;
            savehighscore();
        }
        showhighscore();
        String highscorecontent = "High score : " + highscore ;
        highcore.setText(highscorecontent);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainactivity();
            }
        });
    }
    public void savehighscore() {
        SharedPreferences sharedpreferences = getSharedPreferences("highscore",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("score",highscore);
        editor.apply();
    }
    public void showhighscore() {
        SharedPreferences sharedPreferences = getSharedPreferences("highscore",MODE_PRIVATE);
        highscore = sharedPreferences.getInt("score",MODE_PRIVATE);
    }
    public void openmainactivity() {
        Intent mainintent = new Intent(quizActivity.this,MainActivity.class);
        startActivity(mainintent);
    }
    @Override
    public void onBackPressed() {
    }
}
