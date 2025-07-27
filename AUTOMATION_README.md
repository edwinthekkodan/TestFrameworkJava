# Automation Testing Framework

This project includes both UI automation using Selenium WebDriver and API automation using Karate framework.

## Project Structure

```
src/test/java/
├── API_Automation/               # API Automation (Karate)
│   └── features/
│       ├── ApiTestRunner.java    # API test runner
│       └── sample-api.feature    # Sample API tests
├── UI_Automation/                # UI Automation (Selenium)
│   ├── webdriver/
│   │   └── BaseTest.java         # WebDriver base configuration
│   ├── pageobjects/              # Page Object Model classes
│   │   ├── DemoQATextBoxPage.java # DemoQA page objects
│   │   └── GoogleHomePage.java   # Google page objects
│   └── uitests/                  # UI test classes
│       ├── GoogleHomeTest.java   # Google UI tests
│       └── JavaKeywordDemoTest.java # Demo UI tests
└── resources/
    ├── karate-config.js          # Karate configuration
    └── simplelogger.properties   # Logging configuration
```

## Running Tests

### UI Tests (Selenium WebDriver):
```bash
# Run all UI tests
mvn test -Dtest=*Test

# Run specific UI test
mvn test -Dtest=GoogleHomeTest

# Run with specific browser
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge

# Run using TestNG XML
mvn test -DsuiteXmlFile=testng.xml
```

### API Tests (Karate):
```bash
# Run API tests
mvn test -Dtest=API_Automation.features.ApiTestRunner

# Run with specific environment
mvn test -Dtest=API_Automation.features.ApiTestRunner -Dkarate.env=test
```

### Run All Tests:
```bash
mvn test
```

## UI Automation (Selenium WebDriver)

### Framework Features:
- **BaseTest**: Cross-browser support (Chrome, Firefox, Edge)
- **Page Object Model**: Organized page classes in `pageobjects/`
- **TestNG Integration**: Parameterized tests and parallel execution
- **WebDriverManager**: Automatic driver management

### Writing UI Tests:
1. Extend `BaseTest` class for WebDriver setup
2. Create page objects in `UI_Automation.pageobjects` package
3. Write test classes in `UI_Automation.uitests` package
4. Use TestNG annotations (`@Test`, `@BeforeMethod`, `@AfterMethod`)

### Sample UI Test:
```java
public class SampleTest extends BaseTest {
    @Test
    public void testExample() {
        driver.get("https://example.com");
        // Test implementation
    }
}
```

## API Automation (Karate)

### Framework Features:
- **Environment Configuration**: Multi-environment support
- **Gherkin Syntax**: BDD-style test writing
- **Built-in Assertions**: Rich matching capabilities
- **JSON/XML Support**: Native data handling

### Writing API Tests:
1. Create `.feature` files in `src/test/java/API_Automation/features/`
2. Use Gherkin syntax with Karate keywords
3. Common Karate keywords:
   - `url` - set base URL
   - `path` - set endpoint path
   - `method` - HTTP method (GET, POST, PUT, DELETE)
   - `request` - request body
   - `status` - expected status code
   - `match` - assertions

### Environment Configuration:
Edit `src/test/resources/karate-config.js` for environment settings:
- `dev` - Development environment (default)
- `test` - Test environment
- `prod` - Production environment

### Sample API Test:
```gherkin
Feature: API Test Example

  Background:
    * url baseUrl

  Scenario: Test API endpoint
    Given path '/endpoint'
    And request { "key": "value" }
    When method POST
    Then status 200
    And match response.result == 'success'
```

## Browser Configuration

Supported browsers can be configured via:
- System property: `-Dbrowser=chrome`
- TestNG parameter in `testng.xml`
- Default: Chrome

## Dependencies

- **Selenium WebDriver 4.11.0**: UI automation
- **TestNG 7.4.0**: Test framework
- **WebDriverManager 5.6.2**: Driver management
- **Karate 1.2.0**: API automation
- **SLF4J**: Logging