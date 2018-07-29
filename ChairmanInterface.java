
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.sql.*;
import java.util.Calendar;

import java.awt.BorderLayout;

// import javax.swing.JFrame;
// import javax.swing.JScrollPane;
// import javax.swing.JTable;

class ChairmanInterface extends JFrame implements ActionListener
{
	JButton []AdminButton = new JButton[6];
	JButton Reset = new JButton("Reset");
	JButton []search = new JButton[2];
	JTextArea []SearchResultInput =new JTextArea[2];
	JTextArea SearchResultOutput =new JTextArea();
	JLabel []SearchInfo =new JLabel[2];
	JLabel Title =new JLabel("ADMIN PANEL");
	String getqueryresult="";
	public void elementCreate()
	{
		for(int i = 0; i < 6; i++) {
			if(i==0)
			{
				AdminButton[i] =new JButton("ADD Employee");
				search[i] =new JButton("Emp Search");
				SearchResultInput[i] =new JTextArea();
				SearchInfo[i] =new JLabel("Enter Id to Search Employee");
				//SearchResultOutput[i] =new JTextArea();
			}
         			if(i==1)
			{
				AdminButton[i] =new JButton("Counter");
				search[i] =new JButton("Cus Search");
				SearchResultInput[i] =new JTextArea();
				SearchInfo[i] =new JLabel("Enter Id to Search Cus");
				//SearchResultOutput[i] =new JTextArea();
			}
			
			
			if(i==2)
			AdminButton[i] =new JButton("All Emp Details");
			if(i==3)
			AdminButton[i] =new JButton("All Cus Details");
			if(i==4)
			AdminButton[i] =new JButton("All Bus details");
			if(i==5)
			AdminButton[i] =new JButton("Change Password");	
			
         
		}
		
	}
	
	public ChairmanInterface()
	{
		elementCreate();
		setTitle("ADMIN Pannel");
		setSize(1320,960);
		for(int i = 0; i < 2; i++)
		{
			add(search[i]);
			add(SearchResultInput[i]);
			add(SearchInfo[i]);
			
		}
		 for(int i = 0; i < 6; i++)
		 {add(AdminButton[i]);
			
		}	
		add(SearchResultOutput);
		add(Reset);
		add(Title);
		 
		
				int x=350, y=50;
		for(int i = 0; i < 3; i++)  
		{  AdminButton[i].setBounds(x,y,250,80);
		AdminButton[i+3].setBounds(x+300,y,250,80);
		  y+=100;

			AdminButton[i].addActionListener(this);
			AdminButton[i+3].addActionListener(this);
						
         }
		
		for(int i = 0; i < 2; i++)  
		{  SearchInfo[i].setBounds(x,y,250,50);
		//SearchInfo[i].addActionListener(this);
		SearchResultInput[i].setBounds(x+350,y,80,50);
		//SearchResultInput[i].addActionListener(this);
		search[i].setBounds(x+450,y,100,50);
		search[i].addActionListener(this);
		  y+=80; 
		  
			
			
			//AdminButton[i].addActionListener(this);
			
			
		  
		}
		
		 SearchResultOutput.setBounds(x,y,700,80);
		 Reset.setBounds(x+570,y-100,100,50);
		 Title.setBounds(600,10,100,50);
		 Reset.addActionListener(this);
		 
		 setLayout(null);
		setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
}
public void actionPerformed(ActionEvent e)
	{   if(e.getSource()==AdminButton[0])
		{	setVisible(false);
			EmployeeAddFrame emp=new EmployeeAddFrame();
		}
		 if(e.getSource()==AdminButton[1])
		{ setVisible(false);
			TicketSellingFrame TicF=new TicketSellingFrame();
			
		}
		
		if(e.getSource()==AdminButton[2])
		{TableFromMySqlDatabase frame = new TableFromMySqlDatabase("employee_info");
		}
		if(e.getSource()==AdminButton[3])
		{
		TableFromMySqlDatabase frame = new TableFromMySqlDatabase("cus");	
		}
		if(e.getSource()==AdminButton[4])
		{ TableFromMySqlDatabase frame = new TableFromMySqlDatabase("bus_info"); 
		}
		 if(e.getSource()==AdminButton[5])
		{       setVisible(false);
			ChangeLoginInterface Cp = new ChangeLoginInterface();
		}
		 if(e.getSource()==search[0])
		{       
			  
try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/a1","root","");  
  
//here data is database name, root is username and password is ""
  
Statement stmt=con.createStatement();  
  String Id=SearchResultInput[0].getText();
  String sql="select * from employee_info where Emp_Id= "+Id+ " ;";
  System.out.println(sql);
ResultSet rs=stmt.executeQuery(sql);  


	
while(rs.next())  
{
	//getqueryresult=("\n"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(6));  
 ///getqueryresult+=("\n  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  ");
///*+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getDate(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getDate(11)+"  "+rs.getString(12)+"  "+rs.getString(13)+"  "+rs.getString(14)+"  "*/+rs.getInt(15)/*+"  "+rs.getInt(16)*/);  
   	 getqueryresult=("ID = "+rs.getInt(1)+"	Name = "+rs.getString(2)+" Phone= "+rs.getString(5)+"	Type= "+rs.getString(14)+"	Salary = "+rs.getInt(15));  
	
	SearchResultOutput.setText(getqueryresult);
	//System.out.println(getqueryresult);

}




//tf1.setText(getqueryresult);


//JOptionPane.showMessageDialog(this,getqueryresult);
con.close();  
  
}
catch(Exception e1)
{ System.out.println(e1);}  
		}
		
		
		
		 if(e.getSource()==search[1])
		{       
			  
try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/a1","root","");  
  
//here data is database name, root is username and password is ""
  
Statement stmt=con.createStatement();  
  String Id=SearchResultInput[1].getText();
  String sql="select * from cus where CusId= "+Id+ " ;";
  System.out.println(sql);
ResultSet rs=stmt.executeQuery(sql);  


	
while(rs.next())  
{
	//getqueryresult=("\n"+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(6));  
 ///getqueryresult+=("\n  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  ");
///*+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getDate(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getDate(11)+"  "+rs.getString(12)+"  "+rs.getString(13)+"  "+rs.getString(14)+"  "*/+rs.getInt(15)/*+"  "+rs.getInt(16)*/);  
   	 getqueryresult=("ID = "+rs.getInt(1)+"	Name = "+rs.getString(2)+"  Phone= "+rs.getString(3)+"	SeatNumbers= "+rs.getString(6)+"	Date = "+rs.getInt(7)+"	BusNo = "+rs.getInt(8));  
	
	SearchResultOutput.setText(getqueryresult);
	//System.out.println(getqueryresult);

}




//tf1.setText(getqueryresult);


//JOptionPane.showMessageDialog(this,getqueryresult);
con.close();  
  
}
catch(Exception e1)
{ System.out.println(e1);}  
		}
		

		if(e.getSource()==Reset)
		{	SearchResultInput[0].setText("");
			SearchResultInput[1].setText("");
			SearchResultOutput.setText("");
			
		}
		
	}

}