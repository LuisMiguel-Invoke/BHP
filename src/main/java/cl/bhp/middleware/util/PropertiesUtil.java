package cl.bhp.middleware.util;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesUtil {
	private static InputStream input = null;


	public static Properties getPropertiesEnvironment(String fileName) {
		String propertiesFile = "";
		Map<String, String> env = System.getenv();
		for (Entry<String, String> envName : env.entrySet()) {
			if (envName.getKey().equals(fileName)) {
				propertiesFile = envName.getValue();
			}
		}
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(propertiesFile));
		} catch (IOException e1) {
			System.out.println("Property error :"+ e1.toString());
		}
		return prop;
	}
	
public Properties getLocalProperties() {
		
		Properties prop = new Properties();
		try {
			prop.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
      	return prop;
	}
}