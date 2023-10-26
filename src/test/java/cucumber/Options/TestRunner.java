package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,features="src/test/java/features",plugin ={"pretty","json:target/jsonReports/cucumber-report.json","html:target/cucumber-reports.html"},glue= {"stepDefinations"},monochrome = true)
public class TestRunner {
//@tags{"@CreateBooking"}
}
