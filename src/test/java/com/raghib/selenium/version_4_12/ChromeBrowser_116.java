package com.raghib.selenium.version_4_12;

/**
Question - Without WebDriverManager in pom dependency firefox and edge is running or no need to check.
Answer - Without WebDriverManager, we are able to run the script in [Chrome, Firefox and Edge Browser].
 
You must download chromedriver from below location for chrome version - 116 onwards.
https://googlechromelabs.github.io/chrome-for-testing/
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.raghib.selenium.BaseClass;

public class ChromeBrowser_116 extends BaseClass {

	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";

	public static String url = "https://www.google.com";
	public static String googleSearchBox = "//*[@id='APjFqb']";
	public static String linkPath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/a/h3";

	public static void main(String[] args) {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);

		WebElement element = driver.findElement(By.xpath(googleSearchBox));

		Duration duration = Duration.ofSeconds(30);

		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(googleSearchBox)));

		element.sendKeys("selenium");
		element.sendKeys(Keys.ENTER);

		WebDriverWait wait1 = new WebDriverWait(driver, duration);
		wait1.until(ExpectedConditions.elementToBeClickable((By.xpath(linkPath)))).click();

		//BaseClass.quitDriver();
	}
}
