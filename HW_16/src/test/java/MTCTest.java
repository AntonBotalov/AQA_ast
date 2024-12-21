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

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class MTCTest {
    private WebDriver driver;
    private MainPage mainPage;
    private FramePage framePage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        mainPage = new MainPage(driver);
        framePage = new FramePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Закрытие баннера с куки
        try {
            driver.findElement(By.id("cookie-agree")).click();
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
    public void checkBlockTitle() {
        String actualTitle = mainPage.getBlockTitle();
        String expectedTitle = "Онлайн пополнение без комиссии";
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок не совпадает!");
    }

    @Test
    @DisplayName("2. Проверка логотипов платёжных систем")
    public void checkPaymentLogos() {
        List<WebElement> logos = mainPage.getPaymentLogos();
        Assertions.assertEquals(5, logos.size(), "Количество логотипов платёжных систем не совпадает.");

        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (int i = 0; i < logos.size(); i++) {
            String actualAlt = logos.get(i).getAttribute("alt").trim();
            Assertions.assertTrue(logos.get(i).isDisplayed(), "Логотип не отображается: " + actualAlt);
            Assertions.assertEquals(expectedAlts[i], actualAlt, "Атрибут alt у логотипа не совпадает.");
        }
    }

    @Test
    @DisplayName("3. Проверка кликабельности ссылки 'Подробнее о сервисе'")
    public void checkMoreDetailsLinkClickable() {
        mainPage.clickMoreDetailsLink();
        WebElement newPage = driver.findElement(By.xpath("//*[@class='container-fluid']/h3"));
        Assertions.assertTrue(newPage.getText().contains("Оплата банковской картой"), "Целевая страница не содержит ожидаемый контент.");
    }

    @Test
    @DisplayName("4. Проверка placeholder для категории 'Услуги связи'")
    public void testPlaceholdersForConnection() {
        mainPage.selectCategory("Услуги связи");
        Map<String, String> placeholders = mainPage.getPlaceholders("Услуги связи");

        Assertions.assertEquals("Номер телефона", placeholders.get("phone"), "Placeholder для номера телефона не совпадает.");
        Assertions.assertEquals("Сумма", placeholders.get("sum"), "Placeholder для суммы не совпадает.");
        Assertions.assertEquals("E-mail для отправки чека", placeholders.get("email"), "Placeholder для email не совпадает.");
    }

    @Test
    @DisplayName("5. Проверка placeholder для категории 'Домашний интернет'")
    public void testPlaceholdersForInternet() {
        mainPage.selectCategory("Домашний интернет");
        Map<String, String> placeholders = mainPage.getPlaceholders("Домашний интернет");

        Assertions.assertEquals("Номер абонента", placeholders.get("phone"), "Placeholder для номера абонента не совпадает.");
        Assertions.assertEquals("Сумма", placeholders.get("sum"), "Placeholder для суммы не совпадает.");
        Assertions.assertEquals("E-mail для отправки чека", placeholders.get("email"), "Placeholder для email не совпадает.");
    }

    @Test
    @DisplayName("6. Проверка placeholder для категории 'Рассрочка'")
    public void testPlaceholdersForInstalment() {
        mainPage.selectCategory("Рассрочка");
        Map<String, String> placeholders = mainPage.getPlaceholders("Рассрочка");

        Assertions.assertEquals("Номер счета на 44", placeholders.get("score"), "Placeholder для номера счета не совпадает.");
        Assertions.assertEquals("Сумма", placeholders.get("sum"), "Placeholder для суммы не совпадает.");
        Assertions.assertEquals("E-mail для отправки чека", placeholders.get("email"), "Placeholder для email не совпадает.");
    }

    @Test
    @DisplayName("7. Проверка placeholder для категории 'Задолженность'")
    public void testPlaceholdersForArrears() {
        mainPage.selectCategory("Задолженность");
        Map<String, String> placeholders = mainPage.getPlaceholders("Задолженность");

        Assertions.assertEquals("Номер счета на 2073", placeholders.get("score"), "Placeholder для номера счета не совпадает.");
        Assertions.assertEquals("Сумма", placeholders.get("sum"), "Placeholder для суммы не совпадает.");
        Assertions.assertEquals("E-mail для отправки чека", placeholders.get("email"), "Placeholder для email не совпадает.");
    }

    @Test
    @DisplayName("8. Заполнение полей и проверка данных в появившемся окне")
    public void checkContinueButton1() {
        mainPage.fillPhoneNumber("297777777");
        mainPage.fillSum("200");
        mainPage.clickContinueButton();

        framePage.switchToPaymentIframe();
        WebElement modalContent = wait.until(ExpectedConditions.visibilityOf(framePage.getModalContent()));
        Assertions.assertTrue(modalContent.isDisplayed(), "Модальное окно внутри фрейма не отображается или пустое.");

        // Проверка текста
        String expectedText = "Оплата: Услуги связи Номер:375297777777";
        Assertions.assertEquals(expectedText, framePage.getPaymentDetailsText(), "Текст оплаты не совпадает.");

        // Проверка суммы
        Assertions.assertEquals("200.00 BYN", framePage.getPaymentAmountText(), "Сумма оплаты не совпадает.");

        // Проверка lebel'ов внутри фрейма
        Assertions.assertEquals("Номер карты", framePage.getCardNumberPlaceholder(), "Текст для номера карты не совпадает.");
        Assertions.assertEquals("Срок действия", framePage.getCardExpirationPlaceholder(), "Текст для срока действия не совпадает.");
        Assertions.assertEquals("CVC", framePage.getCardCvcPlaceholder(), "Текст для CVC не совпадает.");
        Assertions.assertEquals("Имя держателя (как на карте)", framePage.getCardHolderPlaceholder(), "Текст для имени держателя не совпадает.");

        // Проверка наличия иконок платёжных систем, преверяю, что отображается 4 иконки
        Assertions.assertTrue(framePage.arePaymentIconsDisplayed(), "Иконки платёжных систем не отображаются.");

        framePage.switchToDefaultContent();
    }
}

