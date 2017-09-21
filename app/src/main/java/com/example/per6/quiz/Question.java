package com.example.per6.quiz;

/**
 * Created by per6 on 9/15/17.
 */

public class Question {

    private String questionText;
    private int questionNum;
    private boolean answer;
    private boolean answered;

    public Question(String text, int num, boolean ans){
        questionText = text;
        questionNum = num;
        answer = ans;
        answered = false;
    }

    public boolean checkAnswer(boolean userAnswer){
        answered = true;
        if(userAnswer == answer){
            return true;
        }
        else{
            return false;
        }
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean checkAnswered() {return answered;}

}
