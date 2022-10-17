package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert 
{
	@Test
public void CreateCustomerTest()
{
	System.out.println("Step1");
	System.out.println("Step2");
	System.out.println("step3");
	SoftAssert soft = new SoftAssert();
	soft.assertEquals("a","b");
	System.out.println("step4");
	System.out.println("step5");
	soft.assertAll();
}
}
