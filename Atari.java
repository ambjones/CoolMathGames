import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Atari {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void navigateToHomepage() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(2000);
        WebElement title = driver.findElement(By.cssSelector("span.title-with-button"));
        Assert.assertTrue(title.isDisplayed(), "Homepage did not load properly.");
    }

    @Test(priority = 2)
    public void clickAllGamesTab() throws InterruptedException {
        WebElement allGamesLink = driver.findElement(By.xpath("//a[@href='/all-games']"));
        Assert.assertTrue(allGamesLink.isDisplayed(), "'All Games' link not found.");
        allGamesLink.click();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void selectAtariAsteroids() throws InterruptedException {
        WebElement asteroidsLink = driver.findElement(By.xpath("//a[@href='/0-asteroids']"));
        Assert.assertTrue(asteroidsLink.isDisplayed(), "'Atari Asteroids' link not found.");
        asteroidsLink.click();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void clickThumbsUpIcon() throws InterruptedException {
        WebElement thumbsUp = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.thumb-icon")));

        thumbsUp.click();
        Thread.sleep(2000);
    }


    @Test(priority = 5)
    public void clickDislikeButton() throws InterruptedException {
        WebElement dislikeButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("a[aria-label='Dislike Atari Asteroids']")));

        dislikeButton.click();
        Thread.sleep(2000);
    }



}