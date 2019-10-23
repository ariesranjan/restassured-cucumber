package com.helloFresh.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
glue={"com/helloFresh/stepDefinitions"},
plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
monochrome = true)

public class TestRunner {


}
