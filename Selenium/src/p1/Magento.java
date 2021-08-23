package p1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Magento {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://account.magento.com/customer/account/create/");
	driver.findElement(By.name("firstname")).sendKeys("assam");
	driver.findElement(By.name("lastname")).sendKeys("pur");
	
	WebElement w=driver.findElement(By.name("individual_role"));
	Select s=new Select(w);
	s.selectByVisibleText("Tech");
//	List<WebElement> l=new ArrayList<>();
//	l=s.getAllSelectedOptions();
//	for(int i=1;i<=l.size();i++)
//	{
//		System.out.println(l.get(i).getText());
//	}
	}

}
