import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.sql.*;
import java.util.Calendar;

public class TicketSellingFrame04 extends JFrame implements ActionListener 

{	private int TotalSeat=0, Amount=0;//variable
	private String TOtalSeatNo="";
			  int Avail;Date Date2;
			  int DId, redseat;
			  String TempInfo; int tempavail2;


	JLabel []BusNo = new JLabel[2];
    JButton []HeaderTopOption =new JButton[6];
    JLabel []CusInfoLevel =new JLabel[4];
    JLabel []CusTicketInfoLevel =new JLabel[4];
    JLabel []TicketInfoLevel =new JLabel[14];
    JTextArea []CusInfoText =new JTextArea[3];
	JButton CusSubmitButton = new JButton("Submit");
	JButton CusResetButton = new JButton("Reset");
	JButton []SeatNo = new JButton[40];
	private void countRedseat()
	{
		try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/a1","root","");  
  
  
Statement stmt=con.createStatement();  
  
ResultSet rsCH=stmt.executeQuery("select count(Available)  AS  SeatNO  from seatdetailsbus04 where Available=0; ");  
  
while(rsCH.next())  
{
	redseat=   Integer.parseInt(rsCH.getString("SeatNO"));
	
} 


  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
		
	}

	private void HeaderTopOptionCreate()
	{
		
		for(int i = 0; i < 6; i++) {
			if(i==0)
            {
			HeaderTopOption[i] = new JButton("Counter");
			BusNo[i]=new JLabel("BUS NO");
			}
			else if(i==1)
            {
				HeaderTopOption[i] = new JButton("Admin");
			BusNo[i]=new JLabel("04");
			}else if(i==2)
            HeaderTopOption[i] = new JButton("Bus ONE");
			else if(i==3)
            HeaderTopOption[i] = new JButton("Bus TWO");
			else if(i==4)
            HeaderTopOption[i] = new JButton("Bus THREE");
			else if(i==5)
            HeaderTopOption[i] = new JButton("Bus FOUR");
			
        }
	}
	private void SeatNoCreate()
	{
		
		for(int i = 0; i < 40; i++) {
			
            SeatNo[i] = new JButton(String.valueOf(i+1));
        }
	}
	 
	private void CusInfoCreate()
	{
		for(int i = 0; i < 3; i++)
		{   
			CusInfoText[i] = new JTextArea("");
			if(i==0)
			CusInfoLevel[i] = new JLabel("Customer Name");
			else if(i==1)
			CusInfoLevel[i] = new JLabel("Mobile No");
			else if(i==2)
			CusInfoLevel[i] = new JLabel("Seat No");

		}	
		
		
	}
	private void CusTicketInfoLevelCreate()
	{
		for(int i = 0; i < 4; i++)
		{   
			if(i==0)
			CusTicketInfoLevel[i] = new JLabel("Total Seat");
			else if(i==2)
			CusTicketInfoLevel[i] = new JLabel("Amount");
			else if(i==1||i==3)
			CusTicketInfoLevel[i] = new JLabel();


		}	
		
		
	}
	 
	 void TicketInfoLevelCreate()
	{
		for(int i = 0; i < 7; i++)
		{   
			
			if(i==0)
			TicketInfoLevel[i] = new JLabel("Total");
			else if(i==1)
			TicketInfoLevel[i] = new JLabel("");//available
			else if(i==2)
			TicketInfoLevel[i] = new JLabel("Av.BUs01");
			else if(i==3)
			TicketInfoLevel[i] = new JLabel("Av.BUs02");
			else if(i==4)
			TicketInfoLevel[i] = new JLabel("Av.BUs03");
			else if(i==5)
			TicketInfoLevel[i] = new JLabel("Av.BUs04");
			else if(i==6)
			TicketInfoLevel[i] = new JLabel("Start Time");
		
		
			TicketInfoLevel[i+7] = new JLabel();
			getTicketInfoLevelInfo	(i);

		}	
		
		
	}
	// private void Addinfo()
	 // { for(int i = 0; i < 40; i++)
		// {add(SeatNo[i]);
		 // SeatNo[i].setBackground(Color.yellow);
		
