/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group9.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MultiChoiceQuestion extends Question implements Serializable{

    private ArrayList<String> answerList = new ArrayList();
    private int numberAnswers;

    public MultiChoiceQuestion() {
        super();
        this.setContent("empty multi choice");
        this.numberAnswers = 0;
    }

    public MultiChoiceQuestion(String content, int level, int point, int chapter, ArrayList<String> answerList) {
        super(content, level, point, chapter);
        this.answerList = answerList;
        this.numberAnswers = answerList.size();
        
    }

    
    
    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
        this.numberAnswers = answerList.size();
    }

    public int getNumberAnswers() {
        return numberAnswers;
    }   
    
    public void addAnswer(String answer){
        this.answerList.add(answer);
        this.numberAnswers++;
    }
    
    public void deleteAnswer(int i){
        this.answerList.remove(i);
        this.numberAnswers--;
    }
      
    
    @Override
    public void printQuestion() {
        String info = this.getContent() + "\n";
        for(String answer : answerList){
            info += answer + "\n";
        }
        System.out.println(info);
    }
    
}
