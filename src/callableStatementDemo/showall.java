package callableStatementDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class showall
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/rushi";
		
		String uname="root",pass="root";
		Connection con=DriverManager.getConnection(url, uname,pass);
		CallableStatement cst=con.prepareCall("{call getbook()}");
		 
		boolean res=cst.execute();
		if(res)
		{
			ResultSet  rs=cst.getResultSet();
			System.out.println("All Books are");
			while (rs.next()) 
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
				
			}
		}
		con.close();
	}

}
