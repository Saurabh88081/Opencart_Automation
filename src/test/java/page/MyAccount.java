package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement my_AccountPage;
	@FindBy(xpath = "//*[@id='column-right']//a[text()='Logout']")
	WebElement logout_link;
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement Logout_ContinueBTN;

	public boolean My_AccountPage() {
		try {
			return (my_AccountPage.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void Logout_Btn() {
		logout_link.click();
	}
	public void Logout_Continue() {
		Logout_ContinueBTN.click();
	}
}
