package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {
	FileInputStream  fis;
	public String getPropertiesData(String key) throws Exception {
		fis=new FileInputStream("./src/test/resources/Data.properties");
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
