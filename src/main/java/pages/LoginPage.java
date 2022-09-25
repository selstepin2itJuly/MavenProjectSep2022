package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utilities.TestUtilities;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver dr)
	{
		this.driver = dr;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(css="button[type='submit']")
	private WebElement login;
	
	public void enterUsername(String user)
	{
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void loginToApplication(String user, String pass)
	{
		wait(username);
		Reporter.log("Login TestCase");
		TestUtilities.addScreeshot();
		username.sendKeys(user);
		password.sendKeys(pass);
		login.click();
	}
	
	private void wait(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
}
