package veeva;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Test2 {

    public static void main(String[] args) {

        // (a) Launch browser and navigate to URL
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        // (d) Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // (b) Locate elements using robust CSS selectors
        WebElement searchBox = driver.findElement(
                By.cssSelector("input#twotabsearchtextbox"));

        WebElement searchButton = driver.findElement(
                By.cssSelector("input#nav-search-submit-button"));

        // (c) Perform basic user actions
        // Enter text into input field
        searchBox.sendKeys("Headphones");

        // Click a button
        searchButton.click();

        // (d) Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultsText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("span.a-color-state")));

        // (e) Verification & Validation
        if (resultsText.isDisplayed()) {
            System.out.println("Search results are displayed successfully.");
        } else {
            System.out.println("Search results are NOT displayed.");
        }

        // Close browser
        driver.quit();
    }
}

