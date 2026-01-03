package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage {
	public AccountRegisterationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath = "//*[@name='firstname']") WebElement txtfirstname;
	@FindBy(xpath = "//*[@name='lastname']") WebElement txtlastname;
	@FindBy(xpath = "//*[@name='email']") WebElement txtemail;
	@FindBy(xpath = "//*[@name='telephone']") WebElement txttelephone;
	@FindBy(xpath = "//*[@name='password']") WebElement txtpassword;
	@FindBy(xpath = "//*[@name='confirm']") WebElement txtcnfpassword;
	@FindBy(xpath = "(//*[@class='radio-inline'])[2]") WebElement chknewsletter;
	@FindBy(xpath = "//*[@name='agree']") WebElement chkpolicybtn;
	@FindBy(xpath = "//*[@type='submit']") WebElement btncontinue;
	@FindBy(xpath = "//h1[contains(text(),'Account Has Been Created')]") WebElement msgconfirmation;
	
	public void setFname(String fname ) {
		txtfirstname.sendKeys(fname);
	}
	public void setLname(String lname ) {
		txtlastname.sendKeys(lname);
	}
	public void setemail(String mail ) {
		txtemail.sendKeys(mail);
	}
	public void settelephone(String telephonenum ) {
		txttelephone.sendKeys(telephonenum);
	}
	public void setpassword(String pword ) {
		txtpassword.sendKeys(pword);
	}
	public void setcnfpassword(String cnfpword ) {
		txtcnfpassword.sendKeys(cnfpword);
	}
	public void clicknewsletter() {
		chknewsletter.click();
	}
	public void checkpolicy() {
		chkpolicybtn.click();
	}
	public void continuebtn() {
		btncontinue.click();
	}
	public String getacc() {
		return(msgconfirmation.getText());
	}
}
