
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pgcil
 */
public class DataBaseLoader {
    Connection conn=null;
    
    Scanner sc=new Scanner(System.in);

String url="jdbc:mysql://localhost/";
String dbname="project";
String driver="com.mysql.jdbc.Driver";
String username="root";
String password="jalaj";
String str1,str2;
Statement stmt=null;

      public  ResultSet load()
{
       



try{

Class.forName("com.mysql.jdbc.Driver");
conn=DriverManager.getConnection("jdbc:mysql://localhost/project",username,password);
stmt=conn.createStatement();
String sql="Select * from students";
ResultSet rsl=stmt.executeQuery(sql);
//System.out.println("1 came");

return rsl;


}
catch(Exception e)
{
}

return null;
}//for main
public void closeconn(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void addinfo(String ten,String twelve,String cg,String addr,String str5,int id)
{
   
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/project",username,password);
            stmt=conn.createStatement();
            String sql="UPDATE students SET addr=\""+addr+"\",10th=\""+ten+"\",12th= \""+twelve+"\",cgpa=\""+cg+"\",branch=\""+str5+"\",infoavail=\"Y\" WHERE id="+id+";";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (Exception ex) {
            
        }
}
public void addscore(int score,String grade,int id)
{
    try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/project",username,password);
            stmt=conn.createStatement();
            String sql="UPDATE students SET testgiven=\"Y\",testscore=\""+score+"\",grade=\""+grade+"\" where id="+id+";";
            System.out.println(sql);
            stmt.executeUpdate(sql);
    }
    catch(Exception ex) {
            
        }
}
public void dbreg(String name,String pass,String mail)
{
     try {
           //INSERT INTO `project`.`students` (`name`, `pass`, `infoavail`, `email`) VALUES ('jk', 'jk', 'N', 'jlad@msa.com');
       
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/project",username,password);
            stmt=conn.createStatement();
            String sql1="INSERT INTO students (name,pass,infoavail,email) VALUES (\""+name+"\",\""+pass+"\",\"N\",\""+mail+"\");";
            System.out.println(sql1);
            stmt.executeUpdate(sql1);
            

        } catch (Exception ex) {
            
        }
}
}

