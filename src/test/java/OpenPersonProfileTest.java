import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import page_object.*;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.$;

public class OpenPersonProfileTest {
    PersonAccountPage personAccountPage;
    LoginPage loginPage;
    MainPage mainPage;
    HeaderOfPage headerOfPage;

    String name;
    String email;
    String password;

    private void loginUser() {
        loginPage = open(LoginPage.URL, LoginPage.class);
        loginPage.loginUser(email, password);
    }

    @Before
    public void setUp() {
        mainPage = open(MainPage.URL, MainPage.class);
        personAccountPage = page(PersonAccountPage.class);
        headerOfPage = page(HeaderOfPage.class);

        loginPage = page(LoginPage.class);

        name = RandomStringUtils.randomAlphabetic(6);
        email = RandomStringUtils.randomAlphabetic(5) + "@gmail.ru";
        password = RandomStringUtils.randomAlphabetic(8);

        RegistrationRandomUser.registrationUser(name, email, password);
    }

    @Test
    @DisplayName("Открытие личного кабинета авторизованным клиентом")
    public void openPersonProfileWithAuthorization() {
        loginUser();

        headerOfPage.clickOnPersonAccountButton();
        personAccountPage.waitForLoadProfilePage();

        personAccountPage.logoutProfile();
        loginPage.waitForLoadLoginPage();
    }

    @Test
    @DisplayName("Открытие личного кабинета неавторизованным клиентом")
    public void openPersonProfileWithoutAuthorization() {
        headerOfPage.clickOnPersonAccountButton();
        $(byXpath(".//button[text()='Войти']")).shouldBe(Condition.visible);
    }
}