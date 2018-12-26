package com.selenenium.apis;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MaximizeTest {

	public static void main(String[] args) {
		WebDriver dri = new FirefoxDriver();
		dri.manage().window().maximize();
		Dimension dim = new Dimension(600, 800);
		dri.manage().window().setSize(dim);
	}
}
