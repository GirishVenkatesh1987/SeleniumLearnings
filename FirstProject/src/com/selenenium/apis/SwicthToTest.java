package com.selenenium.apis;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwicthToTest {

	public static void main(String[] args) {
		
		WebDriver dri = new FirefoxDriver();
		Set<String> handles = dri.getWindowHandles();
		for (String handle : handles) {
			dri.switchTo().window(handle);
		}
		
		dri.switchTo().alert();
	}
}
