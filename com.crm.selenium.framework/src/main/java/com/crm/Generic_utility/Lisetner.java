package com.crm.Generic_utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Lisetner implements ITestListener
{

	//public void onTestFailure(ITestResult result)
	//{
	//	String data = result.getMethod().getMethodName();
	//System.out.println("execute i am listening");
	//	EventFiringWebDriver  edriver = new EventFiringWebDriver(Base_class.sdriver);
	//	File src = edriver.getScreenshotAs(OutputType.FILE);
	//	try
	//	 {
			//File dst = new File(" ./ScreenShot/"+data+".png");
			//FileUtils.copyFile(src, dst);
	//	}
	//	catch(Throwable e)
	//{
	//		e.printStackTrace();
	//	}

	//}

}
