package kr.cleancode.dashboard.manager.common;

import java.util.Properties;

public class XrManagerProperties {

	public static String getValueForJava(String key){
		final Properties properties = new Properties();
		try {
			properties.load(XrManagerProperties.class.getResourceAsStream("/properties/xrManager.properties"));
			
			if("path.root".equals(key)){
				if(-1 < System.getProperty("os.name").indexOf("Windows")){
					key = key + ".window";
				}else{
					key = key + ".linux";
				}
			}
			
			return properties.getProperty(key);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String moduleName = getValueForJava("name.module");
	public static String moduleVersion = getValueForJava("version.module");
	public static String manufacturer = getValueForJava("manufacturer");
	public static String developer = getValueForJava("developer");
	public static String lisUpperPk = getValueForJava("lisUpperPk");
	public static String description = getValueForJava("description");
	
}
