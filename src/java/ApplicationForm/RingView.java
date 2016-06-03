/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationForm;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.sql.DataSource;

/**
 *
 * @author henrykmg
 */
@ManagedBean(eager=true)
public class RingView {
     @Resource(name = "test")
     
    private DataSource test;
    
    private List<Student> students;
    private Student selectedStudent;
     
    @PostConstruct
    public void init() {
        students = new ArrayList<Student>();
        ResultSet rs = null; 
        PreparedStatement pst = null;
        Connection con =null;
        try{
        con= test.getConnection();
        String stm = "Select * from applicationforms";
       
      //  List<Student> students = new ArrayList<Student>(); 
            pst = con.prepareStatement(stm); 
            pst.execute(); 
            rs = pst.getResultSet();
            while(rs.next())
            { 
               Student s=new Student();
               s.setAid(rs.getLong(1));
               s.setFname(rs.getString(2));
               s.setMname(rs.getString(3));
               s.setLname(rs.getString(4));
               s.setDob(rs.getString(5));
               s.setGender(rs.getString(6));
               s.setStudent_class(rs.getString(7));
               s.setPhoto("http://localhost:8080/Lesson1/faces/images/"+rs.getString(8)); 
               s.setOtherInfo(rs.getString(9));
            
             students.add(s);
            
             }
        }
        catch(SQLException ex)
        {
            
        }
           
      
 
    
    
         
       // students.add(new Student(){{setAid(1);setFname("John");setMname("F");setLname("Kennedy");setDob("3 June, 2016");setGender("Male");setStudent_class("Primary 2");setPhoto("http://localhost:8080/Lesson1/faces/images/14649488358952910369094502174068.png"); setOtherInfo("NA");}});
      //students.add(new Student(){{setAid(2);setFname("Mike");setMname("F");setLname("Kennedy");setDob("3 June, 2016");setGender("Male");setStudent_class("Primary 2");setPhoto("http://localhost:8080/Lesson1/faces/images/14649503308882911347130092067363.png"); setOtherInfo("NA");}});
    //students.add(new Student(){{setAid(3);setFname("Sam");setMname("F");setLname("Kennedy");setDob("3 June, 2016");setGender("Male");setStudent_class("Primary 2");setPhoto("http://localhost:8080/Lesson1/faces/images/14649465252168562816473289570081.png"); setOtherInfo("NA");}});
    }
 
    public List<Student> getStudents() {
        
        return students;
    }
 
    public void setStudents(List<Student> students) {
        this.students= students;
    }
 
    public Student getSelectedStudent() {
        return selectedStudent;
    }
 
    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }
    
}
