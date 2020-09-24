package com.saucedemo;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

/*
* First shown by Simon Stewart 7/18/20
* https://www.youtube.com/watch?time_continue=14&v=c163xQXiiEM&feature=emb_logo
* */

public class HelloSelenium2Test {

    private WebDriver driver;

    @After
    public void tearDown() throws Exception {
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void deprecatedTest()
    {
        driver = new SafariDriver();
        //Deprecated in 4.x
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        //Removed in 4.x
        WebElement button = driver.findElement(By.name("LOGIN"));
        button.click();
    }

    @Test
    public void relativeLocators() {
        driver = new SafariDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        /*
        * This currently doesn't work as there's a bug.
        * The bug has been resolved and will likely work in .7-alpha
        * https://github.com/SeleniumHQ/selenium/issues/8368
        * */
        WebElement password = driver.findElement(By.id("password"));
        WebElement button =driver.findElement(withTagName("input").below(password));
        button.click();
    }
}