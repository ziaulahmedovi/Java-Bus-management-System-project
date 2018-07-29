import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
class EmployeeAddFrame extends JFrame implements ActionListener
{
	JTextField EmpNameTxt = new JTextField();
	
	JTextField EmpCityTxt = new JTextField();
	
	JTextField EmpDisTxt = new JTextField();
	JTextField EmpPhnTxt = new JTextField();
	JTextField EmpEmailTxt = new JTextField();
	JTextField EmpDobTxt = new JTextField();
	JTextField EmpNidTxt = new JTextField();
	JTextField EmpBloodTxt = new JTextField();
	// JTextField EmpJoinTxt = new JTextField();
	JTextField EmpSscTxt = new JTextField();
	JTextField EmpHscTxt = new JTextField();
	JTextField EmpGndrTxt = new JTextField();
	JTextField EmpTypTxt = new JTextField();
	JTextField EmpSalTxt = new JTextField();
	
	JButton B1 =new JButton("Admin");
	JButton B2 =new JButton("Save");
	JButton B3 =new JButton("Reset");
		JLabel EmpJoinTxt = new JLabel();
	
	JLabel EmpInfoLabel = new JLabel ("EmpInfoLabel Info");
	JLabel EmpNameLabel = new JLabel("Name");
	
	JLabel EmpCityLabel = new JLabel("City");
	JLabel EmpDisLabel = new JLabel("Distric");
	JLabel EmpPhnLabel = new JLabel("Phone");
	JLabel EmpEmailLabel = new JLabel("Email");
	JLabel EmpDobLabel = new JLabel("Date Of Birth");
	JLabel EmpNidLabel = new JLabel("NID");
	JLabel EmpBloodLabel= new JLabel("Blood");
	JLabel EmpJOinLabel= new JLabel("Joinig Date");
	JLabel EmpEduLabel= new JLabel("Education");
	JLabel EmpSscLabel= new JLabel("S.S.C");
	JLabel EmpHscLabel= new JLabel("H.S.C");
	JLabel EmpGndrLabel= new JLabel("Gender");
	JLabel EmpTypLabel= new JLabel("Type");
	JLabel EmpSalLabel= new JLabel("Salary");
	
