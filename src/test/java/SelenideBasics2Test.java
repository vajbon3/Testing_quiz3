import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideBasics2Test {

    public static Predicate<SelenideElement> JavascriptAuthorFunc() {
        return book -> book.lastChild().has(exactText("O'Reilly Media")) && book.$(By.tagName("a")).has(text("javascript"));
    }

    @Test
    public void task1() {
        open("https://demoqa.com/books");
        $$($$(".rt-tr").stream().filter(JavascriptAuthorFunc()).collect(Collectors.toList())).shouldHave(size(10));
    }
}