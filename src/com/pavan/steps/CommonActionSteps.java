package com.pavan.steps;

import static com.qmetry.qaf.automation.util.Reporter.log;

import java.util.concurrent.TimeUnit;

import com.pavan.pages.Base_Template;
import com.pavan.pages.SearchPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;

public class CommonActionSteps extends Base_Template {

	@QAFTestStep(description = "user open application url")
	public void userOpenApplicationUrl() {
		SearchPage s = new SearchPage();
		s.launchPage(null);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log("Opened URL --> " + driver.getCurrentUrl());

	}

	@QAFTestStep(description = "user quit the browser")
	public void userQuitTheBrowser() {
		driver.quit();
		new WebDriverTestBase().tearDown();
		log("Closing the browser");
	}


}
