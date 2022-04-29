package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
		
	WebDriver driver;
	public Properties pro;
	@SuppressWarnings("deprecation")
	public WebDriver intializeDriver() throws IOException {
	pro = new Properties();
	String propath= System.getProperty("user.dir") +"\\src\\main\\java\\resources\\data.properties";
	FileInputStream fis = new FileInputStream(propath);
	pro.load(fis);
	String Browsername = pro.getProperty("browser");
	if(Browsername.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}else if(Browsername.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else if(Browsername.equalsIgnoreCase("ie")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	return driver;
	
	}
public String takeScreenShot(String testName, WebDriver driver) throws IOException {
	
	File fileSourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String destinationFilePath = System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
	FileUtils.copyFile(fileSourceFile,new File(destinationFilePath));
	return destinationFilePath;
	
	
}
}

 