package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class LaunchPage extends BaseClass {
public  LaunchPage() {
	
	PageFactory.initElements(driver, this);
}

@FindBy(id = "q")
private WebElement searchBox;

@FindBy (xpath = "//button[text()='SEARCH']")
private WebElement searchButton ;

@FindBy (xpath= "//a[text()='login']")
private WebElement clickLogin ;


public WebElement getSearchBox() {
	return searchBox;
}

public WebElement getSearchButton() {
	return searchButton;
}












}


