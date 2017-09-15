package PageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Home_Page {

	private static WebElement element = null;

	public static WebElement cityMoscow(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@data-cityid='1094']"));

		return element;

	}
	public static WebElement new_registrationMobile(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[contains(@class,'next-button')]/input"));

		return element;

	}
	
	
	public static WebElement header_search_text_input(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@class='header__search-text-input']"));

		return element;

	}
	public static WebElement header_search(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@class='header__search-icon']"));

		return element;

	}
	public static WebElement header_button_type_catalog(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[contains(@class,'header-button_type_catalog')]"));

		return element;

	}
	public static WebElement subcategory1(WebDriver driver) {

		element = driver.findElement(By.xpath("//li[contains(@data-id,'5722')]"));

		return element;

	}
	public static WebElement subcategory2(WebDriver driver) {

		element = driver.findElement(By.xpath("//li[contains(@data-id,'6130')]"));

		return element;

	}
	public static WebElement category(WebDriver driver) {

		element = driver.findElement(By.xpath("//li[contains(@data-id,'6137')]"));

		return element;

	}
	
	
}