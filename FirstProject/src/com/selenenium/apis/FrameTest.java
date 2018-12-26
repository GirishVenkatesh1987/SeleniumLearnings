package com.selenenium.apis;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameTest {
	
	public static void main(String[] args) {
		WebDriver dri = new FirefoxDriver();
		List<WebElement> frames = dri.findElements(By.tagName("frame"));
		frames.addAll(dri.findElements(By.tagName("iframe")));
		for (WebElement webElement : frames) {
			dri.switchTo().frame(webElement);			
		}
		
	}

}
