import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='pay__wrapper']/h2")
    private WebElement blockTitle;

    @FindBy(css = "div.pay__partners ul li img")
    private List<WebElement> paymentLogos;

    @FindBy(xpath = "//*[@class='pay__wrapper']/a")
    private WebElement moreDetailsLink;

    @FindBy(css = "form#pay-connection input#connection-phone")
    private WebElement phoneNumberInput;

    @FindBy(css = "form#pay-connection input#connection-sum")
    private WebElement sumInput;

    @FindBy(css = "form#pay-connection button[type='submit']")
    private WebElement continueButton;

    @FindBy(css = "iframe.bepaid-iframe")
    private WebElement paymentIframe;

    @FindBy(css = ".app-wrapper__content")
    private WebElement modalContent;

    // Категории
    @FindBy(xpath = "//*[@class='select__header']")
    private WebElement categoryDropdown;

    @FindBy(id = "connection-phone")
    private WebElement phoneField;

    @FindBy(id = "connection-sum")
    private WebElement sumField;

    @FindBy(id = "connection-email")
    private WebElement emailField;

    @FindBy(id = "internet-phone")
    private WebElement internetPhoneField;

    @FindBy(id = "internet-sum")
    private WebElement internetSumField;

    @FindBy(id = "internet-email")
    private WebElement internetEmailField;

    @FindBy(id = "score-instalment")
    private WebElement instalmentScoreField;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSumField;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmailField;

    @FindBy(id = "score-arrears")
    private WebElement arrearsScoreField;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSumField;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmailField;



    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getBlockTitle() {
        return blockTitle.getText().replaceAll("\\s+", " ").trim();
    }

    public List<WebElement> getPaymentLogos() {
        return paymentLogos;
    }

    public void clickMoreDetailsLink() {
        moreDetailsLink.click();
    }

    public void fillPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void fillSum(String sum) {
        sumInput.sendKeys(sum);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void switchToPaymentIframe() {
        driver.switchTo().frame(paymentIframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public WebElement getModalContent() {
        return modalContent;
    }

    public void selectCategory(String category) {
        categoryDropdown.click();
        WebElement option = driver.findElement(By.xpath(String.format("//option[text()='%s']", category)));
        option.click();
    }

    public Map<String, String> getPlaceholders(String category) {
        Map<String, String> placeholders = new HashMap<>();

        switch (category) {
            case "Услуги связи":
                placeholders.put("phone", phoneField.getAttribute("placeholder"));
                placeholders.put("sum", sumField.getAttribute("placeholder"));
                placeholders.put("email", emailField.getAttribute("placeholder"));
                break;

            case "Домашний интернет":
                placeholders.put("phone", internetPhoneField.getAttribute("placeholder"));
                placeholders.put("sum", internetSumField.getAttribute("placeholder"));
                placeholders.put("email", internetEmailField.getAttribute("placeholder"));
                break;

            case "Рассрочка":
                placeholders.put("score", instalmentScoreField.getAttribute("placeholder"));
                placeholders.put("sum", instalmentSumField.getAttribute("placeholder"));
                placeholders.put("email", instalmentEmailField.getAttribute("placeholder"));
                break;

            case "Задолженность":
                placeholders.put("score", arrearsScoreField.getAttribute("placeholder"));
                placeholders.put("sum", arrearsSumField.getAttribute("placeholder"));
                placeholders.put("email", arrearsEmailField.getAttribute("placeholder"));
                break;

            default:
                throw new IllegalArgumentException("Неизвестная категория: " + category);
        }

        return placeholders;
    }
}
