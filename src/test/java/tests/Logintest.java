package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.Homepage;
import page.Loginpage;
import page.MyAccount;
import testBase.BaseClass;

public class Logintest extends BaseClass {
@Test
	public void loginpage() throws InterruptedException {
	try
	{
		logger.info("****Execution start here****");
	    Homepage hp=new Homepage(driver);
		hp.my_Account();
		hp.link_login();
		Loginpage lp=new Loginpage(driver); 
		lp.LoginField(properties.getProperty("Username"));
		lp.password_Field(properties.getProperty("Password"));
		lp.login_BTN();
		MyAccount my_acc=new MyAccount(driver);
		boolean account_page=my_acc.My_AccountPage();
		Assert.assertTrue(account_page);
		my_acc.Logout_Btn();
		Thread.sleep(6000);
     }
	catch(Exception e){
		Assert.fail();
	}
	   logger.info("******test execution completed****");
}
}
