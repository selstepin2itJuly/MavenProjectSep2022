package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PIMPage;
import testbase.TestBase;
import utilities.TestUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class LoginTest_CB {
	private WebDriver dr;
	private LoginPage lp;
	private PIMPage pimp;
  @Test(description="Login Test case 001", enabled = true, priority=1)
  public void LoginSuccess_001() 
  {
	  Reporter.log("Login TestCase");
	  //TestUtilities.addScreeshot();
	  lp.loginToApplication("Admin", "admin123");
	  boolean b = pimp.isSearchDisplayed();
	  TestUtilities.addScreeshot();
	  Reporter.log("Actual"+b+":"+"Expected:"+"True");
	  assertEquals(true, b);
	  
  }
  
  
  @Parameters({"browser"})
  @BeforeMethod //precondition
  public void beforeMethod(String str) throws IOException {
	 dr =TestBase.getInstanceFromXML(str);
	 lp = new LoginPage(dr);
	 pimp = new PIMPage(dr);
  }

  @AfterMethod //postcondition
  public void afterMethod() {
	  pimp.logout();
	  dr.quit();
  }

}
