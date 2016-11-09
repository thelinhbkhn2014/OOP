/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group9.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Data {
    private static ArrayList<Subject> subjectList;

    public Data() {
        readData();
    }

    public static ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    
    // tớ để mặc định data.txt, bạn nào làm GUI có thể dùng JFileChooser cho chọn, còn ko thì thôi cũng dc :D
    public void readData() {
        subjectList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            subjectList = (ArrayList<Subject>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void writeData(){
        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(subjectList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String[] toArrayString_Subject(ArrayList<Subject> subjectList) {
        String[] list = new String[subjectList.size()];
        for (int i = 0; i < subjectList.size(); i++) {
           list[i] = subjectList.get(i).getSubjectName();
        }
        return list;
    }
	
    public static String[] toArrayString_Question(ArrayList<Question> questionList) {
        String[] list = new String[questionList.size()];
        for (int i = 0; i < questionList.size(); i++) {
           list[i] = questionList.get(i).getContent();
        }
        return list;
    }
	
    public static String[] toArrayString_Test(ArrayList<Test> testList) {
        String[] list = new String[testList.size()];
        for (int i = 0; i < testList.size(); i++) {
            list[i] = testList.get(i).getTestName();			
        }
	return list;		
    }
    
    public static Test createTest(int subjectIndex, int testType, int questionNumber, int level) {
        ArrayList<Question> questionList = Data.subjectList.get(subjectIndex).getQuestionList();
        Test test = new Test();
	// dạng đề thi = 1 lay cau trac nghiem
	if (testType == 1) { 
            for (int i = 0; i < questionNumber; i++) {
		Question question;
		while (true) {
                    int random = (new Random()).nextInt(questionList.size());
                    question = questionList.get(random);
                    if (question.getLevel() == level && question instanceof MultiChoiceQuestion) {
			break;
                    }			
		}
		test.addQuestion(question);						
			
            }		
                
	} else if (testType == 2) { // dạng đề thi =2 chỉ lấy tự luận
            for (int i = 0; i < questionNumber; i++) {
		Question question;
		while (true) {
                    int random = (new Random()).nextInt(questionList.size());
                    question = questionList.get(random);
                    if (question.getLevel() == level && question instanceof EssayQuestion) {
			break;
                    }
		}
		test.addQuestion(question);
            }
	} else if (testType == 3) { // cả trắc nghiệm và tự luận
            int essayQuestionNumber = (new Random()).nextInt(questionNumber/3) + 1;
            for (int i = 0; i < questionNumber - essayQuestionNumber; i++) {
		Question question;
		while (true) {
                    int random = (new Random()).nextInt(questionList.size());
                    question = questionList.get(random);
                    if (question.getLevel() == level && question instanceof MultiChoiceQuestion) {
			break;
                    }
		}
		test.addQuestion(question);
            }
            for (int i = 0; i < essayQuestionNumber; i++) {
		Question question;
		while (true) {
                    int random = (new Random()).nextInt(questionList.size());
                    question = questionList.get(random);
                    if (question.getLevel() == level && question instanceof EssayQuestion) {
			break;
                    }
		}
		test.addQuestion(question);
            }
	} 
        return test;
    }
	    
}
