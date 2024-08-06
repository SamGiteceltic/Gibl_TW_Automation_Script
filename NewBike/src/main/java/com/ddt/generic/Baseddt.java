package com.ddt.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseddt {
	public static int index=0;
	public static int index1=2;
	public static int row=0;
	
	public static WebDriver driver;
	@BeforeClass
	public void open() {
		driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.gibl.in/two-wheeler-insurance/");
	}
	@AfterClass
	public void close() {
		driver.quit();
	}
	
}
