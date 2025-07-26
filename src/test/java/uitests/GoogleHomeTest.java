package uitests;

import org.testng.Assert;
import org.testng.annotations.Test;
import webdriver.BaseTest;

public class GoogleHomeTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {
        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch detected!");
    }
}