package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/bhumidobariya/eclipse-workspace/CastleHill_2/src/test/java/features/login.feature", //the path of the feature files
		glue = {"StepDefinations"},
		monochrome = true, //display the console output in a proper readable format
		plugin =  {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"} //to generate different types of reporting
		
		)
 
public class TestRunner {
	//nikuj

}



