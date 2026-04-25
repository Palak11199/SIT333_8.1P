package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MathGameSeleniumTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10); // seconds
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    // ---------------- FULL FLOW ----------------
    @Test
    public void testFullGameFlowCorrect() {

        driver.get("http://localhost:8080/q1");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number1"))).sendKeys("2");
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("5");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number1"))).clear();
        driver.findElement(By.name("number1")).sendKeys("5");
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("2");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number1"))).clear();
        driver.findElement(By.name("number1")).sendKeys("2");
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("6");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }

    // ---------------- WRONG ANSWER ----------------
    @Test
    public void testWrongAnswerQ1() {

        driver.get("http://localhost:8080/q1");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number1"))).sendKeys("2");
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("10");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        Assert.assertTrue(driver.getPageSource().contains("Wrong answer"));
    }

    // ---------------- EMPTY INPUT ----------------
    @Test
    public void testEmptyInputQ1() {

        driver.get("http://localhost:8080/q1");

        WebElement n1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number1")));
        n1.clear();

        WebElement n2 = driver.findElement(By.name("number2"));
        n2.clear();

        WebElement res = driver.findElement(By.name("result"));
        res.clear();

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        Assert.assertTrue(driver.getPageSource().contains("Invalid input"));
    }
}