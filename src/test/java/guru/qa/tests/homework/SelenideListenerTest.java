package guru.qa.tests.homework;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideListenerTest {

    private static final String REPOSITORY = "selenide/selenide";
    public static final Integer ISSUE_NUMBER = 1636;

    @Test
    @DisplayName("Проверка репозитория")
    @Owner("Liza-tester")
    @Severity(SeverityLevel.BLOCKER)

    public void selenideListenerTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = "1900x1200";
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText("selenide/selenide")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
    }

}

