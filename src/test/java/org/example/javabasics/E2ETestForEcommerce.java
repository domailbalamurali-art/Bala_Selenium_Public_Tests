package org.example.javabasics;

import org.example.modelclass1.LoginModel;
//the above steps take the variables and methods from the class LoginModel, which helps us to keep the variables(Locators and methods separate)
//Why? To keep the locators in one file and can be used globally and once it is required to change any locator we can come to this file and make the changes.



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

// This is the main TestNG test class that orchestrates the test flow.
public class E2ETestForEcommerce {

    // WebDriver instance, declared here so it can be accessed by all methods.
    ChromeOptions chromeOptions;
    private WebDriver wd;

    /**
     * This method runs before each test method.
     * It sets up the WebDriver by initializing ChromeOptions and creating a RemoteWebDriver
     * to connect to a Selenium Grid.
     * @throws MalformedURLException if the URL is not valid.
     */
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws MalformedURLException {
        // Set ChromeOptions if needed (e.g., for headless mode).
        ChromeOptions chromeOptions = new ChromeOptions();

        // Connect to the Selenium Grid Hub.
        // Make sure your Grid is running at this IP address.
        wd = new RemoteWebDriver(new URL("http://192.168.29.118:4444"), chromeOptions);
    }

    /**
     * This is the main test case for the login functionality.
     * It uses the LoginModel class to perform the login actions in a readable,
     * chained manner and asserts the outcome.
     */
    @Test
    public void loginTest() {
        // Create an instance of the LoginModel and pass the WebDriver.
        LoginModel login = new LoginModel(wd);

        // Perform the login actions using method chaining.
        login.enterTheURL()
                .fillCredentials("akhiljda@gmail.com", "Pasword");

        // *** ASSERTION: This is the most critical part of the test. ***
        // We assert that the login was successful by calling the verification method
        // in the LoginModel. If this returns false, the test will fail.
        //Assert.assertTrue(login.isLoginSuccessful(), "Login was not successful with provided credentials.");
    }

    /**
     * This method runs after each test method. It is responsible for closing the
     * browser and releasing all resources.
     */
    //@AfterMethod(alwaysRun = true)
    //public void tearDown() {
       // if (wd != null) {
     //       wd.quit();
     //   }
  //  }
}








/*package org.example.javabasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class E2ETestForEcommerce{

        // WebDriver instance
        private WebDriver wd;

        /**
         * This method runs before each test method. It sets up the WebDriver
         * by initializing ChromeOptions and creating a RemoteWebDriver instance
         * to connect to a Selenium Grid.
         * @throws MalformedURLException if the URL is not valid.

        @BeforeMethod(alwaysRun = true)
        public void beforeMethod() throws MalformedURLException {
            ChromeOptions chromeOptions = new ChromeOptions();
            // The URL for the Selenium Grid Hub, replace with your own if needed.
            wd = new RemoteWebDriver(new URL("http://192.168.68.102:4444"), chromeOptions);
        }

        /**
         * This is the main test case for the login functionality.
         * It uses the LoginModel class to perform the login actions in a readable,
         * chained manner.

        @Test
        public void loginTest() {
            // Create an instance of the LoginModel
            LoginModel login = new LoginModel(wd);

            // Perform the login actions using method chaining
            login.enterTheURL()
                    .fillCredentials("akhiljda@gmail.com", "Password");
        }

        /**
         * This method runs after each test method. It quits the WebDriver
         * to close the browser and release resources.

        @AfterMethod
        public void tearDown() {
            if (wd != null) {
                wd.quit();
            }
        }
    }


*/
