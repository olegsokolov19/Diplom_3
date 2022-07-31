import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page_object.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest {
    PersonAccountPage personAccountPage;
    LoginPage loginPage;
    HeaderOfPage headerOfPage;

    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(6);
        email = RandomStringUtils.randomAlphabetic(5) + "@gmail.ru";
        password = RandomStringUtils.randomAlphabetic(8);
        RegistrationRandomUser.registrationUser(name, email, password);

        personAccountPage = page(PersonAccountPage.class);
    }

    @After
    public void logoutProfile() {
        PersonAccountPage personAccountPage = page(PersonAccountPage.class);
        loginPage = page(LoginPage.class);
        personAccountPage.logoutProfile();
        loginPage.waitForLoadLoginPage();
    }

    @Test
    @DisplayName("Авторизация с главной страницы")
    @Description("Авторизация при нажатии на кнопку \"Войти в аккаунт\" на главной странице")
    public void loginOnMainPage() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        loginPage = page(LoginPage.class);

        mainPage.clickOnLoginButton();
        loginPage.waitForLoadLoginPage();

        loginPage.setUpRequiredFieldsInLoginForm(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForLoadMainPage(true);
    }

    @Test
    @DisplayName("Авторизация при нажатии на \"Личный кабинет\"")
    @Description("Авторизация при нажатии на кнопку \"Личный кабинет\"")
    public void loginOnPersonalAccount() {
        RegistrationRandomUser.registrationUser(name, email, password);
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        loginPage = page(LoginPage.class);
        headerOfPage = page(HeaderOfPage.class);

        headerOfPage.clickOnPersonAccountButton();
        loginPage.waitForLoadLoginPage();

        loginPage.setUpRequiredFieldsInLoginForm(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForLoadMainPage(true);
    }

    @Test
    @DisplayName("Авторизация из формы регистрации")
    @Description("Авторизация при нажатии на кнопку \"Уже зарегистрированы? Войти\" на странице регистрации")
    public void loginInRegistrationForm() {
        RegistrationPage registrationPage = open(RegistrationPage.URL, RegistrationPage.class);
        MainPage mainPage = page(MainPage.class);
        loginPage = page(LoginPage.class);

        registrationPage.clickOnLoginButton();
        loginPage.waitForLoadLoginPage();

        loginPage.setUpRequiredFieldsInLoginForm(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForLoadMainPage(true);
    }

    @Test
    @DisplayName("Авторизация со страницы восстановления пароля")
    @Description("Авторизация при нажатии на кнопку \"Вспомнили пароль? Войти\" на странице восстановления пароля")
    public void loginInResetPasswordForm() {
        RegistrationRandomUser.registrationUser(name, email, password);
        ResetPasswordPage resetPasswordPage = open(ResetPasswordPage.URL, ResetPasswordPage.class);
        MainPage mainPage = page(MainPage.class);
        LoginPage loginPage = page(LoginPage.class);

        resetPasswordPage.clickLoginButton();
        loginPage.waitForLoadLoginPage();

        loginPage.setUpRequiredFieldsInLoginForm(email, password);
        loginPage.clickLoginButton();

        mainPage.waitForLoadMainPage(true);
    }
}