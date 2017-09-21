package com.example.per6.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueButton, falseButton, nextButton;
    private TextView questionView;
    private Question[] questionList;
    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        makeQuestions();
        quiz = new Quiz(questionList);
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
        questionView.setText(quiz.next());
    }

    public void trueClicked(View view){
        Toast.makeText(this, quiz.checkAnswer(true), Toast.LENGTH_SHORT).show();

    }

    public void falseClicked(View view){
        Toast.makeText(this, quiz.checkAnswer(false), Toast.LENGTH_SHORT).show();
    }

    public void nextClicked(View view){
        nextQuestion();
    }

}
