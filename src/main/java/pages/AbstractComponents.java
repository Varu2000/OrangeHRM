package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='oxd-main-menu-item'])[1]")
	WebElement admin;

	@FindBy(xpath = "//a[@class='oxd-main-menu-item']//span[.='PIM']")
	WebElement PMI;

	public void adminTab() {
		waitForEle(admin);
		admin.click();
	}
	
	public void PMItab() {
		waitForEle(PMI);
		PMI.click();
	}

	public void SelectByText(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}

	public void waitForEle(WebElement ele) {
		WebDriverWait wait = new  WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
