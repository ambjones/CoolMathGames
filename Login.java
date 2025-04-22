import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.coolmathgames.com/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test (priority = 1)
    public void forgotPassword () throws InterruptedException { // testing to see if the forgot password button works

        driver.get("https://www.coolmathgames.com/");
        driver.manage().window().maximize();
        Thread.sleep(500);

        //select sign in button
        driver.findElement(By.xpath("/html/body/div[3]/div/main/header[1]/nav/div/div[3]/div/div/ul/li[4]/a")).click();
        Thread.sleep(500);

        // enter random username
        driver.findElement(By.id("username")).sendKeys("TestUsername");
        Thread.sleep(500);

        // select forgot password
        driver.findElement(By.xpath("//*[@id=\"cmg-overlay-6b1279480676d86cd9b32f88420a9864\"]/div/div[4]/a")).click();
        Thread.sleep(500);
    }
    @Test (priority = 2)
    public void rememberMe () throws InterruptedException {

        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(500);

        //select sign in button
        driver.findElement(By.xpath("/html/body/div[3]/div/main/header[1]/nav/div/div[3]/div/div/ul/li[4]/a")).click();
        Thread.sleep(500);

        // enter random username
        driver.findElement(By.id("username")).sendKeys("TestUsername");
        Thread.sleep(1000);

        // select remember me
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        Thread.sleep(2000);
    }
    @Test (priority = 3)
    public void createAccount () throws InterruptedException{
        driver.get("https://www.coolmathgames.com/");
        Thread.sleep(2000);
        // select sign in button
        driver.findElement(By.xpath("/html/body/div[3]/div/main/header[1]/nav/div/div[3]/div/div/ul/li[4]/a")).click();
        Thread.sleep(1500);
        //select sign up for free
        driver.findElement(By.xpath("//*[@id=\"cmg-overlay-6b1279480676d86cd9b32f88420a9864\"]/div/div[5]/div[2]/a[1]")).click();
        Thread.sleep(200);
    }
    @Test (priority = 4)
    public void invalidLogin () throws InterruptedException{
        driver.get("https://www.coolmathgames.com/");
        driver.manage().window().maximize();
        Thread.sleep(500);

        //select sign in button
        driver.findElement(By.xpath("/html/body/div[3]/div/main/header[1]/nav/div/div[3]/div/div/ul/li[4]/a")).click();
        Thread.sleep(500);

        // verify that the username and password field allows you to enter text
        driver.findElement(By.id("username")).sendKeys("TestUsername");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("TestPassword");
        Thread.sleep(500);
        //click the login button
        driver.findElement(By.xpath("//*[@id=\"cmg-overlay-6b1279480676d86cd9b32f88420a9864\"]/div/div[5]/div[1]/button")).click();
        Thread.sleep(500);

    }


    @Test
    public void validLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Go to the homepage first
        driver.get("https://www.coolmathgames.com/");

        // Click the login icon to open the login modal
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Login') or contains(@href, '/login')]")));
        loginLink.click();

        // Wait for the username and password fields to be visible
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        // Clear any pre-filled text
        usernameField.clear();
        passwordField.clear();

        // Enter credentials
        usernameField.sendKeys("Users123");
        passwordField.sendKeys("Pass123");

        // Click the login button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Login') or contains(text(),'Log in')]")));
        loginBtn.click();

        // Optional: wait for login confirmation element (e.g., profile icon or welcome text)
        Thread.sleep(2000); // Can replace with wait for some success element
    }

}


