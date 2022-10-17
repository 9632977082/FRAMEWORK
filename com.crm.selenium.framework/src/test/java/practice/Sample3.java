package practice;

import org.testng.annotations.Test;

public class Sample3 
{
	@Test(priority=1)
	public void createCustomer()
	{
		System.out.println("hi");
	}    
	@Test
	public void modifyCustomer()
	{
		System.out.println("moidfy");
	}
	@Test
	public void deleteCustomer()
	{
		System.out.println("delet");
	}
}
