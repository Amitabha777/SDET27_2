package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateTheDatabase2 {

	public static void main(String[] args) throws Throwable {
		
		Connection connection=null;
		try
		{
			System.out.println("Start");
		//Register the driver
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		
		//Establish the connection with Database
		connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb3", "root", "root");
		
		//Issue Statement for Database
		Statement statement= connection.createStatement();
		
		//Query to Update Database
		int update= statement.executeUpdate("insert into practice value (8,'tambitasdf','figh',20976);");
		
		//Verify Whether Data Added or not
		if(update==1)
		{
			System.out.println("One set of data is added");
		
		}
		else
			System.out.println("Data not added in Database");
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
		//close the connection
		connection.close();
		}
		
	}
}
