package guru.qa.tests.homework;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.tests.homework.steps.WebSteps;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {

    private static final String REPOSITORY = "selenide/selenide";
    public static final Integer ISSUE_NUMBER = 1636;
    private WebSteps steps = new WebSteps();

    @Test
    @DisplayName("Проверка репозитория")
    @Owner("Liza-tester")
    @Severity(SeverityLevel.BLOCKER)

    public void testGithubIssues() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);

    }
}

