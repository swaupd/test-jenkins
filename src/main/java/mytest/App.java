package mytest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class App {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new SafariDriver();
        driver.get("https://www.youtube.com");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testTitle() {
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
