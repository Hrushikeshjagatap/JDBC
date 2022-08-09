package callableStatementDemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDemo
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/rushi",uname="root",pass="root";
		
		Connection con=DriverManager.getConnection(url,uname,pass);
		
		CallableStatement cst=con.prepareCall("{call insertBook(?,?,?,?)}");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int i=sc.nextInt();
		
		System.out.println("enter the book name");
		sc.nextLine();
		String nm=sc.nextLine();
		
		System.out.println("enter the author");
		String au=sc.nextLine();
		
		System.out.println("enter the price");
		float p=sc.nextFloat();
		
		
		cst.setInt(1, i);
		cst.setString(2, nm);
		cst.setString(3, au);
		cst.setDouble(4, p);
		
		boolean r=cst.execute();
		
		if(r==false)
		{
			int ans=cst.getUpdateCount();
			if(ans > 0)
				System.out.println("insert into tables");
			else
				System.out.println("unablen to insert");
		
				
			
		}
		con.close();

		
	}

}
