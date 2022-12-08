import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    public void testIssue() {
        open("https://github.com/");
    }

}
