import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Language {

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

    private void scrollPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        Thread.sleep(1000);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
    }

    @Test
    public void english() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.cssSelector("span.title-with-button"));
        Assert.assertTrue(title.isDisplayed(), "EN: 'New Games' title not visible");
        scrollPage();
    }

    @Test
    public void spanish() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/es/frontpage");
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.cssSelector("h2.common-title span.title-with-button"));
        Assert.assertEquals(title.getText().trim(), "NUEVOS JUEGOS");
        scrollPage();
    }

    @Test
    public void french() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/fr/frontpage");
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.cssSelector("h2.common-title span.title-with-button"));
        Assert.assertEquals(title.getText().trim(), "NOUVEAUX JEUX");
        scrollPage();
    }

    @Test
    public void italian() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/it/frontpage");
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.cssSelector("h2.common-title span.title-with-button"));
        Assert.assertEquals(title.getText().trim(), "NUOVI GIOCHI");
        scrollPage();
    }

    @Test
    public void hindi() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/hi/frontpage");
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.cssSelector("h2.common-title span.title-with-button"));
        Assert.assertEquals(title.getText().trim(), "नए खेल");
        scrollPage();
    }

    @Test
    public void chinese() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/zh-hans/frontpage");
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.cssSelector("h2.common-title span.title-with-button"));
        Assert.assertEquals(title.getText().trim(), "新游戏");
        scrollPage();
    }

    @Test
    public void japanese() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/ja/frontpage");
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.cssSelector("h2.common-title span.title-with-button"));
        Assert.assertEquals(title.getText().trim(), "新しいゲーム");
        scrollPage();
    }

    @Test
    public void deutsch() throws InterruptedException {
        driver.get("https://www.coolmathgames.com/de/frontpage");
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.cssSelector("h2.common-title span.title-with-button"));
        Assert.assertEquals(title.getText().trim(), "NEUE SPIELE");
        scrollPage();
    }
}
