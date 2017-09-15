package PageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Order {

	private static WebElement element = null;

	public static WebElement checkoutOrder(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[contains(@class,'b-btn_fw')]"));

		return element;

	}
	public static WebElement removeOrder(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[contains(@class,'b-cart-remove__order')]"));

		return element;

	}

	public static WebElement removeOrder_yes(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[contains(@class,'b-remove-order_yes')]"));

		return element;

	}
	public static WebElement removeOrder_no(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[contains(@class,'b-remove-order_no')]"));

		return element;

	}

	public static WebElement empty_cart(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[contains(@class,'empty-cart')]"));

		return element;

	}
	
	public static WebElement checkoutaddressform_delivery_recipient(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[contains(@id,'checkoutaddressform-delivery_recipient')]"));

		return element;

	}
	public static WebElement checkoutaddressform_buyer_email(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[contains(@id,'checkoutaddressform-buyer_email')]"));

		return element;

	}
	
	public static WebElement checkoutaddressform_buyer_password(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[contains(@id,'checkoutaddressform-buyer_password')]"));

		return element;

	}
	
	public static WebElement btn__modal_next_checkout(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[contains(@class,'b-btn__modal-next_checkout')]"));

		return element;

	}
	
	
	public static WebElement btn__ask_code(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[contains(@class,'b-btn__ask-code')]"));

		return element;

	}
	
	public static WebElement phoneconfirmform_phone(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[contains(@id,'phoneconfirmform-phone')]"));

		return element;

	}
	
	public static WebElement phoneconfirmform_code(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[contains(@id,'phoneconfirmform-code')]"));

		return element;

	}
	
	//phoneconfirmform-code
	
	public static WebElement phoneconfirmform_agreement_styler(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[contains(@id,'phoneconfirmform-agreement-styler')]"));

		return element;
	
	}
	public static WebElement btn__send_code (WebDriver driver) {

		element = driver.findElement(By.xpath("//div[contains(@class,'b-btn__send-code')]"));

		return element;

	}
	
	
		
}