package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class ProductPage extends BaseClass {

	public ProductPage() {
	PageFactory.initElements(driver, this);
	}
		@FindBy (xpath = "(//button[text()='Add to cart'])[1]")
		private WebElement clickAddToCart ;

		@FindAll ({
		@FindBy 
		(xpath = "//div[@class='SuburbInputPrefix__control css-yk16xz-control']"),
		@FindBy
		(xpath = "//div[text()='Enter your postcode or suburb']")
		})
		private WebElement txtPostcode ;


@FindBy (xpath = "//button[text()='Save']")
private WebElement clickSave ;

@FindBy (xpath = "//input[@type='number']")
private WebElement txtQty;

@FindBy (xpath = "//button[@aria-label='increase quantity by 1']")
private WebElement clickQty;

@FindBy (xpath = "(//div[text()='2'])[2]")
private WebElement verifyQtyTxt;

@FindBy (xpath = "//div[@class='Icon pickup variant-primary size-normal']")
private WebElement scrollPickup;



public WebElement getTxtPostcode() {
	return txtPostcode;
}

public WebElement getClickSave() {
	return clickSave;
}

public WebElement getTxtQty() {
	return txtQty;
}

public WebElement getClickQty() {
	return clickQty;
}

public WebElement getVerifyQtyTxt() {
	return verifyQtyTxt;
}

public WebElement getClickAddToCart() {
	return clickAddToCart;
}

public WebElement getScrollPickup() {
	return scrollPickup;
}
	
	
	
}

