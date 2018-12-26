package com.selenenium.apis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementTest {
	public static void main(String[] args) {
		WebDriver dri = new FirefoxDriver();
		WebElement ele = dri.findElement(By.id("test"));
		System.out.println(ele.getAttribute("name"));
		System.out.println(ele.getTagName());
		System.out.println(ele.getText());
	}

}
