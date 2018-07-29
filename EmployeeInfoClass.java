import java.sql.*;
import java.util.Calendar;


public class EmployeeInfoClass
{
	private String Emp_Name;
	private int Emp_Id;   
	
	private String Emp_City;
	private String Emp_Distric;
	private String Emp_Phone;
	private String Emp_Email;
    private String Emp_Date_Of_Birth;
	private String Emp_NID;
	private String Emp_Blood;
	private Date Emp_Joining_Date;
	private String Emp_S_S_C;
	private String Emp_H_S_C;
	private String Emp_Gender;
	private String Emp_Type;
	private int Emp_Salary;
	
	
	
	
	
	// Set Method ..............
	
	public void set_Emp_Name(String en)
   {
       Emp_Name = en;
   }
   
   public void set_Emp_ID(int ei)
   {
       Emp_Id = ei;
   }
   
   
   public void set_Emp_City(String ec)
   {
       Emp_City = ec;
   }
   
   public void set_Emp_Distric(String ed)
   {
       Emp_Distric = ed;
   }
   
   public void set_Emp_Phone(String ep)
   {
       Emp_Phone = ep;
   }
   public void set_Emp_Email(String ee)
   {
       Emp_Email = ee;
   }
   
   // public void set_Emp_Date_Of_Birth(Date edb)
   // {
       // Emp_Date_Of_Birth = edb;
   // }
   
   public void set_Emp_NID(String eni)
   {
       Emp_NID = eni;
   }
   
   public void set_Emp_Blood(String eb)
   {
       Emp_Blood = eb;
   }
   
   // public void set_Emp_Joining_Date(Date ej)
   // {
       // Emp_Joining_Date = ej;
   // }
   
   public void set_Emp_SSC(String essc)
   {
       Emp_S_S_C = essc;
   }
   
   public void set_Emp_HSC(String ehsc)
   {
       Emp_H_S_C = ehsc;
   }
   
   public void set_Emp_Gender(String eg)
   {
       Emp_Gender = eg;
   }
   
   public void set_Emp_Type(String et)
   {
       Emp_Type = et;
   }
   
   public void set_Emp_Salary(int es)
   {
       Emp_Salary = es;
   }
	
	
   
   
   
   
   
   // // Get Methode .............
   
   public String get_Emp_Name()
   {
     return Emp_Name;
   } 
   
   public int get_Emp_ID()
   {
     return Emp_Id;
   }
  
   public String get_Emp_City()
   {
     return Emp_City;
   }
   public String get_Emp_Distric()
   {
     return Emp_Distric;
   }
   
   public String get_Emp_Phone()
   {
     return Emp_Phone;
   }
   
   public String get_Emp_Email()
   {
     return Emp_Email;
   }
   
    public String get_Emp_Date_Of_Birth()
   {
     return Emp_Date_Of_Birth;
    }
   
   public String get_Emp_NID()
   {
     return Emp_NID;
   }
   
   public String get_Emp_Blood()
   {
     return Emp_Blood;
   }
   
   public Date get_Emp_Joining_Date()
   {
     return Emp_Joining_Date;
   }
   
   public String get_Emp_SSC()
   {
     return Emp_S_S_C;
   }
   
   public String get_Emp_HSC()
   {
     return Emp_H_S_C;
   }
   public String get_Emp_Gender()
   {
     return Emp_Gender;
   }
   
   public String get_Emp_Type()
   {
     return Emp_Type;
   }
   
   public int get_Emp_Salary()
   {
     return Emp_Salary;
   } 
   
  
	
	//private String Emp_Name =" ",Emp_Id =" ",Emp_Address=" ",Emp_City=" ",Emp_Distric=" ",Emp_Phone=" ",Emp_Email=" ",Emp_Date_Of_Birth=" ",Emp_NID=" ",Emp_Blood=" ",Emp_Joining_Date=" ",Emp_S_S_C=" ",Emp_H_S_C=" ",Emp_Gender=" ",Emp_Type=" ";
	//private int Emp_Salary,Emp_Bonus;
	
    public EmployeeInfoClass(String En , String Ec , String Ed, String Ep, String Ee,String Edob, String Enid,String Eb, String Ejd, String Essc,String Ehsc, String Eg, String Et, String Es)
	{ //  DateFormat df= new SimpleDateFormat("mm/dd/yyyy");
		// Date startDate=df.parse(Ejd);
		// Date startDate1=df.parse(Edob);
		         // Calendar calendar = Calendar.getInstance();
      // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		// countRedseat();
		// UpdateNewDate(startDate);
		
		
		Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		
		Emp_Name=En;
	    //Emp_Id=Ei;   
	    Emp_City=Ec;
	    Emp_Distric=Ed;
	    Emp_Phone=Ep;
	    Emp_Email=Ee;
        Emp_Date_Of_Birth=Edob ;
	    Emp_NID=Enid;
	    Emp_Blood=Eb;
	    //Emp_Joining_Date=Ejd;
		
	   Emp_Joining_Date=startDate;
	    Emp_S_S_C=Essc;
	    Emp_H_S_C=Ehsc;
	    Emp_Gender=Eg;
	    Emp_Type=Et;
	    Emp_Salary=  Integer.parseInt( Es);
	   // Emp_Salary=  1240;
	   
    try
    {
      // create a mysql database connection
		 Class.forName("com.mysql.jdbc.Driver");  
   
  
      String myUrl = "jdbc:mysql://localhost:3306/a1";
	  //"jdbc:mysql:3306//localhost/jdbcdemo";
     
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	  //id genarate
	  Statement stmt=conn.createStatement(); 
		ResultSet rsID=stmt.executeQuery("select * from Employee_info where Emp_Id=(select max(Emp_Id) from Employee_info )");  
  
		while(rsID.next())  
	{
		Emp_Id=rsID.getInt("Emp_Id");
		
	} 
	  Emp_Id+=1;
	  
	  
	  
    
      // create a sql date object so we can use it in our INSERT statement
      

      // the mysql insert statement
	  // // stmt.execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) "
                                // // + "VALUES (1,'Lokesh','Gupta',5)");
	  
	  
      String query = "INSERT INTO Employee_info (Emp_Id,Emp_Name,Emp_City,Emp_Distric,Emp_Phone,Emp_Email,Emp_Date_Of_Birth,Emp_NID,Emp_Blood,Emp_Joining_Date,Emp_S_S_C,Emp_H_S_C,Emp_Gender,Emp_Type,Emp_Salary)" 
			+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt(1, Emp_Id);
      preparedStmt.setString(2, Emp_Name);
      preparedStmt.setString(3, Emp_City);
      preparedStmt.setString(4, Emp_Distric);
      preparedStmt.setString(5, Emp_Phone);
      preparedStmt.setString(6, Emp_Email);
      preparedStmt.setString(7,Emp_Date_Of_Birth);
	  preparedStmt.setString(8, Emp_NID);
	  preparedStmt.setString(9, Emp_Blood);
	  preparedStmt.setDate(10, Emp_Joining_Date);
	  preparedStmt.setString(11,Emp_S_S_C);
	  preparedStmt.setString(12, Emp_H_S_C);
	  preparedStmt.setString(13, Emp_Gender);
	  preparedStmt.setString(14, Emp_Type);
	  preparedStmt.setInt(15, Emp_Salary);
	 
	  
		

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
  
  
	// public static void main(String[] args){
		// EmployeeInfoClass e1=new EmployeeInfoClass("Haider","123","mirpur","dhaka","015465465","abs","12 JAN 1990","734534587354","12 MAR 2014","2001","2013");
	// }
}