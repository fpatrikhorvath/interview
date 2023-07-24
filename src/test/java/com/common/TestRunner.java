package com.common;

import groovy.util.logging.Slf4j;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@Slf4j
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenarios",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        glue = "common/stepdefinitions"
)
public class TestRunner {}
