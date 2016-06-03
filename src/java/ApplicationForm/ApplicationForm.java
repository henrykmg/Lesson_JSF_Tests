/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationForm;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author henrykmg
 */
@ManagedBean
@RequestScoped
public class ApplicationForm{
    @Resource(name = "test")
    private DataSource test;
    private Part file;

    private String fname;
    private String mname;
    private String lname;
    private String dob;
    private String gender;
    private String student_class;
    private String photo;
    private String otherInfo;
    private String status;
    
    private String uploadedImage;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public String getUploadedImage() {
        return uploadedImage;
    }

    public void setUploadedImage(String uploadedImage) {
        this.uploadedImage = uploadedImage;
    }
    
    

    public String getStatus() {
        
       
                return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
    
    
    
    public Connection getConnection()
    {
        Connection con = null; 
        try { 
            con = test.getConnection();
                    //DriverManager.getConnection(url, user, password); 
            System.out.println("Connection completed."); 
        } catch (SQLException ex) 
        { 
            System.out.println(ex.getMessage()); 
        } 
        finally{ } 
        
        return con;
    }

public void addStudent()
{
int i = 0;
PreparedStatement ps = null;
Connection con = null; 
try
{
//Class.forName("com.mysql.jdbc.Driver");
con =test.getConnection();   //getConnection();
String sql = "INSERT INTO applicationforms(FName,MName,LName,DOB,Gender,Student_Class,Photo,OtherInfo) VALUES(?,?,?,?,?,?,?,?)";
ps= con.prepareStatement(sql); 
ps.setString(1,fname);
ps.setString(2,mname);
ps.setString(3, lname);
ps.setString(4,"01 June, 2016");
ps.setString(5, gender);
ps.setString(6, student_class);
ps.setString(7, photo);
ps.setString(8, otherInfo);

i = ps.executeUpdate();
status="Student was added successfully..";
System.out.println("Data Added Successfully");
con.close();
ps.close();
}
catch(Exception e)
{
System.out.println(e); 
status=e.getMessage();
}
finally
{
try
{
con.close();
ps.close();
 FacesMessage message = new FacesMessage(status);
 FacesContext.getCurrentInstance().addMessage(null, message);
}
catch(Exception e)
{
e.printStackTrace();
status=e.getMessage();
}
}
}

 public void upload(FileUploadEvent event) throws IOException {
      long millis=System.currentTimeMillis();
      String dt=""+millis;
      String extension= event.getFile().getFileName().substring(event.getFile().getFileName().indexOf("."));
      InputStream is =   event.getFile().getInputstream(); //file1.getInputStream();
        // String extension =file1.getSubmittedFileName().substring(file1.getSubmittedFileName().indexOf("."));   
      Path destination = Files.createTempFile(Paths.get("\\var\\luazi\\images"), dt,extension);
      Files.copy(is, destination, StandardCopyOption.REPLACE_EXISTING);
      uploadedImage="http://localhost:8080/Lesson1/faces/images/"+destination.getFileName();
      photo=""+destination.getFileName();
        // result="Upload was Successfull..";
        //return "success";
    }

    
}
