import javax.swing.*;
import java.awt.event.*;
class ChangeLoginInterface extends JFrame implements ActionListener
{
	JTextField tf = new JTextField();
	JTextField tf1 = new JTextField();	
	JTextField tf2 = new JTextField();	
	JTextField tf3 = new JTextField();	
	JLabel L1 = new JLabel ("Change Password");
	JLabel L3 = new JLabel ("Admin USER ID");
	JLabel L4 = new JLabel ("PASSWORD");
	JLabel L5 = new JLabel ("Counter New PASSWORD");
	JLabel L6 = new JLabel ("Admin New PASSWORD");
	JButton LoginButton = new JButton("Change");
	JButton LoginButton1 = new JButton("Admin");
	
	public ChangeLoginInterface ()
	{   
		setSize (600,600);
		setLayout(null);
		setVisible(true);
		add (L1);
		add (L3);
		add (L4);
		add (L5);
		add (L6);
		add(tf);
		add(tf1);
		add(tf2);
		add(tf3);
		add(LoginButton);
		add(LoginButton1);
		L1.setBounds(180,30,300,20);
		
		L3.setBounds(50,100,180,20);
		tf.setBounds(250,100,80,20);
		
		L4.setBounds(50,130,180,20);
		tf1.setBounds(250,130,80,20);
		
		L5.setBounds(50,170,180,20);
		tf2.setBounds(250,170,80,20);
		
		L6.setBounds(50,200,180,20);
		tf3.setBounds(250,200,80,20);
		
		LoginButton.setBounds(400, 170, 80,30);
		LoginButton1.setBounds(400, 30, 80,30);
		LoginButton.addActionListener(this);
		LoginButton1.addActionListener(this);
		
		
		
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==LoginButton)
		{  
			LoginClass lg= new LoginClass();
			 
			if(tf.getText().equals(lg.get_chairman_username())&&tf1.getText().equals(lg.get_chairman_password()))
			{
				lg.LoginPasworrdChange(tf2.getText(),tf3.getText());
				JOptionPane.showMessageDialog(this,"Sucess");

				setVisible(false);
			LoginInterface m = new LoginInterface();
			 
			
			}
			
			
			else {JOptionPane.showMessageDialog(this,"Wrong User \n Try again ");
			  setVisible(false);
			  LoginInterface m = new LoginInterface();
			}
		}
		if(e.getSource()==LoginButton1)
		{  setVisible(false);
			LoginInterface m = new LoginInterface();
		}
		
	}
	

}