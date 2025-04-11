import io.github.bonigarcia.wdm.WebDriverManager;
import itmo.pages.RegistrationPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class RegistrationTest {
	private WebDriver driver;
	private RegistrationPage registrationPage;
	private final String BASE_URL = "https://www.ucoz.ru/register?utm_source=main&utm_medium=screen1&utm_campaign=signup";
	
	@BeforeAll
	public static void setupAll() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	}
	
	enum BrowserType {
		CHROME,
		FIREFOX
	}
	
	private WebDriver createDriver(BrowserType browserType) {
		return switch (browserType) {
			case CHROME -> new ChromeDriver();
			case FIREFOX -> new FirefoxDriver();
		};
	}

	@ParameterizedTest
	@EnumSource(BrowserType.class)
	public void testSuccessfulRegistrationChrome(BrowserType browserType) {
		driver = createDriver(browserType);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(BASE_URL);
		
		registrationPage = new RegistrationPage(driver);
		String email = "testuser_" + System.currentTimeMillis() + "@example.com";
		String password = "SecurePass123";
		
		registrationPage.enterEmail(email);
		registrationPage.enterPassword(password);
		registrationPage.submitForm();
		
		Assertions.assertTrue(registrationPage.isSuccessMessageDisplayed(),
				"Сообщение об успешной регистрации не отображается");
	}
	
	@ParameterizedTest
	@EnumSource(BrowserType.class)
	public void enterExistingEmail(BrowserType browserType) {
		driver = createDriver(browserType);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(BASE_URL);
		
		registrationPage = new RegistrationPage(driver);
		String email = "kostikbushmelev@gmail.com";
		String password = "SecurePass123";

		registrationPage.enterEmail(email);
		
		registrationPage.pressTab();
		
		Assertions.assertTrue(registrationPage.isErrorMessageDisplayed(),
				"Сообщение о существовании email не отображается");
	}
	
	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}