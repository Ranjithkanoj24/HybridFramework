package com.practise.session1;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestExecutor {
	WebDriver driver;
	ExcelHandling eh;
	String sheetName;

	public void executeTest(String scriptName) {
		sheetName = scriptName;
		driver = new FirefoxDriver();
		/* System.out.println("The name of the sheet is : "+ scriptName); */
		System.out.println("The sheet name in TestExecutor class is : " + sheetName);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://127.0.0.1/login.do");
		eh = new ExcelHandling();
		int row_count = eh.getExcelRowCount(sheetName);
		System.out.println("The number of rows in excel are : " + row_count);
		for (int i = 1; i <= row_count; i++) {
			String actionKeyword = eh.readExcelData(sheetName, i, 1);
			String elementProp = eh.readExcelData(sheetName, i, 2);
			String locator = eh.readExcelData(sheetName, i, 3);
			String data = eh.readExcelData(sheetName, i, 4);
			System.out.println(actionKeyword + elementProp + locator + data);
			if (actionKeyword.equalsIgnoreCase("type")) {
				typeMethod(elementProp, locator, i, data);
			} else if (actionKeyword.equalsIgnoreCase("click")) {
				clickMethod(elementProp, i, locator);
			} else if (actionKeyword.equalsIgnoreCase("select")) {
				selectMethod(elementProp, locator, data);
			}

		}
		driver.quit();
	}

	public void typeMethod(String elementProp, String locator, int rowNo, String data) {
		if (elementProp.equalsIgnoreCase("id")) {
			try {
				driver.findElement(By.id(locator)).sendKeys(data);
				eh.writeExcel(sheetName, rowNo, 5, "PASS");
				eh.writeExcel(sheetName, rowNo, 6, "successfully Executed");
			} catch (Exception e) {
				// TODO: handle exception
				eh.writeExcel(sheetName, rowNo, 5, "FAIL");
				eh.writeExcel(sheetName, rowNo, 6, "Failed to execute this step");
			}
		} else if (elementProp.equalsIgnoreCase("name")) {
			try {
				System.out.println("I am " + locator + data);
				driver.findElement(By.name(locator)).sendKeys(data);
				eh.writeExcel(sheetName, rowNo, 5, "PASS");
				eh.writeExcel(sheetName, rowNo, 6, "successfully Executed");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Fucked");
				e.printStackTrace();
				eh.writeExcel(sheetName, rowNo, 5, "FAIL");
				eh.writeExcel(sheetName, rowNo, 6, "Failed to execute this step");
			}
		} else if (elementProp.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locator)).sendKeys(data);
		} else if (elementProp.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(data);
		} else if (elementProp.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(locator)).sendKeys(data);
		} else if (elementProp.equalsIgnoreCase("linkText")) {
			try {
				driver.findElement(By.linkText(locator)).sendKeys(data);
				eh.writeExcel(sheetName, rowNo, 5, "PASS");
				eh.writeExcel(sheetName, rowNo, 6, "successfully Executed");
			} catch (Exception e) {
				// TODO: handle exception
				eh.writeExcel(sheetName, rowNo, 5, "FAIL");
				eh.writeExcel(sheetName, rowNo, 6, "Failed to execute this step");
			}
		} else if (elementProp.equalsIgnoreCase("partiallinkText")) {
			driver.findElement(By.partialLinkText(locator)).sendKeys(data);
		} else if (elementProp.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(locator)).sendKeys(data);
		}
	}

	public void clickMethod(String elementProp, int i, String locator) {
		if (elementProp.equalsIgnoreCase("id")) {
			try {
				driver.findElement(By.id(locator)).click();
				eh.writeExcel(sheetName, i, 5, "PASS");
				eh.writeExcel(sheetName, i, 6, "Successfully Completed");
			} catch (Exception e) {
				// TODO: handle exception
				eh.writeExcel(sheetName, i, 5, "FAIL");
				eh.writeExcel(sheetName, i, 6, "Failed to execute this step");
			}
		} else if (elementProp.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locator)).click();
		} else if (elementProp.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locator)).click();
		} else if (elementProp.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locator)).click();
		} else if (elementProp.equalsIgnoreCase("classname")) {
			driver.findElement(By.className(locator)).click();
		} else if (elementProp.equalsIgnoreCase("linkText")) {
			try {
				driver.findElement(By.linkText(locator)).click();
				eh.writeExcel(sheetName, i, 5, "PASS");
				eh.writeExcel(sheetName, i, 6, "Successfully Completed");
			} catch (Exception e) {
				// TODO: handle exception
				eh.writeExcel(sheetName, i, 5, "FAIL");
				eh.writeExcel(sheetName, i, 6, "Failed to execute this step");
			}
		} else if (elementProp.equalsIgnoreCase("partiallinkText")) {
			driver.findElement(By.partialLinkText(locator)).click();
		} else if (elementProp.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(locator)).click();
		}
	}

	public void selectMethod(String elementProp, String locator, String data) {
		if (elementProp.equalsIgnoreCase("name")) {
			WebElement we = driver.findElement(By.name(locator));
			selectMethod2(we, locator, data);
		} else if (elementProp.equalsIgnoreCase("xpath")) {
			WebElement we = driver.findElement(By.xpath(locator));
			selectMethod2(we, locator, data);
		} else if (elementProp.equalsIgnoreCase("css")) {
			WebElement we = driver.findElement(By.cssSelector(locator));
			selectMethod2(we, locator, data);
		} else if (elementProp.equalsIgnoreCase("classname")) {
			WebElement we = driver.findElement(By.className(locator));
			selectMethod2(we, locator, data);
		} else if (elementProp.equalsIgnoreCase("linkText")) {
			WebElement we = driver.findElement(By.linkText(locator));
			selectMethod2(we, locator, data);
		} else if (elementProp.equalsIgnoreCase("partiallinkText")) {
			WebElement we = driver.findElement(By.partialLinkText(locator));
			selectMethod2(we, locator, data);
		} else if (elementProp.equalsIgnoreCase("tagname")) {
			WebElement we = driver.findElement(By.tagName(locator));
			selectMethod2(we, locator, data);
		} else if (elementProp.equalsIgnoreCase("id")) {
			WebElement we = driver.findElement(By.id(locator));
			selectMethod2(we, locator, data);
		}
	}

	public void selectMethod2(WebElement we, String locator, String value) {
		Select sel = new Select(we);
		String arr[] = value.split("=");
		if (arr[0].equalsIgnoreCase("visibletext")) {
			List<WebElement> list = sel.getOptions();
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getText().equalsIgnoreCase(arr[1])) {
					sel.selectByVisibleText(arr[1]);
				}
			}
		} else if (arr[0].equalsIgnoreCase("value")) {
			sel.selectByValue(arr[1]);
		} else if (arr[0].equalsIgnoreCase("index")) {
			sel.selectByIndex(Integer.parseInt(arr[1]));
		}

	}

	/*
	 * public void writeResult() {
	 * 
	 * }
	 */
}
