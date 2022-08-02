import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import page_object.HeaderOfPage;
import page_object.LoginPage;
import page_object.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class OpenManePageByClickLogoAndConstructorTest {
    HeaderOfPage headerOfPage;
    MainPage mainPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        loginPage = open(LoginPage.URL, LoginPage.class);
        headerOfPage = page(HeaderOfPage.class);
        mainPage = page(MainPage.class);
    }

    @Test
    @DisplayName("Открытие главной странцы при нажатии на кнопку \"Конструктор\" в шапке страницы")
    public void openManePageByClickOnConstructor() {
        headerOfPage.clickOnConstructorButton();
        mainPage.waitForLoadMainPage(false);
    }

    @Test
    @DisplayName("Открытие главной странцы при нажатии на логотип \"stellar burger\" в шапке страницы")
    public void openManePageByClickOnLogo() {
        headerOfPage.clickOnLogoButton();
        mainPage.waitForLoadMainPage(false);
    }
}