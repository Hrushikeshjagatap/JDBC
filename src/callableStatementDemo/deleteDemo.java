package callableStatementDemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteDemo
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/rushi",uname="root",pass="root";
	Connection con=DriverManager.getConnection(url,uname,pass);
	
	CallableStatement cst=con.prepareCall("{call deletebook(?)}");
	
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the id whose record be deleted");
	int i=sc.nextInt();
	
	cst.setInt(1, i);
	boolean r=cst.execute();
	
	if(r==false)
	{
		int ans=cst.getUpdateCount();
		if(ans > 0)
			System.out.println("recored deleted");
		else
			System.out.println("reocred not found");
	
			
		
	}
	con.close();

}
}
