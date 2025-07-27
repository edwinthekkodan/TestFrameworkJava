package UI_Automation.uitests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import UI_Automation.webdriver.BaseTest;

public class JavaKeywordDemoTest extends BaseTest {

    static final String URL = "https://demoqa.com/text-box"; // 🔒 final + static usage

    @Test
    public void testJavaKeywordsInUIFlow() throws InterruptedException {
        try {
            driver.get(URL);
            Thread.sleep(2000); // Wait for page load

            // Interacting with the UI
            driver.findElement(By.id("userName")).sendKeys("Edwin");
            driver.findElement(By.id("userEmail")).sendKeys("edwin@example.com");
            driver.findElement(By.id("currentAddress")).sendKeys("Pune");
            driver.findElement(By.id("permanentAddress")).sendKeys("Maharashtra");
            driver.findElement(By.id("submit")).click();

            // Some dummy final variable usage
            final int confirmationCode = 101;  // 🔐 final example
            System.out.println("Confirmation code is: " + confirmationCode);

        } finally {
            System.out.println("Cleaning up resources..."); // 🔄 finally block executes no matter what
        }
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        driver = null;
        System.gc();  // 🧹 finalize() may be called here
    }

    // 🎯 finalize demonstration (Note: Rarely used in practice)
    @Override
    protected void finalize() {
        System.out.println("Finalize method called for cleanup!");
    }
}