import javax.swing.*;
import java.awt.event.*;
class LoginInterface extends JFrame implements ActionListener
{
	JTextField tf = new JTextField();
	JTextField tf1 = new JTextField();	
	JLabel L1 = new JLabel ("LOGIN");
	JLabel L3 = new JLabel ("USER ID");
	JLabel L4 = new JLabel ("PASSWORD");
	JButton LoginButton = new JButton("Login");
	
	public LoginInterface()
	{   
		setSize (400,300);
		setLayout(null);
		setVisible(true);
		add (L1);
		add (L3);
		add (L4);
		add(tf);
		add(tf1);
		add(LoginButton);
		
		L1.setBounds(180,30,100,20);
		
		L3.setBounds(50,100,80,20);
		tf.setBounds(200,100,80,20);
		
		L4.setBounds(50,130,80,20);
		tf1.setBounds(200,130,80,20);
		LoginButton.setBounds(200, 170, 80,30);
		LoginButton.addActionListener(this);
		
		
		
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
			{    if(lg.get_CHtype()!=1)
				JOptionPane.showMessageDialog(this,"Another User Use the Soft\n Try again Later");
				else{
			 lg.ChairmanInterfaceCreate();
			 setVisible(false);
			}
			}
			
			else if(tf.getText().equals(lg.get_counterest_username())&&tf1.getText().equals(lg.get_counterest_password()))
			{ if(lg.get_COtype()!=1)
				JOptionPane.showMessageDialog(this,"Another User Use the Soft\n Try again Later");
				else{
					 setVisible(false);
					lg.TicketSellingFrameCreate();
			 
			}
			}
			else JOptionPane.showMessageDialog(this,"Failed to login \n Try again ");
			
		}
		
	}
	

}