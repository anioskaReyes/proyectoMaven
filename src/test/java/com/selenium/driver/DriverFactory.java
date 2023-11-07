
package com.selenium.driver;
import metodosUtiles.utiles;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.Reporter;

public class DriverFactory {

	private enum browsers {
		 FIREFOX, CHROME
	};
//	public static WebDriver LevantarBrowser(WebDriver driver, ITestContext context )
	
	public static WebDriver LevantarBrowser(WebDriver driver, String Browser, String url )
	{  
//		String browserName = context.getCurrentXmlTest().getParameter("Navegador");
//		
//		String pagina= context.getCurrentXmlTest().getParameter("Url");
//		
		String browserName =Browser;
		String pagina=url;
		
		switch (browsers.valueOf(browserName)) {
		case CHROME: // Using WebDriver
		{
			System.setProperty("webdriver.chrome.driver", "src\\resources\\drivers\\chromedriver.exe");
			utiles.reportes("Abro browser");
			driver = new ChromeDriver();
			break;
		}
		case FIREFOX:// Using WebDriver resources\drivers\Chrome\chromedriver.exe
		{
			System.setProperty("webdriver.gecko.driver", "src\\resources\\drivers\\geckodriver.exe");
			utiles.reportes("Abro browser");
			driver = new FirefoxDriver();
			break;
		}
		default:
			utiles.reportes("No selecciono ningun browser correcto, se le asignara Chrome");
			System.setProperty("webdriver.chrome.driver", "src\\resources\\drivers\\chromedriver.exe");
			utiles.reportes("Abro browser");
			driver = new ChromeDriver();
			break;

		}
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(pagina);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}
	
	public static void FinalizarBrowser(WebDriver driver) {
		utiles.reportes("Cerrando el browser");
		driver.quit();
		driver = null;
	}

	//public static WebDriver LevantarBrowser(WebDriver driver, String string, String string2) {
		// TODO Auto-generated method stub
	//	return null;
	//}

}
