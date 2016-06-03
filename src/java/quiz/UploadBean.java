package quiz;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.opencsv.CSVReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;


/**
 *
 * @author henrykmg
 */
@ManagedBean
@SessionScoped
public class UploadBean implements Serializable{
  private List<Question> qn=new ArrayList<Question>();
  private String[] question;
  private String n;
  private Question qs;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

  
  
    public Question getQs() {
        return qs;
    }

    public void setQs(Question qs) {
        this.qs = qs;
    }
  
  

    public String[] getQuestion() {
        return question;
    }

    public void setQuestion(String[] question) {
        this.question = question;
    }
  
  
  

    public List<Question> getQn() {
        return qn;
    }

    public void setQn(List<Question> qn) {
        this.qn = qn;
    }
  
  
  
  public void handleFileUpload(FileUploadEvent event) {
            try{
    String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
    String name ="level1"; //fmt.format(new java.util.Date());
    String extension=event.getFile().getFileName().substring(event.getFile().getFileName().lastIndexOf('.'));
    Path destination = Files.createTempFile(Paths.get("\\var\\luazi\\images"),name,extension);
    InputStream is = event.getFile().getInputstream();
    OutputStream out = new FileOutputStream(destination.toFile());
    byte buf[] = new byte[1024];
    int len;
    while ((len = is.read(buf)) > 0)
        out.write(buf, 0, len);
    is.close();
    out.close();
   
     
FacesMessage message = new FacesMessage("Succesful",name+extension + " is uploaded.");     
FacesContext.getCurrentInstance().addMessage(null, message);
      }
      catch(IOException ioe)
      {
        FacesMessage message = new FacesMessage("Upload Failed", event.getFile().getFileName() + "failed tp upload.");
        FacesContext.getCurrentInstance().addMessage(null, message);
      }
       

  }
  String[] row = null; 
 
  int x=0;
  
private String text;
public List<String> complete(String query) {
List<String> results = new ArrayList<String>();
for (int i = 0; i < 10; i++)
results.add(query + i);
return results;
}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
  
    public void handleSelect(SelectEvent event) {
Object item = event.getObject();
FacesMessage msg = new FacesMessage("Selected", "Item:" + item);
}
  
  public void loadData()
  {
      qn.clear();
  String csvFilename = "C:\\var\\luazi\\images\\201605191232328681952777464192397.csv";
      try{
CSVReader csvReader = new CSVReader(new FileReader(csvFilename));


List content = csvReader.readAll();
List<String[]> lst=new ArrayList<>();
for (Object object : content) {
    
    row = (String[]) object;
    lst.add(row);
    Question q=new Question();
    q.setQuestion(row[0]);
    q.setOption1(row[1]);
    q.setOption2(row[2]);
    q.setOption3(row[3]);
    q.setOption4(row[4]);
    q.setAnswer(row[5]);
    q.setLevel(row[6]);
    qn.add(q);
}

   //setQs(qn);
qn.remove(0);
   setQn(qn);
  // setQuestion(lst.get(x));//qn.get(0).getQuestion());
  
   csvReader.close();
  
      }
catch(Exception fne)
        {
        FacesMessage message = new FacesMessage("Upload Failed", fne.getMessage() + "failed tp upload.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        }   
  }

 
    
    }
    

