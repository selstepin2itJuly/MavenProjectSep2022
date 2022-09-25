package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {

	private WebDriver driver;
	
	public PIMPage(WebDriver dr)
	{
		this.driver = dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="ul.oxd-main-menu span")
	private List<WebElement> sideMenu;
	
	@FindBy(css="[placeholder='Search']")
	private WebElement search;
	
	@FindBy(css=".oxd-userdropdown-name")
	private WebElement logoutDropdown;
	
	@FindBy(linkText = "Logout")
	private WebElement logout;
	
	public boolean isSearchDisplayed()
	{
		boolean b =false;
		try {
			b = search.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	public void logout()
	{
		logoutDropdown.click();
		wait(logout);
		logout.click();
	}
	
	public List<String> getQuickLaunchItems()
	{
		List<String> temp = new ArrayList<String>();
		for(WebElement e:sideMenu)
		{
			temp.add(e.getText().trim());
		}
		
		return temp;
	}
	
	public int getQuickLaunchItemCount()
	{
		return sideMenu.size();
	}
	private void wait(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
}
