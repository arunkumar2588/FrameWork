package com.crm.Generic_Utilities;

import java.util.Random;

public class Java_Utility {
	/**
	 * this method is used to avoid duplicate value
	 * @return
	 * @author Arun
	 */
	
	public int getRanDomNum() {
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
		
	}
}
