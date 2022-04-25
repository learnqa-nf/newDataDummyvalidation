package runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/validasi.feature",
		glue = {"generateDefinitions"},
		// tags = "@data",
		plugin = {"pretty",
				"html:target/reports/HtmlReport.html",
				"junit:target/reports/JUnitReport.xml",
				"json:target/reports/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)
public class validasiReport {

}