		// if( i < 2)
		// add(BusNo[i]);
		  // // for(int i = 0; i < 6; i++)
		   // // add(HeaderTopOption[i]);
		// if( i < 3)
		
		// add(CusInfoLevel[i]);
	   // if( i < 4)
		// add(CusTicketInfoLevel[i]);
	
		// if( i < 3)
		// add(CusInfoText[i]);
	
		
		
		// if( i < 14)
		// add(TicketInfoLevel[i]);
	 // } 
	    // add(CusSubmitButton);
		// add(CusResetButton);
	 // }
	 
	 public void UpdateNewDate(Date d)   //update new dates
	 {
		
		try
    {   
	  
      // create a mysql database connection
		 Class.forName("com.mysql.jdbc.Driver");  
   
  
      String myUrl = "jdbc:mysql://localhost:3306/a1";
	  //"jdbc:mysql:3306//localhost/jdbcdemo";
     
      Connection con = DriverManager.getConnection(myUrl, "root", "");

      
	  
     // String query = "UPDATE seatdetailsbus01 SET Available=false WHERE SeatNO="+x.getText()+";";
	Statement stmt=con.createStatement(); 
  //id genarate
		 Statement stmt1=con.createStatement(); 
		ResultSet rsID=stmt1.executeQuery("select Id from Datetable where Id=(select max(Id) from Datetable )");  
			while(rsID.next())  
	{
		DId=rsID.getInt("Id");
		
	} 	
  
	ResultSet rsCH=stmt.executeQuery("select * from Datetable where Id=(select max(Id) from Datetable)  ;");  
  
	while(rsCH.next())  
	{
	Date2=rsCH.getDate("Date");

	} 


System.err.println("Sucess got Date="+ Date2+" from database");
System.err.println("Sucess today Date="+ d+"");
	
			if(d.before(Date2))//.......................................
{   redseat=0;
		
	
{     for(int i=1;i<=40;i++)

	{
	String query = "UPDATE seatdetailsbus04 SET Available=1 WHERE SeatNO="+i+";";

      // create the mysql update 
      PreparedStatement preparedStmt = con.prepareStatement(query);
	  preparedStmt.executeUpdate();
	  
     }
	   String query2 = "INSERT INTO Datetable (Id,Date) "
			+"VALUES (?,?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt2 = con.prepareStatement(query2);
      preparedStmt2.setInt (1, DId+1);
      preparedStmt2.setDate (2, d);
      preparedStmt2.execute();
	  // // TicketInfoLevel[8].setText("160");
	  // // TicketInfoLevel[9].setText("40");
	  // // TicketInfoLevel[10].setText("40");
	  // // TicketInfoLevel[11].setText("40");
	  // // TicketInfoLevel[12].setText("40");
	     updateTicketInfoLevelInfoDatabase	("160","40","40","40","40");
System.err.println("Sucess update Date database");

      // execute the preparedstatement
   
}
}
 
		else  System.err.println("toady database");
	
 
  
con.close();  
    
	}
	
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
			
	}
	 

	 
	 
	 
	 
