package com.crm.Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_utility 
{
public String getPropertyKeyValue(String key) throws IOException
{
	/**
	 * THIS METHOD IS USED TO LAUNCH THE APPLICATION
	 * PARAM KEY
	 * RETURN
	 * THROWS
	 * @author Shivashankar 
	 */
	
	//FileInputStream fis = new FileInputStream("./commondata.properties.txt");
	FileInputStream fis = new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
	Properties pro = new Properties();
	pro.load(fis);
	String value = pro.getProperty(key);
	return value;
}
}
