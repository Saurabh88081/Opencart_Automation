package tests;

import org.testng.annotations.Test;

import page.Homepage;
import page.RegisterPage;
import testBase.BaseClass;

public class RegisterTest extends BaseClass {

	@Test
	public void registerTest() throws InterruptedException {
		Homepage hp = new Homepage(driver);
		RegisterPage rp = new RegisterPage(driver);
		//hp.navigation_link();
		//ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		//driver.switchTo().window(newTb.get(1));
		//System.out.println("switched to new tab");
		hp.my_Account();
		Thread.sleep(2000);
		hp.link_Register();

		rp.firstname_inputfield("Surabhi");
		rp.LN_INputField("Singh");
		rp.Email_Field("mack@gmail.com");
		rp.field_tel("5778458489");
		Thread.sleep(3000);
		rp.Input_Pwd("Closecart@123");
		Thread.sleep(3000);
		rp.cnf_Btn("Closecart@123");
		Thread.sleep(3000);
		rp.agree_btn();
		Thread.sleep(3000);
		rp.Continue_Btn();
		Thread.sleep(5000);
	}

	
}
