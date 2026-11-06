package org.example.tests;

import com.microsoft.playwright.Response;
import org.example.model.RegistrationData;
import org.example.pages.AccountPage;
import org.example.pages.LoginPage;
import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrationTest extends BaseTest {

    @Test
    void userCanRegisterWithValidDummyData() {
        RegistrationData user = RegistrationData.dummy();
        RegistrationPage registrationPage = new RegistrationPage(page, BASE_URL);

        registrationPage.open();
        registrationPage.fillForm(user);
        Response response = registrationPage.submitAndWaitForApiResponse();

        assertEquals(201, response.status(),
                "Registration API should return 201 Created");
    }

  //  @Test
 /*   void newlyRegisteredUserCanLogIn() {
        RegistrationData user = RegistrationData.dummy();
        RegistrationPage registrationPage = new RegistrationPage(page, BASE_URL);

        registrationPage.open();
        registrationPage.fillForm(user);
        assertEquals(201, registrationPage.submitAndWaitForApiResponse().status());

        LoginPage loginPage = new LoginPage(page, BASE_URL);
        loginPage.open();
        loginPage.login(user.email(), user.password());

        AccountPage accountPage = new AccountPage(page);
        assertThat(accountPage.pageTitle()).containsText("My account");
        assertThat(accountPage.navMenu()).containsText(user.fullName());
    } */
}