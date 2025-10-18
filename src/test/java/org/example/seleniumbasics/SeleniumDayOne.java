package org.example.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumDayOne {

    public static void main(String args[]) throws MalformedURLException {

        ChromeOptions cd = new ChromeOptions();
        WebDriver chromeDriver = new RemoteWebDriver(new URL("http://192.168.29.118:4444"), cd);

    //ChromeDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://demo.evershop.io/account/login");
    chromeDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("akhiljda@gmail.com");
    chromeDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Password");
    chromeDriver.findElement(By.xpath("//button[@type='submit']")).click();

  /*      Thread.sleep(10000);
        JavascriptExecutor js;
        chromeDriver.get(ExpectedConditions.urlContains("https://demo.evershop.io/"));

                JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement nikeZoomFlyProduct = chromeDriver.get(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Nike Zoom Fly")));
        System.out.println("Found the product: " + nikeZoomFlyProduct.getText());
   */
    }
}

//you did it boy!! More tomorrow