package jdbc_with_GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class registerDemo extends JFrame
{

	Container cp;
	
	JLabel lblname,username,lblpass,lblconformpass;
	JTextField txtname,txtusername,txtpass,txtconformpass;
	JButton btnregister,btncance;
	Connection con;
	ResultSet rs;
	int ans;
	PreparedStatement ps;
	String url,user,pass;
	public registerDemo(String title) throws ClassNotFoundException, SQLException
	{

		con=getconnection();
		cp=getContentPane();
		cp.setLayout(new GridLayout(4,2,5,5));
		
		lblname=new JLabel("Name");
		txtname=new JTextField();
		
		
	}
	public static void main(String[] args) 
	{
	
	}
	public Connection getconnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		url="jdbc:mysql://localhost:3306/rushi";
		user="root";
		pass="root";
		
		con=DriverManager.getConnection(url,user,pass);
		
		return con;
		
	}

}
