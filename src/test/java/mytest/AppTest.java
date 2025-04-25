package mytest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void testTitle() {
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @Test
    public void testLogo() {
        boolean isLogoDisplayed = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "Google logo is not displayed!");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
