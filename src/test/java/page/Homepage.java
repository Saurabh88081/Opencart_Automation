package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {

	WebDriver driver;

	public Homepage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//a[@href='https://demo.opencart.com/']")
	WebElement Navigation_Link;
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MY_Account;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register_link;
	@FindBy(xpath = "//a[text()='Login']")
	WebElement Login_link;

	// Action
//	public void navigation_link() {
//		Navigation_Link.click();
//	}
	public void my_Account() {
		MY_Account.click();
	}

	public void link_Register() {
		register_link.click();
	}

	public void link_login() {
		Login_link.click();
	}
}
