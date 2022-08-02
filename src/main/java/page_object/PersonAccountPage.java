package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class PersonAccountPage {

    public final static String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    @Step("Ожидание загрузки страницы личного кабинета")
    public void waitForLoadProfilePage() {
            $(byClassName("Account_contentBox__2CPm3")).shouldBe(Condition.visible);
    }

    @Step("Клик по кнопке \"Личный кабинет\"")
    public void clickOnPersonAccountButton() {
        personalAccountButton.click();
    }

    @Step("Клик по кнопке \"Выход\" в личном кабинете")
    public void logoutProfile() {
        clickOnPersonAccountButton();
        logoutButton.click();
    }
}