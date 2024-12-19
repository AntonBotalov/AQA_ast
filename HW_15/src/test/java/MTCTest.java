import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MTCTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.mts.by/");

        // Закрываем баннер с куки
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookieAcceptButton.click();
        } catch (Exception ignored) {}
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    @DisplayName("1. Проверка названия блока")
    public void checkBlockTitle(){
        WebElement title = driver.findElement(By.xpath("//*[@class='pay__wrapper']/h2"));
        String actualTitle = title.getText().replaceAll("\\s+", " ").trim();
        String expectedTitle = "Онлайн пополнение без комиссии";
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок не совпадает!");
    }

    @Test
    @DisplayName("2. Проверка логотипов платёжных систем")
    public void checkPaymentLogos() {
        List<WebElement> logos = driver.findElements(By.cssSelector("div.pay__partners ul li img"));
        Assertions.assertEquals(5, logos.size(), "Количество логотипов платёжных систем не совпадает.");

        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (int i = 0; i < logos.size(); i++) {
            String actualAlt = logos.get(i).getAttribute("alt").trim();
            Assertions.assertTrue(logos.get(i).isDisplayed(), "Логотип не отображается: " + logos.get(i).getAttribute("alt"));
            Assertions.assertEquals(expectedAlts[i], actualAlt, "Атрибут alt у логотипа не совпадает.");
        }
    }

    @Test
    @DisplayName("3. Проверка кликабельности ссылки 'Подробнее о сервисе'")
    public void checkMoreDetailsLinkClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='pay__wrapper']/a")));
        Assertions.assertTrue(link.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается.");
        Assertions.assertTrue(link.isEnabled(), "Ссылка 'Подробнее о сервисе' не кликабельна.");

        link.click();

        WebElement newPage = driver.findElement(By.xpath("//*[@class='container-fluid']/h3"));
        Assertions.assertTrue(newPage.getText().contains("Оплата банковской картой"), "Целевая страница не содержит ожидаемый контент.");

    }

    @Test
    @DisplayName("4. Заполнение полей и проверка кнопки 'Продолжить'")
    public void checkContinueButton() {
        WebElement phoneNumberInput = driver.findElement(By.cssSelector("form#pay-connection input#connection-phone"));
        phoneNumberInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.cssSelector("form#pay-connection input#connection-sum"));
        sumInput.sendKeys("200");

        WebElement continueButton = driver.findElement(By.cssSelector("form#pay-connection button[type='submit']"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement modalWindow = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@class='app-wrapper__content']/app-header")
        ));

        Assertions.assertTrue(modalWindow.isDisplayed(), "Модальное окно не отображается после нажатия кнопки.");
    }

}
