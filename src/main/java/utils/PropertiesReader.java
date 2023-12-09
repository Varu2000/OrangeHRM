package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	static Properties prop;

	public static String getData(String propName) {
		prop = new Properties();
		try {
			String filePath = System.getProperty("user.dir") + "/src/main/java/resources/data.properties";
			prop.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String property = prop.getProperty(propName);
		return property;
	}

}
