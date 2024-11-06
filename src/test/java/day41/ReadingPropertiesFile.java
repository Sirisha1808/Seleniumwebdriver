package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {

		//Create object of properties file
		Properties propertiesobj = new Properties();
		
		//location of the properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\config.properties");
		
		//Loading properties file
		propertiesobj.load(file);
		
		//Reading data from properties file
		String url=propertiesobj.getProperty("appurl");
		String email=propertiesobj.getProperty("email");
		String pwd=propertiesobj.getProperty("password");
		String orid=propertiesobj.getProperty("orderid");
		String custid=propertiesobj.getProperty("customerid");
		
		System.out.println(url+"  "+email+"  "+pwd+"  "+orid+"  "+custid);
		
		//Reading all keys from properties file
//		Set<String> keys=propertiesobj.stringPropertyNames();
//		// Print all keys
//            System.out.println(key);
		 
            Set<Object> keys=propertiesobj.keySet();
            System.out.println("Keys in the properties file:");
              System.out.println(keys);
        
          //Reading all the value from properties file
          Collection<Object> values=propertiesobj.values();
              System.out.println(values);
        
          file.close();
	}
	}


