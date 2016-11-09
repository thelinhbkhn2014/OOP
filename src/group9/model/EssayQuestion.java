/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group9.model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class EssayQuestion extends Question implements Serializable{

    private String answer;

    public EssayQuestion() {
        super();
        this.setContent("empty essay");
        this.answer = "empty";
    }

    public EssayQuestion(String content, int level, int point, int chapter, String answer) {
        super(content, level, point, chapter);
        this.answer = answer;
    }

    
    
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
      
    @Override
    public void printQuestion() {
        System.out.println(this.getContent());
    }
    
}
