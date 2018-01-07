package PageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class SearchGoogle {

	private static WebElement element = null;

	public static WebElement inputLine(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@id='lst-ib']"));

		return element;

	}
	
	

	
	public static WebElement ImageSearch(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@id='hdtb-msb-vis']/div/a"));

		return element;

	}
	
	public static WebElement Image(WebDriver driver) {

		element = driver.findElement(By.xpath("//img[contains(@class,'rg_i')]"));

		return element;

	}
	

	
	public static WebElement SearchAll(WebDriver driver) {
		
		

		element = driver.findElement(By.xpath("//div[contains(@class,'hdtb-imb')]/a"));

		return element;

	}

	
	public static WebElement ImageLocator(WebDriver driver) {
	
		element = driver.findElement(By.xpath("//a[@jsname='hSRGPd']"));

		//element = driver.findElement(By.xpath("//div[contains(@class,'rg_ilmbg')]/span"));

		return element;

	}
	
	public static WebElement buttonSearch(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@class='lsb']"));

		return element;

	}	
	public static WebElement searchResult(WebDriver driver) {

		element = driver.findElement(By.xpath("//div/cite[@class='_Rm']"));

		return element;

	}
	
	
	
	

	
}