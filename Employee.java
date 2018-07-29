import javax.swing.*;
import java.awt.event.*;
class Employee extends JFrame implements ActionListener
{
	JTextField tf = new JTextField();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	JTextField tf7 = new JTextField();
	JTextField tf8 = new JTextField();
	JTextField tf9 = new JTextField();
	JTextField tf10 = new JTextField();
	JTextField tf11 = new JTextField();
	JTextField tf12 = new JTextField();
	JTextField tf13 = new JTextField();
	
	
	JLabel L1 = new JLabel ("ADD Employee Info");
	JLabel L2 = new JLabel("Name :");
	JLabel L3 = new JLabel("ID :");
	JLabel L4 = new JLabel("Address :");
	JLabel L5 = new JLabel("City :");
	JLabel L6 = new JLabel("Distric :");
	JLabel L7 = new JLabel("Phone :");
	JLabel L8 = new JLabel("Email :");
	JLabel L9 = new JLabel("Date Of Birth :");
	JLabel L10 = new JLabel("NID :");
	JLabel L11= new JLabel("Blood :");
	JLabel L12= new JLabel("JOinig Date :");
	JLabel L13= new JLabel("Education Info : ");
	JLabel L14= new JLabel("S.S.C :");
	JLabel L15= new JLabel("H.S.C :");
	JLabel L16= new JLabel("Gender :");
	public Employee()
	{
		setSize (4000,960);
		setLayout(null);
		setVisible(true);
		add (L1);
		add (L2);
		add (L3);
		add (L4);
		add (L5);
		add (L6);
		add (L7);
		add (L8);
		add (L9);
		add  (L10);
		add (L11);
		add (L12);
		add (L13);
		add (L14);
		add (L15);
		add (L16);

		
		add(tf);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);
		add(tf7);
		add(tf8);
		add(tf9);
		add(tf10);
		add(tf11);
		add(tf12);
		add(tf13);
		
		L1.setBounds(300,50,100,50);
		
		L2.setBounds(50,150,100,20);
		tf.setBounds(200,150,100,20);
		
		L3.setBounds(50,200,100,20);
		tf1.setBounds(200,200,100,20);
		
		L4.setBounds(50,250,100,20);
		tf2.setBounds(200,250,100,20);
		
		L5.setBounds(50,300,100,20);
		tf3.setBounds(200,300,100,20);
		
		L6.setBounds(650,300,100,20);
		tf4.setBounds(800,300,100,20);
		
		L7.setBounds(50,350,100,20);
		tf5.setBounds(200,350,100,20);
		
		L8.setBounds(650,350,100,20);
		tf6.setBounds(800,350,100,20);
		
		L9.setBounds(50,400,100,20);
		tf7.setBounds(200,400,100,20);
		
		L10.setBounds(50,450,100,20);
		tf8.setBounds(200,450,100,20);
		
		L11.setBounds(50,500,100,20);
		tf9.setBounds(200,500,100,20);
		
		L12.setBounds(50,550,100,20);
		tf10.setBounds(200,550,100,20);
		
		L13.setBounds(50,600,100,20);
		
		L14.setBounds(50,650,100,20);
		tf11.setBounds(200,650,100,20);
		
		L15.setBounds(650,650,100,20);
		tf12.setBounds(800,650,100,20);
		
		
		L16.setBounds(650,500,100,20);
		tf13.setBounds(800,500,100,20);
		
		
		
		
		
		
	}
public void actionPerformed(ActionEvent e)
	{
		tf.setText("");
		
	}
	public static void main(String []args)
	{
		
		Employee m = new Employee();
	}
}