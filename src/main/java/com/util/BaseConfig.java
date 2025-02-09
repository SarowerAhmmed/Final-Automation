package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseConfig {
	
	
	public String getConfig(String key){
		String filePath ="./qa.properties";
		// file or data ==> convert to stream 
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties pro = new Properties();
		try {
			pro.load(fs);//FileInputStream
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//System.out.println(pro.get(key));
		
		
		
		return (String) pro.get(key);
	}
	
	public static void main(String[] args) {
		BaseConfig bc = new BaseConfig();
		String value =bc.getConfig("VALID_USER");
		System.out.println(value);
	}

}
