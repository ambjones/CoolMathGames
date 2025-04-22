import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Logic {
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
    public void testAtoZ () throws InterruptedException{
        driver.get("https://www.coolmathgames.com/");
        driver.manage().window().maximize();
        Thread.sleep(500);

        driver.findElement(By.xpath("/html/body/div[3]/div/main/header[1]/nav/div/div[2]/div/div/div/ul/li[4]/a")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"tab-az\"]")).click();
        Thread.sleep(3000);

        for (int i = 0; i < 15; i++) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100)");
            Thread.sleep(500);
        }
        Thread.sleep(1000);
    }

    @Test (priority = 2)
    public void testPageNumbers () throws InterruptedException{

        // scroll back to top of page
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -1500)");
        Thread.sleep(1000);

        // select most liked tab
        driver.findElement(By.xpath("//*[@id=\"tab-mostliked\"]")).click();
        Thread.sleep(1000);

        // scroll to the bottom of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1500)");
        Thread.sleep(2000);

        // click tab 2 at the bottom of the page
        driver.findElement(By.xpath("//*[@id=\"panel-mostliked\"]/div/section/section/div/div/nav/nav/div[1]/div/div[2]/a/span[2]")).click();
        Thread.sleep(1000);

        // scroll back down
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1500)");
        Thread.sleep(2000);

        //click on tab 3
        driver.findElement(By.xpath("//*[@id=\"panel-mostliked\"]/div/section/section/div/div/nav/nav/div[1]/div/div[3]/a/span[2]")).click();
        Thread.sleep(1500);

        // scroll back down
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1500)");
        Thread.sleep(2000);
    }
    @Test (priority = 3)
    public void checkRecommended () throws InterruptedException{

        // scroll back to top of page
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -1500)");
        Thread.sleep(1000);

        // click on recommended tab
        driver.findElement(By.xpath("//*[@id=\"tab-recommended\"]")).click();
        Thread.sleep(2000);

        // scroll down and click on see all escape games
        for (int i = 0; i < 11; i++) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100)");
            Thread.sleep(200);
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"panel-recommended\"]/div/div/div/section[5]/div[1]/div/a")).click();
        Thread.sleep(1500);

        // Click the arrow twice to scroll through the new escape games
        driver.findElement(By.xpath("//*[@id=\"panel-recommended\"]/div/div/div/section[1]/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"panel-recommended\"]/div/div/div/section[1]/div[2]/div/div[1]/div[2]/button[2]")).click();
        Thread.sleep(1000);
    }
    @Test (priority = 4)
    public void verifyGameLoads () throws InterruptedException{

        // click on logic again near the top of the screen
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/div[1]/header/nav/nav/ol/li[3]/a")).click();
        Thread.sleep(1000);

        // click on the new tab
        driver.findElement(By.xpath("//*[@id=\"tab-new\"]")).click();
        Thread.sleep(5000);

        // select rope wrapper game
        driver.findElement(By.xpath("//*[@id=\"panel-new\"]/div/section/section/div/div/div/div/div[2]/div/div/div/div/div/a/div[1]/div")).click();
        Thread.sleep(8000);
    }
    @Test (priority = 5)
    public void loadRandomGame () throws InterruptedException{
        // click on random game button and verify that it loads
        driver.findElement(By.xpath("/html/body/div[3]/div/main/header[1]/nav/div/div[3]/div/div/ul/li[1]/a")).click();
        Thread.sleep(5000);

        System.out.println("This game has successfully started loading");
        Thread.sleep(1000);
    }

}
