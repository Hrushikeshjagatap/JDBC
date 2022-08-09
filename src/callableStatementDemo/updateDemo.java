package callableStatementDemo;
import java.sql.*;
import java.util.Scanner;
public class updateDemo
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/rushi",user="root",pass="root";
	
	Connection con=DriverManager.getConnection(url, user, pass);
	
	CallableStatement cst=con.prepareCall("{call updatebook(?,?,?)}");
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("enter the id");
	int id=sc.nextInt();
	
	System.out.println("enter the name");
	sc.nextLine();
	String nm=sc.nextLine();
	
	System.out.println("enter the price");
	float p=sc.nextFloat();
	
	cst.setInt(1, id);
	cst.setString(2, nm);
	cst.setFloat(3, p);
	
	boolean r=cst.execute();
	
	if(r==false)
	{
		int ans=cst.getUpdateCount();
		if(ans > 0)
			System.out.println("updated Sucefully..");
		else
			System.out.println("unablen to updated");
	
			
		
	}
	con.close();

	
	
	}

}
