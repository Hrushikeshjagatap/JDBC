package preparedStatement;
import java.sql.*;
import java.util.Scanner;

public class InsertDemo
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/rushi";
		String user="root",pass="root";
		
		Connection con=DriverManager.getConnection(url, user, pass);
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the id");
		int id=sc.nextInt();
		
		System.out.println("enter the name");
		sc.nextLine();
		String name=sc.nextLine();
		
		System.out.println("enter the balance");
		double balance=sc.nextDouble();
		String q="insert into Account values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(q);
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setDouble(3, balance);
		
		int ans=ps.executeUpdate();
		
		if(ans>0)
		{
			System.out.println("insert sucessfully...!");
		}
		else
		{
			System.out.println("unable to insert");
		}
		con.close();
	}

}
