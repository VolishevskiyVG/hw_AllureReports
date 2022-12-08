import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {


    SelenideElement searchInput = $(".header-search-input");


    @Test
    public void testIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        searchInput.click();
        searchInput.sendKeys("VolishevskiyVG/hw_AllureReports");
        searchInput.submit();
        $(linkText("VolishevskiyVG/hw_AllureReports")).click();
        $("#issues-tab").click();
        $(withText("testIssues")).shouldBe(exist);
    }

}
