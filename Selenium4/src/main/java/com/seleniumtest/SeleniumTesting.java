package com.seleniumtest;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTesting {

	public static void main(String[] args) {

		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(
				"C:\\Users\\HP\\eclipse-workspace\\Selenium4\\target\\Report.html");
		ExtentReports report = new ExtentReports();
		ExtentTest test;

		Logger log = Logger.getLogger(SeleniumTesting.class);
		DOMConfigurator.configure("log4j2.xml");

		report.attachReporter(htmlReport);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		log.warn("Chrome driver is launched");

		driver.get("https://www.facebook.com/");
		log.info("Application is launched");
		driver.manage().window().maximize();

		test = report.createTest("Login Module");
		test.createNode("Username");
		test.assignAuthor("Kundan").assignCategory("Login");
		test.createNode("Password");
		log.info("Login Module testing is completed");

		String title = driver.getTitle();
		Object title1 = driver.getTitle();
		log.info("Title of application is : " + title1);
		test = report.createTest(title);
		test.createNode("Menu");
		test.createNode(driver.getPageSource());
		test.createNode("Contact Us");
		test.createNode("About Us");

		String url = driver.getCurrentUrl();
		Object url1 = driver.getCurrentUrl();
		log.info("Url of application is : " + url1);
		test = report.createTest(url);
		test.assignCategory("From Logout");
		test.createNode("Logout button");

		report.flush();
		driver.quit();

	}

}
