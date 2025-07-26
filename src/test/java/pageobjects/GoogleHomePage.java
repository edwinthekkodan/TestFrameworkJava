package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    
    private WebDriver driver;
    
    // Locators
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");
    
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void searchFor(String searchTerm) {
        WebElement search = driver.findElement(searchBox);
        search.sendKeys(searchTerm);
        driver.findElement(searchButton).click();
    }
    
    public String getTitle() {
        return driver.getTitle();
    }
}