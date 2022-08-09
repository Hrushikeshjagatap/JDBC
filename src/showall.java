import java.sql.*;
public class showall 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/rushi";
	String user="root",pass="root";
	
	Connection con=DriverManager.getConnection(url,user,pass);
	
	Statement st=con.createStatement();
	
	ResultSet rs=st.executeQuery("select * from employee");
	
	while (rs.next())
	{
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4)+"\t"+rs.getDate(5)+"\t"+rs.getString(6));	
	}
	/*
	ResultSet rs1=st.executeQuery("select * from student");
	System.out.println("\n");
	
	while (rs1.next())
	{
	System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getInt(3)+"\t"+rs1.getString(4)+"\t"+rs1.getDouble(5));	
	}
	
*/
	con.close();
	}
}
