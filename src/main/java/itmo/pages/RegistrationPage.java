package itmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// page_url = https://ukit.com/ru?utm_source=ucozmain&utm_medium=ulp&utm_campaign=umainlp2/#signUp
public class RegistrationPage {
    private final WebDriver driver;
    
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    
    @FindBy(xpath = "//input[@id='sign_up_password']")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[contains(text(), 'Зарегистрироваться')]")
    private WebElement submitButton;
    
    @FindBy(xpath = "//div[contains(text(), 'Выбор шаблона')]")
    private WebElement successMessage;
    
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
        submitButton.click();
    }
    
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}