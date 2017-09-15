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
    private int questionNum, points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        makeQuestions();
        nextQuestion();
    }

    private void wireWidgets(){
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);
        questionView = (TextView) findViewById(R.id.question);
    }

    private void makeQuestions(){
        questionList = new Question[] { new Question("Are potatoes fluffy?", 0, true), new Question("Is it weird to like fluffy things?", 1, false) };
        questionNum = 0;
        points = 0;
    }

    private void nextQuestion(){
        if(questionNum < questionList.length){
            questionView.setText(questionList[questionNum].getQuestionText());
            questionNum +=1;
        }
    }

    public void trueClicked(View view){
        if(questionList[questionNum - 1].checkAnswer(true)){
            Toast.makeText(this, "Correct! You're a fluffyboi.", Toast.LENGTH_SHORT).show();
            points += 1;
        }
        else{
            Toast.makeText(this, "Incorrect. You are not a fluffyboi.", Toast.LENGTH_SHORT).show();
        }
    }

    public void falseClicked(View view){
        if(questionList[questionNum - 1].checkAnswer(false)){
            Toast.makeText(this, "Correct! You're a fluffyboi.", Toast.LENGTH_SHORT).show();
            points += 1;
        }
        else{
            Toast.makeText(this, "Incorrect. You are not a fluffyboi.", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextClicked(View view){
        nextQuestion();
    }

}
