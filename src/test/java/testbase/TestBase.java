package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class TestBase {

	public static WebDriver driver;
	public static String browser; 
	public static Properties prop;
	public static WebDriver getInstance() throws IOException
	{
		String file = "./src/main/java/config/config.properties";
		
		FileInputStream stream = new FileInputStream(new File(file));
		prop = new Properties();
		prop.load(stream);
		browser = prop.getProperty("browser");
		//browser = System.getenv("envClass");
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("firefoxagend"));
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("edgeagent"));
			driver = new FirefoxDriver();
		}else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		
		
		driver.manage().window().maximize();
		//Dimension d = new Dimension(768,1024);
		//driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	
	//multiple browser
	public static WebDriver getInstanceFromXML(String browser) throws IOException
	{
String file = "./src/main/java/config/config.properties";
		
		FileInputStream stream = new FileInputStream(new File(file));
		prop = new Properties();
		prop.load(stream);
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgeagent"));
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxagend"));
			driver = new FirefoxDriver();
		}else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		
		
		driver.manage().window().maximize();
		//Dimension d = new Dimension(768,1024);
		//driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
