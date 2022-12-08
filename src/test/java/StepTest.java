import annotated.WebStepsTest;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {

    private static final String REPOSITORY = "VolishevskiyVG/hw_AllureReports";
    private static final String ISSUE = "testIssues";
    SelenideElement searchInput = $(".header-search-input");


    @Test
    @DisplayName("Поиск репозитория по названию в Github из главной страницы")
    @Story("Поиск репозиторий")
    @Owner("Volishevskii")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "git", url = "https://github.com")
    public void testLambdaIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        step("Перейти в github", () -> {
            open("https://github.com");
        });
        step("Найти репозиторий " + REPOSITORY, () -> {
            searchInput.click();
            searchInput.sendKeys(REPOSITORY);
            searchInput.submit();
        });
        step("Кликнуть на репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликнуть на Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверить Issues c названием " + ISSUE, () -> {
            $(withText(ISSUE)).shouldBe(exist);
        });


    }

    @Test
    public void testAnnotated() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsTest issueSteps = new WebStepsTest();

        issueSteps.openMainPage();
        issueSteps.searchRepository(REPOSITORY);
        issueSteps.clickRepository(REPOSITORY);
        issueSteps.openIssues();
        issueSteps.shouldTestIssue(ISSUE);
    }
}
