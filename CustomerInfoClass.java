import java.sql.*;
import java.util.Calendar;


 public class CustomerInfoClass
{
private String SeatNumbers="", CusName="",CusMobileNumber="";
public int CusId ;
    public CustomerInfoClass(String CNa ,  String CMo ,String SNo,  String Ts , String Amount, String BusNO)
	{   
		CusName=CNa;
		CusMobileNumber=CMo;
		SeatNumbers=SNo;
    try
    {
      // create a mysql database connection
		 Class.forName("com.mysql.jdbc.Driver");  
   
  
      String myUrl = "jdbc:mysql://localhost:3306/a1";
	  //"jdbc:mysql:3306//localhost/jdbcdemo";
     
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	  //id genarate
	  Statement stmt=conn.createStatement(); 
		ResultSet rsID=stmt.executeQuery("select CusId from cus where Date=(select max(Date) from cus )");  
  
		while(rsID.next())  
	{
		CusId=rsID.getInt("CusId");
		CusId+=1;
	} 
	  
	  
	  
	  
    
      // create a sql date object so we can use it in our INSERT statement
      Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

      // the mysql insert statement
	  // // stmt.execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) "
                                // // + "VALUES (1,'Lokesh','Gupta',5)");
	  
	  
      String query = "INSERT INTO cus (CusId, CusName, CusMobileNumber, CusTotalSeat, Amount, SeatNumbers, Date,BusNO) "
			+"VALUES (?, ?, ?, ?, ?, ?, ?,?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt (1, CusId);
      preparedStmt.setString (2, CusName);
      preparedStmt.setString (3, CusMobileNumber);
      preparedStmt.setString (4, Ts);
      preparedStmt.setString   (5, Amount);
      preparedStmt.setString(6, SeatNumbers);
      preparedStmt.setDate    (7, startDate);
      preparedStmt.setString    (8, BusNO);
		

      // execute the preparedstatement
   preparedStmt.execute();
      System.err.println("Sucess insert database");
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
}




















// // // import java.sql.*;
// // // import java.util.Calendar;

// // // /**
 // // // * A Java MySQL PreparedStatement INSERT example.
 // // // * Demonstrates the use of a SQL INSERT statement against a
 // // // * MySQL database, called from a Java program, using a
 // // // * Java PreparedStatement.
 // // // * 
 // // // * Created by Alvin Alexander, http://devdaily.com
 // // // */
 // // // public class CustomerInfoClass
// // // {
// // // private String SeatNumbers="", CusName="",CusMobileNumber="";
    // // // public CustomerInfoClass(int CusId ,String CNa ,  String CMo ,String SNo,  String Ts , String Amount)
	// // // {
		// // // CusName=CNa;
		// // // CusMobileNumber=CMo;
		// // // SeatNumbers=SNo;
    // // // try
    // // // {
      // // // // create a mysql database connection
		 // // // Class.forName("com.mysql.jdbc.Driver");  
   
  
      // // // String myUrl = "jdbc:mysql://localhost:3306/a1";
	  // // // //"jdbc:mysql:3306//localhost/jdbcdemo";
     
      // // // Connection conn = DriverManager.getConnection(myUrl, "root", "");
    
      // // // // create a sql date object so we can use it in our INSERT statement
      // // // Calendar calendar = Calendar.getInstance();
      // // // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

      // // // // the mysql insert statement
	  // // // // // stmt.execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) "
                                // // // // // + "VALUES (1,'Lokesh','Gupta',5)");
	  
	  
      // // // String query = "INSERT INTO cus (CusId, CusName, CusMobileNumber, CusTotalSeat, Amount, SeatNumbers, Date) "
			// // // +"VALUES (?, ?, ?, ?, ?, ?, ?)";

      // // // // create the mysql insert preparedstatement
      // // // PreparedStatement preparedStmt = conn.prepareStatement(query);
      // // // preparedStmt.setInt (1, CusId);
      // // // preparedStmt.setString (2, CusName);
      // // // preparedStmt.setString (3, CusMobileNumber);
      // // // preparedStmt.setString (4, SeatNumbers);
      // // // preparedStmt.setString   (5, Amount);
      // // // preparedStmt.setString(6,Ts);
      // // // preparedStmt.setDate    (7, startDate);
		

      // // // // execute the preparedstatement
   // // // preparedStmt.execute();
      // // // System.err.println("Got ffffffffff");
      // // // conn.close();
    // // // }
    // // // catch (Exception e)
    // // // {
      // // // System.err.println("Got an exception!");
      // // // System.err.println(e.getMessage());
    // // // }
  // // // }
// // // }











// // // /*import java.sql.*;
// // // import java.util.Calendar;

// // // public class CustomerInfoClass
// // // {
   
	// // // private String SeatNumbers="", CusName="",CusMobileNumber="";
    // // // public CustomerInfoClass(int CusId ,String CNa ,  String CMo ,String SNo,  String Ts , String Amount)
	// // // {
      // // // try{  
		 // // // Class.forName("com.mysql.jdbc.Driver");  
  
		 // // // Connection con=DriverManager.getConnection(  
						 // // // "jdbc:mysql://localhost:3306/a1","root","");  
  
		// // // CusName=CNa;
		// // // CusMobileNumber=CMo;
		// // // SeatNumbers=SNo;
		 // // // Calendar calendar = Calendar.getInstance();
      // // // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		
		// // // //String query= "INSERT INTO cus (CusId, CusName, CusMobileNumber, CusTotalSeat, Amount, SeatNumbers, Date) VALUES("+CusId+","+CusName+","+CusMobileNumber+","+Ts+","+Amount+","+ SeatNumbers+","+dateFormat.format(date)+")"+";"  ; 
		
             // // // // Statement stinsert2 = con.createStatement(); 
			 // // // // stinsert2.executeUpdate(query);
			 // // // // stinsert2.close();
            // // // // System.out.println(" row(s) updated");
            // // // // System.out.println(query);
		 // // // String query = "INSERT INTO cus (CusId, CusName, CusMobileNumber, CusTotalSeat, Amount, SeatNumbers, Date) VALUES (?, ?, ?, ?, ?, ?, ?)";

      // // // // create the mysql insert preparedstatement
      // // // PreparedStatement preparedStmt = con.prepareStatement(query);
      // // // preparedStmt.setInt (1, CusId);
      // // // preparedStmt.setString (2, CusName);
      // // // preparedStmt.setString (3, CusMobileNumber);
      // // // preparedStmt.setString (4, Ts);
      // // // preparedStmt.setString   (5, Amount);
      // // // preparedStmt.setString(6, SeatNumbers);
      // // // preparedStmt.setDate    (7, startDate);
		
	  // // // }
        
        // // // catch(Exception ex){
            // // // ex.printStackTrace();
        // // // }
		
		
    // // // }
	
	
// // // }
   
   
   // // // */
   
   
    // // // // public void close()throws SQLException{
        // // // // if(rs!=null)rs.close();
        // // // // if(rs!=null)stmt.close();
    // // // // }
    // // // // public ResultSet getData(String query) {
        // // // // try{
            // // // // stmt = conn.createStatement();
            // // // // rs= stmt.executeQuery(query);
            // // // // System.out.println("Info from DB");
        // // // // }
        // // // // catch(Exception ex){
            // // // // System.out.println("DB Read Error !");
            // // // // //ex.printStackTrace();
        // // // // }
        // // // // return rs;
   // // // // }
    // // // // public int updateDB(String sql){
        // // // // int numOfRowsUpdated=0;
        // // // // try{
            // // // // stmt = conn.createStatement(); 
            // // // // numOfRowsUpdated=stmt.executeUpdate(sql);
            // // // // System.out.println(numOfRowsUpdated+" row(s) updated");
        // // // // }
        // // // // catch(Exception ex){
            // // // // ex.printStackTrace();
        // // // // }
        // // // // return numOfRowsUpdated;
    // // // // }
	
	
	




	
	
	// // // // //method
	// // // // public void CustomerSeatReserve(int CusId ,String CNa ,  String CMo ,String SNo,  String Ts , String Amount)
	// // // // {
		// // // // CusName=CNa;
		// // // // CusMobileNumber=CMo;
		// // // // SeatNumbers=SNo;
		// // // // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// // // // Date date = new Date();
		// // // // //System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		
		// // // // //stinsert1.executeUpdate( "INSERT INTO cus VALUES(CusId,CusName,CusMobileNumber,Ts,Amount, SeatNumbers,dateFormat.format(date))" ); 
		// // // // //stinsert1.executeUpdate( "INSERT INTO `cus` (`CusId`, `CusName`, `CusMobileNumber`, `CusTotalSeat`, `Amount`, `SeatNumbers`, `Date`) VALUES(CusId,CusName,CusMobileNumber,Ts,Amount, SeatNumbers,dateFormat.format(date))"  ); 
		// // // // String query= "INSERT INTO cus (CusId, CusName, CusMobileNumber, CusTotalSeat, Amount, SeatNumbers, Date) VALUES("+CusId+","+CusName+","+CusMobileNumber+","+Ts+","+Amount+","+ SeatNumbers+","+dateFormat.format(date)+")"  ; 
			// // // // updateDB(query);
	
	// // // // }
// // // //}