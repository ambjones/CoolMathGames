import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavBar {

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

    private void pause() throws InterruptedException {
        Thread.sleep(1500);
    }

    private void goToHomepage() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        pause();
    }

    @Test(priority = 1)
    public void strategyCategory() throws InterruptedException {
        goToHomepage();
        WebElement strategy = driver.findElement(By.xpath("//a[@href='/c/strategy-games']"));
        Assert.assertTrue(strategy.isDisplayed(), "Strategy link not visible");
        strategy.click();
        pause();
    }

    @Test(priority = 2)
    public void skillCategory() throws InterruptedException {
        goToHomepage();
        WebElement skill = driver.findElement(By.xpath("//a[@href='/c/skill-games']"));
        Assert.assertTrue(skill.isDisplayed(), "Skill link not visible");
        skill.click();
        pause();
    }

    @Test(priority = 3)
    public void logicCategory() throws InterruptedException {
        goToHomepage();
        WebElement logic = driver.findElement(By.xpath("//a[@href='/c/logic-games']"));
        Assert.assertTrue(logic.isDisplayed(), "Logic link not visible");
        logic.click();
        pause();
    }

    @Test(priority = 4)
    public void classicCategory() throws InterruptedException {
        goToHomepage();
        WebElement classic = driver.findElement(By.xpath("//a[@href='/c/classic-games']"));
        Assert.assertTrue(classic.isDisplayed(), "Classic link not visible");
        classic.click();
        pause();
    }

    @Test(priority = 5)
    public void triviaCategory() throws InterruptedException {
        goToHomepage();
        WebElement trivia = driver.findElement(By.xpath("//a[@href='/trivia']"));
        Assert.assertTrue(trivia.isDisplayed(), "Trivia link not visible");
        trivia.click();
        pause();
    }

    @Test(priority = 6)
    public void categoriesPage() throws InterruptedException {
        goToHomepage();
        WebElement categories = driver.findElement(By.xpath("//a[@href='/categories']"));
        Assert.assertTrue(categories.isDisplayed(), "Categories link not visible");
        categories.click();
        pause();
    }

    @Test(priority = 7)
    public void allGamesPage() throws InterruptedException {
        goToHomepage();
        WebElement allGames = driver.findElement(By.xpath("//a[@href='/all-games']"));
        Assert.assertTrue(allGames.isDisplayed(), "All Games link not visible");
        allGames.click();
        pause();
    }
}
