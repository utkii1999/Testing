package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/CucumberWithTags",
glue= {"StepDefinitions"},
//tags= "@smoke"
//tags="@smoke or @regression"
//tags="@smoke and @regression"
//tags="@smoke or @regression and @important "
//tags="(@smoke or @regression) and @important"
//tags="@regression and not @smoke"
tags="@mustRun"
)
public class Test_RunnerTags {


}
