package com.qa.ispeakbetter.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.LoginPage;
import com.qa.ispeakbetter.util.Constants;

public class LoginPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1, enabled = true, description = "I Speak Better Main Page Title")
	public void testPageTitle() {
		String title = loginPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE_STRING);
	}

	@Test(priority = 2, enabled = true, description = "Login System in I Speak Better")
	public void testLogin() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
	}

	@Test(priority = 3, enabled = true, description = "Flexible Package")
	public void filexiblePackage() {
		Assert.assertEquals(loginPage.duration(), "60");
		Assert.assertEquals(loginPage.subscribed(), "2 weeks");
		Assert.assertEquals(loginPage.weeklyClass(), "2 Classes");
		Assert.assertEquals(loginPage.program(), "Conversational English");
	}

	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}