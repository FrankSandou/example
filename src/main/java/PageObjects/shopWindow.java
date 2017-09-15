package PageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class shopWindow {

	private static WebElement element = null;

	public static WebElement productCard(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@data-cityid='1094']"));

		return element;

	}
	public static WebElement itemsList(WebDriver driver) {

		element = driver.findElement(By.xpath("//ul[@id='js-itemsList']"));

		return element;

	}
	
	
	
	
	public static WebElement productCard_buttonBuy(WebDriver driver) {

		element = driver.findElement(By.xpath("//ul[@class='itemsList__companyActions']/li"));

		return element;

	}
	
	
	public static WebElement cartBtn(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@id='cartBtn']"));

		return element;

		
	}
	
	public static WebElement goCart(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[contains(@class,'addedToCart')]"));

		return element;

		
	}
	public static WebElement user_icon_counter(WebDriver driver) {

		element = driver.findElement(By.xpath("//b[contains(@class,'user-icon-counter')]"));

		return element;

		
	}
}