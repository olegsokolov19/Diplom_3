import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;
import page_object.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class SwitchSectionsOnManePageTest {
    MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    public void selectSaucesSection() {
        mainPage.clickOnSaucesButton();
        $(byXpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect'] / .//span[text()='Соусы']"))
                .shouldBe(Condition.visible);
    }

    @Test
    public void selectFillingsSection() {
        mainPage.clickOnFillingsButton();
        $(byXpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect'] / .//span[text()='Начинки']"))
                .shouldBe(Condition.visible);
    }

    @Test
    public void selectBunsSection() {
        //"Булки" выбрана по умолчанию. Шаг с кликом на "Соусы" нужен, чтобы задизейблить кнопку "Булки"
        mainPage.clickOnSaucesButton();
        mainPage.clickOnBunsButton();
        $(byXpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect'] / .//span[text()='Булки']"))
                .shouldBe(Condition.visible);
    }
}