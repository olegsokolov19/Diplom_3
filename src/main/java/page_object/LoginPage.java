package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public final static String URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.CSS, using = "div.input__container input")
    private ElementsCollection fieldsLoginForm;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement buttonLoginInLoginForm;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement buttonLoginInResetPasswordForm;

    @FindBy(how = How.XPATH, using = "")
    private SelenideElement buttonForgotPassword;

    @Step("Ожидание загрузки страницы авторизации")
    public void waitForLoadLoginPage() {
        $(byClassName("Auth_login__3hAey")).shouldBe(Condition.visible);
    }

    @Step("Заполнение обязательных полей в форме авторизации")
    public void setUpRequiredFieldsInLoginForm(String email, String password) {
        fieldsLoginForm.get(0).setValue(email);
        fieldsLoginForm.get(1).setValue(password);
    }

    @Step("Клик по кнопке \"Войти\" на странице авторизации")
    public void clickLoginButton() {
        buttonLoginInLoginForm.click();
    }

    @Step("Клик по кнопке \"Восстановить пароль\" на странице авторизации")
    public void clickResetPasswordButton() {
        buttonForgotPassword.click();
    }

    @Step("Авторизация пользователя")
    public void loginUser(String email, String password) {
        setUpRequiredFieldsInLoginForm(email, password);
        clickLoginButton();
    }
}