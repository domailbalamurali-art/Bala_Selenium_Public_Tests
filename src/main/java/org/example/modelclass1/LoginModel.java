package org.example.modelclass1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// This class follows the Page Object Model (POM) design pattern.
// It encapsulates the web elements and actions of the login page.
public class LoginModel {

    // The WebDriver instance is passed to this class to interact with the browser.
    private WebDriver wd;

    // Locators for the web elements on the login page.
    // Using 'By' objects makes locators reusable and easy to manage.
    private By email = By.name("email");
    private By password = By.name("password");
    private By submitButton = By.xpath("//button [@type='submit']");

    // The URL for the login page.
    private String loginURL = "https://demo.evershop.io/account/login";

    // A locator for a post-login element to verify successful login.
    // Note: You will need to replace this with an actual locator from the site
    // after a successful login (e.g., a "My Account" link or "Logout" button).
    private By postLoginVerificationElement = By.xpath("//a[contains(@href, '/account')]");

    // Constructor to initialize the WebDriver instance for this page model.
    public LoginModel(WebDriver driver) {
        this.wd = driver;
    }

    /**
     * Navigates the browser to the login page URL.
     * @return The current LoginModel instance for method chaining.
     */
    public LoginModel enterTheURL() {
        wd.get(loginURL);
        return this;
    }

    /**
     * Fills the login form with the provided credentials and clicks the submit button.
     * @param emailId The email address to use for login.
     * @param password The password for the account.
     * @return The current LoginModel instance for method chaining.
     */
    public LoginModel fillCredentials(String emailId, String password) {
        wd.findElement(this.email).sendKeys(emailId);
        wd.findElement(this.password).sendKeys(password);
        wd.findElement(this.submitButton).click();
        return this;
    }

    /**
     * Verifies if the login was successful by checking for a specific element
     * that appears after logging in.
     * @return true if the element is found, false otherwise.
     */
    public boolean isLoginSuccessful() {
        try {
            // Wait for a few seconds to let the page load after login.
            // Note: This is a static wait and is not recommended for production code.
            // Use explicit waits (WebDriverWait) for a more robust solution.
            Thread.sleep(5000);
            // Check if the post-login verification element is displayed on the page.
            return wd.findElement(postLoginVerificationElement).isDisplayed();
        } catch (Exception e) {
            // If the element is not found, an exception will be thrown,
            // and we return false.
            return false;
        }
    }
}


/*package org.example.javabasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginModel {

    WebDriver wd;
    private By email = By.name("email");
    private By password = By.name("password");
    private String loginURL = "https://demo.evershop.io/account/login";
    private By submitButton = By.xpath("//button [@type='submit']");

    public LoginModel(WebDriver driver) {
        this.wd = driver;
    }

    public LoginModel enterTheURL() {
        wd.get(loginURL);
        return this;
    }
    public LoginModel fillCredentials(String emailId, String password) {
        // Find the email input field and enter the email address
        wd.findElement(this.email).sendKeys(emailId);
        // Find the password input field and enter the password
        wd.findElement(this.password).sendKeys(password);
        // Find the submit button and click it
        wd.findElement(this.submitButton).click();
        return this;
    }

}

   /* public LoginModel fillCredentials(String emailId, String password) {
        class E2ETestForEcommerce {

            ChromeOptions chromeOptions;
            WebDriver wd;

            @BeforeMethod(alwaysRun = true)
            public void beforeMethod() throws MalformedURLException {
                chromeOptions = new ChromeOptions();
                wd = new RemoteWebDriver(new URL("http://192.168.68.102:4444"), chromeOptions);
            }

            @Test
            public void loginTest() {
                LoginModel login = new LoginModel(wd);
                login.enterTheURL()
                        .fillCredentials("akhiljda@gmail.com", "Password");
            }


            @AfterMethod
            public void tearDown() {
                if (wd != null) {
                    wd.quit();
                }
            }
        }
        return null;
    }
}*/
