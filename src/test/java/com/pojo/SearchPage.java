package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class SearchPage extends BaseClass {
public SearchPage()  {
	PageFactory.initElements(driver, this);
}

@FindBy (xpath = "//span[text()='Xiaomi']")
private WebElement filterclick;

@FindBy (xpath = "(//a[contains(text(),'Pocophone Smartphone')])[1]")
private WebElement clickPocoM3;

@FindBy (xpath ="//a[text()='Xiaomi Redmi 9A']")
private WebElement clickRedmi9A;

public WebElement getFilterclick() {
	return filterclick;
}

public WebElement getClickPocoM3() {
	return clickPocoM3;
}



}
