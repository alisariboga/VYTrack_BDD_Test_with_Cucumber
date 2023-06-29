package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/default-cucumber-reports.html",
                "rerun:target/return.txt"
        },
        features = {
                "@target/return.txt" //to specify where txt with failed features
        },
        glue = {"com/vytrack/step_definitions"},
        dryRun = false

)
public class FailedRunner {
}
