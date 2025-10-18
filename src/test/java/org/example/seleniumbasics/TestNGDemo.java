package org.example.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestNGDemo {
    @Test
    public void successLoginTest() throws MalformedURLException {

        ChromeOptions cd = new ChromeOptions();
        WebDriver chromeDriver = new RemoteWebDriver(new URL("http://192.168.29.118:4444"), cd);

        //ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://demo.evershop.io/account/login");
        chromeDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("akhiljda@gmail.com");
        chromeDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Password");
        chromeDriver.findElement(By.xpath("//button[@type='submit']")).click();

    }


@Test
    public void failedLoginTest() throws MalformedURLException {

        ChromeOptions cd = new ChromeOptions();
        WebDriver chromeDriver = new RemoteWebDriver(new URL("http://192.168.29.118:4444"), cd);

        //ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://demo.evershop.io/account/login");
        chromeDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("akhiljda@gmail.com");
        chromeDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Pasword");
        chromeDriver.findElement(By.xpath("//button[@type='submit']")).click();

    }

}