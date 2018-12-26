package com.selenium.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebdriverEventListnerTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		EventFiringWebDriver eventdriver = new EventFiringWebDriver(driver);
		EventCapture eventListnerMethods = new EventCapture();
		eventdriver.register(eventListnerMethods);
		eventdriver.navigate().to("https://www.google.com/");
		eventdriver.quit();
		eventdriver.unregister(eventListnerMethods);
		
	}

}
