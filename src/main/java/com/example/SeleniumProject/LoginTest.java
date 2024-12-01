package com.example.SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.cdimascio.dotenv.Dotenv;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "G:/java/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
         try {
            driver.get("https://www.reddit.com/login/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement fieldUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-username")));
            WebElement fieldPassword = driver.findElement(By.id("login-password"));
            Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
            fieldUsername.sendKeys(dotenv.get("REDDIT_USERNAME"));
            fieldPassword.sendKeys(dotenv.get("REDDIT_PASSWORD"));
            Actions builder = new Actions(driver);
            builder.keyDown(Keys.RETURN).keyUp(Keys.RETURN).build().perform();
          } finally {
            //driver.quit();
        }
    }
}
