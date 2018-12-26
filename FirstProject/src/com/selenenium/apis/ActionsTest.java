package com.selenenium.apis;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver(); //launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);//switch to frame if its present
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
		.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']")))
		.release()
		.build()
		.perform();
		
		action.keyDown(Keys.DOWN).keyUp(Keys.UP).build().perform();
		
	}

}