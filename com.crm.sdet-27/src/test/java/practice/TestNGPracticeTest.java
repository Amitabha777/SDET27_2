package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPracticeTest {

	@Test(priority=3, invocationCount=3)
	public void createCustomerTest()
	{
		Reporter.log("Customer created",true);
		
	}
	
	@Test(priority =1, enabled=true)
	public void deleteCustomerTest()
	{
		
		Reporter.log("User Deleted Successfully",true);
	}
	
	@Test(priority =-1)
	public void modifyCustomerTest()
	{
		Reporter.log("Customet Modified",true);
	}
	
	
}
