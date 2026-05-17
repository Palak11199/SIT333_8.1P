package web.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MathGameSeleniumTest {

    private WebDriver driver;

    @Before
    public void setup() {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\chromedriver\\chromedriver.exe"
        );

        ChromeOptions options = new ChromeOptions();

        // DISABLE GOOGLE PASSWORD POPUP
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");

        options.setExperimentalOption(
                "prefs",
                new java.util.HashMap<String, Object>() {{
                    put("credentials_enable_service", false);
                    put("profile.password_manager_enabled", false);
                }}
        );

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    // ======================================================
    // SUBMIT FORM
    // ======================================================

    private void submitPage() {

        try {

            driver.findElement(
                    By.cssSelector("input[type='submit']")
            ).click();

        } catch (Exception e1) {

            try {

                driver.findElement(
                        By.cssSelector("button")
                ).click();

            } catch (Exception e2) {

                driver.findElement(
                        By.tagName("form")
                ).submit();
            }
        }
    }

    // ======================================================
    // CHECK PAGE
    // ======================================================

    private void checkCurrentPage(String expectedUrlPart) {

        if (!driver.getCurrentUrl().contains(expectedUrlPart)) {

            throw new AssertionError(
                    "Expected page "
                            + expectedUrlPart
                            + " but current URL is "
                            + driver.getCurrentUrl()
                            + "\nCurrent page text:\n"
                            + driver.findElement(
                                    By.tagName("body")
                            ).getText()
            );
        }
    }

    // ======================================================
    // FULL GAME FLOW
    // ======================================================

    @Test
    public void testCompleteStemGameFlow()
            throws InterruptedException {

        // ==================================================
        // LOGIN
        // ==================================================

        driver.get("http://localhost:8080/login");

        Thread.sleep(2000);

        WebElement username =
                driver.findElement(By.name("username"));

        username.clear();
        username.sendKeys("palak");

        WebElement password =
                driver.findElement(By.name("passwd"));

        password.clear();
        password.sendKeys("palak_pass");

        // DATE FIX
        WebElement dob =
                driver.findElement(By.name("dob"));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].value='1990-01-01';",
                        dob
                );

        Thread.sleep(1000);

        submitPage();

        Thread.sleep(3000);

        checkCurrentPage("/q1");

        // ==================================================
        // Q1
        // ==================================================

        driver.findElement(By.name("number1"))
                .sendKeys("2");

        driver.findElement(By.name("number2"))
                .sendKeys("3");

        driver.findElement(By.name("result"))
                .sendKeys("5");

        submitPage();

        Thread.sleep(2000);

        checkCurrentPage("/q2");

        // ==================================================
        // Q2
        // ==================================================

        driver.findElement(By.name("number1"))
                .sendKeys("7");

        driver.findElement(By.name("number2"))
                .sendKeys("3");

        driver.findElement(By.name("result"))
                .sendKeys("4");

        submitPage();

        Thread.sleep(2000);

        checkCurrentPage("/q3");

        // ==================================================
        // Q3
        // ==================================================

        driver.findElement(By.name("number1"))
                .sendKeys("3");

        driver.findElement(By.name("number2"))
                .sendKeys("4");

        driver.findElement(By.name("result"))
                .sendKeys("12");

        submitPage();

        Thread.sleep(2000);

        checkCurrentPage("/q4");

        // ==================================================
        // Q4
        // ==================================================

        WebElement q4date =
                driver.findElement(By.name("date"));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].value='2025-05-10';",
                        q4date
                );

        driver.findElement(By.name("result"))
                .sendKeys("2025-05-11");

        submitPage();

        Thread.sleep(2000);

        checkCurrentPage("/q5");

        // ==================================================
        // Q5
        // ==================================================

        WebElement q5date =
                driver.findElement(By.name("date"));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].value='2025-05-10';",
                        q5date
                );

        // CORRECT ANSWER = MINUS 7 DAYS
        driver.findElement(By.name("result"))
                .sendKeys("2025-05-03");

        submitPage();

        Thread.sleep(2000);

        checkCurrentPage("/q6");

        // ==================================================
        // Q6
        // ==================================================

        try {

            driver.findElement(By.name("answer"))
                    .sendKeys("100");

        } catch (NoSuchElementException e) {

            driver.findElement(By.name("result"))
                    .sendKeys("100");
        }

        submitPage();

        Thread.sleep(2000);

        checkCurrentPage("/success");

        WebElement body =
                driver.findElement(By.tagName("body"));

        if (!body.getText().contains("Success")) {

            throw new AssertionError(
                    "Success page was not reached."
            );
        }
    }

    @Test
    public void testInvalidLoginShowsError() {

        driver.manage().deleteAllCookies();

        driver.get("http://localhost:8080/login");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username")));

        driver.findElement(By.name("username"))
                .sendKeys("wrong");

        driver.findElement(By.name("passwd"))
                .sendKeys("wrong");

        WebElement dob =
                driver.findElement(By.name("dob"));

        dob.sendKeys("2000-01-01");

        submitPage();

        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println(driver.getCurrentUrl());

        assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "User incorrectly logged in"
        );
    }
   
    // ======================================================
    // WRONG DATE ANSWER
    // ======================================================

    @Test
    public void testWrongDateAnswerShowsError()
            throws InterruptedException {

        driver.get("http://localhost:8080/q4");

        Thread.sleep(2000);

        WebElement date =
                driver.findElement(By.name("date"));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].value='2025-05-10';",
                        date
                );

        driver.findElement(By.name("result"))
                .sendKeys("2025-05-20");

        submitPage();

        Thread.sleep(2000);

        WebElement body =
                driver.findElement(By.tagName("body"));

        if (!body.getText()
                .contains("Wrong answer")) {

            throw new AssertionError(
                    "Wrong date answer error was not displayed."
            );
        }
    }

    // ======================================================
    // CLOSE
    // ======================================================

    @After
    public void closeBrowser() {

        if (driver != null) {

            driver.quit();
        }
    }
}