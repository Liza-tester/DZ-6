package guru.qa.tests.lessonExamples;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AttachmentTest {

    private static final String REPOSITORY = "selenide/selenide";

    @Test
    public void testLambda() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

        step("Открываем главную страницу", () -> {
            Configuration.browserSize = "1900x1200";
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshot());
        });
    }

    @Test
    public void testAnnotated() {

        step("Открываем главную страницу", () -> {
            Configuration.browserSize = "1900x1200";
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            takeScreenshot();
        });
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    private byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private byte[] getScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}

