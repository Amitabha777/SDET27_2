package practice;

import org.testng.annotations.BeforeSuite;

public class AnnotationsPractice {

	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("Before Suite running");
	}
}
