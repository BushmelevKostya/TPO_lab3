package itmo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://ukit.com/ru?utm_source=ucozmain&utm_medium=ulp&utm_campaign=umainlp2/#signUp
public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}