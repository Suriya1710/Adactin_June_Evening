package com.adactinjune.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adactinsite.baseclass.BaseClass;
import com.adactinsite.helper.File_Reader_Manager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//com//adactinjune//feature", 
glue = "com.adactinjune.stepdefinition", 
monochrome = true, dryRun = false, 
strict = false, 
tags = ("@SmokeTest,@SanityTest"), 
plugin = 
{"html:Report/HTML_Report" ,
		
"pretty" , 

"json:Report/CucumberJSON_Report.json",

"com.cucumber.listener.ExtentCucumberFormatter:Reports/ExtentReport.html"



}


)
public class Test_Runner {

	public static WebDriver driver; // ---> null

	@BeforeClass
	public static void set_Up() throws Throwable {

		String browser = File_Reader_Manager.getInstance().getInstanceCR().get_Browser();

		driver = BaseClass.getDriver(browser);

		// driver = BaseClass.getDriver("chrome");
	}

	@AfterClass
	public static void tear_Down() {

		// driver.close();

	}

}
