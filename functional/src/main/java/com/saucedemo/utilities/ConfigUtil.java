package com.saucedemo.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import io.opentelemetry.api.internal.StringUtils;

public class ConfigUtil {
	
static Properties pro = new Properties();
	
	public static String getpropertyvalue(String key) throws Exception {
		String src = System.getProperty("user.dir")+"/src/test/resources/configuration/config.properties";
		FileInputStream fis = new FileInputStream(src);
		pro.load(fis);
		String value = pro.get(key).toString();
		
		if(StringUtils.isNullOrEmpty(value)) {
			throw new Exception("Value is not present for the specified key:"+key+" in config property file");
		}
		return value;
		
		
	}


}
