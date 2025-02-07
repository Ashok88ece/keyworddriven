package com.lao.actionKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.lao.executionEngine.executionEngine;
import com.lao.utilities.ExcelUtilities;

public class ActionKeywords {

	static WebDriver driver;
	//OpenBrowser()

	public static void openBrowser() {
		String Path = "C:\\Selenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	//goToUrl()
	public static void goToUrl() {
		driver.get(ExcelUtilities.dataColumnvalue);

	}

	//enterUserName()
	public static void enterUserName() {
		WebElement username = driver.findElement(executionEngine.locator);
		username.sendKeys(ExcelUtilities.dataColumnvalue);
	}

	//enterPassword()

	public static void enterPassword() {
		WebElement password = driver.findElement(executionEngine.locator);
		password.sendKeys(ExcelUtilities.dataColumnvalue);
	}

	//clickLogin()

	public static void clickLogin() {
		WebElement loginbtn = driver.findElement(executionEngine.locator);
		loginbtn.click();
	}

	
	  public static void clickdirectory() {
	  
	  WebElement directory = driver.findElement(executionEngine.locator);
	  directory.click(); 
	  
	  }
	/* 
	 * public static void selectQaLead() {
	 * 
	 * WebElement dropdown = driver.findElement(By.id("searchDirectory_job_title"));
	 * 
	 * Select select = new Select(dropdown); select.selectByVisibleText("QA Lead");
	 * 
	 * } public static void clickSearch() { WebElement searchbtn =
	 * driver.findElement(By.id("searchBtn")); searchbtn.click(); }
	 */

}
