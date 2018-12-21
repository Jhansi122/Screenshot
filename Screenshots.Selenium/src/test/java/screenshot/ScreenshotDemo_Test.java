package screenshot;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.ScreenshotLibrary;

public class ScreenshotDemo_Test {

	public class ScreenshtTest {
		WebDriver driver;

		@BeforeTest
		public void URL() {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\Geckodriver\\geckodriver.exe\\");
			driver = new FirefoxDriver();
			driver.get("https://www.jetairways.com//en//in//Home.aspx");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ScreenshotLibrary.ScreenshotTest(driver, "Screenshot");
			String title = driver.getTitle();
			System.out.println("-----------------------------------------------------------");
			System.out.println("Title of the Webpage is " + title);
			System.out.println("-----------------------------------------------------------");

		}

		@AfterClass

		public void Cookie_Management() {
			Set<Cookie> before_deletion = driver.manage().getCookies();
			System.out.println("-----------------------------------------------------------");
			System.out.println("Total number of cookies before deletion = " + before_deletion.size());
			System.out.println("-----------------------------------------------------------");
			for (Cookie cookies : before_deletion) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("Class name of the cookie = " + cookies.getClass());
				System.out.println("Name name of the cookie = " + cookies.getName());
				System.out.println("Value name of the cookie = " + cookies.getValue());
				System.out.println("-----------------------------------------------------------");

			}
			System.out.println("-----------------------------------------------------------");
			driver.manage().deleteAllCookies();
			Set<Cookie> after_deletion = driver.manage().getCookies();
			System.out.println("Total number of cookies after deletion = " + after_deletion.size());
			System.out.println("-----------------------------------------------------------");
			driver.close();

		}

		@Test(priority = 2)

		public void Selection() throws Exception {
			driver.findElement(By.xpath("//input[@value='OneWay' and @name='ctl00$ObeFlights1$triptype']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='ctl00$ObeFlights1$autoOriginHome$AutoText']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),'Dar-Es-Salaam')]")).click();

			driver.findElement(By.xpath(
					"//input[@name='ctl00$ObeFlights1$autoDestinationHome$AutoText' and @id= 'ObeFlights1_autoDestinationHome_AutoText']"))
					.click();
			driver.findElement(By.xpath("(//span[contains(.,'Donetsk (DOK)')])[2]")).click();

			driver.findElement(By.xpath("(//div[contains(@class,'form-group')])[3]")).click();
			driver.findElement(By.xpath("(//a[contains(@data-handler,'next')])[1]")).click();
			driver.findElement(By.xpath("(//a[contains(.,'22')])[1]")).click();
			driver.findElement(By.xpath("//div[@class='form-group js-toggle-contol']")).click();
			Thread.sleep(2000);

			ScreenshotLibrary.ScreenshotTest(driver, "DataSelection");

			Select Adults = new Select(driver.findElement(By.xpath("//select[contains(@name,'ddlAdult')]")));
			System.out.println("First Selected option =" + Adults.getFirstSelectedOption());
			List<WebElement> elements = Adults.getOptions();
			System.out.println("-----------------------------------------------------------");
			System.out.println("Total number of elements in the dropdown = " + elements.size());
			System.out.println("-----------------------------------------------------------");
			for (WebElement dropdown : elements) {
				System.out.println("Elements in dropdown1 = " + dropdown.getText());
			}

			System.out.println("-----------------------------------------------------------");

			Adults.selectByValue("4");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}

		@Test(priority = 3)
		public void Navigate() throws Exception {
			((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			driver.findElement(By.xpath("//img[contains(@alt,'Thailand-Visa-Free')]")).click();
			((JavascriptExecutor) driver).executeScript("scroll(0,300)");
			driver.findElement(By.xpath("//h3[contains(.,'Mumbai (BOM) to Bangkok (BKK)')]")).click();
			ScreenshotLibrary.ScreenshotTest(driver, "ThailandTourPackages");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='closebutton']")).click();
			Thread.sleep(3000);
			ScreenshotLibrary.ScreenshotTest(driver, "Popup Window");

			driver.navigate().back();

		}

		@Test(priority = 4)
		public void mouseOver() throws Exception {
			driver.findElement(By.xpath("//img[contains(@alt,'Thailand-Visa-Free')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(.,'Login')]")).click();
			Thread.sleep(3000);
			
			/*WebElement ele = driver.findElement(By.xpath("(//a[contains(.,'TRAVEL INFORMATION')])[2]"));
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(.,'Weather')]")).click();
			Thread.sleep(3000);
			
			ScreenshotLibrary.ScreenshotTest(driver, "Weather");

			driver.findElement(By.xpath("//input[@id='MainBody_IWOVID_item_1_autoBoxOrigin_txtCountry']"))
					.sendKeys("Hyderabad");
			driver.findElement(By.xpath("//button[contains(@name,'btnWeatherReport')]")).click();
			Thread.sleep(3000);
			ScreenshotLibrary.ScreenshotTest(driver, "After clicking Get Weather");

			boolean error_msg = driver.findElement(By.xpath("//span[@id='SpnCity']")).isDisplayed();
			if (error_msg) {
				System.out.println("Error message is displayed ");
			}

			else {
				System.out.println("Error message is not displayed");

			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='MainBody_IWOVID_item_1_autoBoxOrigin_txtCountry']")).clear();
			Thread.sleep(3000);
			ScreenshotLibrary.ScreenshotTest(driver, "After clearing data in the text box");*/
			
			

		}
	}
}
