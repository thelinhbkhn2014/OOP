/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group9.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Test implements Serializable{
    private String testName;
    private int time;
    private int year;
    private int semester;
    private ArrayList<Question> questionList = new ArrayList<>();

    public Test() {
        this.testName = "";
        this.time = 90;
        this.year = 2016;
        this.semester = 1;
    }

    public Test(String testName, int time, int year, int semester) {
        this.testName = testName;
        this.time = time;
        this.year = year;
        this.semester = semester;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    // add,delete question, so cau hoi, lay ra cau hoi
    public void addQuestion(Question question){
        this.questionList.add(question);
    }
    
    public void deleteQuestion(int i){
        this.questionList.remove(i);
    }
    
    public int getQuestionNumbers(){
        return this.questionList.size();
    }
    
    public Question getQuestion(int i){
        return this.questionList.get(i);
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
    
    // Các bạn xuất ra thì check thử căn chỉnh cho căn đẹp nhé
    public void printTest(){
        try {
            FileWriter fw = new FileWriter(this.testName + ".txt");
            fw.write("      ĐỀ THI MÔN \n" + this.testName);
            fw.write("\n     Học Kỳ: " + this.semester + " - Năm học: " + this.year + "\n");
            fw.write(" Thời gian");
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    
}
