package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public final static String URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = ".//div[@class='input__container'] / .//input[@class='text input__textfield text_type_main-default']")
    private ElementsCollection fieldsRegistrationForm;

    //кнопка "Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement buttonRegistration;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement buttonLoginInRegistrationForm;

    //ошибка при вводе некорректного пароля
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container'] / p[@class='input__error text_type_main-default']")
    private SelenideElement invalidPasswordError;

    public void waitForLoadRegistrationPage() {
        $(byClassName("Auth_form__3qKeq mb-20")).shouldBe(Condition.visible);
    }

    @Step("Заполнение поля \"Имя\"")
    public void setFieldName(String name) {
        fieldsRegistrationForm.get(0).setValue(name);
    }

    @Step("Заполнение поля \"Email\"")
    public void setFieldEmail(String email) {
        fieldsRegistrationForm.get(1).setValue(email);
    }

    @Step("Заполнение поля \"Пароль\"")
    public void setFieldPassword(String password) {
        fieldsRegistrationForm.get(2).setValue(password);
    }

    @Step("Клик по кнопке \"Зарегистрироваться\"")
    public void clickRegistrationButton() {
        buttonRegistration.click();
    }

    @Step("Клик по кнопке \"Войти\" на странице регистрации")
    public void clickOnLoginButton() {
        buttonLoginInRegistrationForm.click();
    }

    @Step("Получение ошибки при некорректном пароле")
    public SelenideElement getInvalidPasswordError() {
        return invalidPasswordError;
    }

    @Step("Регистрация пользователя")
    public void registrationUser(String name, String email, String password) {
        setFieldName(name);
        setFieldEmail(email);
        setFieldPassword(password);

        clickRegistrationButton();
    }
}