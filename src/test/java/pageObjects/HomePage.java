package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{	
	public HomePage(WebDriver driver){
		super(driver);
	}
		
	@FindBy(xpath = "(//*[text()='My Account'])[1]") WebElement myacclink;
	@FindBy(xpath = "//*[text()='Register']") WebElement reglink;
	@FindBy(xpath = "//*[text()='Login']") WebElement loginlink;
	
	public void clickMyAccount() {
		myacclink.click();
	}
	public void clickRegisterlink() {
		reglink.click();
	}
	public void clickLoginlink() {
		loginlink.click();
	}
}
