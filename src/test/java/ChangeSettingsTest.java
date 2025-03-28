// Generated by Selenium IDE
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
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ChangeSettingsTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
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
    driver.get("https://www.ucoz.ru/");
    driver.manage().window().setSize(new Dimension(1550, 830));
    driver.findElement(By.linkText("Войти")).click();
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.cssSelector(".nowrap > span")).click();
    vars.put("win2734", waitForWindow(2000));
    driver.switchTo().window(vars.get("win2734").toString());
    driver.findElement(By.cssSelector(".popup-close-btn")).click();
    driver.findElement(By.cssSelector(".dashboard-card:nth-child(1) li:nth-child(3) .setting-name")).click();
    driver.findElement(By.cssSelector("#dcid1 > a:nth-child(2) > img")).click();
    driver.findElement(By.id("subbutfrm348")).click();
    driver.findElement(By.linkText("Добавить пункт меню")).click();
    driver.findElement(By.id("mnTitle")).click();
    driver.findElement(By.id("mnTitle")).sendKeys("Расписание");
    driver.findElement(By.id("mnUrl")).click();
    driver.findElement(By.id("subbutfrm348")).click();
    driver.findElement(By.id("subbutfrm349")).click();
  }
}
