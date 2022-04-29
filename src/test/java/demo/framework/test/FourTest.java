package demo.framework.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {

	public WebDriver driver;

	@Test
	public void fourtest() throws IOException, InterruptedException {
		System.out.println("fouttest");
		driver = intializeDriver();
		driver.get("https://www.browserstack.com");
		Thread.sleep(3000);
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void closeMethod() {
		driver.close();

	}
}
