package practice;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;

public class ScrollHandling extends BaseClass{

	@Test
	public void scroll() throws InterruptedException
	{
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,1000);");
		
		Thread.sleep(1000);
		
	}
}
