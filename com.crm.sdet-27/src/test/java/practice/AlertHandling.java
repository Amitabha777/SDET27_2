package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main (String[]args)
	{
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("JavaScript Alerts")).click();

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		Alert alt= driver.switchTo().alert();
		
		alt.accept();
		
		//driver.close();

		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		alt=driver.switchTo().alert();
		
		String msg=alt.getText();
		System.out.println("msg="+msg);
		
		alt.dismiss();
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		
//		alt=driver.switchTo().alert();
//		
//		alt.accept();
		
		
	}
}
