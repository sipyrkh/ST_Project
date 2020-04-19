package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ContactPage {

    @Step("Checking contact area visibility on 'Contact' page")
    public boolean isContactAreaDisplayed() {
        return getContactAreaLbl().isDisplayed();
    }

    @Step("Getting phone number from 'Contact' page")
    public String getPhoneNumber() {
        return getPhoneNumberLbl().getText();
    }

    @Step("Getting email address from 'Contact' page")
    public String getEmailAddress() {
        return getEmailAddressLbl().getText();
    }

    private SelenideElement getPhoneNumberLbl() {
        return $(By.xpath("//div[contains(@class, 'contacts_area')]//span[normalize-space(@class) = 'h3']"));
    }

    private SelenideElement getEmailAddressLbl() {
        return $(By.xpath("//div[contains(@class, 'contacts_area')]//span//a"));
    }

    private SelenideElement getContactAreaLbl() {
        return $(By.xpath("//div[contains(@class, 'contact') and contains(@class, 'area')]"));
    }
}
