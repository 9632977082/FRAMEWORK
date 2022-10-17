package com.crm.Generic_utility;

import java.util.Random;

public class Java_utility 
{
public int getRanDomNum()
{
	/*
	 * this method used to avoid duplicate
	 * @shivashankar
	 */
	Random ran = new Random();
	int Rannum = ran.nextInt(1000);
	return Rannum;
}

}
