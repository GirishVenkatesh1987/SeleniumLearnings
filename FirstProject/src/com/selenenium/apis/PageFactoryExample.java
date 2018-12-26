package com.selenenium.apis;

import org.eclipse.jetty.util.security.Password;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryExample {
	
	

	WebDriver driver = new ChromeDriver(); // launch chrome
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	public PageFactoryExample() {
		PageFactory.initElements(driver, this);
	}
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		PageFactoryExample pf = new PageFactoryExample();
		
		pf.driver.get("https://www.freecrm.com/"); // enter URL
		
		pf.username.sendKeys("naveenk");
		pf.password.sendKeys("test@123");
		pf.login.click(); //login button
		
	}

}
