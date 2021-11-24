package guru.qa.tests.lessonExamples;

import guru.qa.tests.lessonExamples.steps.WebSteps;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class ParametersTest {

    private WebSteps steps = new WebSteps();

    @DisplayName("Проверка репозитория")
    @ParameterizedTest(name = "{displayName} {0}")
    @ValueSource(strings = {"selenide/selenide", "selenide/selenide-appium"})

    public void testGithubIssues(String repository) {
        Allure.parameter("Репозиторий", repository);
        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.goToRepository(repository);

    }
}
