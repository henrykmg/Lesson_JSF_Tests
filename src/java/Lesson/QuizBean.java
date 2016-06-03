/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author henrykmg
 */
@ManagedBean(eager = true)
@ViewScoped
public class QuizBean  implements Serializable{
    
    private List<Question> questions=new ArrayList<Question>();
    Random r=new Random();
    private int c=1;
    private String qsn;
    private int qno=0;
    private String[] opts;
    private String ans;
    int cc;
    private Question qq;
    private String correct;
    private boolean chances=false;
    private boolean quizon=false;
    private boolean startScreen=true;
    private String quizStatus="Start";
    private int score=0;
    private String bgColor="white";
    
    
      

    public boolean isStartScreen() {
        return startScreen;
    }

    public void setStartScreen(boolean startScreen) {
        this.startScreen = startScreen;
    }

    public String getQuizStatus() {
        return quizStatus;
    }

    public void setQuizStatus(String quizStatus) {
        this.quizStatus = quizStatus;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    
    public boolean isQuizon() {
        return quizon;
    }

    public void setQuizon(boolean quizon) {
        this.quizon = quizon;
    }
    
    

    public boolean getChances() {
        return chances;
    }

    public void setChances(boolean chances) {
        this.chances = chances;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
    
    
  

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    
    public String getQsn() {
        return qsn;
    }

    public void setQsn(String qsn) {
        this.qsn = qsn;
    }

    public String[] getOpts() {
        return opts;
    }

    public void setOpts(String[] opts) {
        this.opts = opts;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
    
    
    

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    
    
    public Question getQq() {
        return qq;
    }

    public void setQq(Question qq) {
        this.qq = qq;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
    
    
    
    public void checkAnswer(String answer)
    {
        
        if(ans==answer)
        {
            bgColor="green";
            this.correct="Correct!!"; 
            this.score+=2;
        }
        else if(ans!=answer){
            bgColor="red";
        this.correct="Wrong!!, Answer is "+ans+".";
        
        }
               
        this.questions.remove(0);
        chances=true;

    }
    
    public void startQuiz()
    {
        bgColor="white";
        if(quizStatus=="Start")
        {
      score=0;
      quizon=true; 
      startScreen=false;
      correct="";
      chances=false;
      addQuestions();
      qq=questions.get(0);
      qsn= qq.getQn();
      qno=qq.getQno();
      opts=qq.getOptions();
      ans=qq.getAnswer();
     FacesMessage msg = new FacesMessage("Click on the most correct Question","Click on the most correct Question..");  
     FacesContext.getCurrentInstance().addMessage(null, msg); 
     quizStatus="Stop/Break";
        }
        else if(quizStatus=="Resume")
        {
      quizon=true; 
      startScreen=false;
      correct="";
      chances=false;
      qq=questions.get(0);
      qsn= qq.getQn();
      qno=qq.getQno();
      opts=qq.getOptions();
      ans=qq.getAnswer();
     FacesMessage msg = new FacesMessage("Click on the most correct Question","Click on the most correct Question..");  
     FacesContext.getCurrentInstance().addMessage(null, msg); 
     quizStatus="Stop/Break";
        }
        else
        {
      quizon=false; 
      startScreen=true;  
      quizStatus="Resume";
        }
    }
    
    public void ask()
    {
        bgColor="white";
        if(!questions.isEmpty())
        {
      correct="";
      chances=false;
      qq=questions.get(0);
      qsn= qq.getQn();
      qno=qq.getQno();
      opts=qq.getOptions();
      ans=qq.getAnswer();
     FacesMessage msg = new FacesMessage("Click on the most correct Question","Click on the most correct Question..");  
     FacesContext.getCurrentInstance().addMessage(null, msg); 
        }
        else{
            bgColor="Orange";
            quizStatus="Start";
            quizon=false;
            this.correct="End of Quiz, your score is :"+score;
        }
    
    }
     
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions() {
        this.questions = addQuestions();
    }
    public String[] setOptions(String opt1,String opt2,String opt3,String opt4)
    {
        String[]options={opt1,opt2,opt3,opt4};
        return options;
    }
    public List<Question> addQuestions()
    {
    
       //List<Question> questions=new ArrayList<Question>();
       Question q=new Question(1,"What is the Capital city of Uganda?",setOptions("Jinja","Masaka","Kampala","Nairobi"),"Kampala",3);
       this.questions.add(q);
       Question q1=new Question(2,"Who is the president of Uganda?",setOptions("Obama","Kibaki","Kadaga","Museveni"),"Museveni",3);
       this.questions.add(q1);
       Question q3=new Question(3,"What is 2 by 4 by 3?",setOptions("12","24","33","None of the above"),"24",3);
       this.questions.add(q3);
       Question q4=new Question(4,"Who is the Speaker of the 10th Parliament?",setOptions("Kadaga","Nambooze","Olanya","Nsereko"),"Kadaga",3);
       this.questions.add(q4);
       Question q5=new Question(5,"What is the Capital city of Kenya?",setOptions("Mombasa","Zanzibar","Kampala","Nairobi"),"Nairobi",3);
       this.questions.add(q5);
       
       return this.questions;
    }
    
    
    
    
}
