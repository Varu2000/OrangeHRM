package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.PropertiesReader;

public class PMI extends AbstractComponents {

	public PMI(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='button']//i[@class='oxd-icon bi-plus oxd-button-icon']")
	WebElement addEmp;
	
	@FindBy(name = "firstName")
	WebElement frstName;

	@FindBy(name = "middleName")
	WebElement midName;
	
	@FindBy(name = "lastName")
	WebElement lastName;
	
	@FindBy(xpath = "//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active']")
	WebElement empCode;
	
	@FindBy(className = "oxd-switch-wrapper")
	WebElement logSwitch;
	
	@FindBy(xpath = "(//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement userName;
	
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement radEnable;
	
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	WebElement radDisable;
	
	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement password;
	
	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement confmPassword;
	
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	WebElement passwordError;
	
	@FindBy(css = "button[type='submit']")
	WebElement saveBtn;
	
	@FindBy(css = "#oxd-toaster_1")
	WebElement toaster;
	
	//side menu
	@FindBy(xpath = "//a[text()='Job']")
	WebElement Job;
	
	@FindBy(xpath = "//a[text()='Report-to']")
	WebElement report;
	
	@FindBy(xpath = "(//div[@class='orangehrm-action-header']//button[@type='button'])[1]")
	WebElement addSupervisors;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement superName;
	
	@FindBy(css = "i[class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	WebElement reportingMthod;
	
	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	WebElement jobTitle;
	
	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]")
	WebElement subUnit;
	
	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[5]")
	WebElement empStatus;
	
	@FindBy(xpath = "//a[.='Employee List']")
	WebElement EmpList;
	
	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	WebElement empName;
	
	@FindBy(xpath = "//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active']")
	WebElement empId;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement search;
	
	@FindBy(xpath = "//div[@role='option']")
	List<WebElement> options;
	
	@FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell']//div[@data-v-6c07a142]")
	List<WebElement> records;
	
	public void goToAddEmp() {
		PMItab();
		addEmp.click();
	}
	
	public void addEmp() {
		frstName.sendKeys(PropertiesReader.getData("firstName"));
		midName.sendKeys(PropertiesReader.getData("midName"));
		lastName.sendKeys(PropertiesReader.getData("lastName"));
		empCode.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE),PropertiesReader.getData("empId"));
	}
	
	public void createLog(String username, String pass, String confirmPass) {
		logSwitch.click();
		userName.sendKeys(username);
		Actions action =new Actions(driver);
		action.moveToElement(radDisable).click().build().perform();
		password.sendKeys(pass);
		confmPassword.sendKeys(confirmPass);
	}
	
	public String getPassError() {
		String error = passwordError.getText();
		System.out.println(error);
		return error;
	}
	
	public String save() {
		saveBtn.click();
		waitForEle(toaster);
		String toast = toaster.getText();
		System.out.println(toast);
		return toast;
	}
	
	public void job() throws InterruptedException {
		Job.click();
		Thread.sleep(1000);
		jobtitle(PropertiesReader.getData("jobTitle"));
		subUnit(PropertiesReader.getData("subUnit"));
		empStatus(PropertiesReader.getData("empStatus"));
		saveBtn.click();
	}
	
	public void report_to() throws InterruptedException {
		report.click();
		addSupervisors.click();
		supName(PropertiesReader.getData("supervisorName"));
		repMethd(PropertiesReader.getData("reportMethod"));
		saveBtn.click();
	}
	
	public void repMethd(String reprtmethod) {
		reportingMthod.click();
		for(WebElement option:options) {
			String opt = option.getText();
//			System.out.println(opt);
			if(opt.contains(reprtmethod)) {
				option.click();
				break;
			}
		}
	}
	
	public void supName(String supervisorName) throws InterruptedException {
		superName.sendKeys(supervisorName);
		Thread.sleep(3000);
		for (WebElement option : options) {
			String opt = option.getText();
//			System.out.println(opt);
			if(opt.contains(supervisorName)){
				option.click();
				break;
			}
		}
	}
	public void jobtitle(String job) {
		jobTitle.click();
		for (WebElement option : options) {
			String opt = option.getText();
//			System.out.println(opt);
			if(opt.contains(job)) {
				option.click();
				break;
			}
		}
		
	}
	
	public void subUnit(String sub) {
		subUnit.click();
		for (WebElement option : options) {
			String opt = option.getText();
//			System.out.println(opt);
			if(opt.contains(sub)) {
				option.click();
				break;
			}
		}
		
	}
	public void empStatus(String status) {
		empStatus.click();
		for (WebElement option : options) {
			String opt = option.getText();
//			System.out.println(opt);
			if(opt.contains(status)) {
				option.click();
				break;
			}
		}
		
	}
	
	public void EmployeeList() {
		EmpList.click();
		empName.sendKeys(PropertiesReader.getData("firstName"));
		empId.sendKeys(PropertiesReader.getData("empId"));
		search.click();
	}
	
	public List<String> getRecord() {
		List<String> recList = records.stream().map(x->x.getText()).collect(Collectors.toList());
		System.out.println(recList);
		return recList;
	}
	
	
	
	
	
	
}
