package com.pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PojoClass extends BaseClass {
	
public PojoClass() {
	PageFactory.initElements(driver, this);
}

@FindBy (xpath = "//div[text()='Login/Register']")
private WebElement toClickLoginBtnHome ;

@FindBy (name= "email")
private WebElement txtUser;

@FindBy (name = "password")
private WebElement txtPass;

@FindBy (xpath = "//button[text()='Login']")
private WebElement clickLogin;

@FindBy (name = "text")
private WebElement txtSearch;

@FindAll ({	
@FindBy(xpath = "//button[@type='submit'])[1]"),
@FindBy (xpath = "//button[@f-label='search']")
})
private WebElement clickSearchButton ;


@FindBy (xpath = "//h5[text()='Brands']")
private WebElement scrollDownBrands; 

@FindBy (xpath = "//button[text()='more '] ")
private WebElement clickMoreBrands;

@FindBy (xpath = "//div[text()='Apple'] ")
private WebElement clickAppleBrand;

@FindBy (xpath = "(//span[text()='Mobile Phones'])[3]")
private WebElement verifyTxtMobilePhones;
@FindAll ({
@FindBy (xpath ="//a[text()='Apple iPhone SE 64GB - White']"),

@FindBy (xpath = "//img[@alt='Apple iPhone SE 64GB - White']")
})
private WebElement selectProductApple;

@FindBy (xpath= "//img[@alt='Telstra Essential Alcatel 1TL - Black']")
private WebElement selectTel;

@FindBy (xpath = "//img[@alt='Apple iPhone 12 128GB - Black']")
private WebElement selectAppleBlack;


@FindBy (xpath = "//h5[text()='Category']")
private WebElement scrolldownLabel;

@FindBy (xpath = "//label[text()='Home delivery']")
private WebElement scrollHomeDelivery;

@FindBy (xpath = "//a[text()='postcode']")
private WebElement enterPostcode;



public WebElement getToClickLoginBtnHome() {
	return toClickLoginBtnHome;
}

public WebElement getTxtUser() {
	return txtUser;
}

public WebElement getTxtPass() {
	return txtPass;
}

public WebElement getClickLogin() {
	return clickLogin;
}

public WebElement getTxtSearch() {
	return txtSearch;
}



public WebElement getScrollDownBrands() {
	return scrollDownBrands;
}

public WebElement getClickMoreBrands() {
	return clickMoreBrands;
}

public WebElement getClickAppleBrand() {
	return clickAppleBrand;
}

public WebElement getClickSearchButton() {
	return clickSearchButton;
}

public WebElement getVerifyTxtMobilePhones() {
	return verifyTxtMobilePhones;
}

public WebElement getSelectProductApple() {
	return selectProductApple;
}



public WebElement getScrolldownLabel() {
	return scrolldownLabel;
}

public WebElement getEnterPostcode() {
	return enterPostcode;
}

public WebElement getSelectTel() {
	return selectTel;
}

public WebElement getScrollHomeDelivery() {
	return scrollHomeDelivery;
}

public WebElement getSelectAppleBlack() {
	return selectAppleBlack;
}




}

