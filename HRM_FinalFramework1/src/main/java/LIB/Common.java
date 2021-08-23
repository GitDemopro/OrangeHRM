package LIB;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import GlobalVar.Global;
public class Common extends Global
{
	
	//Start fire fox Browser
	public void startBrowserFirefox()
	{
		switch (sBrowserName)
		{
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\D-Drive\\FromC\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "D:\\D-Drive\\FromC\\IEDriverServer.exe"); 
			InternetExplorerOptions caps =new InternetExplorerOptions();
			//It will avoid security domain warning message
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			//It will accept ssl certificate
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			driver = new InternetExplorerDriver(caps);
			break;
		case "Chrome":	
			System.setProperty("webdriver.chrome.driver", "D:\\D-Drive\\FromC\\chromedriver.exe"); 
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("Invalid Driver");
			break;
		}
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, 60);
	}
	//Maximize Browser
	public void maximiseBrowser()
	{
		driver.manage().window().maximize();
	}
	//Find WebElement 
	public WebElement FindElementByLoc(String identifier,String locator)
	{
		WebElement e=null;
		switch (identifier)
		{
		case "id" : 
			e=driver.findElement(By.id(locator));
		              	break;
		case "className" : 
			e=driver.findElement(By.className(locator));
					  	break;
		case "tagName" : 
			e=driver.findElement(By.tagName(locator));
						break;
		case "name" : 
			e=driver.findElement(By.name(locator));
						break;		 
		case "linkText" : 
			e=driver.findElement(By.linkText(locator));
						break;		 
		case "partialLinkText" : 
			e=driver.findElement(By.partialLinkText(locator));
						break;          
		case "cssSelector" : 
			e=driver.findElement(By.cssSelector(locator));
						break;
		case "xpath" :
			e=driver.findElement(By.xpath(locator));
						break;
		default : 
			System.out.println("Locator not found");
       	 			e=null;
		}
		return e;
	}
	
	//open web page
	public void OpenApp()
	{
		driver.get(sURL);		
	}

	//Sendkey general method
	public void sendKeys(String identifier,String locator,String content)
	{		
		WebElement e=FindElementByLoc(identifier, locator);
		e.sendKeys(content);		
	}
	//Way 2
	public void typedata(By obj, String content)
	{
		driver.findElement(obj).sendKeys(content);
	}
	
	//Clear text  field method
	public void ClearTextField(String identifier,String locator)
	{
	
		WebElement e=FindElementByLoc(identifier, locator);
		e.clear();		
	}
	//click general method
	public void click(String identifier,String locator)
	{
		WebElement e=FindElementByLoc(identifier, locator); 
		e.click();
	}
	//verify title of the page
	public void verifyTitle(String title)
	{
		if(driver.getTitle().equals(title))
		{
			System.out.println(title+" displayed" );
		}
		else
		{
			System.out.println("Failed to display "+title );
			return;
		} 		
	} 

	//Wait until the Element is present
	public void waitUntilElementPresent(String elementpath)
	{
		WebElement elementpresent=(new WebDriverWait(driver,10)).
		until(ExpectedConditions.presenceOfElementLocated
				(By.xpath(elementpath)));
	}
	
	//wait for title
	public void waitforTitle(String title)
	{
		wait.until(ExpectedConditions.titleIs(title));
	}
	//Verify Text
	public void verifyText(String identifier,String locator,String text)
	{
		WebElement e=FindElementByLoc(identifier, locator);
		if (e.getText().equals(text))
		{
			System.out.println(text+" displayed");
		}
		else
		{
			System.out.println(text+"Did not displayed");
		}
	}
	//verify element present
	public void verifyElementPresent(String identifier,String locator)
	{
		WebElement e=FindElementByLoc(identifier, locator);
		if (e.isDisplayed())
		{
			System.out.println("Element present");
		}
		else
		{
			System.out.println("Element is not present");
		}
	}
	
	//Verify element enabled or not
	public void VerifyElementEnabled(String identifier,String locator)
	{
		WebElement e=FindElementByLoc(identifier, locator);
		if(e.isEnabled())
		{
			System.out.println("Element enabled");
		}
		else
		{
			System.out.println("Element disabled");
		}
	}
	
	//Thread sleep
	public void sleepThread(long sleeptime) 
	{
		try
		{
			Thread.sleep(sleeptime);
		} catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	//Wait for page to load
	public void waitForPageToLoad()
	{
		try {
			for(int i=0;i< 50;)
			{
				if (driver.getTitle().length()!=0 )
				{
					System.out.println("Page loaded");
					i=51;
					break;
				}else {
					Thread.sleep(1000);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}			
	}
	
	//select frame by id
	public void selectFrameById(String locator)
	{
		driver.switchTo().frame(locator);
	}
	//Select frame default method   
	public void selectFrameDefault(){
		driver.switchTo().defaultContent();
	}
	
	//getting data from table and verifying it with the required text  
	public void verifyElementInTable(String xpathlocator,String text)
	{
		boolean a=false;
		List<WebElement> tdlist = driver.findElements(By.xpath(xpathlocator));
		for(WebElement el: tdlist)  
		{
			if (el.getText().equals(text))
			{		
				a=true;	
				break;
			}
		}
		
		if(a==true)
		{
			System.out.println(text+" was identifed");				
		}
		else
		{
			System.out.println( text+" was not identifed");
		}
	}
	//Start action
	public void startAction()
	{
		action =new Actions(driver);
	}
	//move to element
	public void MouseOverToElement(String identifier,String locator)
	{		
		WebElement e=FindElementByLoc(identifier, locator);
		action.moveToElement(e).perform();
	}
	
	//close 
	public void closeBrowser()
	{
		driver.close();
	}
	//Quit
	public void QuitObject()
	{
		driver.quit();
	}
}