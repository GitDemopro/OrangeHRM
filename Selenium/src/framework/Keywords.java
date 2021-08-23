package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Keywords {

	static WebDriver driver;
	WebElement w;
		public void launchbrowser(String name)
	{
		if(name.equalsIgnoreCase("chrome"))
	{
			driver=new ChromeDriver();
	}
		if(name.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		
	}

		public void site(String url)
		{
			driver.get(url);
		}
		public WebElement findelements1(String s1,String s2) {
//		{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(s1.equalsIgnoreCase("id"))  w=driver.findElement(By.id(s2));
			if(s1.equalsIgnoreCase("name"))   w=driver.findElement(By.name(s2));
			if(s1.equalsIgnoreCase("classname"))   w=driver.findElement(By.className(s2));
			if(s1.equalsIgnoreCase("plinktext"))   w=driver.findElement(By.partialLinkText(s2));
			if(s1.equalsIgnoreCase("xpath"))   w=driver.findElement(By.xpath(s2));
			if(s1.equalsIgnoreCase("css"))   w=driver.findElement(By.cssSelector(s2));
			return w;
				
		}
		public void sendkey(String action,String value)
		{
			if(action.equalsIgnoreCase("sendkeys")) w.sendKeys(value);
		}
		public void click()
		{
			w.click();
		}
		public void dropdown(String type,String data)
		{
			Select s=new Select(w);
			if (type.equalsIgnoreCase("byvalue")) s.selectByValue(data); 
			if (type.equalsIgnoreCase("byindex")) 
			{ String s1=new String(data); 
			Integer data1=Integer.parseInt(s1);
			s.selectByIndex((data1));
			}
			if (type.equalsIgnoreCase("byvisibletext")) s.selectByVisibleText(data);
			
				
		}
}
		

