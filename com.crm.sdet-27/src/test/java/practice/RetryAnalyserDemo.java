package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.RetryAnalyserImpl;

public class RetryAnalyserDemo {

	@Test(retryAnalyzer= RetryAnalyserImpl.class)
	public void retry()
	{
		System.out.println("Retry Analyser Trial Run");
		//Assert.fail("Trial");
	}
}
