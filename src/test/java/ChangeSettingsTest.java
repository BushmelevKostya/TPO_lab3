// Generated by Selenium IDE

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ChangeSettingsTest {
	private WebDriver[] drivers = new WebDriver[2];
	private Map<String, Object> vars;
	JavascriptExecutor js;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		drivers[0] = new FirefoxDriver();
		drivers[1] = new ChromeDriver();
		vars = new HashMap<String, Object>();
	}
	
	public String waitForWindow(int timeout, WebDriver driver) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}
	
	@Test
	public void changeSettings() {
		for (WebDriver driver : drivers) {
			driver.get("https://www.ucoz.ru/");
			driver.manage().window().setSize(new Dimension(1550, 830));
			driver.findElement(By.linkText("Войти")).click();
			driver.findElement(By.id("fEmail")).click();
			driver.findElement(By.id("fEmail")).sendKeys("kostikbushmelev@yandex.ru");
			driver.findElement(By.id("fPassword")).click();
			driver.findElement(By.id("fPassword")).sendKeys("strongpassword");
			driver.findElement(By.id("submit_btn")).click();
			vars.put("window_handles", driver.getWindowHandles());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nowrap > span"))).click();
			vars.put("win2734", waitForWindow(5000, driver));
			driver.switchTo().window(vars.get("win2734").toString());
			driver.findElement(By.cssSelector(".popup-close-btn")).click();
			driver.findElement(By.cssSelector(".dashboard-card:nth-child(1) li:nth-child(3) .setting-name")).click();
			driver.findElement(By.cssSelector("#dcid1 > a:nth-child(2) > img")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("subbutfrm348"))).click();
			driver.findElement(By.linkText("Добавить пункт меню")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("mnTitle"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("mnTitle"))).sendKeys("Расписание");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("mnUrl"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("subbutfrm348"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("subbutfrm349"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cp-home-link"))).click();
			vars.put("window_handles", driver.getWindowHandles());
			driver.findElement(By.xpath("//a[contains(text(), 'https://tpolab.ucoz.net/')]")).click();
			vars.put("win3869", waitForWindow(10000, driver));
			driver.switchTo().window(vars.get("win3869").toString());
			WebElement el = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//span[contains(text(), 'Расписание')]"))));
			assertTrue("Новый элемент не добавился", el.isDisplayed());
			try{Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
			driver.quit();
		}
	}
}