	 void getTicketInfoLevelInfo	(int i)					//getTicketInfoLevelInfo
{
		
		try
		
		  {   
	  
      // create a mysql database connection
		 Class.forName("com.mysql.jdbc.Driver");  
   
  
      String myUrl = "jdbc:mysql://localhost:3306/a1";
	  //"jdbc:mysql:3306//localhost/jdbcdemo";
     
      Connection con = DriverManager.getConnection(myUrl, "root", "");

      
	  
     // String query = "UPDATE seatdetailsbus01 SET Available=false WHERE SeatNO="+x.getText()+";";
	// Statement stmt=con.createStatement();  
		 	
  
	// ResultSet rsCH=stmt.executeQuery("select * from TicketInfoLevelInfoDatabase ;");  
  
	 

 
		
		
		
		
		





for(; i < 7; i++)
		{   
			
			if(i==0)
			{ 
				Statement stmt=con.createStatement();  
				ResultSet rsCH=stmt.executeQuery("select * from TicketInfoLevelInfoDatabase WHERE TLid=1;");  
  
				while(rsCH.next())  
			{
				TempInfo=rsCH.getString("Total");
				TicketInfoLevel[i+7].setText(TempInfo);

			}
			}
			 // if(i==1)
			// {				Statement stmt=con.createStatement();  
				// ResultSet rsCH=stmt.executeQuery("select * from TicketInfoLevelInfoDatabase WHERE TLid=1;");  

				// while(rsCH.next())  
			// {
				// TempInfo=rsCH.getString("Available");
				// TicketInfoLevel[i+7].setText(TempInfo);

			// }	
			//}
			 if(i==2)
			{				Statement stmt=con.createStatement();  
				ResultSet rsCH=stmt.executeQuery("select * from TicketInfoLevelInfoDatabase WHERE TLid=1;");  

				while(rsCH.next())  
			{
				TempInfo=rsCH.getString("AvBUsSeat01");
				TicketInfoLevel[i+7].setText(TempInfo);

			}	
			}
			 if(i==3)
			{				Statement stmt=con.createStatement();  
				ResultSet rsCH=stmt.executeQuery("select * from TicketInfoLevelInfoDatabase WHERE TLid=1;");  

				while(rsCH.next())  
			{
				TempInfo=rsCH.getString("AvBUsSeat02");
				TicketInfoLevel[i+7].setText(TempInfo);

			}	
			}
			 if(i==4)
			{				Statement stmt=con.createStatement();  
				ResultSet rsCH=stmt.executeQuery("select * from TicketInfoLevelInfoDatabase WHERE TLid=1;");  

				while(rsCH.next())  
			{
				TempInfo=rsCH.getString("AvBUsSeat03");
				TicketInfoLevel[i+7].setText(TempInfo);

			}	
			}
			 if(i==5)
			{				Statement stmt=con.createStatement();  
				ResultSet rsCH=stmt.executeQuery("select * from TicketInfoLevelInfoDatabase WHERE TLid=1;");  

				while(rsCH.next())  
			{
				TempInfo=rsCH.getString("AvBUsSeat04");
				TicketInfoLevel[i+7].setText(TempInfo);

			}	
			}
			 if(i==6)
			{				Statement stmt=con.createStatement();  
				ResultSet rsCH=stmt.executeQuery("select * from TicketInfoLevelInfoDatabase WHERE TLid=1;");  

				while(rsCH.next())  
			{
				TempInfo=rsCH.getString("BUS_Starting_Time04");
				TicketInfoLevel[i+7].setText(TempInfo);

			}	
			}
			
			
		}
		
		System.err.println("Sucess today Data from TicketInfoLevelInfoDatabase"); 
con.close();  
		  }
	
	
    catch (Exception e)
    {
      System.err.println("Got an exception! from TicketInfoLevelInfoDatabase");
      System.err.println(e.getMessage());
    }
		
}
	 
	 
	 
	 
	 
	 
	 
