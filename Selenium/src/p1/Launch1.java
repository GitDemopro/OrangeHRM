package p1;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter expected title");
//		String etitle=sc.nextLine();
		System.setProperty("webdriver.chrome.driver","E:\\java programs\\aug2rev1\\seleniumNeww\\Selenium\\drivers\\chromedriver.exe" );
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com");
//		String atitle=driver.getTitle();
//		if(etitle.equalsIgnoreCase(atitle))
//		{
//			System.out.println("success");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
//		driver.findElement(By.id("search")).sendKeys("see you again");
//		driver.findElement(By.id("search-icon-legacy")).click();
//		driver.findElementByLinkText("Official Video").click();
//		System.out.println(driver.getTitle());
	}

}
