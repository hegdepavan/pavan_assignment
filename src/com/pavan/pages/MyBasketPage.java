package com.pavan.pages;

import java.util.List;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class MyBasketPage extends Base_Template {

	@FindBy(locator = "css=div[data-qa='myBasket']")
	private QAFWebElement myBasketIcon;

	@FindBy(locator = "css=div[data-qa='myBasket']+div span+div>div:nth-child(2)")
	private List<QAFWebElement> productNamesMBList;

	@FindBy(locator = "css=div[data-qa='myBasket']+div  div:nth-child(3) div:nth-child(2)")
	private List<QAFWebElement> productQtyMBList;

	public QAFWebElement getMyBasketIcon() {
		return myBasketIcon;
	}

	public List<QAFWebElement> getProductNamesMBList() {
		return productNamesMBList;
	}

	public List<QAFWebElement> getProductQtyMBList() {
		return productQtyMBList;
	}

	public void clickMyBasketIcon() {
		getMyBasketIcon().click();
	}
}
