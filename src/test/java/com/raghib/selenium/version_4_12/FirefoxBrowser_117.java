package com.raghib.selenium.version_4_12;

/**
Reference:-
https://www.youtube.com/watch?v=Wml9Pt5OCho
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.raghib.selenium.BaseClass;

public class FirefoxBrowser_117 extends BaseClass {

	public static WebDriver driver;
	public static String browserName = "firefox";
	public static String browserVersion = "117";

	public static String url = "https://www.google.com";
	public static String googleSearchBox = "//*[@id='APjFqb']";
	public static String linkPath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/a/h3";

	public static void main(String[] args) {
		//Firefox Browser
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
