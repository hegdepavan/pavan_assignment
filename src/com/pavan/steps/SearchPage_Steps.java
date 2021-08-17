package com.pavan.steps;

import com.pavan.pages.SearchPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

public class SearchPage_Steps extends SearchPage {

	@QAFTestStep(description = "user search with keyword {0}")
	public void userSearchWithKeyword(String key) {
		typeSearchInput(key);
	}

	@QAFTestStep(description = "user select {0} th item from search suggesion list")
	public void userSelectThItemFromSearchSuggesionList(String num) {
		selectAnItemFromSearchSuggesion(Integer.valueOf(num));
	}
}
