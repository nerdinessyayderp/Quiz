package com.example.per6.quiz;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueButton, falseButton, nextButton;
    private TextView questionView;
    private Question[] questionList;
    private Quiz quiz;
    public static final String TAG = "derp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        makeQuestions();
        quiz = new Quiz(questionList);
        if(savedInstanceState != null){
             quiz.setQuestionNum(savedInstanceState.getInt("question num"));
        }
        nextQuestion();
    }

    private void wireWidgets(){
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);
        questionView = (TextView) findViewById(R.id.question);
    }

    private void makeQuestions(){
        questionList = new Question[] { new Question(getString(R.string.question1), 0, true),
                new Question(getString(R.string.question2), 1, false),
                new Question(getString(R.string.question3), 2, true),
                new Question(getString(R.string.question4), 3, false),
                new Question(getString(R.string.question5), 4, false),
                new Question(getString(R.string.question6), 5, true)};
    }

    private void nextQuestion(){
        if(!quiz.isFinished())
            questionView.setText(quiz.next());
        else {
            Intent i = new Intent(MainActivity.this, EndScreen.class);
            i.putExtra("score", quiz.getScore());
            startActivity(i);
        }
    }

    public void trueClicked(View view){ Toast.makeText(this, quiz.checkAnswer(true), Toast.LENGTH_SHORT).show(); }

    public void falseClicked(View view){ Toast.makeText(this, quiz.checkAnswer(false), Toast.LENGTH_SHORT).show(); }

    public void nextClicked(View view){
        nextQuestion();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: method fired");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: method fired");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: method fired");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: method fired");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: method fired");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: method fired");
        outState.putInt("question num", quiz.getQuestionNum());
    }
}
