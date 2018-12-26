package com.selenenium.apis;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.listeners.WebdriverEventListnerTest;
import com.sun.jna.platform.FileUtils;

public class ScreenshotTest {
	
	public static void main(String[] args) throws IOException {
		WebDriver dri = new FirefoxDriver();
		TakesScreenshot screenshot = (TakesScreenshot) dri;  
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(file, new File("test.png"));
	}

}
