package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class Loginpage extends BasePage{
	
	public Loginpage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath = "//*[@name='email']") WebElement txtmail;
	@FindBy(xpath = "//*[@name='password']") WebElement txtpassword;
	@FindBy(xpath = "//*[@value='Login']") WebElement loginbtn;
	@FindBy(xpath = "//*[@id='content'] //*[text()='My Account']") WebElement myacc;
	@FindBy(xpath = "(//*[text()='Logout'])[2]") WebElement logoutbtn;
	
	public void setemail(String email) {
		txtmail.sendKeys(email);
	}
	public void setpword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void click_login_btn() {
		loginbtn.click();
	}
	public String getmyaccount() {
		return(myacc.getText());
	}
	public void click_logout_btn() {
		logoutbtn.click();
	}
}
