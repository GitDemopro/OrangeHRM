package BusinessFunctions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import LIB.Common;

public class Admin 
{
	Common browser;
	Properties locators;
	//constructor with one argument.
	public Admin(Common br, Properties loc,String locPath) throws FileNotFoundException, IOException
	{
		browser=br;
		locators=loc;
		locators.load(new FileInputStream(locPath));
	}
	

	//Add location
	public void addlocation()
	{
		
	}	
	
	
}
