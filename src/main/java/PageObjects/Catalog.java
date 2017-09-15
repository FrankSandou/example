package PageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Catalog {

	private static WebElement element = null;

	public static WebElement cityMoscow(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@data-cityid='1094']"));

		return element;

	}
	public static WebElement new_registrationMobile(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[contains(@class,'next-button')]/input"));

		return element;

	}
	
	
	public static WebElement select_Summa(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@id='slider1']/a[2]"));

		return element;

	}
	

	
}