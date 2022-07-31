package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public final static String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10'] / button[text()='Войти в аккаунт']")
    private SelenideElement buttonLoginOnMainPage;

    @FindBy(how = How.XPATH, using = ".//section[@class='BurgerIngredients_ingredients__1N8v2'] / .//div[contains(@class, 'tab_tab__1SPyG')]")
    private ElementsCollection burgerContentsButtons;

    @Step("Ожидание загрузки главной страницы")
    public void waitForLoadMainPage(boolean authorization) {
        if (authorization) {
            $(byXpath(".//button[text()='Оформить заказ']")).shouldBe(Condition.visible);
        } else {
            $(byXpath(".//button[text()='Войти в аккаунт']")).shouldBe(Condition.visible);
        }
    }

    @Step("Клик по кнопке \"Войти\" на главной странице")
    public void clickOnLoginButton() {
        buttonLoginOnMainPage.click();
    }

    @Step("Клик по кнопке \"Булки\" на главной странице")
    public void clickOnBunsButton() {
        burgerContentsButtons.get(0).click();
    }

    @Step("Клик по кнопке \"Соусы\" на главной странице")
    public void clickOnSaucesButton() {
        burgerContentsButtons.get(1).click();
    }

    @Step("Клик по кнопке \"Начинки\" на главной странице")
    public void clickOnFillingsButton() {
        burgerContentsButtons.get(2).click();
    }
}