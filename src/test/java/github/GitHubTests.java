package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {
    String BASE_URL = "https://github.com/";
    String VALUE = "selenide";
    String SEARCH_TEXT = "selenide/selenide";

    @Test
    void ShouldSelenideTextInTheTop(){
        open(BASE_URL);
        $(".search-input").click();
        $("#query-builder-test").setValue(VALUE).pressEnter();
        $(".search-match").shouldHave(text(SEARCH_TEXT)).click();
        $("[data-turbo-frame='repo-content-turbo-frame']").shouldHave(text(VALUE));

    }
}
