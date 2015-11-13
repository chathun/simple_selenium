package com.tokbox.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebElement;
import com.tokbox.pages.*;

/**
 * This is the test class.  It has all the test methods.  
 * @author chathuri
 *
 */


public class SignupPageTest {
	SignupPage signup;

	protected static String BASE_ENDPOINT = "http://tokbox.com";
	public static WebDriver driver;

	@DataProvider(name = "user")
	private static Object[][] user() {
		return new Object[][] { { "Mary", "Smith", "TokBox","password" } };
	};

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) throws MalformedURLException, InterruptedException {
		driver = createWebDriver(browser);
		getWebDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(BASE_ENDPOINT);
	}

    @AfterClass
	public void afterClass() {
		if (getWebDriver() != null) {
			getWebDriver().quit();
		}
	}

	public WebDriver createWebDriver(String browser) throws InterruptedException {
		WebDriver newdriver = null;
		if (browser.equalsIgnoreCase("firefox"))
			newdriver = new FirefoxDriver();
		if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		    newdriver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("safari")) {

			newdriver = new SafariDriver();
		}

		newdriver.manage().window().maximize();
		return newdriver;
	}

	public static WebDriver getWebDriver() {
		return driver;
	}

	@Test
	public void testLoginSucces() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
		WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(getWebDriver().findElement(By.xpath(
				"//div[@class='left-side ten offset-by-pointfive columns']//a[@class='btn-blue-v2 btn ctaarrow-gray']"))));
		signup.click();
	}

	@Test(dependsOnMethods = { "testLoginSucces" }, dataProvider = "user")
	public void testSignUp(String firstname, String lastname, String company, String password) throws InterruptedException {
		SignupPage signup = new SignupPage(getWebDriver());
		signup.getFirstName().sendKeys(firstname);
		signup.getLastName().sendKeys(lastname);
		signup.getCompanyName().sendKeys(company);
		signup.getPassword().sendKeys(password);
		signup.getTos().click();
		signup.getNext().click();
		Assert.assertTrue(signup.getError().isDisplayed());
		Assert.assertEquals(signup.getError().getText(), "Please enter a valid email address.");

	}

}
