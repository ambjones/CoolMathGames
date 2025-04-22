import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class SearchBar {

    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit(); // Only closes after all tests finish
    }

    @Test
    public void searchBarFunctionality() {
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        searchBar.click();
        searchBar.sendKeys("Search Bar Input Working");
    }

    @Test
    public void searchBarWhenEmpty() {
        driver.get("https://www.coolmathgames.com/"); // Reset to homepage if test depends on it
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        searchBar.click();
        WebElement button = driver.findElement(By.className("see-result"));
        button.click();

        String expectedUrl = "https://www.coolmathgames.com/";
        String actualUrl = driver.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("URL mismatch! Expected: " + expectedUrl + ", but got: " + actualUrl);
        }
    }

    @Test
    public void searchBarClearing() {
        driver.get("https://www.coolmathgames.com/");
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        searchBar.click();
        searchBar.sendKeys("Sugar, Sugar Christmas");


        Actions actions = new Actions(driver);
        for (int i = 0; i < "Sugar, Sugar Christmas".length(); i++) {
            actions.sendKeys(Keys.BACK_SPACE);
        }
        actions.perform();

        String clearedText = searchBar.getAttribute("value");
        if (!clearedText.isEmpty()) {
            throw new AssertionError("The search bar was not cleared properly with backspace.");
        }
    }

    @Test
    public void searchBarValidSearch() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        searchBar.click();
        searchBar.sendKeys("Sugar, Sugar Christmas");
        WebElement button = driver.findElement(By.className("see-result"));
        button.click();
        Thread.sleep(2000);

        WebElement sugarSugar = driver.findElement(By.cssSelector("a[aria-label*='Play Sugar, Sugar']"));
        sugarSugar.click();

        String expectedUrl = "https://www.coolmathgames.com/0-sugar-sugar-christmas-xmas-edition";
        String actualUrl = driver.getCurrentUrl();

        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("URL mismatch! Expected: " + expectedUrl + ", but got: " + actualUrl);
        }
    }

    @Test
    public void searchBarInvalidSearch() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        searchBar.click();
        searchBar.sendKeys("NOT Sugar, Sugar Christmas");
        WebElement button = driver.findElement(By.className("see-result"));
        button.click();
        Thread.sleep(2000);

        List<WebElement> results = driver.findElements(By.cssSelector("a[aria-label*='Play Sugar, Sugar']"));
        if (!results.isEmpty()) {
            throw new AssertionError("Unexpected results found for invalid search.");
        }
    }
}
