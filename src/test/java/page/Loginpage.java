package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {

	public Loginpage(WebDriver driver) {
		super(driver);
	}
	//locators
	@FindBy(xpath="//*[@id='input-email']") WebElement login_Field;
	@FindBy(xpath="//*[@id='input-password']") WebElement pwd_field;
	@FindBy(xpath="//input[@value='Login']")WebElement login_Btn;
	
	//action
	
	public void LoginField(String s) {
		login_Field.sendKeys(s);
	}
	public void password_Field(String pwd) {
		pwd_field.sendKeys(pwd);
	}
	public void login_BTN() {
		login_Btn.click();
	}
}
