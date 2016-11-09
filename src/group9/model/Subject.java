/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group9.model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Subject {
    private String subjectId;
    private String subjectName;
    private String introduce;
    private int testNumber;
    private int questionNumber;
    private int chapterNumber;
    private ArrayList<Question> questionList = new ArrayList<>();
    private ArrayList<Test> testList = new ArrayList<>();

    //3 contructor dùng cái nào thì dùng :D
    public Subject() {
        this.subjectId = "empty";
        this.subjectName = "empty";
        this.introduce = "empty";
        this.testNumber = 0;
        this.questionNumber = 0;
        this.chapterNumber = 0;
    }

    public Subject(String subjectId, String subjectName, String introduce, ArrayList<Question> questionList, ArrayList<Test> testList) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.introduce = introduce;
        this.questionList = questionList;
        this.testList = testList;
        this.questionNumber = questionList.size();
        this.testNumber = testList.size();
    }

    public Subject(String subjectId, String subjectName, String introduce) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.introduce = introduce;
        this.questionNumber = 0;
        this.testNumber = 0;
        this.chapterNumber = 0;
    }
    
    //getter setter

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getTestNumber() {
        return testNumber;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public ArrayList<Test> getTestList() {
        return testList;
    }
    
    // thêm, xóa câu hỏi + đề thi
    public void addQuestion(Question question){
        this.questionList.add(question);
        this.questionNumber ++;
    }
    
    public void deleteQuestion(int i){
        this.questionList.remove(i);
        this.questionNumber --;
    }
    
    public void addTest(Test test){
        this.testList.add(test);
        this.testNumber ++;
    }
    
    public void deleteTest(int i){
        this.testList.remove(i);
        this.testNumber --;
    }
    
    
}
