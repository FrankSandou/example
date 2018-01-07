package TestSearch;



	import PageObjects.*;
	import java.io.IOException;
	import java.sql.SQLException;
	import java.util.concurrent.TimeUnit;
	import org.junit.AfterClass;
	import org.junit.Assert;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.*;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;


	public class MyTest {
		public WebDriverWait wait = new WebDriverWait(driver, 60);
		
		public static String cat = System.getProperty("user.dir");
		public static WebDriver driver;
		WebElement element;
		
	 
		@BeforeClass
		
		public static void openBrowser() throws SQLException, IOException{

			String exePath = cat +"\\src\\main\\java\\OLD\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} 

		@Test
		public void TestSearch() throws Exception {
			
			
			//test
			System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
//Stage1 GOTO http://google.com/ncr
			driver.get("http://google.com/ncr");
			wait.until((ExpectedConditions.elementToBeClickable(SearchGoogle.inputLine(driver))));
//Stage2 Search for selenide
			SearchGoogle.inputLine(driver).sendKeys("selenide");
			wait.until((ExpectedConditions.elementToBeClickable(SearchGoogle.buttonSearch(driver))));
			SearchGoogle.buttonSearch(driver).click();
			wait.until((ExpectedConditions.elementToBeClickable(SearchGoogle.searchResult(driver))));
//Stage3			
			Assert.assertEquals("selenide.org/",SearchGoogle.searchResult(driver).getText());

//Stage4
		
			SearchGoogle.ImageSearch(driver).click();			
			wait.until((ExpectedConditions.elementToBeClickable(SearchGoogle.Image(driver))));	
			Assert.assertTrue(SearchGoogle.ImageLocator(driver).getAttribute("href").contains("selenide.org"));		

//Stage5
			SearchGoogle.SearchAll(driver).click();
//Repeat Stage3			
			wait.until((ExpectedConditions.elementToBeClickable(SearchGoogle.searchResult(driver))));
			Assert.assertEquals("selenide.org/",SearchGoogle.searchResult(driver).getText());
			
			System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		}



		@AfterClass
		public static void closeBrowser() throws SQLException{
			
			driver.quit();
		}
	}

