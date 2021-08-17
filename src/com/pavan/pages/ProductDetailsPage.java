package com.pavan.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductDetailsPage extends Base_Template {

	@FindBy(locator = "css=#title>h1")
	private QAFWebElement productName;

	@FindBy(locator = "name=qty")
	private QAFWebElement quantityInput;

	@FindBy(locator = "css=div[data-qa='addToBasket']")
	private QAFWebElement addToBasketBtn;

	public QAFWebElement getProductName() {
		return productName;
	}

	public QAFWebElement getQuantityInput() {
		return quantityInput;
	}

	public QAFWebElement getAddToBasketBtn() {
		return addToBasketBtn;
	}

	public void enterQty(String qty) {
		getQuantityInput().clear();
		getQuantityInput().sendKeys(qty);
	}

	public void clickAddToBasketBtn() {
		getAddToBasketBtn().click();
	}
}
