package StepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	//features="src/test/resources/features/SeduceLogin.feature",
	features="@target/rerun.txt",
	glue= {"StepDefination"},
	dryRun=false,
	monochrome=true,
	plugin= {//"pretty","junit:target/JunitReports/report.xml"
			
	
	//"json:target/JSonReports/reports/json",
	"html:target/Html/Reports"}
)

public class Failedtest {

}
