package com.rmgyantra.testScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class AddProjectFromMySql {
	
	public static void main(String[] args) throws Throwable {
		
		Connection connection=null;
		String expectedValue= "Harsh";
		
		try {
			//Register Driver
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		
		//Establish Connection with Database
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		//Issue the Statement
		Statement statement= connection.createStatement();
		
		//Write The Query
		//int result = statement.executeUpdate("insert into project value ('TY_PROJ_003','Database','16/12/21','Harsh','Completed',5);");
		
		ResultSet result2 = statement.executeQuery("select * from project;");
		
		//Verifying Project Added or Not
		while(result2.next())
		{
			if(result2.getString(4).equals(expectedValue))
			{	System.out.println("Verified");
			break;
			}	
		}
		}
		//Exception Handling
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally {
			//Closing Connection
			connection.close();
		}
	
				
	}
}
