package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;
import pages.PMI;
import utils.PropertiesReader;

public class Test_001 extends BasePage {
	@Test(enabled = true)
	public void addEmployee() throws InterruptedException {
		String[] names = { PropertiesReader.getData("empId"), PropertiesReader.getData("fullName"),
				PropertiesReader.getData("lastName"), PropertiesReader.getData("jobTitle"),
				PropertiesReader.getData("empStatus"), PropertiesReader.getData("subUnit"),
				PropertiesReader.getData("supName_rec") };
		
		List<String> rec = Arrays.asList(names);

		LoginPage log = setUp();
		log.login(PropertiesReader.getData("user"), PropertiesReader.getData("password"));
		PMI pmi = log.PMIAfterLog();
		pmi.goToAddEmp();
		pmi.addEmp();
		pmi.createLog(PropertiesReader.getData("userName"), PropertiesReader.getData("userPassword"),
				PropertiesReader.getData("userPassword"));
		String toaster = pmi.save();
		Assert.assertTrue(toaster.contains("Successfully Saved"));
		pmi.job();
		pmi.report_to();
		pmi.EmployeeList();
		Thread.sleep(2000);
		List<String> recordList = pmi.getRecord();
		Assert.assertEquals(recordList, rec);
	}

	@Test
	public void passwordInvalid() {

		LoginPage log = setUp();
		log.login(PropertiesReader.getData("user"), PropertiesReader.getData("password"));
		PMI pmi = log.PMIAfterLog();
		pmi.goToAddEmp();
		pmi.addEmp();
		pmi.createLog(PropertiesReader.getData("userName"), PropertiesReader.getData("userPassword"),
				PropertiesReader.getData("confirmPassword"));
		String error = pmi.getPassError();
		Assert.assertTrue(error.contains("dd not match"));
	}
}
