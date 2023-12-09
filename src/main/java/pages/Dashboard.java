package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends AbstractComponents{
WebDriver driver;
	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//div[@class='orangehrm-dashboard-widget-body-nocontent']/p[@class='oxd-text oxd-text--p']")
	WebElement leaveToday;

	
	
	public String textLeave() {
		String text = leaveToday.getText();
		return text;
	}
}
