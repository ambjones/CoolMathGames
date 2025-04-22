import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Skills {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void goToHome() {
        driver.get("https://www.coolmathgames.com/");
    }

    private void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        element.click();
    }

    // 1. Navigating to the skills tab and clicking buttons.
    @Test
    public void NavigateToSkillsandClick() {
        safeClick(By.linkText("Skill"));
        safeClick(By.xpath("//*[@id='tab-new']/span/div[1]"));
        safeClick(By.xpath("//*[@id='tab-mostliked']/span/div[1]"));
        safeClick(By.xpath("//*[@id='tab-az']/span/div[1]"));
    }

    // 2. Scrolling down the page in segments and horizontal scroll.
    @Test
    public void VerticalandHorizontalScroll() {
        safeClick(By.linkText("Skill"));

        js.executeScript("window.scrollBy(0,400)");
        js.executeScript("window.scrollBy(0,800)");
        js.executeScript("window.scrollBy(0,-400)");

        // Horizontal scroll - click arrows
        String baseXPath = "//*[@id='panel-recommended']/div/div/div/section[3]/div[2]/div/div[2]/div/div/button";
        for (int i = 1; i <= 3; i++) {
            safeClick(By.xpath(baseXPath + "[" + i + "]"));
        }

        // Scroll and click left arrow
        safeClick(By.xpath("//*[@id='panel-recommended']/div/div/div/section[3]/div[2]/div/div[1]/div[2]/button[2]"));
    }

    // 3. Hovering over games and clicking the first one.
    @Test
    public void HoveringOverGamesandClick() {
        safeClick(By.linkText("Skill"));

        Actions action = new Actions(driver);

        for (int i = 1; i <= 3; i++) {
            WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='panel-recommended']/div/div/div/section[1]/div[2]/div/div[1]/div[1]/div/div[" + i + "]/div")));
            action.moveToElement(video).pause(Duration.ofSeconds(2)).perform();
        }

        // Click first game
        WebElement firstGame = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='panel-recommended']/div/div/div/section[1]/div[2]/div/div[1]/div[1]/div/div[1]/div")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstGame);
        firstGame.click();
    }

    // 4. Scroll to bottom and click next on A-Z game list
    @Test
    public void GamePages() {
        safeClick(By.linkText("Skill"));
        safeClick(By.xpath("//*[@id='tab-az']/span/div[1]"));

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        for (int i = 0; i < 2; i++) {
            By nextBtn = By.xpath("//*[@id='panel-az']/div/section/section/div/div/nav/nav/div[1]/a");
            if (driver.findElements(nextBtn).size() > 0) {
                safeClick(nextBtn);
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            }
        }
    }

    // 5. Access 'Skill' tab from bottom footer nav
    @Test
    public void SkillButtonFromFooter() {
        safeClick(By.linkText("Skill"));

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        By footerSkill = By.xpath("//*[@id='main-content']/div/div[2]/footer/div/div/div[2]/nav/div[2]/ul/li[2]/a");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(footerSkill));
        new Actions(driver).moveToElement(element).pause(Duration.ofSeconds(1)).click().perform();
    }
}
