package preparedStatement;
import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class selectDemo 
{

	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rushi","root","root");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the id");
		int id=sc.nextInt();
		
		PreparedStatement ps=con.prepareStatement("select * from Account where acno=?");
		ps.setInt(1, id);
		
	ResultSet rs=ps.executeQuery();	
		rs.next();
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
		
		
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Exception occur...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}
	}

}