	public EmployeeAddFrame()
	{  
	Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		setSize (4000,960);
		setLayout(null);
		setVisible(true);
		add (EmpInfoLabel);
		add (EmpNameLabel);
		
		add (EmpCityLabel);
		add (EmpDisLabel);
		add (EmpPhnLabel);
		add (EmpEmailLabel);
		add (EmpDobLabel);
		add (EmpNidLabel);
		add (EmpBloodLabel);
		add (EmpJOinLabel);
		add (EmpEduLabel);
		add (EmpSscLabel);
		add (EmpHscLabel);
		add (EmpGndrLabel);
		add (EmpTypLabel);
		add (EmpSalLabel);
		add (B1);
		add (B2);
		add (B3);

		
		add(EmpNameTxt);
		
		add(EmpCityTxt);
		add(EmpDisTxt);
		add(EmpPhnTxt);
		add(EmpEmailTxt);
		add(EmpDobTxt);
		add(EmpNidTxt);
		add(EmpBloodTxt);
		add(EmpJoinTxt);
		add(EmpSscTxt);
		add(EmpHscTxt);
		add(EmpGndrTxt);
		add (EmpTypTxt);
		add (EmpSalTxt);
		
		 EmpJoinTxt.setText(""+startDate+"");
		EmpInfoLabel.setBounds(300,50,100,100);
		
		
		EmpNameLabel.setBounds(50,250,100,20);
		EmpNameTxt.setBounds(200,250,200,20);
		
		
		
		EmpCityLabel.setBounds(50,300,100,20);
		EmpCityTxt.setBounds(200,300,100,20);
		
		EmpDisLabel.setBounds(650,300,100,20);
		EmpDisTxt.setBounds(800,300,100,20);
		
		EmpPhnLabel.setBounds(50,350,100,20);
		EmpPhnTxt.setBounds(200,350,100,20);
		
		EmpEmailLabel.setBounds(650,350,10000,20);
		EmpEmailTxt.setBounds(800,350,200,20);
		
		EmpDobLabel.setBounds(50,400,100,20);
		EmpDobTxt.setBounds(200,400,100,20);
		
		EmpNidLabel.setBounds(50,450,100,20);
		EmpNidTxt.setBounds(200,450,100,20);
		
		EmpBloodLabel.setBounds(50,500,100,20);
		EmpBloodTxt.setBounds(200,500,100,20);
		
		EmpJOinLabel.setBounds(50,550,100,20);
		EmpJoinTxt.setBounds(200,550,100,20);
		
		EmpEduLabel.setBounds(50,600,100,20);
		
		EmpSscLabel.setBounds(50,650,100,20);
		EmpSscTxt.setBounds(200,650,100,20);
		
		EmpHscLabel.setBounds(650,650,100,20);
		EmpHscTxt.setBounds(800,650,100,20);
		
		
		EmpGndrLabel.setBounds(650,500,100,20);
		EmpGndrTxt.setBounds(800,500,100,20);
		
		EmpTypLabel.setBounds(650,200,100,20);
		EmpTypTxt.setBounds(800,200,100,20);
		
		EmpSalLabel.setBounds(650,550,100,20);
		EmpSalTxt.setBounds(800,550,100,20);
		
		
		
		
		
		B1.setBounds(50,50,100,50);
		B1.addActionListener(this);
		B2.setBounds(850,50,100,50);
		B2.addActionListener(this);
		B3.setBounds(1050,50,100,50);
		B3.addActionListener(this);
		
		
		
		
		
		
	}
public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==B1)
		{    
		setVisible(false);
			LoginInterface m = new LoginInterface();
		}
		if(e.getSource()==B2)
		{    
	    EmployeeInfoClass emp=new  EmployeeInfoClass( EmpNameTxt.getText() , EmpCityTxt.getText() , EmpDisTxt.getText(), EmpPhnTxt.getText(),
		EmpEmailTxt.getText(),EmpDobTxt.getText(), EmpNidTxt.getText(),EmpBloodTxt.getText(), EmpJoinTxt.getText(), EmpSscTxt.getText(),
		EmpHscTxt.getText(), EmpGndrTxt.getText(), EmpTypTxt.getText(),EmpSalTxt.getText());
		
		 JOptionPane.showMessageDialog(this,"Succes to add Emp ");
		 EmpNameTxt.setText("");
		 EmpCityTxt.setText("");
		 EmpDisTxt.setText("");
		 EmpPhnTxt.setText("");
		 EmpEmailTxt.setText("");
		 EmpDobTxt.setText("");
		 EmpNidTxt.setText("");
		 EmpBloodTxt.setText("");
		 EmpJoinTxt.setText("");
		 EmpSscTxt.setText("");
		 EmpHscTxt.setText("");
		 EmpGndrTxt.setText("");
		 EmpTypTxt.setText("");
		 EmpSalTxt.setText("");
		 
		 
		  
		}
		if(e.getSource()==B3)
		{    
	     
		 EmpNameTxt.setText("");
		 EmpCityTxt.setText("");
		 EmpDisTxt.setText("");
		 EmpPhnTxt.setText("");
		 EmpEmailTxt.setText("");
		 EmpDobTxt.setText("");
		 EmpNidTxt.setText("");
		 EmpBloodTxt.setText("");
		 EmpJoinTxt.setText("");
		 EmpSscTxt.setText("");
		 EmpHscTxt.setText("");
		 EmpGndrTxt.setText("");
		 EmpTypTxt.setText("");
		 EmpSalTxt.setText("");
		 
		  
		}
		
	}
}