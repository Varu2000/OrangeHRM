package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@name='username']")
	WebElement name;
	
	@FindBy(css = "input[type='password']")
	WebElement pass;
	
	@FindBy(css = "button[type='submit']")
	WebElement lgnbtn;
	
	public void login(String username, String password) {
		name.sendKeys(username);
		pass.sendKeys(password);
		lgnbtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Dashboard dashAfterLog() {
		Dashboard dash = new Dashboard(driver);
		return dash;
	}
	
	public PMI PMIAfterLog() {
		return new PMI(driver);
		
	}
	
}
