package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyDataFromDatabase {

	public static void main(String[] args) throws Throwable {
		
		Connection connection= null;
		String actualElement="amit";
		
		try {
		//register the driver
		
		Driver driver= new Driver();
		
		DriverManager.registerDriver(driver);
		
		//Establish connection from Database
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		
		//Issue The Statement
		
		Statement statement= connection.createStatement();
		
		//Execute the Query
		ResultSet result = statement.executeQuery("select * from studentinfo;");
		
		//Verify
		while(result.next())
		{
			String presentElement= result.getString(2);
			
			if(actualElement.equals(presentElement))
			{
				System.out.println("Element is present");
				break;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			//close connection
			connection.close();
		}
	}
}
