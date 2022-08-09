package resultset_interface;
import java.sql.*;

public class scroolresultDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.jdbc.Driver");
	
	String url="jdbc:mysql://localhost:3306/rushi",user="root",pass="root";
	Connection con=DriverManager.getConnection(url,user,pass);
	
	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
	ResultSet rs=st.executeQuery("select * from book");
	
	System.out.println("All book are");
	
	while (rs.next()) 
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
	}
	
	rs.absolute(3);
	
	rs.updateString(2, "php");
	rs.updateString(3, "yn");
	rs.updateRow();
	
	System.out.println("afetr updated row is");
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));

	rs.absolute(2);
	
	rs.updateString(2, "c++");
	rs.updateString(3, "ym");
	rs.updateRow();
	
	System.out.println("afetr updated row is");
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));

	rs.absolute(-1);
	rs.updateString(2, "Ds");
	rs.updateString(3, "yk");
	rs.updateRow();
	
	System.out.println("afetr updated row is");
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));

	rs.first();
	rs.updateString(2, "c");
	rs.updateString(3, "yg");
	rs.updateRow();
	
	System.out.println("afetr updated row is");
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
	
	rs.last();
	rs.updateString(2, "DS");
	rs.updateString(3, "yk");
	rs.updateRow();
	
	System.out.println("afetr updated row is");
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
	
	
	
	}

}
