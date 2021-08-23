package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class Datadriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("/Selenium/property/datadriven.properties");
		Properties p=new Properties();
		p.load(fis);
		ChromeDriver driver=new ChromeDriver();
		driver.get(p.getProperty("url"));
		
	}

}
