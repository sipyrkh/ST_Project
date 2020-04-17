package pages;

import com.codeborne.selenide.SelenideElement;
import enums.MenuItems;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("Opening menu item: {0}")
    public void openMenu(MenuItems item) {
        getMenuBtn(item).click();
    }

    private SelenideElement getMenuBtn(MenuItems item) {
        return $(By.xpath(String.format("//li//a[contains(@href, '%s')]", item.getValue())));
    }
}
