package demo.framework.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	
	public WebDriver driver;

	@Test
	public void testtwo() throws IOException, InterruptedException {
		System.out.println("Testtwo");
		driver = intializeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.close();

	}
}
