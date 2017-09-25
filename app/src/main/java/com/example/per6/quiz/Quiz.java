package com.example.per6.quiz;

import android.widget.Toast;

/**
 * Created by per6 on 9/19/17.
 */

public class Quiz {

    private Question[] questionList;
    private int questionNum, points;

    public Quiz(Question[] list){
        questionList = list;
        points = 0;
        questionNum = 0;
    }

    public String checkAnswer(boolean b){
        if(!questionList[questionNum - 1].checkAnswered()){
            if(questionList[questionNum - 1].checkAnswer(b)){
                points += 1;
                return "Correct! You're a fluffyboi.";

            }
            else{
                return "Incorrect. You are not a fluffyboi.";
            }
        }
        else{
            return "You have already answered this question";
        }
    }

    public String next(){
        questionNum +=1;
        return questionList[questionNum-1].getQuestionText();
    }

    public String getScore(){
        int percent = (int)(100*(points/(double)questionList.length));
        return "Score: "+points+"/"+questionList.length+"\nPercentage: "+percent+"%";
    }

    public int getQuestionNum(){ return questionNum; }

    public void setQuestionNum(int num){ questionNum = num; }

    public boolean isFinished(){
        if(questionNum == questionList.length){ return true; }
        else { return false; }
    }

}
