package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PIMPage;
import testbase.TestBase;
import utilities.TestUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class QuickLaunch_CB {
	
	private WebDriver driver;
	private LoginPage lp;
	private PIMPage pm;
	
  @Test(description="Quick Launch Items 003", enabled = true, priority=1)
  public void VerifyQuickLaunchItems_003() {
	  List<String> actual = pm.getQuickLaunchItems();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Admin");
	  exp.add("PIM");
	  exp.add("Leave");
	  exp.add("Time");
	  exp.add("Recruitment");
	  exp.add("My Info");
	  exp.add("Performance");
	  exp.add("Dashboard");
	  exp.add("Directory");
	  exp.add("Maintenance");
	  exp.add("Buzz");
	  TestUtilities.addScreeshot();
	  Assert.assertEquals(exp, actual);
  }
  
  @Test(description="Quick Launch Item count 002", enabled = true, priority=2)
  public void VerifyQuickLaunchItemCount_002() {
	  int actual = pm.getQuickLaunchItemCount();
	  TestUtilities.addScreeshot();
	  Assert.assertEquals(actual, 11);
  }
  
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String str) throws IOException {
	  driver = TestBase.getInstanceFromXML(str);
	  lp = new LoginPage(driver);
	  pm = new PIMPage(driver);
	  lp.loginToApplication("Admin", "admin123");
  }

  @AfterMethod
  public void afterMethod() {
	  pm.logout();
	  driver.quit();
  }

}
