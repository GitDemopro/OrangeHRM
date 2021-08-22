package TestScripts;
import org.testng.annotations.Test;
import BusinessFunctions.Login;
public class Tc1_Login extends RootTest 
{

	@Test
	public static void verifyOrangeHRM() throws Exception
	{
		Login objlogin=new Login(brow,objProperties,strlocPath);
		//---------------------------------------------------------
		brow.startBrowserFirefox();
		brow.maximiseBrowser();
		//Login to orangeHRM
		objlogin.loginToapp("qaplanet1","lab1");
		brow.waitForPageToLoad();
		
		objlogin.logout();
		brow.closeBrowser();
		brow.QuitObject();
	}
}
