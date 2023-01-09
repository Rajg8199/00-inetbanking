package com.inetbanking.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.AddCustomerPage;
import com.inetbanking.PageObject.LoginPage;

public class TC_AddCustomerPage_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.ClickAddNewCustomer();

		logger.info("Providing customer details...");
		addcust.custName("Praveen");
		addcust.custgender("male");
		addcust.custDob("12", "3", "2121");
		addcust.custAddress("ALpha2");
		addcust.custCity("Noida");
		addcust.custState("UttarPradesh");
		addcust.custPinno("233231");
		addcust.custTelephoneno("9834432433");

		String email = randomstring() + "@gmail.com";
		addcust.custEmailId(email);
		addcust.custPassword("ad323232wdw");
		addcust.custSubmit();
		Thread.sleep(3000);

		logger.info("Validation started...");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Testcase passes");
		} else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Testcase failed");
		}

	}

}
