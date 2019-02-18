package com.util;

import java.util.StringTokenizer;

public class StringtoInt {

	public static int[] toInt(String str) {  
		  
	    int ret[] = new int[str.length()];   
	  
	    StringTokenizer toKenizer = new StringTokenizer(str, ",");   
	  
	    int i = 0;  
	  
	    while (toKenizer.hasMoreElements()) {   
	  
	      ret[i++] = Integer.valueOf(toKenizer.nextToken());  
	  
	    }   
	  
	   return ret;  
	  
	 }  
}
