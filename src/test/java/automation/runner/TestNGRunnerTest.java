package automation.runner;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber"},
    snippets = CAMELCASE,
    glue = {"automation.stepDefs"},
    features = {"src/test/resources/automation/features"})
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {}
