/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author henrykmg
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Login implements Serializable{
    private List<User> users;
    private User user;
    
    private String uname="";
    private String password="";
    private String er;
     private String er1;
     private String rnd;
     private String rnd1;

    public String getRnd() {
        return rnd;
    }

    public void setRnd(String rnd) {
        this.rnd = rnd;
    }

    public String getRnd1() {
        return rnd1;
    }

    public void setRnd1(String rnd1) {
        this.rnd1 = rnd1;
    }
     
     

    public String getEr() {
        return er;
    }

    public void setEr(String er) {
        this.er = er;
    }

    public String getEr1() {
        return er1;
    }

    public void setEr1(String er1) {
        this.er1 = er1;
    }
    

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public List<User> getUsers() {
        return generateUsers();
    }

    public User getUser() {
        return user;
    }
    
    public String checkuser()
    {
        String page;
        int x=0;
       generateUsers();
        if(this.uname.equals(user.getfName()))
        {
            this.er="";
            this.rnd="0";
            x++;
        }
        else
        {
            this.er="Invalid Username";
            this.rnd="50";
        }
        if(this.password.equals(user.getPassword()))
        {
            this.er1="";
            this.rnd1="0";
            x++;
        }
        else
        {
            this.er1="Invalid Password";
            this.rnd1="50";
        }
        
        if(x==2)
        {
            page= "newjsf";
        }
        else
        {
            page="";
        }
        return page;
    }
    
     
    public List<User> generateUsers()
    {
        users=new ArrayList<User>();
        user=new User();
        user.setfName("Fred");
        user.setlName("Mukasa");
        user.setEmail("fred@gmail.com");
        user.setPassword("12345");
        users.add(user);
        return users;
    }
    
}
