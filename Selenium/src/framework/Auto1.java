package framework;



public class Auto1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Keywords k=new Keywords();
		k.launchbrowser("chrome");
		k.site("https://account.magento.com/customer/account/create");
		Thread.sleep(10000);
		k.findelements1("name","firstname");
		k.sendkey("sendkeys", "sf");
		k.findelements1("id", "lastname");
		k.sendkey("sendkeys", "man");
		k.findelements1("id", "company_type");
		k.dropdown("byindex","1");
		k.findelements1("id", "agree_terms");
		k.click();
		k.driver.close();
	}

}
