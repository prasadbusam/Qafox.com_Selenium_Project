package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.Baseclass;

public class TC001_AccountRegisterationPage extends Baseclass {
	
	@Test
	public void Verify_Account_Registeration_Page() {
		logger.info("*******Starting TC001_AccountRegisterationPage*******");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on Myaccount link");
		hp.clickRegisterlink();
		logger.info("Clicked on Register link");
		AccountRegisterationPage ac=new AccountRegisterationPage(driver);
		logger.info("Providing user details");
		ac.setFname(randomString().toUpperCase());
		ac.setLname(randomString().toUpperCase());
		ac.setemail(randomString()+"@gmail.com");
		ac.settelephone(randomNumber());
		String password=randomAlphaNumber();
		ac.setpassword(password);
		ac.setcnfpassword(password);
		ac.clicknewsletter();
		ac.checkpolicy();
		ac.continuebtn();
		logger.info("Validating expected message");
		String cnfmsg=ac.getcnfmsg();
		Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		
	}
	
}
