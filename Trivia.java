import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Trivia {

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
    public void goToTriviaCategory() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600);");
        Thread.sleep(1000);

        WebElement triviaLink = driver.findElement(By.xpath("//a[@href='/trivia']"));
        Assert.assertTrue(triviaLink.isDisplayed(), "Trivia link not visible on homepage.");
        triviaLink.click();
        Thread.sleep(3000);

        WebElement triviaGameTile = driver.findElement(By.xpath("//a[@href='/trivia/name-that-candy-vol-2']"));
        Assert.assertTrue(triviaGameTile.isDisplayed(), "'Name That Candy! Vol. 2' game not visible.");

    }

    @Test(priority = 3)
    public void openNameThatCandyVol2() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        Thread.sleep(2000);

        WebElement candyGameLink = driver.findElement(By.xpath("//a[@href='/trivia/name-that-candy-vol-2']"));
        Assert.assertTrue(candyGameLink.isDisplayed(), "'Name That Candy! Vol. 2' game not found.");
        candyGameLink.click();
        Thread.sleep(5000);

        WebElement gameTitle = driver.findElement(By.cssSelector("h1"));
        Assert.assertTrue(gameTitle.getText().toLowerCase().contains("name that candy"), "Candy game page not loaded properly.");
    }

    @Test(priority = 4)
    public void startCandyQuiz() throws InterruptedException {
        Thread.sleep(3000);

        WebElement startButton = driver.findElement(By.id("start-the-quiz"));
        Assert.assertTrue(startButton.isDisplayed(), "'Start The Quiz' button not visible.");
        startButton.click();
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void selectSourPatchKids() throws InterruptedException {
        Thread.sleep(3000);

        WebElement answer = driver.findElement(By.xpath("//p[text()='Sour Patch Kids']"));
        Assert.assertTrue(answer.isDisplayed(), "'Sour Patch Kids' answer not found.");
        answer.click();
        Thread.sleep(2000);
    }
}
