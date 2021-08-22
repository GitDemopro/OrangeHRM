package GlobalVar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Global 
{
	//Global objects
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	//-------Locators-------------------------------
	public static By objUN=By.name("txtUserName");
	public static By objPWD=By.name("txtPassword");
	
	//---------------TestData----------------------------------
	public static String sBrowserName="Chrome";
	public static String sURL="http://apps.qaplanet.in/hrm";
	public static String sUsername="qaplanet1";
	public static String sPassword="lab1";
	
}
