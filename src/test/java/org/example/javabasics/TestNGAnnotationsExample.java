package org.example.javabasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGAnnotationsExample {


    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("--- @BeforeSuite: Setting up Chrome driver property ---");

        System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver.exe");
    }

    // =================================================================================

    @BeforeTest
    public void beforeTest() {
        System.out.println("---- @BeforeTest: Preparing test environment ----");
    }

    // =================================================================================
    // Class Level Annotations: Run once for each test class
    // =================================================================================

    /**
     * @BeforeClass: This method runs only once per class, before the first @Test method
     * in the current class is invoked.
     * A perfect place to initialize the WebDriver and open the browser.
     */
    @BeforeClass
    public void beforeClass() {
        System.out.println("------ @BeforeClass: Initializing WebDriver and opening browser ------");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // =================================================================================
    // Method Level Annotations: Run for each @Test method
    // =================================================================================

    /**
     * @BeforeMethod: This method runs before each and every @Test method.
     * It's ideal for navigating to the application URL or ensuring a clean state
     * before a test begins.
     */
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("-------- @BeforeMethod: Navigating to Google --------");
        driver.get("https://www.google.com");
    }

    // =================================================================================
    // Test Cases
    // ========================================================================

    /**
     * @Test: This annotation marks a method as a test case.
     * This is the actual test logic.
     */
    @Test(priority = 1)
    public void verifyGoogleTitle() {
        System.out.println("---------- @Test 1: Verifying Google Title ----------");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }


    @Test(priority = 2)
    public void verifyGoogleUrl() {
        System.out.println("---------- @Test 2: Verifying Google URL ----------");
        String expectedUrl = "https://www.google.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl), "URL is incorrect!");
    }


    // =================================================================================
    // "After" Annotations (Teardown) - Run in reverse order of "Before"
    // =================================================================================

    /**5
4++++++++++++++++
     * @AfterMethod: This method runs after each and every @Test method.
     * Useful for post-test cleanup, like taking a screenshot on failure or logging out.
     */
    @AfterMethod
    public void afterMethod() {
        System.out.println("-------- @AfterMethod: Test method finished --------\n");
    }

    /**
     * @AfterClass: This method runs only once per class, after all the @Test methods
     * in the current class have been run.
     * The best place to close the browser and quit the driver session.
     */
    @AfterClass
    public void afterClass() {
        System.out.println("------ @AfterClass: Closing browser ------");
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * @AfterTest: This method runs after all the @Test methods belonging to the classes
     * inside the <test> tag in testng.xml have completed.
     */
    @AfterTest
    public void afterTest() {
        System.out.println("---- @AfterTest: Tearing down test environment ----");
    }

    /**
     * @AfterSuite: This method runs only once, after all tests in this suite have run.
     * Used for final cleanup activities, like generating a custom report.
     */
    @AfterSuite
    public void afterSuite() {
        System.out.println("--- @AfterSuite: Suite execution finished. Cleaning up. ---");
    }
}


