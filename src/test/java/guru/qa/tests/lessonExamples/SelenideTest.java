package guru.qa.tests.lessonExamples;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    public void testIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = "1900x1200";
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("selenide/selenide");
        $(".header-search-input").submit();

        $(linkText("selenide/selenide")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1636")).should(Condition.visible);
        sleep(1000);
    }

}

