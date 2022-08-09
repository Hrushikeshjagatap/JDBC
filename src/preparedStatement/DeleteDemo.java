package preparedStatement;
import java.sql.*;
import java.util.Scanner;
public class DeleteDemo
{

	public static void main(String[] args) throws SQLException
	{
		Connection con=null;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rushi","root","root");
		 
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("enter the id whose record will be deleted");
		 double id=sc.nextDouble();
		 
		 PreparedStatement ps=con.prepareStatement("delete from Account where balance=?");
		 
		 ps.setDouble(1, id);
		 
		 int ans=ps.executeUpdate();
		 if(ans>0)
		 {
			 System.out.println("delete sucessfully");
		 }
		 else
		 {
			 System.out.println("can't be deleted");
		 }
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}

	}

}
