package annotated;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsTest {
    SelenideElement searchInput = $(".header-search-input");

    @Step("Перейти в github")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти репозиторий {repo}")
    public void searchRepository(String repo) {
        searchInput.click();
        searchInput.sendKeys(repo);
        searchInput.submit();
    }

    @Step("Кликнуть на репозиторий {repo}")
    public void clickRepository(String repo) {
        $(linkText(repo)).click();

    }

    @Step("Кликнуть на Issues")
    public void openIssues() {
        $("#issues-tab").click();


    }

    @Step("Проверить Issues c названием {issue}")
    public void shouldTestIssue(String issue) {
        $(withText(issue)).shouldBe(exist);
    }


}

