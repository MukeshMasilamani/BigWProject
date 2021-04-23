package com.stepdeffile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pojo.CheckOutPage;
import com.pojo.PojoClass;
import com.pojo.ProductPage;
import com.utility.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class StepDefClass extends BaseClass {
	public static PojoClass p;
	public Actions ac;
	public Robot r;
	public static ProductPage pro;
	public static CheckOutPage co;

	@Given("User launch url of BigW home page")
	public void user_launch_url_of_BigW_home_page() throws InterruptedException {

		toLaunchUrl("https://www.bigw.com.au/");
		Thread.sleep(8000);
	}

	@When("user enter keyword in searchbox in home page")
	public void user_enter_keyword_in_searchbox_in_home_page(DataTable d) {
		p = new PojoClass();

		Map<String, String> map = d.asMap(String.class, String.class);
		String keyword = map.get("keyword");
		System.out.println(keyword);

		toSendKeys(p.getTxtSearch(), keyword);

	}

	@When("User click search button")
	public void user_click_search_button() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		// toClick(p.getClickSearchButton());
	}

	@Then("User navigate to search result page and Search results should be displayed relevant to keyword")
	public void user_navigate_to_search_result_page_and_Search_results_should_be_displayed_relevant_to_keyword() {

		String actual = toGetText(p.getVerifyTxtMobilePhones());
		Assert.assertEquals("Mobile Phones", actual);
		System.out.println("Given Test Case passed");
	}

	@When("user search keyword in searchbox in home page")
	public void user_search_keyword_in_searchbox_in_home_page(DataTable d2) {
		p = new PojoClass();
		Map<String, String> map = d2.asMap(String.class, String.class);
		String keyword = map.get("keyword");
		System.out.println(keyword);

		toSendKeys(p.getTxtSearch(), keyword);
	}

	@When("User click search button and User navigate to search result page")
	public void user_click_search_button_and_User_navigate_to_search_result_page() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("Scrolldown to brands filter area")
	public void scrolldown_to_brands_filter_area() {
		p = new PojoClass();

		toScrollDown(p.getScrollDownBrands());

	}

	@When("click more brands in brands filter")
	public void click_more_brands_in_brands_filter() throws InterruptedException, AWTException {
		p = new PojoClass();
		r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);
		
		toClickInJS(p.getClickMoreBrands());
	}

	@When("select Apples brand in brands filter")
	public void select_Apples_brand_in_brands_filter() {
		toImplicitWait(5);
		toClick(p.getClickAppleBrand());
	}

	@Then("User get results should be displayed same as relevant to filter")
	public void user_get_results_should_be_displayed_same_as_relevant_to_filter() {
		
		List<WebElement> names = driver.findElements(By.xpath("//a[@class='product-name' and contains (text(),'Apple')]"));
		for (int i = 0; i < names.size(); i++) {
			String txt = names.get(i).getText();
			Assert.assertTrue(txt.contains("Apple"));
			
		}
		System.out.println("Given testcase s2 passed");
		
	}

	@When("User navigate to login page")
	public void user_navigate_to_login_page() throws InterruptedException {
		Thread.sleep(6000);
		p = new PojoClass();
		toClick(p.getToClickLoginBtnHome());

	}

	@When("User enter valid ID and password in login page")
	public void user_enter_valid_ID_and_password_in_login_page(DataTable d3) throws InterruptedException, AWTException {
		List<String> li = d3.asList();
		String user = li.get(0);
		String pass = li.get(1);

		toSendKeys(p.getTxtUser(), user);
		toSendKeys(p.getTxtPass(), pass);
		toClick(p.getClickLogin());

	}

	@When("user search keyword in searchbox in my account page")
	public void user_search_keyword_in_searchbox_in_my_account_page(io.cucumber.datatable.DataTable d4) {

		p = new PojoClass();
		Map<String, String> map = d4.asMap(String.class, String.class);
		String keyword = map.get("keyword");
		System.out.println(keyword);

		toSendKeys(p.getTxtSearch(), keyword);
	}

	@When("User press enter button keyboard for search and navigate to search result page")
	public void user_press_enter_button_keyboard_for_search_and_navigate_to_search_result_page() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("Select any one product in search result page")
	public void select_any_one_product_in_search_result_page() throws InterruptedException {
		p = new PojoClass();

		Thread.sleep(3000);
		toScrollDown(p.getScrollHomeDelivery());
		explicitWait(p.getSelectAppleBlack());
		toClick(p.getSelectAppleBlack());

	}

	@When("Click add to cart button")
	public void click_add_to_cart_button() throws AWTException, InterruptedException {
		pro = new ProductPage();

		Thread.sleep(3000);
		explicitWait(pro.getClickAddToCart());
		toClick(pro.getClickAddToCart());

		Thread.sleep(3000);

		r = new Robot();

		Thread.sleep(5000);
		ac = new Actions(driver);
		ac.sendKeys("1021").perform();

		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		// explicitWait(pro.getClickSave());
		Thread.sleep(5000);
		toClick(pro.getClickSave());
		// explicitWait(pro.getClickAddToCart());
		Thread.sleep(5000);


	}

	@When("User increase quantity of item in product page")
	public void user_increase_quantity_of_item_in_product_page() throws InterruptedException {
		pro = new ProductPage();
		toScrollDown(pro.getScrollPickup());
		toImplicitWait(5);
		toClickInJS(pro.getClickAddToCart());
		Thread.sleep(3000);
		toClickInJS(pro.getClickQty());
	}

	@Then("User should be able to increase the quantity of item")
	public void user_should_be_able_to_increase_the_quantity_of_item() {

	}

	@Given("User navigate to login page BigW")
	public void user_navigate_to_login_page_BigW() throws InterruptedException {
		toLaunchUrl("https://www.bigw.com.au/");
		Thread.sleep(8000);
	}

	@Given("User enter valid ID and password in BigW login page")
	public void user_enter_valid_ID_and_password_in_BigW_login_page(DataTable d5) throws InterruptedException {

		p = new PojoClass();
		Thread.sleep(5000);
		toClick(p.getToClickLoginBtnHome());
	

		List<String> li = d5.asList();
		String user = li.get(0);
		String pass = li.get(1);

		toSendKeys(p.getTxtUser(), user);
		toSendKeys(p.getTxtPass(), pass);
		toClick(p.getClickLogin());
	}

	@Given("user search keyword in searchbox in my login page")
	public void user_search_keyword_in_searchbox_in_my_login_page(DataTable d6) {
		p = new PojoClass();

		Map<String, String> map = d6.asMap(String.class, String.class);
		String keyword = map.get("keyword");
		System.out.println(keyword);

		toSendKeys(p.getTxtSearch(), keyword);
	}

	@Given("User press enter button in keyboard for search and navigate to search result page")
	public void user_press_enter_button_in_keyboard_for_search_and_navigate_to_search_result_page()
			throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		// toClick(p.getClickSearchButton());

	}

	@Given("Select product in search result page")
	public void select_product_in_search_result_page() throws InterruptedException {
		p = new PojoClass();

		Thread.sleep(3000);
		toScrollDown(p.getScrollHomeDelivery());
		explicitWait(p.getSelectAppleBlack());
		toClick(p.getSelectAppleBlack());
	}

	@Given("Click add to cart button and enter postcode in product page again click add to cart")
	public void click_add_to_cart_button_and_enter_postcode_in_product_page_again_click_add_to_cart()
			throws InterruptedException, AWTException {
		Thread.sleep(3000);
		pro = new ProductPage();
		// explicitWait(pro.getClickAddToCart());
		toClick(pro.getClickAddToCart());

		Thread.sleep(3000);

		r = new Robot();

		Thread.sleep(5000);
		ac = new Actions(driver);
		ac.sendKeys("1021").perform();

		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		// explicitWait(pro.getClickSave());
		Thread.sleep(5000);
		toClick(pro.getClickSave());
		// explicitWait(pro.getClickAddToCart());
		Thread.sleep(5000);

		toScrollDown(pro.getScrollPickup());
		Thread.sleep(3000);
		toClickInJS(pro.getClickQty());
		
	}

	@When("User move mouse hover the cart icon")
	public void user_move_mouse_hover_the_cart_icon() throws InterruptedException {
		co = new CheckOutPage();
		toScrollUP(co.getScrollUplogout());
		ac = new Actions(driver);
		//explicitWait(co.getWaitElement());
		//toImplicitWait(3);
		Thread.sleep(5000);
		ac.moveToElement(co.getCartMouseHover()).perform();	
	}

	@When("User click checkout buttton")
	public void user_click_checkout_buttton() {
		
		toClickInJS(co.getClickCheckoutBtn());
	}

	@Then("user should navigate to order summary page")
	public void user_should_navigate_to_order_summary_page() {
		co = new CheckOutPage(); 
		String txt = toGetText(co.getVerifyOrderSummary());
		Assert.assertEquals("Order Summary", txt);
		System.out.println("Scenario4 is passed");	
}

	
	
	@Given("User should navigate to login page BigW")
	public void user_should_navigate_to_login_page_BigW() throws InterruptedException {
		toLaunchUrl("https://www.bigw.com.au/");
		Thread.sleep(8000);
	}

	@Given("User should enter valid ID and password in login page of BigW")
	public void user_should_enter_valid_ID_and_password_in_login_page_of_BigW(DataTable d6) throws InterruptedException {
		p = new PojoClass();
		Thread.sleep(5000);
		toClickInJS(p.getToClickLoginBtnHome());

		List<String> li = d6.asList();
		String user = li.get(0);
		String pass = li.get(1);

		toSendKeys(p.getTxtUser(), user);
		toSendKeys(p.getTxtPass(), pass);
		toClick(p.getClickLogin());
	}

	@Given("User move the cursor to  the cart icon and click checkout buttton")
	public void user_move_the_cursor_to_the_cart_icon_and_click_checkout_buttton() throws InterruptedException {
		co = new CheckOutPage();
		toScrollUP(co.getScrollUplogout());
		ac = new Actions(driver);
		//explicitWait(co.getWaitElement());
		//toImplicitWait(3);
		Thread.sleep(5000);
		ac.moveToElement(co.getCartMouseHover()).perform();	
		toClickInJS(co.getClickCheckoutBtn());
	}

	@When("user click promocode and enter invalid promocode")
	public void user_click_promocode_and_enter_invalid_promocode(io.cucumber.datatable.DataTable dataTable) {

	}

	@When("Click add button")
	public void click_add_button() {
	    
	}

	@Then("User should get error message")
	public void user_should_get_error_message() {

	}

	
	
	
	

}

