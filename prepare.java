package set;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class prepare{
	static final String DB_URL="jdbc:mysql://localhost:3306/gv";
	static final String USER="root";
	static final String PASS="ganga123";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open a connection
		try
		{
			Connection conn1=DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement stmt =conn1.prepareStatement("insert into employee1 values(?,? ,?,?)");
			stmt.setInt(1, 2);
			stmt.setString(2,"James");
			stmt.setString(3,"Bond");
			stmt.setString(4, "IT");
			int i=stmt.executeUpdate(); //dml
			System.out.println(i+"record inserted");
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}

	}

}