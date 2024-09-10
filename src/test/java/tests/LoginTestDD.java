package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.Homepage;
import page.Loginpage;
import page.MyAccount;
import testBase.BaseClass;
import utils.DataProviders;

public class LoginTestDD extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDt(String email, String pwd, String exp) {
		try {
			logger.info("****Execution start here****");

			// Homepage

			Homepage hp = new Homepage(driver);
			hp.my_Account();
			hp.link_login();

			// Loginpage

			Loginpage lp = new Loginpage(driver);
			lp.LoginField(email);
			lp.password_Field(pwd);
			lp.login_BTN();
			Thread.sleep(4000);

			// MyAccount Page

			MyAccount my_acc = new MyAccount(driver);
			boolean account_page = my_acc.My_AccountPage();
			System.out.println(account_page);
//			Assert.assertTrue(account_page);
//			my_acc.Logout_Btn();

			if (exp.equalsIgnoreCase("valid")) {
				if (account_page == true) {
					my_acc.Logout_Btn();
					my_acc.Logout_Continue();
					Thread.sleep(6000);
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (account_page == true) {
					my_acc.Logout_Btn();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("******test execution completed****");
	}

}
