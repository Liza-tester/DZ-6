package guru.qa.tests.lessonExamples;

import guru.qa.tests.lessonExamples.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {
    private static final String REPOSITORY = "selenide/selenide";
    public static final Integer ISSUE_NUMBER = 1630;
    private WebSteps steps = new WebSteps();

    @Test
    public void testGithubIssues() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);

    }

}

