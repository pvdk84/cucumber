package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps"},
        features = {"src/test/resources/features"},
        tags = {"@UnitTest"})

public class RunUnitTest { }