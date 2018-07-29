
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.sql.*;
import java.util.Calendar;

class LoginClass 
{
private String chairman_username ;
	
private String chairman_password;

 private String counterest_username ;
	
private  String counterest_password ;

private int CHtype ;
private int COtype ;



LoginClass()
{
	try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/a1","root","");  
  
  
Statement stmt=con.createStatement();  
  
ResultSet rsCH=stmt.executeQuery("select * from loginclassdatabase where ID=1");  
  
while(rsCH.next())  
{
	chairman_username=rsCH.getString("UserId");
	chairman_password=rsCH.getString("PassWord");
	CHtype=rsCH.getInt("Open");
} 
ResultSet rsCO=stmt.executeQuery("select * from loginclassdatabase where ID=2");  
  
while(rsCO.next())  
{
	counterest_username=rsCO.getString("UserId");
	counterest_password=rsCO.getString("PassWord");
	COtype=rsCO.getInt("Open");
}

  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}






public String get_chairman_username()
  {
	return chairman_username;
  }
 public String get_chairman_password ()
 {
	return chairman_password;
 }
 
  public String get_counterest_username()
  {
	return counterest_username;
  }
public  String get_counterest_password ()
 {
	return counterest_password;
 }
  public int get_CHtype()
  {
	return CHtype;
  }
public  int get_COtype ()
 {
	return COtype;
 }
 
 public void TicketSellingFrameCreate()
 {
	 TicketSellingFrame TicketFrame = new TicketSellingFrame();
 }
 public void ChairmanInterfaceCreate()
 {
	 ChairmanInterface ChairmanFrame = new ChairmanInterface();
 }
 // public void ChangeLoginInterfaceCreate()
 // {
	 // ChangeLoginInterfacePass Pass = new ChangeLoginInterfacePass();
 // }

 
 
public void LoginPasworrdChange(String Adp,String Cop)
{
	try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/a1","root","");  
  
  
Statement stmt=con.createStatement();  
  

  
  
  
  String query = "UPDATE loginclassdatabase SET PassWord= "+Adp +" where ID=1 ;";
  System.out.println(query);

      // create the mysql update 
      PreparedStatement preparedStmt = con.prepareStatement(query);
	  preparedStmt.executeUpdate();
  
  
  String query2 = "UPDATE loginclassdatabase SET PassWord= "+Cop +" where ID=2 ;";
  
  System.out.println(query2);

      // create the mysql update 
      PreparedStatement preparedStmt2 = con.prepareStatement(query2);
	  preparedStmt2.executeUpdate();

  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}
 
 
}