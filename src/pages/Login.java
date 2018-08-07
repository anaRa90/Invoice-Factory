package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends PageObject{

	
	
	public Login(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="login-form-email")
	WebElement email;
	
	@FindBy(id = "login-pass")
	WebElement password;
	
	@FindBy(id = "login-form-btn")
	WebElement buttonLog;
	
	@FindBy (xpath = "//div[contains(text(),'email field is required')]")
	 WebElement required_E;
	
	@FindBy (xpath = "//div[contains(text(),'password field is required')]")
	 WebElement required_P;
	
	@FindBy(xpath = "//div[contains(text(),'a valid email')]")
	WebElement valid_email;
	
	@FindBy(xpath="//div[contains(text(),'at least 6 characters')]")
	WebElement short_P;
	
	@FindBy(xpath="//div [contains(text(),'than 20 characters')]")
	WebElement long_P;
	
	@FindBy(className="v-snack__content")
	WebElement in_credentials;
	
//	unos podataka za logovanje
	public void logIn(String email, String password) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(buttonLog));
		this.email.click();
		this.email.sendKeys(email);
		this.password.click();;
		this.password.sendKeys(password);
		
		buttonLog.click();
	}
	
	//verifikacija da se prikazuje poruka da je mail obavezan
	public boolean requiredE() {
		wait.until(ExpectedConditions.visibilityOf(required_E));
		return required_E.isDisplayed();
	}
	
	//verifikacija da se prikazuje poruka da je password obavezan
	public boolean requiredP() {
		wait.until(ExpectedConditions.visibilityOf(required_P));
		return required_P.isDisplayed();
	}
	
	//verifikacija da se poruka za invalid email prikazuje
	public boolean validEmail() {
		wait.until(ExpectedConditions.visibilityOf(valid_email));
		return valid_email.isDisplayed();
	}
	
	//verifikacija da je password kratak
	public boolean shortP() {
		wait.until(ExpectedConditions.visibilityOf(short_P));
		return short_P.isDisplayed();
	}
	
	//verifikacija da je password predug
	public boolean longP() {
		wait.until(ExpectedConditions.visibilityOf(long_P));
		return long_P.isDisplayed();
	}
	
	//verifikacija da se pokazuje poruka da mail ili password nije tacan
	public boolean inCredentials() {
		wait.until(ExpectedConditions.visibilityOf(in_credentials));
		return in_credentials.isDisplayed();
	}
	
	//verifikacja da se polje za mail prikazuje kako bi se verifikovao logout
	public boolean email_isDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(email));
		return email.isDisplayed();
	}
}


