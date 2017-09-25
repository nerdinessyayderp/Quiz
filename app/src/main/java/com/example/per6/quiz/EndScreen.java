package com.example.per6.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    private TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
        scoreView = (TextView) findViewById(R.id.view_score);

        Intent i = getIntent();
        scoreView.setText(i.getStringExtra("score"));
    }
}
