package com.rmdaw.cucumber.testrunners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/rmdaw/cucumber/features")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.rmdaw.cucumber")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class MenuManagementTest {

}
