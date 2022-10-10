package automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.jupiter.api.AfterEach;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        snippets = CAMELCASE,
        glue = {"automation.stepDefs"},
        features = {"src/test/resources/automation/features"})
public class TestNGRunnerTest extends AbstractTestNGCucumberTests { }
