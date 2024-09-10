package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement FirstName_InputField;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement LName_IF;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email_Field;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement Tel_field;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pwd_Field;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement Cnfrm_pwd;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement btn_agree;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continue_btn;

	// Action
	public void firstname_inputfield(String fs) {
		FirstName_InputField.sendKeys(fs);
	}

	public void LN_INputField(String ls) {
		LName_IF.sendKeys(ls);
	}

	public void Email_Field(String eId) {
		email_Field.sendKeys(eId);
	}

	public void field_tel(String t) {
		Tel_field.sendKeys(t);
	}

	public void Input_Pwd(String p) {
		pwd_Field.sendKeys(p);
	}

	public void cnf_Btn(String cB) {
		Cnfrm_pwd.sendKeys(cB);
	}
	public void agree_btn() {
		btn_agree.click();
	}

	public void Continue_Btn() {
		continue_btn.click();
	}

	
}
