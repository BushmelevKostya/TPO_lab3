package itmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    
    @FindBy(xpath = "//input[@id='fEmail']")
    private WebElement emailField;
    
    @FindBy(xpath = "//input[@id='fPassword']")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[contains(text(), 'Создать сайт')]")
    private WebElement submitButton;
    
    @FindBy(xpath = "//h2[contains(text(), 'Проверка e-mail адреса')]")
    private WebElement successMessage;
    
    @FindBy(xpath = "//span[@class='error-message']")
    private WebElement errorMessage;
    
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }
    
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    
    public void submitForm() {
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        submitButton.click();
    }
    
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
    
    public boolean isErrorMessageDisplayed() {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        return errorMessage.isDisplayed();
    }
    
    public void pressTab() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }
}