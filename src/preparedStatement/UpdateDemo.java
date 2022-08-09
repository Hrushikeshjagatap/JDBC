package preparedStatement;
import java.sql.*;
import java.util.Scanner;
public class UpdateDemo
{

	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/rushi";
			String user="root",pass="root";
			con=DriverManager.getConnection(url,user,pass);
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the new balance");
			double balance=sc.nextDouble();
			
			
			System.out.println("enter the id whose updated balance");
			int id=sc.nextInt();
			String q="update Account set balance=? where acno=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(2, id);
			ps.setDouble(1, balance);
			int ans=ps.executeUpdate();
			if(ans>0)
			{
				System.out.println("updated Suceefully..!");
			}
			else
			{
				System.out.println("unable to updated");
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
