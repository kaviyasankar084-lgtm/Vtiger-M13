package genericUtility;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	@DataProvider(name="loginData")
	
	public Object[][] data() {
		HashMap<String,String>h1 = new HashMap<String,String>();
		h1.put("username", "admin");
		h1.put("password", "admin");
		
		HashMap<String,String>h2 = new HashMap<String,String>();
		h2.put("username", "adminefa");
		h2.put("password", "admin321");
		
		HashMap<String,String>h3 = new HashMap<String,String>();
		h3.put("username", "admak");
		h3.put("password", "admin3akm");
		Object obj[][]= {{h1},{h2},{h3}};
		return obj;
	}
}
