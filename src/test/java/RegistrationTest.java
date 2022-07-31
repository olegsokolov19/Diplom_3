import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import page_object.LoginPage;
import page_object.PersonAccountPage;
import page_object.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.*;

public class RegistrationTest {
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        registrationPage = open(RegistrationPage.URL, RegistrationPage.class);
    }

    @Test
    @DisplayName("Проверка успешной регистрации с валидными данными")
    public void successfulRegistration() {
        LoginPage loginPage = page(LoginPage.class);

        registrationPage.setFieldName(RandomStringUtils.randomAlphabetic(8));
        registrationPage.setFieldEmail(RandomStringUtils.randomAlphabetic(6) + "@gmail.ru");
        registrationPage.setFieldPassword(RandomStringUtils.randomAlphabetic(6));
        registrationPage.clickRegistrationButton();
        loginPage.waitForLoadLoginPage();
    }

    @Test
    @DisplayName("Проверка содержимого ошибки при вводе некорректного пароля (5 символов)")
    @Description("Проверяем содержимое ошибки при вводе некорректного пароля с 5 символами. Минимальное число символов - 6")
    public void checkErrorForInvalidPassword() {
        String expectedError = "Некорректный пароль";

        registrationPage.setFieldName(RandomStringUtils.randomAlphabetic(8));
        registrationPage.setFieldEmail(RandomStringUtils.randomAlphabetic(6) + "@gmail.ru");
        registrationPage.setFieldPassword(RandomStringUtils.randomAlphabetic(5));
        registrationPage.clickRegistrationButton();

        String actualError = registrationPage.getInvalidPasswordError().getText();

        registrationPage.getInvalidPasswordError().shouldBe(Condition.visible);
        assertEquals(expectedError, actualError);
    }
}