package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		logger.info("BaseUrl is passed");

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is entered");

		lp.setPassword(password);
		logger.info("Password is entered");
		lp.clickSubmit();
		logger.info("Loginbtn clicked");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Testcase passed");
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Testcase failed");
		}

	}

}
