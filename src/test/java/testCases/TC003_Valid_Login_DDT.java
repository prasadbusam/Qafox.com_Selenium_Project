package testCases;

import java.lang.System.Logger;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC003_Valid_Login_DDT extends Baseclass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "Datadriven")
	public void verify_LoginDDT(String email, String pwd, String exp) {
		logger.info("******* Starting TC003_Valid_Login_DDT *******");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on Myaccount link");
		hp.clickLoginlink();
		logger.info("Clicked on Login link");
		Loginpage lp=new Loginpage(driver);
		logger.info("Providing Existing User details");
		lp.setemail(email);
		lp.setpword(pwd);
		logger.info("Clicked on Login button");
		lp.click_login_btn();
		if(exp.equals("Valid")) {
			Assert.assertTrue(true);
			lp.click_logout_btn();
		}else {
			Assert.assertTrue(false);
		}
		
		if(exp.equals("Invalid")) {
			Assert.assertTrue(false);
			lp.click_logout_btn();
		}else {
			Assert.assertTrue(true);
		}
		logger.info("*******Finished TC003_Valid_Login_DDT*******");
	}
	
}


