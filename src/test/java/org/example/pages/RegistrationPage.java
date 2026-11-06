package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import org.example.model.RegistrationData;


public class RegistrationPage {

    private static final String PATH = "/auth/register";

    private final Page page;
    private final String baseUrl;

    private final Locator firstName;
    private final Locator lastName;
    private final Locator dob;
    private final Locator street;
    private final Locator houseNumber;
    private final Locator postalCode;
    private final Locator city;
    private final Locator state;
    private final Locator country;
    private final Locator phone;
    private final Locator email;
    private final Locator password;
    private final Locator submitButton;

    public RegistrationPage(Page page, String baseUrl) {
        this.page = page;
        this.baseUrl = baseUrl;

        this.firstName = page.getByTestId("first-name");
        this.lastName = page.getByTestId("last-name");
        this.dob = page.getByTestId("dob");
        this.street = page.getByTestId("street");
        this.houseNumber = page.getByTestId("house_number");
        this.postalCode = page.getByTestId("postal_code");
        this.city = page.getByTestId("city");
        this.state = page.getByTestId("state");
        this.country = page.getByTestId("country");
        this.phone = page.getByTestId("phone");
        this.email = page.getByTestId("email");
        this.password = page.getByTestId("password");
        this.submitButton = page.getByTestId("register-submit");
    }

    public void open() {
        page.navigate(baseUrl + PATH);
    }

    public void fillForm(RegistrationData data) {
        firstName.fill(data.firstName());
        lastName.fill(data.lastName());
        dob.fill(data.dob());
        street.fill(data.street());
        houseNumber.fill(data.houseNumber());
        postalCode.fill(data.postalCode());
        city.fill(data.city());
        state.fill(data.state());
        country.selectOption(data.country());
        phone.fill(data.phone());
        email.fill(data.email());
        password.fill(data.password());
    }

    /** Clicks Register and returns the response from the registration API call. */
    public Response submitAndWaitForApiResponse() {
        return page.waitForResponse(
                response -> response.url().contains("/users/register")
                        && "POST".equals(response.request().method()),
                submitButton::click);
    }

}
