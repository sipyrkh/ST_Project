package tests;

import enums.MenuItems;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.MainPage;
import tests.base.BaseTest;

import static utils.JsonReader.getTestDataParameter;

public class StContactTest extends BaseTest {

    @Test(priority = 0, description = "ST. Contact matching scenario.")
    @Description("Test Description: Check that the phone number and email address are correct.")
    public void userCanFindContacts() {
        MainPage mainPage = new MainPage();
        mainPage.openMenu(MenuItems.CONTACTS);

        ContactPage contactPage = new ContactPage();
        String actualPhoneNumber = contactPage.getPhoneNumber();
        Assert.assertTrue(actualPhoneNumber.contains(getTestDataParameter("phoneNumber")),
                "Phone numbers aren't same on 'Contact' page");

        String actualEmailAddress = contactPage.getEmailAddress();
        Assert.assertEquals(actualEmailAddress, getTestDataParameter("email"),
                "Email addresses aren't equals on 'Contact' page");
    }
}
