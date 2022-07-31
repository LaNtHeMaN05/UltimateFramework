package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue= {"stepDefinition"},plugin="json:target/jsonReports/api-report.json")
public class TestRunner extends AbstractTestNGCucumberTests{

}
