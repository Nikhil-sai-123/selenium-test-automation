package com.qaautomation.selenium_automation_project01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public static void verifyLogin() {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-features=PasswordLeakDetection");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://the-internet.herokuapp.com/login?utm_source=chatgpt.com");
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		String successmsg = driver.findElement(By.cssSelector(".flash")).getText();
		String expectedmsg = "You logged into a secure area!";
		
		//System.out.println(driver.getPageSource());
		//"You logged into a secure area!"
		//System.out.println(successmsg);
		//Assert.assertEquals(expectedmsg,successmsg);
		Assert.assertTrue(successmsg.contains(expectedmsg),"You logged into a secure area!");
		
		driver.close();
		
	}

}
