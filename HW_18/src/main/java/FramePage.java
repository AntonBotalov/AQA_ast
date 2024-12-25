import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FramePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class = 'content ng-tns-c46-1']//label")
    private WebElement cardNumberField;

    @FindBy(xpath = "//*[@class = 'content ng-tns-c46-4']//label")
    private WebElement cardExpirationField;

    @FindBy(xpath = "//*[@class = 'content ng-tns-c46-5']//label")
    private WebElement cardCvcField;

    @FindBy(xpath = "//*[@class = 'content ng-tns-c46-3']//label")
    private WebElement cardHolderField;

    @FindBy(css = "iframe.bepaid-iframe")
    private WebElement paymentIframe;

    @FindBy(css = ".pay-description__text span")
    private WebElement paymentDetailsText;

    @FindBy(css = ".pay-description__cost span")
    private WebElement paymentAmountText;

    @FindBy(css = ".cards-brands img")
    private List<WebElement> paymentIcons;

    // Методы взаимодействия

    public FramePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToPaymentIframe() {
        driver.switchTo().frame(paymentIframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public WebElement getModalContent() {
        return paymentDetailsText;
    }

    public String getPaymentDetailsText() {
        return paymentDetailsText.getText().trim();
    }

    public String getPaymentAmountText() {
        return paymentAmountText.getText().trim();
    }

    public boolean arePaymentIconsDisplayed() {
        int visibleIconsCount = 0;
        for (WebElement icon : paymentIcons) {
            if (icon.isDisplayed()) {
                visibleIconsCount++;
            }
        }
        return visibleIconsCount >= 4;
    }

    public String getCardNumberPlaceholder() {
        return cardNumberField.getText().trim();
    }

    public String getCardExpirationPlaceholder() {
        return cardExpirationField.getText().trim();
    }

    public String getCardCvcPlaceholder() {
        return cardCvcField.getText().trim();
    }

    public String getCardHolderPlaceholder() {
        return cardHolderField.getText().trim();
    }
}

