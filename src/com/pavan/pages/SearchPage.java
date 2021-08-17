package com.pavan.pages;

import java.util.List;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class SearchPage extends Base_Template {

	@FindBy(locator = "id=input")
	private QAFWebElement searchInput;

	@FindBy(locator = "css=ul[class*='suggesion'] [qa='prodNameAS']")
	private List<QAFWebElement> searchSuggesionList;

	public QAFWebElement getSearchInput() {
		return searchInput;
	}

	public List<QAFWebElement> getSearchSuggesionList() {
		return searchSuggesionList;
	}

	public void typeSearchInput(String key) {
		getSearchInput().sendKeys(key);
	}

	public void selectAnItemFromSearchSuggesion(int itemNum) {
		Base_Template.waitForSeconds(7);
		Reporter.log("Number of Items suggested = " + getSearchSuggesionList().size());
		Reporter.log("Clicking a product with Name = " + getSearchSuggesionList().get(itemNum).getText());
		ConfigurationManager.getBundle().setProperty("selected.product.name",
				getSearchSuggesionList().get(itemNum).getText());
		getSearchSuggesionList().get(itemNum).click();
	}

}
