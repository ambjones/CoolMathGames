import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Categories {

    WebDriver driver;

    @BeforeClass
    public void setChrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void categoriesPage() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(1000);

        WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
        categoriesLink.click();
        Thread.sleep(1000);

        String expectedUrl = "https://www.coolmathgames.com/categories";
        String actualUrl = driver.getCurrentUrl();

        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("URL mismatch! Expected: " + expectedUrl + ", but got: " + actualUrl);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, 0);");
    }

    @Test
    public void categoriesNewGames() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(1000);

        WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
        categoriesLink.click();
        Thread.sleep(2000);

        WebElement newGamesLink = driver.findElement(By.cssSelector("a.inner[href='1-new-games']"));
        newGamesLink.click();
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String newGamesUrl = "https://www.coolmathgames.com/1-new-games";

        if (!actualUrl.equals(newGamesUrl)) {
            throw new AssertionError("URL mismatch! Expected: " + newGamesUrl + ", but got: " + actualUrl);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, 0);");
    }

    @Test
    public void categoriesPopular() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(1000);

        WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
        categoriesLink.click();
        Thread.sleep(2000);

        WebElement popularLink = driver.findElement(By.cssSelector("a.inner[href='1-popular-games']"));
        popularLink.click();
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String popularUrl = "https://www.coolmathgames.com/1-popular-games";

        if (!actualUrl.equals(popularUrl)) {
            throw new AssertionError("URL mismatch! Expected: " + popularUrl + ", but got: " + actualUrl);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, 0);");
    }

    @Test
    public void categoriesDailyGames() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(1000);

        WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
        categoriesLink.click();
        Thread.sleep(2000);

        WebElement dailyGamesLink = driver.findElement(By.cssSelector("a.inner[href='/c/daily-games']"));
        dailyGamesLink.click();
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String dailyGamesUrl = "https://www.coolmathgames.com/c/daily-games";

        if (!actualUrl.equals(dailyGamesUrl)) {
            throw new AssertionError("URL mismatch! Expected: " + dailyGamesUrl + ", but got: " + actualUrl);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, 0);");
    }

    @Test
    public void categoriesCutTheRope() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(1000);

        WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
        categoriesLink.click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);

        WebElement cutTheRopeLink = driver.findElement(By.cssSelector("a.inner[href='http://www.coolmathgames.com/c/cut-the-rope-games']"));
        cutTheRopeLink.click();
        Thread.sleep(1000);

        WebElement mostLikedElement = driver.findElement(By.xpath("//span[text()='Most Liked']"));
        mostLikedElement.click();
        Thread.sleep(1000);

        WebElement azElement = driver.findElement(By.xpath("//span[text()='A - Z']"));
        azElement.click();
        Thread.sleep(1000);
    }
}
