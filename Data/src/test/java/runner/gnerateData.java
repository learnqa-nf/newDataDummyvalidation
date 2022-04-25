package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
      features = "src/test/resources/Features/createDataDummy.feature",
        glue = {"generateDefinitions"},
       // tags = "@data",
        plugin = {"pretty",
        		"html:target/reports/HtmlReport.html",
        		"junit:target/reports/JUnitReport.xml",
        		"json:target/reports/cucumber.json"}
)
public class gnerateData {

}
