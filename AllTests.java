import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Scanner;

public class AllTests {

    WebDriver driver;
    Scanner scanner;

    @BeforeClass
    public void setupClass() {
        System.out.println("=== Running setup before all tests ===");
        scanner = new Scanner(System.in);
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("=== Cleaning up after all tests ===");
        if (driver != null) {
            driver.quit();
        }
        scanner.close();
    }

    @BeforeMethod
    public void setupTest() {
        System.out.println(">>> Starting a test <<<");
    }

    @AfterMethod
    public void teardownTest() {
        System.out.println("<<< Test finished >>>");
    }

    @Test(priority = 1)
    public void testReverseNumberEquality() {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int original = num, reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        // Assert if original and reversed number are equal
        System.out.println("Original: " + original + ", Reversed: " + reversed);
        Assert.assertNotEquals(original, reversed, "Original and reversed numbers should not be equal unless it's a palindrome.");
    }

    @Test(priority = 2)
    public void testFactorial() {
        System.out.print("Enter a number to compute factorial: ");
        int num = scanner.nextInt();
        long actual = 1;
        for (int i = 2; i <= num; i++) {
            actual *= i;
        }
        System.out.print("Enter the expected factorial: ");
        long expected = scanner.nextLong();
        System.out.println("Computed: " + actual + ", Expected: " + expected);
        Assert.assertEquals(actual, expected, "Factorial calculation is incorrect.");
    }

    @Test(priority = 3)
    public void testIsPrime() {
        System.out.print("Enter a number to check if it's prime: ");
        int num = scanner.nextInt();
        boolean isPrime = num > 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println("Is " + num + " a prime number? " + isPrime);
        Assert.assertTrue(isPrime, num + " is not a prime number.");
    }

    @Test(priority = 4)
    public void testPageTitleNotEquals() {
        driver.get("https://www.coolmathgames.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Some Incorrect Title";
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertNotEquals(actualTitle, expectedTitle, "Titles should not match.");
    }

    @Test(priority = 5)
    public void testUrlMatch() {
        driver.get("https://www.coolmathgames.com/");
        String expectedUrl = "https://www.coolmathgames.com/";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Expected URL: " + expectedUrl + ", Actual URL: " + actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl, "URL did not match.");
    }

    @Test(priority = 6)
    public void testElementSize() {
        driver.get("https://www.coolmathgames.com/");
        List<WebElement> navLinks = driver.findElements(By.cssSelector("nav a"));
        int actualSize = navLinks.size();
        int expectedSize = 10; // Replace with the actual expected size after checking
        System.out.println("Found " + actualSize + " nav links.");
        Assert.assertTrue(actualSize >= expectedSize, "Expected at least " + expectedSize + " navigation links.");
    }
}
