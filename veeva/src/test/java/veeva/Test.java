package veeva;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Test {

    public static void main(String[] args) {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open YouTube
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Search for "Believer Imagine Dragons"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
        driver.findElement(By.name("search_query"))
                .sendKeys("Believer Imagine Dragons" + Keys.ENTER);

        // Click on the first video result
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//ytd-video-renderer//a[@id='video-title'])[1]")));
        driver.findElement(
                By.xpath("(//ytd-video-renderer//a[@id='video-title'])[1]")).click();

        // Let the song play for 20 seconds
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close browser
        driver.quit();
    }
}
