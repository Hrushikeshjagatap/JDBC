import java.sql.*;
import java.util.Scanner;
public class Update_in_database 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/rushi";
		
		String user="root",pass="root";
		
		Connection con=DriverManager.getConnection(url,user,pass);
		
		Statement st=con.createStatement();
		
		System.out.println("enter the id");
		
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		System.out.println("enter the salary which will be updated");
		Double p=sc.nextDouble();
		
		String q="update employee set salary="+p+"where Id="+id;
		
		int ans=st.executeUpdate(q);
		
		if(ans>0)
		{
			System.out.println("record updated");
		}
		else
		{
			System.out.println("not updated");
		}
		
		con.close();
		

	}

}
