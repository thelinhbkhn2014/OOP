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
public abstract class Question implements Serializable{
    private String content;
    private int level;
    private int point;
    private int chapter;

    public Question() {
        this.content = "empty";
        this.level = 1;
        this.point = 1;
        this.chapter = 1;
    }

    public Question(String content, int level, int point, int chapter) {
        this.content = content;
        this.level = level;
        this.point = point;
        this.chapter = chapter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }
    
    public abstract void printQuestion();
    
    
}
