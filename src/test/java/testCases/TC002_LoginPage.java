package testCases;
	
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import testBase.Baseclass;

public class TC002_LoginPage extends Baseclass{
	@Test(groups = {"Sanity","Master"})
	public void Verify_Login_page() {
		logger.info("*******Starting TC002_LoginPagePage*******");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on Myaccount link");
		hp.clickLoginlink();
		logger.info("Clicked on Login link");
		Loginpage lp=new Loginpage(driver);
		logger.info("Providing Existing User details");
		lp.setemail(p.getProperty("email"));
		lp.setpword(p.getProperty("password"));
		logger.info("Clicked on Login button");
		lp.click_login_btn();
		logger.info("Validating expected My Account header");
		String viewmyacc=lp.getmyaccount();
		Assert.assertEquals(viewmyacc, "My Account","My account Displayed");
		lp.click_logout_btn();
		logger.info("*******Finished TC002_LoginPagePage*******");
	}
	
}
