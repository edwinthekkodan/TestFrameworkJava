package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQATextBoxPage {
    
    private WebDriver driver;
    
    // Locators
    private By userNameField = By.id("userName");
    private By emailField = By.id("userEmail");
    private By currentAddressField = By.id("currentAddress");
    private By permanentAddressField = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    
    public DemoQATextBoxPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void fillForm(String name, String email, String currentAddress, String permanentAddress) {
        driver.findElement(userNameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(currentAddressField).sendKeys(currentAddress);
        driver.findElement(permanentAddressField).sendKeys(permanentAddress);
    }
    
    public void submitForm() {
        driver.findElement(submitButton).click();
    }
}