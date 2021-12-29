package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDatainDatabase {

	public static void main(String[] args) throws Throwable {
		
		Connection connection = null;
		
		try {
			
			//register the database
			
			Driver driver= new Driver();
			
			DriverManager.registerDriver(driver);
			
			//Establish connection with Database
			
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			
			//Issue the statement
			
			Statement statement = connection.createStatement();
			
			//execute queries
			
			int result = statement.executeUpdate("insert into studentinfo value (4,'sumit','rai');");
			
	
		} catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		finally {
			//Close the Server
			connection.close();
			
		}
	}
}
