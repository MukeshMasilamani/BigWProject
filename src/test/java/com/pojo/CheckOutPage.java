package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class CheckOutPage extends BaseClass{
public CheckOutPage() {
	PageFactory.initElements(driver, this);
}

@FindBy (xpath = "(//*[@class='injected-svg'])[11]")
private WebElement cartMouseHover;

@FindBy (xpath = "(//a[text()='Checkout'])[1]")
private WebElement clickCheckoutBtn;

@FindBy (xpath = "//span[text()=' Add promo code']")
private WebElement clickAddPromoCode;

@FindBy (xpath = "//input[@type='text']")
private WebElement txtPromocode;

@FindBy (xpath = "//button[text()='Add']")
private WebElement clickAddPromocode;

@FindBy (xpath = "//div[text()='Please enter a valid promotion code']")
private WebElement erroMsgPromocode;

@FindBy (xpath = "//button[text()='Proceed to checkout']")
private WebElement clickProceedToCheckout;

@FindBy (xpath ="//div[@class='actions']")
private WebElement clickDeleteBtn1;

@FindBy (xpath = "( //*[local-name()='svg'] [@class='injected-svg']) [56]")
private WebElement clickDeleteBtn2;

@FindBy (xpath = "//button[text()='Log Out']")
private WebElement scrollUplogout;

@FindBy (xpath = "//h4[text()='Order Summary']")
private WebElement verifyOrderSummary;

@FindBy (name = "text")
private WebElement waitElement;

public WebElement getCartMouseHover() {
	return cartMouseHover;
}

public WebElement getClickCheckoutBtn() {
	return clickCheckoutBtn;
}

public WebElement getClickAddPromoCode() {
	return clickAddPromoCode;
}

public WebElement getTxtPromocode() {
	return txtPromocode;
}

public WebElement getClickAddPromocode() {
	return clickAddPromocode;
}

public WebElement getErroMsgPromocode() {
	return erroMsgPromocode;
}

public WebElement getClickProceedToCheckout() {
	return clickProceedToCheckout;
}

public WebElement getClickDeleteBtn1() {
	return clickDeleteBtn1;
}

public WebElement getClickDeleteBtn2() {
	return clickDeleteBtn2;
}

public WebElement getScrollUplogout() {
	return scrollUplogout;
}

public WebElement getVerifyOrderSummary() {
	return verifyOrderSummary;
}

public WebElement getWaitElement() {
	return waitElement;
}





}



