package TestScripts;
import org.testng.annotations.Test;
import BusinessFunctions.Login;
public class TC2_AddEmp extends RootTest
{

	@Test
	public static void AddEmployee() throws Exception
	{
		Login objlogin=new Login(brow,objProperties,strlocPath);
		//---------------------------------------------------------
		brow.startBrowserFirefox();
		brow.maximiseBrowser();
		//verify title
		brow.verifyTitle("OrangeHRM - New Level of HR Management");
		objlogin.loginToapp("qaplanet1","lab1");
		brow.waitForPageToLoad();
		//verify title
		brow.verifyTitle("OrangeHRM");
		objlogin.addEmp("QA","Planet");
		objlogin.verifyItemInEmpList("QA","Planet");
		objlogin.logout();
		brow.closeBrowser();
		brow.QuitObject();
	}
}