	 void updateTicketInfoLevelInfoDatabase	(int x)					//updateTicketInfoLevelInfoDatabase
{
		String AvailSeat;
		int tempavail1=x;
		//int tempavail2;
		//= Integer.toString(160-x);
		       String AvailbusSeat= Integer.toString(40-x);
		try
	{
			  
      // create a mysql database connection
		 Class.forName("com.mysql.jdbc.Driver");  
   
  
      String myUrl = "jdbc:mysql://localhost:3306/a1";
	  //"jdbc:mysql:3306//localhost/jdbcdemo";
   
      Connection con = DriverManager.getConnection(myUrl, "root", "");
	  Statement stmt=con.createStatement(); 
//avail seat genarate
	
		ResultSet rsCO=stmt.executeQuery("select * from ticketinfolevelinfodatabase where TLid=1");  
  
		while(rsCO.next())  
	{
	tempavail2=Integer.parseInt(rsCO.getString("Available"));
	}
	tempavail2=tempavail2-tempavail1;
	AvailSeat=Integer.toString(tempavail2);
	  
     // String query = "UPDATE seatdetailsbus01 SET Available=false WHERE SeatNO="+x.getText()+";";
	//Statement stmt=con.createStatement(); 
    String query = "UPDATE ticketinfolevelinfodatabase SET Available="+AvailSeat+" WHERE TLid=1;";

      // create the mysql update 
      PreparedStatement preparedStmt = con.prepareStatement(query);
	  preparedStmt.executeUpdate();
	  
    // String query1 = "UPDATE ticketinfolevelinfodatabase SET AvBUsSeat01="+AvailbusSeat+" WHERE TLid=1;";

      // // create the mysql update 
      // PreparedStatement preparedStmt2 = con.prepareStatement(query1);
	  // preparedStmt2.executeUpdate();
	  
  
	 // String query = "UPDATE seatdetailsbus01 SET Available=false WHERE SeatNO="+x.getText()+";";
	//Statement stmt=con.createStatement(); 
    String query2 = "UPDATE ticketinfolevelinfodatabase SET AvBUsSeat04="+AvailbusSeat+" WHERE TLid=1;";

      // create the mysql update 
      PreparedStatement preparedStmt2 = con.prepareStatement(query2);
	  preparedStmt2.executeUpdate();
	  
		
		
		
		
		
		System.err.println("Sucess today Data from TicketInfoLevelInfoDatabase"); 
con.close();  
		  }
	
	
    catch (Exception e)
    {
      System.err.println("Got an exception! from TicketInfoLevelInfoDatabase");
      System.err.println(e.getMessage());
    }
		
}
	 void updateTicketInfoLevelInfoDatabase	(String a,String b,String p,String q, String w)					//updateTicketInfoLevelInfoDatabase  override 
{
		
		try
	{
			  
      // create a mysql database connection
		 Class.forName("com.mysql.jdbc.Driver");  
   
  
      String myUrl = "jdbc:mysql://localhost:3306/a1";
	  //"jdbc:mysql:3306//localhost/jdbcdemo";
     
      Connection con = DriverManager.getConnection(myUrl, "root", "");

      
	  
     // String query = "UPDATE seatdetailsbus01 SET Available=false WHERE SeatNO="+x.getText()+";";
	Statement stmt=con.createStatement(); 
    String query = "UPDATE ticketinfolevelinfodatabase SET Available="+a+" WHERE TLid=1;";

      // create the mysql update 
      PreparedStatement preparedStmt = con.prepareStatement(query);
	  preparedStmt.executeUpdate();
	  
    // String query1 = "UPDATE ticketinfolevelinfodatabase SET Av.BUs01="+AvailbusSeat+" WHERE TLid=1;";

      // // create the mysql update 
      // PreparedStatement preparedStmt2 = con.prepareStatement(query1);
	  // preparedStmt2.executeUpdate();
	  
  
	 // String query = "UPDATE seatdetailsbus01 SET Available=false WHERE SeatNO="+x.getText()+";";
	//Statement stmt=con.createStatement(); 
    String query2 = "UPDATE ticketinfolevelinfodatabase SET AvBUsSeat01="+b+" WHERE TLid=1;";

      // create the mysql update 
      PreparedStatement preparedStmt2 = con.prepareStatement(query2);
	  preparedStmt2.executeUpdate();
	  
		
		
    String query3 = "UPDATE ticketinfolevelinfodatabase SET AvBUsSeat02="+p+" WHERE TLid=1;";

      // create the mysql update 
      PreparedStatement preparedStmt3 = con.prepareStatement(query3);
	  preparedStmt3.executeUpdate();
	  
		
		
    String query4 = "UPDATE ticketinfolevelinfodatabase SET AvBUsSeat03="+q+" WHERE TLid=1;";

      // create the mysql update 
      PreparedStatement preparedStmt4 = con.prepareStatement(query4);
	  preparedStmt4.executeUpdate();
	  
		
		
    String query5 = "UPDATE ticketinfolevelinfodatabase SET AvBUsSeat04="+w+" WHERE TLid=1;";

      // create the mysql update 
      PreparedStatement preparedStmt5 = con.prepareStatement(query5);
	  preparedStmt5.executeUpdate();
	  
		
		
		
		
		
		System.err.println("Sucess today Data from TicketInfoLevelInfoDatabase"); 
con.close();  
		  }
	
	
    catch (Exception e)
    {
      System.err.println("Got an exception! from TicketInfoLevelInfoDatabase");
      System.err.println(e.getMessage());
    }
		
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	public TicketSellingFrame04()
	{    // create a sql date object so we can use it in our INSERT statement
      Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		countRedseat();
		UpdateNewDate(startDate);
		
	
	setTitle("ABC BUS SERVICE");
		setSize(1320,960);
		HeaderTopOptionCreate();
		CusInfoCreate();
		CusTicketInfoLevelCreate();
		SeatNoCreate();
		 TicketInfoLevelCreate();
		// getTicketInfoLevelInfo();
		
		for(int i = 0; i < 2; i++)
		add(BusNo[i]);
		 for(int i = 0; i < 6; i++)
		add(HeaderTopOption[i]);
		for(int i = 0; i < 40; i++)
		{add(SeatNo[i]);
				if(!SeatAvailableInfoAll(SeatNo[i]))
				SeatNo[i].setBackground(Color.red);
				 else
				 SeatNo[i].setBackground(Color.yellow);
		}
		for(int i = 0; i < 3; i++)
		add(CusInfoLevel[i]);
	
		for(int i = 0; i < 4; i++)
		add(CusTicketInfoLevel[i]);
	
		for(int i = 0; i < 3; i++)
		add(CusInfoText[i]);
	
		add(CusSubmitButton);
		add(CusResetButton);
		
		for(int i = 0; i < 14; i++)
		add(TicketInfoLevel[i]);
	
		int x,y;
		
		 x=150; y=50;
		for(int i = 0; i < 2; i++)  //BUS NO
		{  BusNo[i].setBounds(x,y,100,50);
		  x+=100;
		
		}
		
		for(int i = 0; i < 6; i++)  //HeaderTopOption
		{  HeaderTopOption[i].setBounds(x,y,100,50);
		  x+=100;
		HeaderTopOption[i].addActionListener(this);
			  HeaderTopOption[i].setBackground(Color.yellow);
		
		}
		HeaderTopOption[5].setBackground(Color.blue);
		
		
		x=50; y=150;
		for(int i = 0; i < 10; i++)  //Seat no
		{     
			
		SeatNo[i].setBounds(x,y,50,30);
		SeatNo[i].addActionListener(this);
		
		
		
		SeatNo[i+10].setBounds(x,y+50,50,30);
		SeatNo[i+10].addActionListener(this);
		
		SeatNo[i+20].setBounds(x,y+150,50,30);
		SeatNo[i+20].addActionListener(this);
		
		SeatNo[i+30].setBounds(x,y+200,50,30);
		SeatNo[i+30].addActionListener(this);
		x+=80;
			
		}
		x= 50; y=500;
		for(int i = 0; i < 3; i++)  //custoinfo
		{
		if (i==0)
		CusInfoLevel[i].setBounds(x,y,100,30);
		else
		CusInfoLevel[i].setBounds(x,y,60,30);
		if (i==0)
		CusInfoText[i].setBounds(x+110,y,120,30);
		else
		CusInfoText[i].setBounds(x+80,y,120,30);
		x+=250;
		}
		
		
		CusSubmitButton.setBounds(x-150,y+50,100,50);//submit button
		CusSubmitButton.addActionListener(this);
		CusResetButton.setBounds(x-150,y+100,100,50);//Reset  button
		CusResetButton.addActionListener(this);
		x=50 ; y=550;
		for(int i=0;i<4;i++) //CusTicketInfoLevel
		{
			CusTicketInfoLevel[i].setBounds(x,y,110,30);
			x+=125;
		}
		
		x=1000; y=150;
		for (int i = 0;i< 7;i++) //TicketInfoLevel
		{
			TicketInfoLevel[i].setBounds(x,y,120,30);
			TicketInfoLevel[i+7].setBounds(x+150,y,120,30);
			y+=50;
		}
		
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
		
		
	}
	// MEthod
	public boolean SeatAvailableInfo(JButton x)  //SeatAvailableInfo
	{
		if(x.getBackground()==Color.red)
			return false;
		else if(x.getBackground()==Color.blue)
			return false;
		else return true ;
	}
	public boolean SeatAvailableInfoAll(JButton x)
	{

		try
    {
      // create a mysql database connection
		 Class.forName("com.mysql.jdbc.Driver");  
   
  
      String myUrl = "jdbc:mysql://localhost:3306/a1";
	  //"jdbc:mysql:3306//localhost/jdbcdemo";
     
      Connection con = DriverManager.getConnection(myUrl, "root", "");

      
	  
     // String query = "UPDATE seatdetailsbus01 SET Available=false WHERE SeatNO="+x.getText()+";";
	Statement stmt=con.createStatement();  
  
	ResultSet rsCH=stmt.executeQuery("select * from seatdetailsbus04 where SeatNO="+x.getText()+";");  
  
	while(rsCH.next())  
	{
	Avail=rsCH.getInt("Available");

	} 

//System.err.println("Sucess SeatAvailableInfoAll database");
//System.err.println("Sucess SeatAvailableInfoAll database");
  
con.close();  
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
	  if(Avail==1)
		return true;
	   else return false;
	
	}
	
    public void updateSeatColor(JButton x)  //SeatUpdateColorInfo
	{ try
    {
      // create a mysql database connection
		 Class.forName("com.mysql.jdbc.Driver");  
   
  
      String myUrl = "jdbc:mysql://localhost:3306/a1";
	  //"jdbc:mysql:3306//localhost/jdbcdemo";
     
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      redseat+=1;
	  
      String query = "UPDATE seatdetailsbus04 SET Available=0 WHERE SeatNO="+x.getText()+";";

      // create the mysql update preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      

      // execute the preparedstatement
   preparedStmt.executeUpdate();
      System.err.println("Sucess updateSeatColor database");
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
	//return SeatAvailableInfoAll(x);
	updateTicketInfoLevelInfoDatabase	(redseat );	//updateTicketInfoLevelInfo
	
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{      
        if(e.getSource()==HeaderTopOption[0])//HeaderTopOption Bus No
		{
		  for(int i=0;i<6;i++)
			  HeaderTopOption[i].setBackground(Color.yellow);
		      HeaderTopOption[0].setBackground(Color.blue);
		  
		}    
        if(e.getSource()==HeaderTopOption[1])//HeaderTopOption Bus No
		{
		  for(int i=0;i<6;i++)
			  HeaderTopOption[i].setBackground(Color.yellow);
		      HeaderTopOption[1].setBackground(Color.blue);
			   setVisible(false);
			  LoginInterface m = new LoginInterface();
		  
		  
		}    
        if(e.getSource()==HeaderTopOption[2])//HeaderTopOption Bus No
		{                setVisible(false);
			TicketSellingFrame Tf =new TicketSellingFrame();
			 
		BusNo[1].setText("01");
		  for(int i=0;i<6;i++)
			  HeaderTopOption[i].setBackground(Color.yellow);
		      HeaderTopOption[2].setBackground(Color.blue);
			  
		  
		}
        if(e.getSource()==HeaderTopOption[3])
		{	              setVisible(false);
			TicketSellingFrame02 Tf2 =new TicketSellingFrame02();
			
		BusNo[1].setText("02");
         for(int i=0;i<6;i++)
			  HeaderTopOption[i].setBackground(Color.yellow);
		      HeaderTopOption[3].setBackground(Color.blue);
			  
		}
		if(e.getSource()==HeaderTopOption[4])
		{              setVisible(false);
			TicketSellingFrame03 Tf3 =new TicketSellingFrame03();
			
				BusNo[1].setText("03");
				for(int i=0;i<6;i++)
			  HeaderTopOption[i].setBackground(Color.yellow);
		      HeaderTopOption[4].setBackground(Color.blue);
			  
		}
        if(e.getSource()==HeaderTopOption[5])
		{
				BusNo[1].setText("04");for(int i=0;i<6;i++)
			  HeaderTopOption[i].setBackground(Color.yellow);
		      HeaderTopOption[5].setBackground(Color.blue);
			  
		}
			for(int i=0;i<40;i++)
			{
				
				
				if(e.getSource()==SeatNo[i]&&SeatAvailableInfo(SeatNo[i]))
				
				{   TotalSeat+=1;
					Amount+=400; 
					CusTicketInfoLevel[1].setText(Integer.toString(TotalSeat));
					CusTicketInfoLevel[3].setText(Integer.toString(Amount));
					
					TOtalSeatNo = TOtalSeatNo.concat(SeatNo[i].getText());
					TOtalSeatNo = TOtalSeatNo.concat("+");
					CusInfoText[2].setText(TOtalSeatNo);
				 SeatNo[i].setBackground(Color.blue);
				 // updateSeatColor(SeatNo[i]);
				}
			}
			if(e.getSource()==CusSubmitButton)// submit button
			{
				
				// CusObject=String.toString;
				// ArrayList<CustomerInfoClass> list = new ArrayList<CustomerInfoClass>();
				// CustomerInfoClass CusObject = new CustomerInfoClass (); //Create a new object.
				// list.add(CusObject);  // Adding it to the list.
				// CustomerInfoClass CusObject=new CustomerInfoClass();
				// CusObject.CustomerSeatReserve(Cusid,CusInfoText[0].getText(),CusInfoText[1].getText(),
				// CusInfoText[2].getText(),CusTicketInfoLevel[1].getText(),CusTicketInfoLevel[3].getText());
				

				 CustomerInfoClass CusObject=new CustomerInfoClass(CusInfoText[0].getText(),CusInfoText[1].getText(),
				 CusTicketInfoLevel[1].getText(),CusInfoText[2].getText(),CusTicketInfoLevel[3].getText(),BusNo[1].getText());
				
				//CustomerInfoClass CusObject=new CustomerInfoClass(5,"eee","eee","2","eee","eee");
				JOptionPane.showMessageDialog(this,"Sucess");//Alert Box
				
				CusInfoText[0].setText("");
				CusInfoText[1].setText("");
				 CusTicketInfoLevel[1].setText("");
				 CusInfoText[2].setText("");
				 CusTicketInfoLevel[3].setText("");
				 TotalSeat=0; Amount=0;TOtalSeatNo="";
				for(int i=0;i<40;i++)
				 {
					 if( SeatNo[i].getBackground()==Color.blue)
					 {SeatNo[i].setBackground(Color.red);
						updateSeatColor(SeatNo[i]);
                     				 
					}
				 }
				  TicketInfoLevelCreate();
				
			}
			if(e.getSource()==CusResetButton)
			{   CusInfoText[0].setText("");
				CusInfoText[1].setText("");
				 CusTicketInfoLevel[1].setText("");
				 CusInfoText[2].setText("");
				 CusTicketInfoLevel[3].setText("");
				 TotalSeat=0; Amount=0;TOtalSeatNo="";
				for(int i=0;i<40;i++)
				 {
					 if( SeatNo[i].getBackground()==Color.blue)
					 SeatNo[i].setBackground(Color.yellow);	 
				 }
			
			}	
			
			
			
		
	}
		
	
}