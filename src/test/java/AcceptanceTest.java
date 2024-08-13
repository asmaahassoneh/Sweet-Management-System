import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/use_cases",   // you must but the path for the featuer file that we wrote on it the senario
        plugin = {"summary", "html:target/cucumber/wikipedia.html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        glue = {"steps"}   // here you must but the path for the functions that the compiler gives  (in source)
)


public class AcceptanceTest {


}
