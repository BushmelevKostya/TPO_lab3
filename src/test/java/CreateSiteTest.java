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
public class CreateSiteTest {
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
  @Test
  public void createSite() {
    driver.get("https://www.ucoz.ru/");
    driver.manage().window().setSize(new Dimension(1550, 830));
    driver.findElement(By.linkText("Войти")).click();
    driver.findElement(By.id("fEmail")).click();
    driver.findElement(By.id("fEmail")).sendKeys("kostikbushmelev@yandex.ru");
    driver.findElement(By.id("fPassword")).click();
    driver.findElement(By.id("fPassword")).sendKeys("strongpassword");
    driver.findElement(By.id("submit_btn")).click();
    driver.findElement(By.id("site_address")).click();
    driver.findElement(By.id("site_address")).sendKeys("testSite");
    driver.findElement(By.id("submit_btn")).click();
    driver.switchTo().frame(2);
  }
}
