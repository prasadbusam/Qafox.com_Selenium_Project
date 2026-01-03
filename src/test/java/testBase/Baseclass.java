package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass  
	@Parameters({"os","browser"})
	public void Setup(String os, String br) throws IOException {
		logger=LogManager.getLogger(this.getClass());
		FileInputStream file=new FileInputStream("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		switch (br.toLowerCase()) {
		case "firefox": driver=new FirefoxDriver();break;
		case "edge": driver=new EdgeDriver();break;
		case "chrome": driver=new ChromeDriver();break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(p.getProperty("appurl"));
		}
	public String randomString(){
		String generatedstring=RandomStringUtils.randomAlphabetic(6);
		return generatedstring;
	}
	
	public String randomNumber(){
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumber(){
		String generatedstring=RandomStringUtils.randomAlphabetic(6);
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedstring+"@"+generatedNumber;

	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

