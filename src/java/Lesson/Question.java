/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson;

/**
 *
 * @author henrykmg
 */
public class Question {
    
    private int qno;
    private String qn;
    private String[] options;
    private String answer;
    private int level;

    public Question(int qno, String qn, String[] options, String answer, int level) {
        this.qno = qno;
        this.qn = qn;
        this.options = options;
        this.answer = answer;
        this.level = level;
    }
    
    

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getQn() {
        return qn;
    }

    public void setQn(String qn) {
        this.qn = qn;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    
}
