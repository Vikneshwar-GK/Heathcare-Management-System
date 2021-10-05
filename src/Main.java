import java.awt.Color;
import java.awt.FlowLayout;
 
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main{
    
    
    public static void main(String []args){
        Connection con;
        Statement st1,st2;
        ResultSet rs1;
        int rs2;
        
        java.sql.Date date;
        LocalDate ldate = LocalDate.now();
        java.sql.Date date2 = java.sql.Date.valueOf(ldate);   
        String query,query1;
        try {
                String bid="";
                Class.forName("com.mysql.cj.jdbc.Driver");   
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","xiic12339");
                st1=con.createStatement();
                //con2= DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","xiic12339");
                st2=con.createStatement();
                
                query="select booking_id from booking_summary where date1<'"+date2+"' and status='N'";
                
                rs1=st1.executeQuery(query);
                
                while(rs1.next()){
                    //date=rs1.getDate("date1");
                    bid=rs1.getString("booking_id");
                    //System.out.println(bid);
                    query1="update booking_summary set status='C' where booking_id='"+bid+"'";
                    rs2=st2.executeUpdate(query1);
                    
                    
                    
                }
    
        }
        catch(Exception ex){
            System.out.println("Error : "+ex);
        }
        
        Opening ob=new Opening();
        ob.setVisible(true);
    }
}