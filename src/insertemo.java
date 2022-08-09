import java.sql.*;
import java.util.Scanner;
public class insertemo 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/rushi";
		String user="root",pass="root";
		Connection con=DriverManager.getConnection(url,user,pass);
		
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int id=sc.nextInt();
		
		System.out.println("enter the first name");
		sc.nextLine();
		String name=sc.nextLine();
		
		System.out.println("enter the last name");
		String lnm=sc.nextLine();
		
		System.out.println("enter the sal");
		Double sal=sc.nextDouble();
		
		System.out.println("enter the date");
		sc.nextLine();
		String da=sc.nextLine();
		
		System.out.println("enter departement");
		String de=sc.nextLine();
		
		String q="insert into employee values("+id+",'"+name+"','"+lnm+"',"+sal+",'"+da+"','"+de+"')";
		
		int ans=st.executeUpdate(q);
		
		if(ans>0)
		{
			System.out.println("insert ");
			
		}
		else
		{
			System.out.println("unable to insert");
		}
		con.close();
	}

}
