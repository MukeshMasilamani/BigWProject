package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public	static WebDriver driver ;
	public	static	Actions ac ; 
	public	static Alert alert ;
	public static JavascriptExecutor js ;
	public static Select s ;
	public static TakesScreenshot t ;
	public static Date d ;
	public static SimpleDateFormat sd ;
	public static WebDriverWait ww;
		
	public static WebDriver toBrowserlaunchChrome() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 return driver ;
	}
	public static void toLaunchUrl(String url) {
		driver.get(url);
		
	}
	public static void toMax() {
		driver.manage().window().maximize();
	}
	public static void toGetCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
	}
	public static void toGetTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}
	public static WebElement toSendKeys(WebElement element , String value) {
		element.sendKeys(value);
		return element ;
	}
	public static WebElement toClick(WebElement element) {
		element.click();
		return element ;
	}
	public static String toGetText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		
		return text ;
	}
	public static void toGetAttribute(WebElement element,String value) {
		String attribute = element.getAttribute(value);
		System.out.println(attribute);

	}
	public static void toDragDrop(WebElement src ,WebElement dest) {
		ac = new Actions(driver) ;
		ac.dragAndDrop(src, dest).perform();

		}
	public static void toMouseHover(WebElement element) {
		ac = new Actions(driver) ;
		ac.moveToElement(element).perform();	
	}
	public static void toDoubleClick(WebElement element) {
		ac = new Actions(driver) ;
		ac.doubleClick(element).perform();;
	}	
	public static void toContextClick(WebElement element) {
		ac = new Actions(driver) ;
		ac.contextClick(element).perform();;
	}	
	public static void toSwitchAlert() {
		driver.switchTo().alert();
	}
	public static void toAlertAccept() {
		alert.accept();
	}
	public static void toAlertDismiss() {
		alert.dismiss();
	}
	
	public static void toScrollDown(WebElement element) {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static void toScrollUP(WebElement element) {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public static void toSendKeysInJs(WebElement element,String value) {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].setAttribute('value' , '"+value+"')", element);
	}
	public static void toGetAttributeInJs(WebElement element) {
		js = (JavascriptExecutor) driver ;
		String getAttribute = (String) js.executeScript("arguments[0].getAttribute('value')", element);
		System.out.println(getAttribute);
	}
	public static void toClickInJS(WebElement element) {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click()", element);
	}
	/*public static void toEnterDate() {
		js = (JavascriptExecutor) driver ;
		js.executeScript("document.getElementById('dateofbirth').removeAttribute('readonly',0);");
	}*/

	public static void dropAndDownSelectByIndex(WebElement element ,int i) {
		s = new Select (element);
		s.selectByIndex(i);
	}
	public static void dropAndDownSelectByValue(WebElement element ,String value) {
		s = new Select (element);
		s.selectByValue(value);;
	}
	public static void dropAndDownSelectByText(WebElement element ,String value) {
		s = new Select (element);
		s.selectByVisibleText(value);
	}
	public static void dropAndDownDeselectByIndex(WebElement element ,int i) {
		s = new Select (element);
		s.deselectByIndex(i);
	}
	public static void dropAndDownDeselectByValue(WebElement element ,String value) {
		s = new Select (element);
		s.deselectByValue(value);
	}
	public static void dropAndDownDeselectByText(WebElement element ,String value) {
		s = new Select (element);
		s.deselectByVisibleText(value);;
	}
	public static void dropAndDownIsMultiple(WebElement element) {
		s = new Select (element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	public static void dropAndDownGetAllSelectedoption(WebElement element) {
		s = new Select (element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement elements : allSelectedOptions) {
			String options = elements.getText();
			System.out.println(options);
		}
	}
		public static void dropAndDownGetFirstSelectedOption(WebElement element) {
			s = new Select (element);
			WebElement firstSelectedOption = s.getFirstSelectedOption();	
			String f = firstSelectedOption.getText();
			System.out.println(f);	
		}	
	
		public static void dropAndDownSelectAllOption(WebElement element) {
			s = new Select (element);	
			List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			s.selectByIndex(i);
		}
		}
		public static void dropAndDownDeselectAll(WebElement element) {
			s = new Select (element);
			s.deselectAll(); 
	}
		public static void toGetScreenShot(String path) throws IOException {
			t = (TakesScreenshot) driver;
			File tempFile = t.getScreenshotAs(OutputType.FILE);
			File destFile = new File(path);
			FileUtils.copyFile(tempFile, destFile);
		}
		public static void toSwitchFrameByIndex(int i) {
			driver.switchTo().frame(i);
		}
		public static void toSwitchFrameByString(String value) {
			driver.switchTo().frame(value);
		}
		public static void toSwitchFrameByWebelement(WebElement element) {
			driver.switchTo().frame(element);
		}
		
		public static void toSwitchToParentFrame() {
			driver.switchTo().parentFrame();
		}
		public static void toSwitchToDefaultContent() {
			driver.switchTo().defaultContent();
		}
		public static void toSwitchToWindowByString(String value) {
			driver.switchTo().window(value);
		}
		public static void toSwitchMultipleWindows(int i) {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> li = new LinkedList<String>();
			li.addAll(windowHandles);
			driver.switchTo().window(li.get(i));
				}
		public static void toSwitchChildWindow() {
			String parentWindow = driver.getWindowHandle();
			Set<String> windowHandles = driver.getWindowHandles();
			for (String st : windowHandles) {
				if (!parentWindow.equals(windowHandles)) {
					driver.switchTo().window(st);}
				}
			}			
		
		
		public static void toImplicitWait(int i) {
			driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
		}
		
		public static void toClear(WebElement element) {
			element.clear();
		}
		
		public static void explicitWait(WebElement element) {
			
			ww = new WebDriverWait(driver, 20);
			ww.until(ExpectedConditions.elementToBeClickable(element));
			
			

		}
		
		public static Map<String, String> excelRead(String testCaseId) throws IOException {
			
				Map <String,String> map = new LinkedHashMap<String,String>();
				File f = new File("C:\\Users\\ram\\eclipse-workspace\\AdactinCucumber\\Testdata\\AdactinData.xlsx");
				FileInputStream fin = new FileInputStream(f);
				Workbook w = new XSSFWorkbook(fin);
				Sheet s = w.getSheet("Sheet1"); 
				
				for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
					
					Row row = s.getRow(i);
					Cell cell = row.getCell(0);
					String testCaseNo = cell.getStringCellValue();																				
					
					if (testCaseNo.equals(testCaseId)) {
						Row headerRow = s.getRow(0);
						Row requiredRow = s.getRow(i);
						
						for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
							
							Cell heading = headerRow.getCell(j);
							Cell data = requiredRow.getCell(j);
							
							int cellTypeHeading = heading.getCellType();
							int cellTypeData = data.getCellType();
							
							String txtHeading ;
							String txtData ;
						
							if (cellTypeHeading == 1) {
								
								txtHeading = heading.getStringCellValue();
							}
							else if (DateUtil.isCellDateFormatted(heading)) {
								Date d = heading.getDateCellValue();
								SimpleDateFormat sim = new SimpleDateFormat("dd/mm/yyyy");
								txtHeading = sim.format(d);
							}
							else {
								double nc = heading.getNumericCellValue();
								long l = (long) nc;
								txtHeading = String.valueOf(l);
							}
							
							if (cellTypeData == 1) {
								
								txtData = data.getStringCellValue();
							}
							else if (DateUtil.isCellDateFormatted(data)) {
								Date di = data.getDateCellValue();
								SimpleDateFormat sim = new SimpleDateFormat("dd/mm/yyyy");
								txtData = sim.format(di);
							}
							else {
								double nc = data.getNumericCellValue();
								long li = (long) nc;
								txtData = String.valueOf(li);
							}
							
						
							
							map.put(txtHeading, txtData);
							
						}
						
						
					}
					
					
				}
				return map ;
		}
		
		

	}

		


