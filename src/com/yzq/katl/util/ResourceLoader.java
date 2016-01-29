package com.yzq.katl.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceLoader {

	public static String loadResource(String key){
		Properties p = new Properties(); 
		try {
			InputStream in = null;
			in = ResourceLoader.class.getClassLoader().getResourceAsStream("config.properties");
			if(in==null){
				in = ResourceLoader.class.getClassLoader().getResourceAsStream("/config.properties");
			}
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
}
