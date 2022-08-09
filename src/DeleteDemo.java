import java.sql.*;
import java.util.Scanner;
public class DeleteDemo 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		String ur="jdbc:mysql://localhost:3306/rushi";
		String us="root",pass="root";
		Connection con=DriverManager.getConnection(ur,us,pass);
		Statement st=con.createStatement();
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id whose record was delete");
		int id=sc.nextInt();
		
		int ans=st.executeUpdate("delete from employee where Id="+id);
		
		if(ans>0)
		{
			System.out.println("delete sucessfully...!");
		}
		else
		{
			System.out.println("something wrong");
		}
		con.close();
	}

}
