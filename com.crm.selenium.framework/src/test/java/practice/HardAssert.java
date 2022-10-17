package practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert 
{
@Test
	public void CreateCustomerTest()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, false);
		System.out.println("Step3");
		System.out.println("Step4");
		
	}
@Test
   public void ModifyCustomerTest()
   {
	   System.out.println("-----");
	   System.out.println("step1");
   }


}
