package guru.qa.tests.lessonExamples;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Link(name = "Github", url = "https://github.com")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Liza-tester")
    @DisplayName("Тест тестовый - аннотации")
    @Feature("Github repository")
    @Story("Issues in repository")
    public void testLambda() {

    }

    @Test
    public void testAnnotated() {
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("Тест тестовый - лямбда");
            Allure.label("owner", "Liza-tester");
            Allure.feature("Issues in Github repository");
            Allure.story("Issues in repository");
            Allure.label("severity", "MINOR");
            Allure.link("Github", "https://github.com");
        });
    }

}

