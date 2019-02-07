
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
public class db2load {
       Connection conn=null;
    
    Scanner sc=new Scanner(System.in);

String url="jdbc:mysql://localhost/";
String dbname="project";
String driver="com.mysql.jdbc.Driver";
String username="root";
String password="jalaj";
String str1,str2;
Statement stmt=null;
    
         
 public  ResultSet load(int dif)
{

try{

Class.forName("com.mysql.jdbc.Driver");
conn=DriverManager.getConnection("jdbc:mysql://localhost/project",username,password);
stmt=conn.createStatement();

String sql="Select * from ques where difficulty="+dif+" ORDER BY RAND() LIMIT 1;";
System.out.println(sql);
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
            Logger.getLogger(db2load.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
