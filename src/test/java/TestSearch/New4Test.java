package TestSkyBuy.SkyBuy;

	import TestSkyBuy.SkyBuy.Constants;
	import junit.framework.TestCase;
	import junit.framework.TestSuite;
	import java.io.File;
	import java.io.IOException;
	import java.sql.SQLException;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import javax.mail.MessagingException;
	import javax.mail.internet.AddressException;


	import org.apache.commons.io.FileUtils;
	import org.junit.AfterClass;
	import org.junit.Assert;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.ElementNotVisibleException;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.chrome.*;
	import org.openqa.selenium.safari.*;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Sleeper;
	import org.openqa.selenium.support.ui.WebDriverWait;

import Actions.Jenkins;
import PageObjects.Home_Page;
import PageObjects.Order;
import PageObjects.shopWindow;

import org.openqa.selenium.support.ui.Select;


	public class New4Test {
		public static String baseUrl = new String();
		public WebDriverWait wait = new WebDriverWait(driver, 60);
		public static String url = new String();
		public static String authLogin = new String();
		public static String authPass = new String();
		public static String host = new String();
		public static String port = new String();
		public static String host2 = new String();
		public static String port2 = new String();
		public static String mailFrom = new String();
		public static String password = new String();
		public static String mailTo = new String();
		public static String subject = new String();
		public static String message = new String();
		public static  String[] attachFiles = new String[1];
		
		public static String cat = System.getProperty("user.dir");
		public static  File newFile = new File(cat+"\\ErrorscreenShot.png");
		public static WebDriver driver;
		//private static FirefoxDriver driver;
		//private static SafariDriver driver;
		WebElement element;
		
	 
		@BeforeClass
		
		public static void start() throws SQLException, IOException{

			String exePath = "C:\\\\Users\\\\ivanov\\\\Downloads\\\\drivers\\\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Jenkins.getParamsFromJenkins(); 
		} 

		@Test
		public void valid_UserRegistrationWithPhoneBIK() throws Exception {
 //Получаем внешние параметры из дженкиса или если работаем локально берем подставляем константы
			
			System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
			
			System.out.println(Jenkins.baseUrl);
			driver.get(Jenkins.urlCard);
			driver.get(Jenkins.baseUrl);
			wait.until((ExpectedConditions.elementToBeClickable(Home_Page.cityMoscow(driver))));
			Home_Page.cityMoscow(driver).click();
			Home_Page.header_search_text_input(driver).sendKeys(Constants.testProduct);
			Home_Page.header_search(driver).click();
		
			wait.until((ExpectedConditions.elementToBeClickable(shopWindow.productCard_buttonBuy(driver))));
			shopWindow.productCard_buttonBuy(driver).click();

			wait.until((ExpectedConditions.elementToBeClickable(shopWindow.cartBtn(driver))));
			shopWindow.cartBtn(driver).click();
			wait.until((ExpectedConditions.elementToBeClickable(shopWindow.user_icon_counter(driver))));
			shopWindow.goCart(driver).click();
			
			wait.until((ExpectedConditions.elementToBeClickable(Order.checkoutOrder(driver))));
			Order.removeOrder(driver).click();
			wait.until((ExpectedConditions.elementToBeClickable(Order.removeOrder_yes(driver))));
			
			Order.removeOrder_yes(driver).click();
			wait.until((ExpectedConditions.elementToBeClickable(Order.empty_cart(driver))));
			System.out.println(shopWindow.user_icon_counter(driver).getText());
			wait.until((ExpectedConditions.textToBePresentInElement(shopWindow.user_icon_counter(driver),"0")));
			
			System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		}



		@AfterClass
		public static void closeBrowser() throws SQLException{
			
			driver.quit();
		}
	}

