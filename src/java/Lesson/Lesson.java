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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author henrykmg
 */
@ManagedBean
@ViewScoped
public class Lesson implements Serializable{
     private int n;
     Random r=new Random();
    private int number=0;
    List<String> nm;
    public int getNumber() {
        return number;
    }
 
    public void increment() {
        number=r.nextInt(5);
//        if(number<nm.size()-1)
//        number++;
//        else
//        number=0;
    }
    
  
     
    public int getN() {
        return n;
    }

    public void setN(int n) {
     
        this.n = n++;
            
    }
     
    public   List<String> addNames()
    {        
      nm=new ArrayList<String>();
      nm.add("Mike");
      nm.add("Nina");
      nm.add("Tom");
      nm.add("Suzan");
      nm.add("Jackie");
      return nm;
      
    }
    
    
}
