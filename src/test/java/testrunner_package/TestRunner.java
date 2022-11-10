package testrunner_package;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

 


@RunWith(Cucumber.class)
@CucumberOptions
       (
    	 features="src/test/resources/Features/Customer.feature",
    	 glue="stepDefinitions",
    	 dryRun=false,
    	 monochrome=true,
    	 plugin={"pretty", "html:target/HtmlReport" , "json:test-output/Json_report" , "html:test-output/HTML_report"}
		
		)



public class TestRunner {

}
