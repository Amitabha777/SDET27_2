package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetDataFromDatabase2 {

	public static void main(String[] args) throws Throwable {
		
		//Register The Driver
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);	
		
		//Establish Connection with Database
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb3", "root", "root");
		
		
		//Create Statement for MySql
		Statement statement= connection.createStatement();
		
		//Write the Query
		ResultSet result = statement.executeQuery("select * from practice;");
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+ "\t"+ result.getString(2)+ "\t"+ result.getString("lname")+ "\t" + result.getInt(4));
			
			//System.out.println(result.getInt(1));
			
//			int viewresult= result.getInt(1);
//			System.out.println(viewresult);
		}
		
		//Close the Connection
		connection.close();
		
	}
}
