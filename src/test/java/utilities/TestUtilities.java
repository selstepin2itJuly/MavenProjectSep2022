package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtilities extends TestBase{

	public static void scrollToElement(WebElement e)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(false);", e);
		je.executeScript("window.scrollBy(0,300)", "");
	}
	
	public static void clickOnElementJS(WebElement e)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", e);
	}
	
	public static void captureScreenshot() throws IOException
	{
		String str = "C://screenshot";
		File f = new File(str);
		if(!f.isDirectory())
		{
			f.mkdir();
		}
		else
		{
			System.out.println("Folder screenshot exist");
		}
		TakesScreenshot t = (TakesScreenshot) driver;
		File file = t.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(str+"/"+getDate()+"_image.jpg"));
	}
	
	public static void addScreeshot()
	{
		TakesScreenshot t = (TakesScreenshot) driver;
		String file = t.getScreenshotAs(OutputType.BASE64);
		String imge ="<img src=\"data:image/png;base64,"+file+"\" height=\"600\" width=\"800\" />";
		Reporter.log(imge);
	}
	public static String getDate()
	{
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MMM_dd_HH_mm_ss_SSSS");
		String d = sdf.format(dt);
		System.out.println(d);
		return d;
	}
}
