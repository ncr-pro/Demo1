package demo.framework.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.pageobjects.AccountPage;
import org.pageobjects.LandingPage;
import org.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;



public class LogicTest extends Base{
	
	public Logger log;
	public WebDriver driver;	
	
@Test(dataProvider = "getLoginData")
	public void login(String email, String password,String expectedstatus) throws IOException{
	
	LandingPage landingpage = new LandingPage(driver);
	landingpage.myAccountDropDown().click();
	log.debug("Clicked on My Account Drop Down");
	landingpage.loginOption().click();
	log.debug("Click on login button");
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.emailAddressField().sendKeys(email);
	log.debug("email got entered");
	loginpage.emailPasswordField().sendKeys(password);
	log.debug("password got entered");
	loginpage.loginButton().click();
	log.debug("Clicked on login button");
	
	AccountPage accountpage = new AccountPage(driver);
	String actualResult = null;
	try {
		if(accountpage.editAccountInformationOption().isDisplayed()){ 
			actualResult = "successfull";
			log.debug("User got logged in ");
		}
	} catch (Exception e) {
		actualResult = "Failure";
		log.debug("User didn't login");
	}
	Assert.assertEquals(actualResult, expectedstatus);
	log.info("Login Test got passer");
	}

@BeforeMethod
public void  openApplication() throws IOException {

	log = LogManager.getLogger(LogicTest.class.getName());

driver =intializeDriver();
log.debug("Browser got launched");
driver.get(pro.getProperty("url"));
log.debug("Navigation to application url");
 }

@AfterMethod
public void closure() {
	
	driver.close();
	
	log.debug("Browser got closed");
}

@DataProvider
public Object[][] getLoginData() {
	
	Object[][] data = {{"arun.selenium@gmail.com","Second@123","successfull"},{"dummy@test.com","dummy","Failure"}};
	return data;
}

}
