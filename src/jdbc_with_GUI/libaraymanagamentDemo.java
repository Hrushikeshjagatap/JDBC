package jdbc_with_GUI;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class libaraymanagamentDemo extends JFrame implements ActionListener
{
	
	Container cp;
	JLabel lblbid,lblbanme,lblauthor,lblprice;
	JTextField txtbid,txtbname,txtauthor,txtprice;
	
	Button btnInsert,btnUpdate,btndelete,btnshowall,btnsearch,btnclear;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int ans;
	String url,user,pass;
	

	public libaraymanagamentDemo(String title) throws ClassNotFoundException, SQLException
	{
		super(title);
		con=getconnection();
		cp=getContentPane();
		
		cp.setLayout(new GridLayout(7,2,5,5));
		
		lblbid=new JLabel("book id");
		txtbid=new JTextField();
		
		cp.add(lblbid);
		cp.add(txtbid);
		
		lblbanme=new JLabel("book Name");
		txtbname=new JTextField();
		
		cp.add(lblbanme);
		cp.add(txtbname);
		
		lblauthor=new JLabel("Author name");
		txtauthor=new JTextField();
		
		cp.add(lblauthor);
		cp.add(txtauthor);
		
		lblprice=new JLabel("Book price");
		txtprice=new JTextField();
		
		cp.add(lblprice);
		cp.add(txtprice);
		
		
		btnInsert=new Button("Insert");
		btnInsert.addActionListener(this);
		
		btnUpdate=new Button("update");
		btnUpdate.addActionListener(this);
		
		btndelete=new Button("Delete");
		btndelete.addActionListener(this);
		
		btnclear=new Button("clear");
		btnclear.addActionListener(this);
		
		btnsearch=new Button("search");
		btnsearch.addActionListener(this);
		
		btnshowall=new Button("show All");
		btnshowall.addActionListener(this);
		
		cp.add(btnInsert);
		cp.add(btnUpdate);
		cp.add(btndelete);
		cp.add(btnsearch);
		cp.add(btnshowall);
		cp.add(btnclear);
		
		setSize(500,500);
		setVisible(true);
		
	}
	public Connection getconnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		url="jdbc:mysql://localhost:3306/rushi";
		user="root";
		pass="root";
		
		 con=DriverManager.getConnection(url,user,pass);
		 return con;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
	
	//libaraymanagamentDemo obj=new libaraymanagamentDemo("my libaray");
	
	}
	public void InsertBook() throws SQLException
	{
		ps=con.prepareStatement("insert into book values(?,?,?,?)");
		int id=Integer.parseInt(txtbid.getText());
		String nm=txtbname.getText();
		String au=txtauthor.getText();
		double p=Double.parseDouble(txtprice.getText());
		
		ps.setInt(1,id);
		ps.setString(2,nm);
		ps.setString(3,au);
		ps.setDouble(4,p);
		
		ans=ps.executeUpdate();
		
		if(ans>0)
		{
			JOptionPane.showMessageDialog(this, "data Insert");
			
			ClearTextBoxes();
			
		}
		else
		{
			JOptionPane.showMessageDialog(this, "data not Insert");
			
		}
		
	}
	public void UpdateBook() throws SQLException
	{
		ps=con.prepareStatement("update book set price=? where id=?");
		int id=Integer.parseInt(txtbid.getText());
		double p=Double.parseDouble(txtprice.getText());
		ps.setDouble(1, p);
		ps.setInt(2, id);
		
		ans=ps.executeUpdate();
		
		if(ans>0)
		{
			JOptionPane.showMessageDialog(this, "Updated sucefully!!!");
			
			ClearTextBoxes();
			
		}
		else
		{
			JOptionPane.showMessageDialog(this, "record not found");
			
		}
	
		
		
	}
	public void DeleteBook() throws SQLException
	{
		ps=con.prepareStatement("delete from book where id=?");
		int id=Integer.parseInt(txtbid.getText());
		ps.setInt(1, id);
		
		ans=ps.executeUpdate();
		
		if(ans>0)
		{
			JOptionPane.showMessageDialog(this, "delete sucefully!!!");
			
			ClearTextBoxes();
			
		}
		else
		{
			JOptionPane.showMessageDialog(this, "record not found");
			
		}	
	}
	public void SearchBook() throws SQLException
	{
		ps=con.prepareStatement("select * from book where id=?");
		int id=Integer.parseInt(txtbid.getText());
		ps.setInt(1, id);
		
		rs=ps.executeQuery();
		
		if(rs.next())
		{
			JOptionPane.showMessageDialog(this, "record  found");
			
			JOptionPane.showMessageDialog(this, "Id="+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
			
			ClearTextBoxes();
			
		}
		else
		{

			JOptionPane.showMessageDialog(this, "record not found");
		
		}
		
		
		
		
	}
	
	public void showall() throws SQLException, ClassNotFoundException
	{
		JFrame f=new JFrame("showing recoeds");
		
		String []columnnames= {"Bid","names","author","price"};
		
		
		DefaultTableModel model=new DefaultTableModel();
		
		model.setColumnIdentifiers(columnnames);
		
		JTable table=new JTable();
		
		table.setModel(model);
		
		JScrollPane jp=new JScrollPane(table);
		jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		getconnection();
		
		Statement st=con.createStatement();
		
		rs=st.executeQuery("select * from book");
		
		while(rs.next())
		{
			int id=rs.getInt(1);
			String bnm=rs.getString(2);
			String au=rs.getString(3);
			double p=rs.getDouble(4);
			
			model.addRow(new Object[]{id,bnm,au,p});
		}
		f.add(jp);
		f.setSize(400,400);
		f.setVisible(true);
		
		
		
		
	}
	public void ClearTextBoxes()
	{
		txtbid.setText("");
		txtbname.setText("");
		txtauthor.setText("");
		txtprice.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try {
				if(e.getSource()==btnInsert)
				{
				
				InsertBook();
				} 
				else if(e.getSource()==btnUpdate)
				{
					UpdateBook();
				}
				else if(e.getSource()==btndelete)
				{
					DeleteBook();
				}
				else if(e.getSource()==btnclear) 
				{
					ClearTextBoxes();
				}
				else if(e.getSource()==btnsearch)
				{
					SearchBook();
				}
				else if(e.getSource()==btnshowall)
				{
					showall();
				}
			}
			catch (SQLException e1) 
			{
			e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	
	}
	
}
