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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author henrykmg
 */
@ManagedBean
@RequestScoped
public class Bean {
 
    private Part file1;
    private String result;
    private String uploadedImage;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUploadedImage() {
        return uploadedImage;
    }

    public void setUploadedImage(String uploadedImage) {
        this.uploadedImage = uploadedImage;
    }
    
    
    
    
 

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
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
         result="Upload was Successfull..";
        //return "success";
    }

}
