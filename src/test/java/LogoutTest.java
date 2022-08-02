import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import page_object.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogoutTest {
    LoginPage loginPage;
    MainPage mainPage;
    HeaderOfPage headerOfPage;
    PersonAccountPage personAccountPage;

    String name;
    String email;
    String password;

    private void loginUser() {
        loginPage = open(LoginPage.URL, LoginPage.class);
        loginPage.loginUser(email, password);
    }

    @Before
    public void setUp() {
        mainPage = page(MainPage.class);
        headerOfPage = page(HeaderOfPage.class);
        personAccountPage = page(PersonAccountPage.class);

        name = RandomStringUtils.randomAlphabetic(6);
        email = RandomStringUtils.randomAlphabetic(6) + "@gmail.ru";
        password = RandomStringUtils.randomAlphabetic(8);

        RegistrationRandomUser.registrationUser(name, email, password);
    }

    @Test
    public void logoutOutOfPersonAccount() {
        loginUser();

        headerOfPage.clickOnPersonAccountButton();
        personAccountPage.logoutProfile();

        loginPage.waitForLoadLoginPage();
    }
}