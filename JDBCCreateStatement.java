package set;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCreateStatement {
	static final String DB_URL="jdbc:mysql://localhost:3306/gv";
	static final String USER="root";
	static final String PASS="ganga123";
	
	// 1. connection thru driver manager
	//2. using try establish connection & statement
	static Connection conn1=null;
	public static void main(String[] args) {
		//3.open a connection
		try
		{
			conn1=DriverManager.getConnection(DB_URL,USER,PASS);
			//4.Create the statement w.r.t sql
			Statement stmt=conn1.createStatement();
			String sql="select * from employee1";
			//executing the query
			ResultSet rs=stmt.executeQuery(sql);
			//printing the record using next();
			while(rs.next())
			{
				
				System.out.println("id"+" "+rs.getInt(1));
				System.out.println("firstName"+" "+rs.getString(2));
				System.out.println("lastName"+" "+rs.getString(3));
				System.out.println("desination"+" "+rs.getString(4));
				
			}
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	

}



