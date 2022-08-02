package page_object;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPasswordPage {

    public final static String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH, using = ".//a[contains(@class, 'Auth_link__1fOlj') and contains(text(), 'Войти')]")
    private SelenideElement loginButton;

    @Step("Клик по кнопке \"Войти\" на странице восстановления пароля")
    public void clickLoginButton() {
        loginButton.click();
    }
}