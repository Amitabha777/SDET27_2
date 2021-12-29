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
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.sun.org.apache.xpath.internal.operations.Equals;

public class AddProject {

	public static void main(String[] args) throws Throwable {
		
		//Loading Chrome Driver
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//Handling Implicit Synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Opening the Server
		driver.get("http://localhost:8084/");
		
		//Maximizing the Browser
		driver.manage().window().maximize();
		
		//Locating UserName TextBox
		WebElement username= driver.findElement(By.id("usernmae"));
		
		//Sending Values to UserName & Password
		username.sendKeys("rmgyantra", Keys.TAB, "rmgy@9999");
	
		//Clicking On Login
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//Clicking On Projects
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		
		//Clicking On Create Project
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		//Clicking On Project Name TextBox
		WebElement projectName= driver.findElement(By.name("projectName"));
		
		//Entering Project Name & Project Manager
		projectName.sendKeys("Sandeep", Keys.TAB, "Amandeep");
		
		//Clicking on Project Status ListBox
		WebElement status=driver.findElement(By.xpath("//label[text()='Project Status ']/../select"));
		
		Select s= new Select(status);
		
		//Selecting Required Status
		s.selectByIndex(2);
		
		//Adding Project To Database
		driver.findElement(By.cssSelector("input[value='Add Project']")).click();
		
		//Closing The Browser
		driver.quit();
		
		//Verify with Database
		Connection connection =null;
		String expectedValue="gaurav";
		try {
			
		//Register with Driver
		Driver dbDriver= new Driver();
		DriverManager.registerDriver(dbDriver);
		
		//Establish Connection with Database
		connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		//Issue the Statement
		Statement statement= connection.createStatement();
		
		//Write The Query
		ResultSet result = statement.executeQuery("select * from project;");
		
		while(result.next())
		{
		//System.out.println(result.getString(1)+ "\t"+ result.getString(2)+ "\t"+ result.getString(3));	
		
			//Verify
		if(result.getString(2).equals(expectedValue))
		{
			System.out.println("Verified");
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
			//Connection Close
			connection.close();
		}
	}
}
