package jdbc_with_GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
public class login_with_GUI extends JFrame implements ActionListener
{
	Container cp;
	
	JLabel lblusername,lblpass;
	JTextField txtuser;
	JPasswordField txtpass;
	JButton btnlogin,btnreset;
	Connection con;
	ResultSet rs;
	int ans;
	PreparedStatement ps;
	String url,user,pass;
	
	public login_with_GUI(String title) throws ClassNotFoundException, SQLException
	{
		super(title);
		
		con=getconnection();
		cp=getContentPane();
		cp.setLayout(new GridLayout(3,2,5,5));
		
		lblusername=new JLabel("User Name");
		txtuser=new JTextField();
		
		lblpass=new JLabel("Password");
		txtpass=new JPasswordField();
		
		btnlogin=new JButton("Login");
		btnlogin.addActionListener(this);
		
		btnreset=new JButton("Cancel");
		btnreset.addActionListener(this);
		
		cp.add(lblusername);
		cp.add(txtuser);
		cp.add(lblpass);
		cp.add(txtpass);
		cp.add(btnlogin);
		cp.add(btnreset);
		
		setSize(500,500);
		setVisible(true);
			
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

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	login_with_GUI obj=new login_with_GUI("Login");
	}
	
	public void Login() throws SQLException, ClassNotFoundException
	{
		ps=con.prepareStatement("select * from username where unm=? and pass=?");
		String um=txtuser.getText();
		String pas=txtpass.getText();
		
		ps.setString(1, um);
		ps.setString(2, pas);
		
		rs=ps.executeQuery();
		
		if(rs.next())
		{
			JOptionPane.showMessageDialog(this, "Login succefully....!");
			libaraymanagamentDemo obj=new libaraymanagamentDemo("my libaray");
			
			
		this.dispose();
		}
		else
		{

			JOptionPane.showMessageDialog(this, "Login failed...!");
			clear();
		
		}

	}
	public void clear()
	{
		txtuser.setText("");
		txtpass.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
			try {
				if(e.getSource()==btnlogin)
				{
				
				Login();
				} 
		
				else if(e.getSource()==btnreset)
				{
					clear();
				}

				
			}
			catch (SQLException e1)
			{
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
	}
}
