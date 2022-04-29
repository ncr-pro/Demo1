package demo.framework.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	
	public WebDriver driver;

	@Test
	public void threeTest() throws IOException, InterruptedException {
		System.out.println("threetest");
		WebDriver driver = intializeDriver();
		driver.get("https://www.flipkart.com");
		Thread.sleep(3000);
		driver.close();

	}
}
