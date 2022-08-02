package page_object;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderOfPage {

    @FindBy(how = How.XPATH, using = ".//a[@class='AppHeader_header__link__3D_hX'] / .//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//a[@class='AppHeader_header__link__3D_hX'] / .//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.CSS, using = "div[class='AppHeader_header__logo__2D0X2'] a")
    private SelenideElement logoButton;

    @Step("Клик по кнопке \"Личный кабинет\"")
    public void clickOnPersonAccountButton() {
        personalAccountButton.click();
    }

    @Step("Клик по кнопке \"Конструктор\"")
    public void clickOnConstructorButton() {
        constructorButton.click();
    }

    @Step("Клик по логотипу \"stellar burgers\"")
    public void clickOnLogoButton() {
        logoButton.click();
    }
}